package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.Tematica;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los m�todos permitidos para las tem�ticas en el sistema
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
public interface TematicaDAO {

	/**
	 * Obtiene la lista de tem�ticas de la db.
	 * @return Lista de tem�ticas.
	 * @throws MyException Ocurre cuando hay un error en la conexi�n a la db.
	 */
	public List<Tematica> allTematicas() throws MyException;
	
	/**
	 * Obtiene una tem�tica dado su id en la db.
	 * @param idTematica Identificador del tem�tica en la db.
	 * @return tematica con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexi�n con la db
	 */
	public Tematica findById(Integer idTematica) throws MyException;
	
	/**
	 * Almacena los datos de una tem�tica en la db.
	 * @param tematica Objeto de la clase {@link Tematica} con la informaci�n necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando la tem�tica.
	 */
	public void insert(Tematica tematica) throws MyException;
	
	/**
	 * Actualiza los datos de una tem�tica en la db.
	 * @param tematica Objeto de la clase {@link Tematica} con la informaci�n necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando la tem�tica.
	 */
	public void update(Tematica tematica) throws MyException;
	
	/**
	 * Elimina los datos de una tem�tica en la db.
	 * @param tematica Objeto de la clase {@link Tematica} con la informaci�n necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando la tem�tica.
	 */
	public void delete(Tematica tematica) throws MyException;
}
