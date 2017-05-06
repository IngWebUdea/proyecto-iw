package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.Tematica;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los métodos permitidos para las temáticas en el sistema
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface TematicaDAO {

	/**
	 * Obtiene la lista de temáticas de la db.
	 * @return Lista de temáticas.
	 * @throws MyException Ocurre cuando hay un error en la conexión a la db.
	 */
	public List<Tematica> allTematicas() throws MyException;
	
	/**
	 * Obtiene una temática dado su id en la db.
	 * @param idTematica Identificador del temática en la db.
	 * @return tematica con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexión con la db
	 */
	public Tematica findById(Integer idTematica) throws MyException;
	
	/**
	 * Almacena los datos de una temática en la db.
	 * @param tematica Objeto de la clase {@link Tematica} con la información necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando la temática.
	 */
	public void insert(Tematica tematica) throws MyException;
	
	/**
	 * Actualiza los datos de una temática en la db.
	 * @param tematica Objeto de la clase {@link Tematica} con la información necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando la temática.
	 */
	public void update(Tematica tematica) throws MyException;
	
	/**
	 * Elimina los datos de una temática en la db.
	 * @param tematica Objeto de la clase {@link Tematica} con la información necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando la temática.
	 */
	public void delete(Tematica tematica) throws MyException;
}
