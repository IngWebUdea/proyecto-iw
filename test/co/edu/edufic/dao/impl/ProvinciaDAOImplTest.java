package co.edu.edufic.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.edufic.dao.ProvinciaDAO;
import co.edu.edufic.dto.Provincia;
import co.edu.edufic.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:config.xml")
public class ProvinciaDAOImplTest {

	@Autowired ProvinciaDAO provinciaDAO;
	
	@Test
	public void testAllProvincias() {
		
		List<Provincia> provincias = null;
		
		try{
			provincias = provinciaDAO.allProvincias();
			
			for(Provincia p : provincias){
				System.out.println("Provincia/departamento: " + p.getProvincia());
				System.out.println("Código: " + p.getCodigo());
				System.out.println("País: " + p.getPais().getPais() + "\n");
			}
			
			assertTrue(provincias.size() > 0);
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
