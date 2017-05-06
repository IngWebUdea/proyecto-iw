package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.Provincia;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los métodos permitidos para las provincias en el sistema
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface ProvinciaDAO {
	
	/**
	 * Obtiene la lista de provincias de la db.
	 * @return Lista de provincias.
	 * @throws MyException Ocurre cuando hay un error en con la conexión a la db.
	 */
	public List<Provincia> allProvincias() throws MyException;
	
	/**
	 * Obtiene una provincia dado su id en la db.
	 * @param idProvincia Identificador del provincia en la db.
	 * @return provincia con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexión con la db
	 */
	public Provincia findById(Integer idProvincia) throws MyException;
	
	/**
	 * Almacena los datos de una provincia en la db.
	 * @param provincia Objeto de la clase {@link Provincia} con la información necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando la provincia.
	 */
	public void insert(Provincia provincia) throws MyException;
	
	/**
	 * Actualiza los datos de una provincia en la db.
	 * @param provincia Objeto de la clase {@link Provincia} con la información necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando la provincia.
	 */
	public void update(Provincia provincia) throws MyException;
	
	/**
	 * Elimina los datos de una provincia en la db.
	 * @param provincia Objeto de la clase {@link Provincia} con la información necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando la provincia.
	 */
	public void delete(Provincia provincia) throws MyException;
}
