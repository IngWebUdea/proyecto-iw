package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.IdRegistroRespuesta;
import co.edu.edufic.dto.RegistroRespuesta;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los métodos permitidos para los registroRespuestas en el sistema
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface RegistroRespuestaDAO {
	/**
	 * Obtiene la lista de registroRespuestas de la db.
	 * @return Lista de registroRespuestas.
	 * @throws MyException Ocurre cuando hay un error en la conexión a la db.
	 */
	public List<RegistroRespuesta> allRegistroRespuestas() throws MyException;
	
	/**
	 * Obtiene un registroRespuesta dado su id en la db.
	 * @param idRegistroRespuesta Identificador del registroRespuesta en la db.
	 * @return registroRespuesta con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexión con la db
	 */
	public RegistroRespuesta findById(IdRegistroRespuesta idRegistroRespuesta) throws MyException;
	
	/**
	 * Almacena los datos de un registroRespuesta en la db.
	 * @param registroRespuesta Objeto de la clase {@link RegistroRespuesta} con la información necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando el registroRespuesta.
	 */
	public void insert(RegistroRespuesta registroRespuesta) throws MyException;
	
	/**
	 * Actualiza los datos de un registroRespuesta en la db.
	 * @param registroRespuesta Objeto de la clase {@link RegistroRespuesta} con la información necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando el registroRespuesta.
	 */
	public void update(RegistroRespuesta registroRespuesta) throws MyException;
	
	/**
	 * Elimina los datos de un registroRespuesta en la db.
	 * @param registroRespuesta Objeto de la clase {@link RegistroRespuesta} con la información necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando el registroRespuesta.
	 */
	public void delete(RegistroRespuesta registroRespuesta) throws MyException;

}
