package co.edu.edufic.bl.impl;

import java.util.Set;

import co.edu.edufic.bl.UsuarioBL;
import co.edu.edufic.dao.PerfilDAO;
import co.edu.edufic.dao.UsuarioDAO;
import co.edu.edufic.dto.Perfil;
import co.edu.edufic.dto.PerfilPorUsuario;
import co.edu.edufic.dto.Usuario;
import co.edu.edufic.exception.MyException;
import co.edu.edufic.util.Cifrar;

public class UsuarioBLImpl implements UsuarioBL {
	
	UsuarioDAO usuarioDAO;
	PerfilDAO perfilDAO;

	@Override
	public void autenticar(String login, String pwd) throws MyException {
		
		Usuario usuario = null;
		String pwdEncrypt = null;
		
		//Se valida que los campos no sean vacíos.		
		if(login.isEmpty() || login == null){
			throw new MyException("El campo login es requerido");
		}
		
		if(pwd.isEmpty() || pwd == null){
			throw new MyException("El campo contraseña es requerido");
		}
		
		//Se valida que el usuario este registrado en el sistema.		
		usuario = usuarioDAO.findById(login);		
		if(usuario == null){
			throw new MyException("Usuario no registrado en el sistema");
		}
		
		//Se valida que la contraseña de usuario corresponda a la registrada en el sistema.
		pwdEncrypt = Cifrar.encrypt(pwd);		
		
		
		if(!usuario.getPassword().equals(pwdEncrypt)){
			throw new MyException("Contraseña incorrecta");
		}

	}
	
	@Override
	public boolean validarPerfil(String login, Integer idPerfil) throws MyException {
		
		Usuario usuario = null;
		Perfil perfil = null;		
		Set<PerfilPorUsuario> perfilesUsuario;
		Integer perfilUsuario;
		Boolean permitido = Boolean.FALSE;	
		
		//Se valida que los campos no sean vacíos.		
		if(login.isEmpty() || login == null){
			throw new MyException("El campo login es requerido");
		}
		
		if(idPerfil == null){
			throw new MyException("El campo perfil es requerido");
		}
		
		//Se valida que el usuario este registrado en el sistema.		
		usuario = usuarioDAO.findById(login);		
		if(usuario == null){
			throw new MyException("Usuario no registrado en el sistema");
		}
		
		//Se valida que el perfil esté registrado en el sistema
		perfil = perfilDAO.findById(idPerfil);
		if(perfil == null){
			throw new MyException("Perfil no registrado en el sistema");
		}
		
		//Obtenemos los perfiles del usuario.
		usuario = usuarioDAO.findById(login);		
		perfilesUsuario = usuario.getPerfiles();
		
		//Verificamos que tenga el perfil 
		for(PerfilPorUsuario pu : perfilesUsuario){			
			perfilUsuario = pu.getIdPerfilPorUsuario().getIdPerfil().getIdPerfil();
			if(perfilUsuario == idPerfil){
				permitido = Boolean.TRUE;
			}
		}				
		
		if(!permitido){
			throw new MyException("El usuario no posee el perfil solicitado");
		}
		
		return permitido;
	}
		
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public PerfilDAO getPerfilDAO() {
		return perfilDAO;
	}

	public void setPerfilDAO(PerfilDAO perfilDAO) {
		this.perfilDAO = perfilDAO;
	}
}
