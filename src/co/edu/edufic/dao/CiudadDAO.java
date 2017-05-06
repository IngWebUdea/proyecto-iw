package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.Ciudad;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los m�todos permitidos para las ciudades en el sistema
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
public interface CiudadDAO {
	/**
	 * Obtiene la lista de ciudades de la db.
	 * @return Lista de ciudad.
	 * @throws MyException Ocurre cuando hay un error en con la conexi�n a la db.
	 */
	public List<Ciudad> allCiudades() throws MyException;
	
	/**
	 * Obtiene una ciudad dada su id en la db.
	 * @param idCiudad Identificador del ciudad en la db.
	 * @return ciudad con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexi�n con la db
	 */
	public Ciudad findById(Integer idCiudad) throws MyException;
	
	/**
	 * Almacena los datos de una ciudad en la db.
	 * @param ciudad Objeto de la clase {@link Ciudad} con la informaci�n necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando la ciudad.
	 */
	public void insert(Ciudad ciudad) throws MyException;
	
	/**
	 * Actualiza los datos de una ciudad en la db.
	 * @param ciudad Objeto de la clase {@link Ciudad} con la informaci�n necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando el ciudad.
	 */
	public void update(Ciudad ciudad) throws MyException;
	
	/**
	 * Elimina los datos de una ciudad en la db.
	 * @param ciudad Objeto de la clase {@link Ciudad} con la informaci�n necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando la ciudad.
	 */
	public void delete(Ciudad ciudad) throws MyException;

}
