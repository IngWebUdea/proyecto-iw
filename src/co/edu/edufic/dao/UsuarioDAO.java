package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.Usuario;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los métodos permitidos para los usuarios en el sistema
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface UsuarioDAO {
	/**
	 * Obtiene la lista de usuarios de la db.
	 * @return Lista de usuarios.
	 * @throws MyException Ocurre cuando hay un error en con la conexión a la db.
	 */
	public List<Usuario> allUsuarios() throws MyException;
	
	/**
	 * Obtiene un usuario dado su id en la db.
	 * @param idUsuario Identificador del usuario en la db.
	 * @return El usuario con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexión con la db
	 */
	public Usuario findById(String idUsuario) throws MyException;
	
	/**
	 * Almacena los datos de un usuario en la db.
	 * @param usuario Objeto de la clase {@link Usuario} con la información necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando el usuario.
	 */
	public void insert(Usuario usuario) throws MyException;
	
	/**
	 * Actualiza los datos de un usuario en la db.
	 * @param usuario Objeto de la clase {@link Usuario} con la información necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando el usuario.
	 */
	public void update(Usuario usuario) throws MyException;
	
	/**
	 * Elimina los datos de un usuario en la db.
	 * @param usuario Objeto de la clase {@link Usuario} con la información necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando el usuario.
	 */
	public void delete(Usuario usuario) throws MyException;

}
