package co.edu.edufic.bl;

import java.util.List;

import co.edu.edufic.dto.Pregunta;
import co.edu.edufic.dto.Tematica;
import co.edu.edufic.exception.MyException;

/**
 * Interface para dar manejo a la lógica de negocio correspondiente a las temáticas.
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface TematicaBL {
	
	/**
	 * Método para listar todas las tematicas en el sistema.
	 * @return Listado de todas las temáticas del sistema.
	 * @throws MyException
	 */
	public List<Tematica> tematicas() throws MyException;
	
	/**
	 * Método para obtener una temática dado su identificador único en el sistema. 
	 * @param idTematica
	 * @return Temática con el id dado
	 * @throws MyException
	 */
	public Tematica tematicaById(Integer idTematica) throws MyException;
	
	/**
	 * Método para obtener todas las preguntas del sistema dado el identificador de la temática
	 * a la que pertenece.
	 * @param idTematica Identificador de la temática.
	 * @return Listado con todas las preguntas de la temática dada.
	 * @throws MyException
	 */
	public List<Pregunta> preguntasByIdTematica(Integer idTematica) throws MyException;
	
	/**
	 * Método para registrar una temática en el sistema.
	 * @param tematica Nombre para la temática.
	 * @param idArea Identificador del área a la que pertenece la temática.
	 * @param sugAprend Sugerencia para el aprendizaje de la temática.
	 * @throws MyException
	 */
	public void registrarTematica(String nombreTematica, Integer idArea, String sugAprend) throws MyException;

	/**
	 * Método para obtener todas la tematicas de un área dada.
	 * @param idArea ideantificador del área.
	 * @return Listado con las temáticas del área especificada.
	 * @throws MyException
	 */
	public List<Tematica> tematicasByArea(Integer idArea) throws MyException;

}
