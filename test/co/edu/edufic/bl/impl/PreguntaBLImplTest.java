package co.edu.edufic.bl.impl;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.edufic.bl.PreguntaBL;
import co.edu.edufic.exception.MyException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config.xml")
@Transactional
public class PreguntaBLImplTest {

	@Autowired PreguntaBL preguntaBL;
	
	@Test
	public void testRegistrarPregunta() {
		
		
		try{
			
			preguntaBL.registrarPregunta("Pregunta reg 1", 1, "{\"a\" : \"opt_a\"}" , 'a', '2', 1, "user01", new Date());
			
		}catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());			
		}
	}

}
