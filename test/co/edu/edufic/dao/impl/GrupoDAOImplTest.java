package co.edu.edufic.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.edufic.dao.GrupoDAO;
import co.edu.edufic.dto.Grupo;
import co.edu.edufic.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:config.xml")
public class GrupoDAOImplTest {

	@Autowired GrupoDAO grupoDAO;
	
	@Test
	public void testAllGrupos() {
		
		List<Grupo> grupos =  null;
		
		try{
			grupos = grupoDAO.allGrupos();
			
			assertTrue(grupos.size() > 0);
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
