package co.edu.edufic.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.edufic.dao.PersonaDAO;
import co.edu.edufic.dto.Persona;
import co.edu.edufic.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:config.xml")
public class PersonaDAOImplTest {
	
	@Autowired PersonaDAO personaDAO;

	@Test
	public void testAllPersonas() {
		
		List<Persona> personas = null;
		
		try{
			personas = personaDAO.allPersonas();
			
			for(Persona p : personas){
				System.out.println("Nombre: " + p.getNombre() + " " + p.getApellido());
				System.out.println("Identificado con: " + p.getTipoDocumento().getTipo() + " número " + p.getIdPersona() + "\n");
			}
			
			assertTrue(personas.size() > 0);
		}catch (MyException e){
			fail(e.getMessage());
		}
	}
/*
	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

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
