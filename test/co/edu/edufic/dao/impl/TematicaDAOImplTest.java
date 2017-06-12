package co.edu.edufic.dao.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.edufic.dao.TematicaDAO;
import co.edu.edufic.dto.Tematica;
import co.edu.edufic.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:config.xml")
public class TematicaDAOImplTest {
	
	@Autowired TematicaDAO tematicaDAO;

	@Test
	public void testAllTematicas() {
		
		List<Tematica> tematicas = null;
		try{
			
			tematicas = tematicaDAO.allTematicas();
			assertTrue(tematicas.size() > 0);
		}catch (MyException e){			
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAllTematicasByArea() {
		
		List<Tematica> tematicas = null;
		try{
			
			tematicas = tematicaDAO.allTematicasByArea(1);
			
			for(Tematica t : tematicas){
				System.out.println("Temática: " + t.getTematica() + " | " + "Área: " + t.getIdArea());
			}
			
			assertTrue(tematicas.size() > 0);
		}catch (MyException e){			
			fail(e.getMessage());
		}
	}

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

}
