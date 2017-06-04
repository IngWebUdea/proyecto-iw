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
	public Boolean validarPerfil(Set<PerfilPorUsuario> perfilesUsuario, Integer idPerfil) throws MyException {		
		
		Perfil perfil = null;
		Integer perfilUsuario;	
		Boolean checkPerfil = Boolean.FALSE;
		
		//Se validan campos no nulos 
		if(perfilesUsuario.isEmpty() || perfilesUsuario == null){
			throw new MyException("El campo perfiles de usuario es requerido");
		}
		if(idPerfil == null){
			throw new MyException("El campo perfil es requerido");
		}
		
		//Se valida que el perfil esté registrado en el sistema.
		perfil = perfilDAO.findById(idPerfil);
		if(perfil == null){
			throw new MyException("Perfil no registrado en el sistema");
		}
		
		//Verificamos que el usuario tenga el perfil dado como parámetro.
		for(PerfilPorUsuario pu : perfilesUsuario){			
			perfilUsuario = pu.getIdPerfilPorUsuario().getPerfil().getIdPerfil();
			if(perfilUsuario == idPerfil){
				checkPerfil = Boolean.TRUE;
			}
		}	
		return checkPerfil;
		
	}
	
	@Override
	public Boolean validarPerfilByCode(Set<PerfilPorUsuario> perfilesUsuario, String codePerfil)  throws MyException {
		
		Perfil perfil = null;
		String codePerfilUsr;	
		Boolean checkPerfil = Boolean.FALSE;
		
		//Se validan campos no nulos 
		if(perfilesUsuario.isEmpty() || perfilesUsuario == null){
			throw new MyException("El campo perfiles de usuario es requerido");
		}
		if(codePerfil.isEmpty() || codePerfil == null){
			throw new MyException("El campo perfil es requerido");
		}
		
		//Se valida que el perfil esté registrado en el sistema.
		perfil = perfilDAO.findByCode(codePerfil);
		if(perfil == null){
			throw new MyException("Perfil no registrado en el sistema");
		}
		
		//Verificamos que el usuario tenga el perfil dado como parámetro.
		for(PerfilPorUsuario pu : perfilesUsuario){			
			codePerfilUsr = pu.getIdPerfilPorUsuario().getPerfil().getCodigo();
			if(codePerfilUsr.equals(codePerfil)){
				checkPerfil = Boolean.TRUE;
				break;
			}
		}	
		return checkPerfil;
		
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
