package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.TipoDoc;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los m�todos permitidos para los tipos de documento en el sistema.
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
public interface TipoDocDAO {
	
	/**
	 * Obtiene una lista de os tipos de documento en el sistema
	 * @return Lista con los tipos de documento
	 * @throws MyException Ocurre cuando hay un error con la conexi�n a la db
	 */
	public List<TipoDoc> allTiposDoc() throws MyException;
	
	/**
	 * Obtiene la informaci�n de un tipo de documento dado si identificador
	 * @param idTipoDoc Identificador del tipo de documento.
	 * @return Objeto de la clase {@link TipoDoc} con la informaci�n almacenada.
	 * @throws MyException Ocurre cuando hay un error con la conexi�n a la DB.
	 */
	public TipoDoc findById(Integer idTipoDoc) throws MyException;
	
	/**
	 * Almacena los datos de un tipo de documento en la db.
	 * @param tipoDoc Objeto de la clase {@link TipoDoc} con la informaci�n necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error con la almacenando el tipo de documento en la DB.
	 */
	public void insert(TipoDoc tipoDoc) throws MyException;
	
	/**
	 * Actualiza los datos de un tipo de documento en la db.
	 * @param tipoDoc Objeto de la clase {@link TipoDoc} con la informaci�n necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error con la actualizando el tipo de documento en la DB.
	 */
	public void update(TipoDoc tipoDoc) throws MyException;
	
	/**
	 * Elimina los datos de un tipo de documento en la db.
	 * @param tipoDoc Objeto de la clase {@link TipoDoc} con la informaci�n necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error con la eliminando el tipo de documento en la DB.
	 */
	public void delete(TipoDoc tipoDoc) throws MyException;
	
}
