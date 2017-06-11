package co.edu.edufic.bl.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.edufic.bl.PersonaBL;
import co.edu.edufic.dto.Persona;
import co.edu.edufic.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config.xml")
@Transactional
public class PersonaBLImpTest {
	
	@Autowired PersonaBL personaBL;

	@Test
	public void testCreate() {
		
		try{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");			
			personaBL.create("004", "Name001", "Apellido001", "303", "mail04@mail.com", 
					"Eduficticia", format.parse("1980-02-02"), 1,1);
			
		}catch (MyException | ParseException e) {
			e.printStackTrace();
			fail(e.getMessage());			
		}
	}

	@Test
	public void testSearchByDoc() {
		
		Persona persona = null;
		try{
			persona = personaBL.searchByDoc("002");
			assertNotNull(persona);
		}catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());			
		}
		
	}

}
