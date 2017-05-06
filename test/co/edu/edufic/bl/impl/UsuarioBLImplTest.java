package co.edu.edufic.bl.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.edufic.bl.UsuarioBL;
import co.edu.edufic.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config.xml")
@Transactional
public class UsuarioBLImplTest {

	@Autowired UsuarioBL usuarioBL;
	
	@Test
	public void testAutenticarDone() {	
		//patrón de los pwd es user01 : pwd01		
		try{
			usuarioBL.autenticar("user03", "pwd03");			
		}catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());			
		}
	}
	
	@Test
	public void testAutenticarFailByEmptyLogin() {		
		try{
			usuarioBL.autenticar("", "pwd03");			
		}catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());			
		}
	}
	
	@Test
	public void testAutenticarFailByEmptyPwd() {		
		try{
			usuarioBL.autenticar("user02", "");			
		}catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());			
		}
	}
	
	@Test
	public void testAutenticarFailByWrongLogin() {			
		try{
			usuarioBL.autenticar("user06", "pwd03");			
		}catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());			
		}
	}
	
	@Test
	public void testValidarPerfilDone() {	
		
		Boolean validate = Boolean.FALSE;
		try{
			validate = usuarioBL.validarPerfil("user01", 1);
			
			assertTrue(validate);
		}catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());			
		}
	}
	
	@Test
	public void testValidarPerfilFailByUnknowedProfile() {	
		
		Boolean validate = Boolean.FALSE;
		try{
			validate = usuarioBL.validarPerfil("user01", 0);
			
			assertTrue(validate);
		}catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());			
		}
	}
	
	@Test
	public void testValidarPerfilFailByUnallowedProfile() {	
		
		Boolean validate = Boolean.FALSE;
		try{
			validate = usuarioBL.validarPerfil("user02", 1);
			
			assertTrue(validate);
		}catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());			
		}
	}

}
