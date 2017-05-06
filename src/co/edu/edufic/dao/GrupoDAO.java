package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.Grupo;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los m�todos permitidos para los grupos en el sistema
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
public interface GrupoDAO {
	
	/**
	 * Obtiene la lista de grupos de la db.
	 * @return Lista de grupos.
	 * @throws MyException Ocurre cuando hay un error en la conexi�n a la db.
	 */
	public List<Grupo> allGrupos() throws MyException;
	
	/**
	 * Obtiene un grupo dado su id en la db.
	 * @param idGrupo Identificador del grupo en la db.
	 * @return grupo con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexi�n con la db
	 */
	public Grupo findById(String idGrupo) throws MyException;
	
	/**
	 * Almacena los datos de un grupo en la db.
	 * @param grupo Objeto de la clase {@link Grupo} con la informaci�n necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando el grupo.
	 */
	public void insert(Grupo grupo) throws MyException;
	
	/**
	 * Actualiza los datos de un grupo en la db.
	 * @param grupo Objeto de la clase {@link Grupo} con la informaci�n necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando el grupo.
	 */
	public void update(Grupo grupo) throws MyException;
	
	/**
	 * Elimina los datos de un grupo en la db.
	 * @param grupo Objeto de la clase {@link Grupo} con la informaci�n necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando el grupo.
	 */
	public void delete(Grupo grupo) throws MyException;
	
}
