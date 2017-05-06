package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.Categoria;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los métodos permitidos para las categorías en el sistema
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface CategoriaDAO {
	
	/**
	 * Obtiene la lista de categorías de la db.
	 * @return Lista de categorías.
	 * @throws MyException Ocurre cuando hay un error en la conexión a la db.
	 */
	public List<Categoria> allCategorias() throws MyException;
	
	/**
	 * Obtiene una categoría dado su id en la db.
	 * @param idCategoria Identificador de la categoría en la db.
	 * @return categoria con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexión con la db
	 */
	public Categoria findById(String idCategoria) throws MyException;
	
	/**
	 * Almacena los datos de una categoría en la db.
	 * @param categoria Objeto de la clase {@link Categoria} con la información necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando la categoría.
	 */
	public void insert(Categoria categoria) throws MyException;
	
	/**
	 * Actualiza los datos de una categoría en la db.
	 * @param categoria Objeto de la clase {@link Categoria} con la información necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando la categoría.
	 */
	public void update(Categoria categoria) throws MyException;
	
	/**
	 * Elimina los datos de una categoría en la db.
	 * @param categoria Objeto de la clase {@link Categoria} con la información necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando la categoria.
	 */
	public void delete(Categoria categoria) throws MyException;

}
