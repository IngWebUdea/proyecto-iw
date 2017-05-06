package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.IdTematicasPorPregunta;
import co.edu.edufic.dto.TematicasPorPregunta;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los m�todos permitidos para las tematicasPorPreguntas en el sistema
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
public interface TematicasPorPreguntaDAO {

	/**
	 * Obtiene la lista de tematicasPorPreguntas de la db.
	 * @return Lista de tematicasPorPreguntas.
	 * @throws MyException Ocurre cuando hay un error en la conexi�n a la db.
	 */
	public List<TematicasPorPregunta> allTematicasPorPreguntas() throws MyException;
	
	/**
	 * Obtiene la lista de tematicasPorPreguntas dado el Id de la tem�tica requierida
	 * @param tematicaId Identificador de la tem�tica requerida
	 * @return Listado de tematicas por pregnta
	 * @throws MyException Ocurre cuando hay un error en la conexi�n a la db. 
	 */
	public List<TematicasPorPregunta> allTematicasPorPreguntasByTematica(Integer tematicaId) throws MyException;
	
	/**
	 * Obtiene una tematicasPorPregunta dado su id en la db.
	 * @param idTematicasPorPregunta Identificador de la tematicasPorPregunta en la db.
	 * @return tematicasPorPregunta con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexi�n con la db
	 */
	public TematicasPorPregunta findById(IdTematicasPorPregunta idTematicasPorPregunta) throws MyException;
	
	/**
	 * Almacena los datos de una tematicasPorPregunta en la db.
	 * @param tematicasPorPregunta Objeto de la clase {@link TematicasPorPregunta} con la informaci�n necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando la tematicasPorPregunta.
	 */
	public void insert(TematicasPorPregunta tematicasPorPregunta) throws MyException;
	
	/**
	 * Actualiza los datos de una tematicasPorPregunta en la db.
	 * @param tematicasPorPregunta Objeto de la clase {@link TematicasPorPregunta} con la informaci�n necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando la tematicasPorPregunta.
	 */
	public void update(TematicasPorPregunta tematicasPorPregunta) throws MyException;
	
	/**
	 * Elimina los datos de una tematicasPorPregunta en la db.
	 * @param tematicasPorPregunta Objeto de la clase {@link TematicasPorPregunta} con la informaci�n necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando la tematicasPorPregunta.
	 */
	public void delete(TematicasPorPregunta tematicasPorPregunta) throws MyException;
	
}
