package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.Area;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los métodos permitidos para las áreas en el sistema
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface AreaDAO {

	/**
	 * Obtiene la lista de áreas de la db.
	 * @return Lista de áreas.
	 * @throws MyException Ocurre cuando hay un error en la conexión a la db.
	 */
	public List<Area> allAreas() throws MyException;
	
	/**
	 * Obtiene un área dado su id en la db.
	 * @param idArea Identificador del área en la db.
	 * @return area con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexión con la db
	 */
	public Area findById(Integer idArea) throws MyException;
	
	/**
	 * Almacena los datos de un área en la db.
	 * @param area Objeto de la clase {@link Area} con la información necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando el área.
	 */
	public void insert(Area area) throws MyException;
	
	/**
	 * Actualiza los datos de un área en la db.
	 * @param area Objeto de la clase {@link Area} con la información necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando el área.
	 */
	public void update(Area area) throws MyException;
	
	/**
	 * Elimina los datos de un área en la db.
	 * @param area Objeto de la clase {@link Area} con la información necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando el área.
	 */
	public void delete(Area area) throws MyException;
}
