package co.edu.edufic.dao.impl;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.edufic.dao.CiudadDAO;
import co.edu.edufic.dto.Ciudad;
import co.edu.edufic.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:config.xml")
public class CiudadDAOImplTest {

	@Autowired CiudadDAO ciudadDAO;
	
	@Test
	public void testAllCiudades() {
		List<Ciudad> ciudades = null;
		
		try{
			ciudades = ciudadDAO.allCiudades();
			
			for(Ciudad c : ciudades){
				System.out.println("Ciudad: " + c.getCiudad() + " / code: " + c.getCodigo());
				System.out.println("Provincia/departamento: " + c.getProvincia().getProvincia());
				System.out.println("País: " + c.getProvincia().getPais().getPais() + "\n");
			}
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
