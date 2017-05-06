package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.Grado;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los métodos permitidos para los grados en el sistema
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface GradoDAO {
	
	/**
	 * Obtiene la lista de grados de la db.
	 * @return Lista de grados.
	 * @throws MyException Ocurre cuando hay un error en la conexión a la db.
	 */
	public List<Grado> allGrados() throws MyException;
	
	/**
	 * Obtiene un grado dado su id en la db.
	 * @param idGrado Identificador del grado en la db.
	 * @return grado con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexión con la db
	 */
	public Grado findById(Integer idGrado) throws MyException;
	
	/**
	 * Almacena los datos de un grado en la db.
	 * @param grado Objeto de la clase {@link Grado} con la información necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando el grado.
	 */
	public void insert(Grado grado) throws MyException;
	
	/**
	 * Actualiza los datos de un grado en la db.
	 * @param grado Objeto de la clase {@link Grado} con la información necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando el grado.
	 */
	public void update(Grado grado) throws MyException;
	
	/**
	 * Elimina los datos de un grado en la db.
	 * @param grado Objeto de la clase {@link Grado} con la información necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando el grado.
	 */
	public void delete(Grado grado) throws MyException;

}
