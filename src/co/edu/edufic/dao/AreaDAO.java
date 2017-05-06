package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.Area;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los m�todos permitidos para las �reas en el sistema
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
public interface AreaDAO {

	/**
	 * Obtiene la lista de �reas de la db.
	 * @return Lista de �reas.
	 * @throws MyException Ocurre cuando hay un error en la conexi�n a la db.
	 */
	public List<Area> allAreas() throws MyException;
	
	/**
	 * Obtiene un �rea dado su id en la db.
	 * @param idArea Identificador del �rea en la db.
	 * @return area con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexi�n con la db
	 */
	public Area findById(Integer idArea) throws MyException;
	
	/**
	 * Almacena los datos de un �rea en la db.
	 * @param area Objeto de la clase {@link Area} con la informaci�n necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando el �rea.
	 */
	public void insert(Area area) throws MyException;
	
	/**
	 * Actualiza los datos de un �rea en la db.
	 * @param area Objeto de la clase {@link Area} con la informaci�n necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando el �rea.
	 */
	public void update(Area area) throws MyException;
	
	/**
	 * Elimina los datos de un �rea en la db.
	 * @param area Objeto de la clase {@link Area} con la informaci�n necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando el �rea.
	 */
	public void delete(Area area) throws MyException;
}
