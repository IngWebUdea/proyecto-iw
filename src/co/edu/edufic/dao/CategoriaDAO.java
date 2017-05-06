package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.Categoria;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los m�todos permitidos para las categor�as en el sistema
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
public interface CategoriaDAO {
	
	/**
	 * Obtiene la lista de categor�as de la db.
	 * @return Lista de categor�as.
	 * @throws MyException Ocurre cuando hay un error en la conexi�n a la db.
	 */
	public List<Categoria> allCategorias() throws MyException;
	
	/**
	 * Obtiene una categor�a dado su id en la db.
	 * @param idCategoria Identificador de la categor�a en la db.
	 * @return categoria con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexi�n con la db
	 */
	public Categoria findById(String idCategoria) throws MyException;
	
	/**
	 * Almacena los datos de una categor�a en la db.
	 * @param categoria Objeto de la clase {@link Categoria} con la informaci�n necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando la categor�a.
	 */
	public void insert(Categoria categoria) throws MyException;
	
	/**
	 * Actualiza los datos de una categor�a en la db.
	 * @param categoria Objeto de la clase {@link Categoria} con la informaci�n necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando la categor�a.
	 */
	public void update(Categoria categoria) throws MyException;
	
	/**
	 * Elimina los datos de una categor�a en la db.
	 * @param categoria Objeto de la clase {@link Categoria} con la informaci�n necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando la categoria.
	 */
	public void delete(Categoria categoria) throws MyException;

}
