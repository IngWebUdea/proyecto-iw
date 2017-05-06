package co.edu.edufic.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.edufic.dao.PaisDAO;
import co.edu.edufic.dto.Pais;
import co.edu.edufic.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:config.xml")
public class PaisTest {
	
	@Autowired PaisDAO paisDAO;

	@Test
	public void testAllPaises() {
		List<Pais> paises = null;
		
		try{
			paises = paisDAO.allPaises();
			
			for(Pais p : paises){
				System.out.println(p.getCodigo() + ": " + p.getPais());
			}
			
			assertTrue(paises.size() > 0);
		} catch (MyException e){
			fail(e.getMessage());
		}		
	}

	@Test
	public void testFindById() {
		
		Pais pais = null;
		
		try{
			pais = paisDAO.findById(1);
			System.out.println(pais.getCodigo() + ": " + pais.getPais());
			assertNotNull(pais);
		}catch (MyException e){
			fail(e.getMessage());
		}	
	}

	@Test
	public void testInsert() {
		Pais pais = new Pais();
		
		try{
			pais.setCodigo("593");
			pais.setPais("Ecuador");
			
			paisDAO.insert(pais);
			
		}catch (MyException e){
			fail(e.getMessage());
		}	
	}

	@Test
	public void testUpdate() {
		
		Pais pais = new Pais();
		
		try{
			pais = paisDAO.findById(1);
			
			pais.setCodigo("57");
			pais.setPais("República de Colombia");
			
			paisDAO.update(pais);
		}catch (MyException e){
			fail(e.getMessage());
		}		
	}

	@Test
	public void testDelete() {
		Pais pais = new Pais();
		
		try{
			pais = paisDAO.findById(1);
			paisDAO.delete(pais);
		}catch (MyException e){
			fail(e.getMessage());
		}		
	}

}
