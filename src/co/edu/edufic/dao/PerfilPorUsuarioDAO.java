package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.IdPerfilPorUsuario;
import co.edu.edufic.dto.PerfilPorUsuario;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los métodos permitidos para los perfilPorUsuario en el sistema
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface PerfilPorUsuarioDAO {

	/**
	 * Obtiene la lista de perfilPorUsuario de la db.
	 * @return Lista de perfilPorUsuario.
	 * @throws MyException Ocurre cuando hay un error en la conexión a la db.
	 */
	public List<PerfilPorUsuario> allPerfilesPorUsuario() throws MyException;
	
	/**
	 * Obtiene un perfilPorUsuario dado su id en la db.
	 * @param idPerfilPorUsuario Identificador del perfilPorUsuario en la db.
	 * @return perfilPorUsuario con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexión con la db
	 */
	public PerfilPorUsuario findById(IdPerfilPorUsuario idPerfilPorUsuario) throws MyException;
	
	/**
	 * Almacena los datos de un perfilPorUsuario en la db.
	 * @param perfilPorUsuario Objeto de la clase {@link PerfilPorUsuario} con la información necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando el perfilPorUsuario.
	 */
	public void insert(PerfilPorUsuario perfilPorUsuario) throws MyException;
	
	/**
	 * Actualiza los datos de un perfilPorUsuario en la db.
	 * @param perfilPorUsuario Objeto de la clase {@link PerfilPorUsuario} con la información necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando el perfilPorUsuario.
	 */
	public void update(PerfilPorUsuario perfilPorUsuario) throws MyException;
	
	/**
	 * Elimina los datos de un perfilPorUsuario en la db.
	 * @param perfilPorUsuario Objeto de la clase {@link PerfilPorUsuario} con la información necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando el perfilPorUsuario.
	 */
	public void delete(PerfilPorUsuario perfilPorUsuario) throws MyException;
}
