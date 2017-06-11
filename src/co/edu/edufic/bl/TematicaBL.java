package co.edu.edufic.bl;

import java.util.List;

import co.edu.edufic.dto.Pregunta;
import co.edu.edufic.dto.Tematica;
import co.edu.edufic.exception.MyException;

/**
 * Interface para dar manejo a la l�gica de negocio correspondiente a las tem�ticas.
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
public interface TematicaBL {
	
	/**
	 * M�todo para listar todas las tematicas en el sistema.
	 * @return Listado de todas las tem�ticas del sistema.
	 * @throws MyException
	 */
	public List<Tematica> tematicas() throws MyException;
	
	/**
	 * M�todo para obtener una tem�tica dado su identificador �nico en el sistema. 
	 * @param idTematica
	 * @return Tem�tica con el id dado
	 * @throws MyException
	 */
	public Tematica tematicaById(Integer idTematica) throws MyException;
	
	/**
	 * M�todo para obtener todas las preguntas del sistema dado el identificador de la tem�tica
	 * a la que pertenece.
	 * @param idTematica Identificador de la tem�tica.
	 * @return Listado con todas las preguntas de la tem�tica dada.
	 * @throws MyException
	 */
	public List<Pregunta> preguntasByIdTematica(Integer idTematica) throws MyException;
	
	/**
	 * M�todo para registrar una tem�tica en el sistema.
	 * @param tematica Nombre para la tem�tica.
	 * @param idArea Identificador del �rea a la que pertenece la tem�tica.
	 * @param sugAprend Sugerencia para el aprendizaje de la tem�tica.
	 * @throws MyException
	 */
	public void registrarTematica(String nombreTematica, Integer idArea, String sugAprend) throws MyException;

	/**
	 * M�todo para obtener todas la tematicas de un �rea dada.
	 * @param idArea ideantificador del �rea.
	 * @return Listado con las tem�ticas del �rea especificada.
	 * @throws MyException
	 */
	public List<Tematica> tematicasByArea(Integer idArea) throws MyException;

}
