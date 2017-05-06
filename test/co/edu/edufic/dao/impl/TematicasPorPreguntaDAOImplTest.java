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

import co.edu.edufic.dao.TematicasPorPreguntaDAO;
import co.edu.edufic.dto.TematicasPorPregunta;
import co.edu.edufic.exception.MyException;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:config.xml")
public class TematicasPorPreguntaDAOImplTest {
	
	@Autowired TematicasPorPreguntaDAO tematicasPorPreguntaDAO;
	
	@Test
	public void testAllTematicasPorPreguntas() {
		List<TematicasPorPregunta> tematicasPorPreguntas;
		
		try{
			tematicasPorPreguntas = tematicasPorPreguntaDAO.allTematicasPorPreguntas(); 
			assertTrue(tematicasPorPreguntas.size() > 0);
		}catch (MyException e){			
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAllTematicasPorPreguntasByTematica() {
		List<TematicasPorPregunta> tematicasPorPreguntas;
		
		try{
			tematicasPorPreguntas = tematicasPorPreguntaDAO.allTematicasPorPreguntasByTematica(1); 
			
			for(TematicasPorPregunta t : tematicasPorPreguntas){
				System.out.println("\n Las pregntas con la temática");
				System.out.println("Pregunta: " + t.getIdTematicasPorPregunta().getIdPregunta().getTexto() + "\n");
			}			
			assertTrue(tematicasPorPreguntas.size() > 0);
		}catch (MyException e){	
			e.printStackTrace();
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
