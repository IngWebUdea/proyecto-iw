package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.Perfil;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los m�todos permitidos para los perfiles en el sistema
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
public interface PerfilDAO {
	/**
	 * Obtiene la lista de perfiles de la db.
	 * @return Lista de perfiles.
	 * @throws MyException Ocurre cuando hay un error en la conexi�n a la db.
	 */
	public List<Perfil> allPerfiles() throws MyException;
	
	/**
	 * Obtiene un perfil dado su id en la db.
	 * @param idPerfil Identificador del perfil en la db.
	 * @return perfil con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexi�n con la db
	 */
	public Perfil findById(Integer idPerfil) throws MyException;
	
	/**
	 * Obtiene un perfil dado su c�digo en la db.
	 * @param codePerfil C�digo del perfil en la db.
	 * @return perfil con el c�digo dado.
	 * @throws MyException Cuando hay un error en la conexi�n con la db
	 */
	public Perfil findByCode(String codePerfil) throws MyException;
	
	/**
	 * Almacena los datos de un perfil en la db.
	 * @param perfil Objeto de la clase {@link Perfil} con la informaci�n necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando el perfil.
	 */
	public void insert(Perfil perfil) throws MyException;
	
	/**
	 * Actualiza los datos de un perfil en la db.
	 * @param perfil Objeto de la clase {@link Perfil} con la informaci�n necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando el perfil.
	 */
	public void update(Perfil perfil) throws MyException;
	
	/**
	 * Elimina los datos de un perfil en la db.
	 * @param perfil Objeto de la clase {@link Perfil} con la informaci�n necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando el perfil.
	 */
	public void delete(Perfil perfil) throws MyException;

}
