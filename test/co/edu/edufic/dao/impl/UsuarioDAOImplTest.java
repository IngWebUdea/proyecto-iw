package co.edu.edufic.dao.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.edufic.dao.UsuarioDAO;
import co.edu.edufic.dto.PerfilPorUsuario;
import co.edu.edufic.dto.Persona;
import co.edu.edufic.dto.Usuario;
import co.edu.edufic.exception.MyException;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:config.xml")
public class UsuarioDAOImplTest {
	
	@Autowired UsuarioDAO usuarioDAO;

	@Test
	public void testAllUsuarios() {
		
		List<Usuario> usuarios = null;
		
		try{
			usuarios = usuarioDAO.allUsuarios();
			
			for(Usuario u : usuarios){
				System.out.println("Login: " + u.getLogin());				
//				for(PerfilPorUsuario pu : u.getPerfiles()){
//					System.out.print(pu.getIdPerfilPorUsuario().getIdPerfil().getCodigo() + " - ");
//				}
				System.out.println("Persona: " + u.getPersona().getNombre());
				System.out.println("Creador: " + u.getUsuarioCrea().getLogin());
				System.out.println("Es activo?: " + u.getActivo());
				System.out.println("Fecha creación: " + u.getFechaCrea() + "\n");
			}
			assertTrue(usuarios.size() > 0);
		} catch (MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}


	@Test
	public void testFindById() {
		
		Usuario usuario = null;
		
		try{
			
			usuario = usuarioDAO.findById("user01");
			
			System.out.println("\nPara el usuario con login " + usuario.getLogin() + " tenemos los siguientes datos:");
			System.out.println("E-mail: " + usuario.getPersona().getEmail());
			System.out.println("Nombre: " + usuario.getPersona().getNombre() + "\n");
			
		}catch (MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	
	@Test
	public void testInsert() {
		
		Usuario usuario = null;
		Usuario usuarioCrea = null;
		Usuario usuarioTest = null;
		Persona persona = null;
		Set<PerfilPorUsuario> perfiles = null;
		Date fechaCrea = new Date();	
		
		try{			
			usuarioCrea = usuarioDAO.findById("user01");
			persona = usuarioCrea.getPersona();
			perfiles = usuarioCrea.getPerfiles();
			
			usuario = new Usuario("user04", "pwd4", Boolean.TRUE, usuarioCrea, fechaCrea, persona, perfiles);
			
			usuarioDAO.insert(usuario);
			
			//buscamos el usuario que acabamos de ingresar en la db			
			usuarioTest = usuarioDAO.findById("user04");
			
			System.out.println("\nUsuario " + usuarioTest.getLogin() + " se ha creado con éxito \n");
			
			//assert que busque el usuario y esté en la db
			assertTrue(usuarioTest != null);
		}catch (MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
	}
	/*
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}
	
*/

}
