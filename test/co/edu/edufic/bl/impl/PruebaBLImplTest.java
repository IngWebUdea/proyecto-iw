package co.edu.edufic.bl.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Time;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.edufic.bl.PruebaBL;
import co.edu.edufic.dao.PreguntaDAO;
import co.edu.edufic.dao.PruebaDAO;
import co.edu.edufic.dto.Prueba;
import co.edu.edufic.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config.xml")
@Transactional
public class PruebaBLImplTest {
	
	@Autowired PruebaBL pruebaBL;
	@Autowired PruebaDAO pruebaDAO;

	@Test
	public void testRegistrarPrueba() {
		Prueba prueba;

		try{
			pruebaBL.registrarPrueba("PSU022017-01", "PSU", 5, new Time(1L), new Date(), "user01", Boolean.FALSE, "Probando la prueba");
			
		}catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());			
		}
		
	}

}
