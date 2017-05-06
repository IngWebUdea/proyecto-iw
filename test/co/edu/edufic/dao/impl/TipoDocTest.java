package co.edu.edufic.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.edufic.dao.TipoDocDAO;
import co.edu.edufic.dto.TipoDoc;
import co.edu.edufic.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:config.xml")
public class TipoDocTest {
	
	@Autowired TipoDocDAO tipoDocDAO;

	@Test
	public void testAllTiposDoc() {
		
		List<TipoDoc> tiposDoc = null;
		
		try{
			tiposDoc = tipoDocDAO.allTiposDoc();
			
			for(TipoDoc tdoc : tiposDoc){
				System.out.println(tdoc.getTipo());
			}
			
			assertTrue(tiposDoc.size() > 0);
		}catch(MyException e){
			fail(e.getMessage());
		}
	}

	@Test
	public void testFindById() {
		
		TipoDoc tipoDoc = null;
		
		try{
			tipoDoc = tipoDocDAO.findById(1);
			System.out.println("\n Encontrado Tipo documento " + tipoDoc.getTipo() + ", con id " + tipoDoc.getIdTipoDoc());
			assertNotNull(tipoDoc);
		}catch(MyException e){
			fail(e.getMessage());
		} 
	}

	@Test
	public void testInsert() {
		
		TipoDoc tipoDoc = new TipoDoc();
		
		try{
			tipoDoc.setTipo("Tipo de prueba");
			
			tipoDocDAO.insert(tipoDoc);
			
		}catch(MyException e){
			fail(e.getMessage());
		}
	}

	@Test
	public void testUpdate() {
		
		TipoDoc tipoDoc = new TipoDoc();
		String doc;
		
		try{
			tipoDoc = tipoDocDAO.findById(1);
			doc = tipoDoc.getTipo();
			tipoDoc.setTipo("Cédula set");
			
			tipoDocDAO.update(tipoDoc);
			
			System.out.println("\n Updated from " + doc + " to " + tipoDocDAO.findById(1).getTipo());
			
			assertTrue(tipoDocDAO.findById(1).getTipo().equals("Cédula set"));
			
		}catch(MyException e){
			fail(e.getMessage());
		}
	}

	@Test
	public void testDelete() {
		
		TipoDoc tipoDoc = new TipoDoc();
		
		try{
			tipoDoc = tipoDocDAO.findById(1);
			tipoDocDAO.delete(tipoDoc);
			System.out.println("\n Borrado el documento tipo: " + tipoDoc.getTipo());
			assertTrue(tipoDocDAO.findById(1) == null);
			
		}catch(MyException e){
			fail(e.getMessage());
		}
	}

}
