package co.edu.edufic.bl;

import java.sql.Time;
import java.util.Date;

import co.edu.edufic.exception.MyException;

/**
 * Interface para los m�todos permitodos para las pruebas en la capa de l�gica de negocio.
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
public interface PruebaBL {
	
	public void registrarPrueba(String codigo, String categoriaId, Integer numPreguntas,
			Time duracion, Date fechaCrea, String usuarioCrea, Boolean aleatoria, String descripcion) throws MyException;
	
}
