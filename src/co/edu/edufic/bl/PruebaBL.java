package co.edu.edufic.bl;

import java.sql.Time;
import java.util.Date;

import co.edu.edufic.exception.MyException;

/**
 * Interface para los métodos permitodos para las pruebas en la capa de lógica de negocio.
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface PruebaBL {
	
	public void registrarPrueba(String codigo, String categoriaId, Integer numPreguntas,
			Time duracion, Date fechaCrea, String usuarioCrea, Boolean aleatoria, String descripcion) throws MyException;
	
}
