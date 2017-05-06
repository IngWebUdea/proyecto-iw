package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.Pregunta;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los métodos permitidos para las preguntas en el sistema
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface PreguntaDAO {
	/**
	 * Obtiene la lista de preguntas de la db.
	 * @return Lista de preguntas.
	 * @throws MyException Ocurre cuando hay un error en la conexión a la db.
	 */
	public List<Pregunta> allPreguntas() throws MyException;
	
	/**
	 * Obtiene una pregunta dado su id en la db.
	 * @param idPregunta Identificador de la pregunta en la db.
	 * @return pregunta con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexión con la db
	 */
	public Pregunta findById(Integer idPregunta) throws MyException;
	
	/**
	 * Almacena los datos de una pregunta en la db.
	 * @param pregunta Objeto de la clase {@link Pregunta} con la información necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando la pregunta.
	 */
	public void insert(Pregunta pregunta) throws MyException;
	
	/**
	 * Actualiza los datos de una pregunta en la db.
	 * @param pregunta Objeto de la clase {@link Pregunta} con la información necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando la pregunta.
	 */
	public void update(Pregunta pregunta) throws MyException;
	
	/**
	 * Elimina los datos de una pregunta en la db.
	 * @param pregunta Objeto de la clase {@link Pregunta} con la información necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando la pregunta.
	 */
	public void delete(Pregunta pregunta) throws MyException;	
}
