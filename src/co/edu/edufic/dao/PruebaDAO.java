package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.Prueba;
/**
 * Interface que define los m�todos permitidos para las pruebas en el sistema
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
import co.edu.edufic.exception.MyException;

	public interface PruebaDAO {
	/**
	 * Obtiene la lista de pruebas de la db.
	 * @return Lista de pruebas.
	 * @throws MyException Ocurre cuando hay un error en la conexi�n a la db.
	 */
	public List<Prueba> allPruebas() throws MyException;
	
	/**
	 * Obtiene una prueba dado su id en la db.
	 * @param idPrueba Identificador de la prueba en la db.
	 * @return prueba con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexi�n con la db
	 */
	public Prueba findById(Integer idPrueba) throws MyException;
	
	/**
	 * Almacena los datos de una prueba en la db.
	 * @param prueba Objeto de la clase {@link Prueba} con la informaci�n necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando la prueba.
	 */
	public void insert(Prueba prueba) throws MyException;
	
	/**
	 * Actualiza los datos de una prueba en la db.
	 * @param prueba Objeto de la clase {@link Prueba} con la informaci�n necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando la prueba.
	 */
	public void update(Prueba prueba) throws MyException;
	
	/**
	 * Elimina los datos de una prueba en la db.
	 * @param prueba Objeto de la clase {@link Prueba} con la informaci�n necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando la prueba.
	 */
	public void delete(Prueba prueba) throws MyException;
	
}
