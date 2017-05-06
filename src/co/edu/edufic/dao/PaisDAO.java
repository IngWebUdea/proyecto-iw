/**
 * 
 */
package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.Pais;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los m�todos permitidos para los paises en el sistema
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
public interface PaisDAO {
	
	/**
	 * Obtiene la lista de paises de la db.
	 * @return Lista de paises.
	 * @throws MyException Ocurre cuando hay un error en con la conexi�n a la db.
	 */
	public List<Pais> allPaises() throws MyException;
	
	/**
	 * Obtiene un pais dado su id en la db.
	 * @param idPais Identificador del pa�s en la db.
	 * @return El pa�s con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexi�n con la db
	 */
	public Pais findById(Integer idPais) throws MyException;
	
	/**
	 * Almacena los datos de un pais en la db.
	 * @param pais Objeto de la clase {@link Pais} con la informaci�n necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando el pais.
	 */
	public void insert(Pais pais) throws MyException;
	
	/**
	 * Actualiza los datos de un pais en la db.
	 * @param pais Objeto de la clase {@link Pais} con la informaci�n necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando el pais.
	 */
	public void update(Pais pais) throws MyException;
	
	/**
	 * Elimina los datos de un pais en la db.
	 * @param pais Objeto de la clase {@link Pais} con la informaci�n necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando el pais.
	 */
	public void delete(Pais pais) throws MyException;

}
