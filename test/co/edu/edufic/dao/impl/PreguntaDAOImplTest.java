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

import co.edu.edufic.dao.PreguntaDAO;
import co.edu.edufic.dto.Pregunta;
import co.edu.edufic.exception.MyException;
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:config.xml")
public class PreguntaDAOImplTest {
	
	@Autowired PreguntaDAO preguntaDAO;

	@Test
	public void testAllPreguntas() {
		
		List<Pregunta> preguntas = null;
		
		try{
			preguntas = preguntaDAO.allPreguntas();
					
			assertTrue(preguntas.size() > 0);	
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
