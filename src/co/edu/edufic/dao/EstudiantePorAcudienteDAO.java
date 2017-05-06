package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.EstudiantePorAcudiente;
import co.edu.edufic.dto.IdEstudiantePorAcudiente;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los métodos permitidos para los estudiantePorAcudientes en el sistema
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface EstudiantePorAcudienteDAO {
	
	/**
	 * Obtiene la lista de estudiantePorAcudientes de la db.
	 * @return Lista de estudiantePorAcudientes.
	 * @throws MyException Ocurre cuando hay un error en la conexión a la db.
	 */
	public List<EstudiantePorAcudiente> allEstudiantePorAcudientes() throws MyException;
	
	/**
	 * Obtiene un estudiantePorAcudiente dado su id en la db.
	 * @param idEstudiantePorAcudiente Identificador del estudiantePorAcudiente en la db.
	 * @return estudiantePorAcudiente con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexión con la db
	 */
	public EstudiantePorAcudiente findById(IdEstudiantePorAcudiente idEstudiantePorAcudiente) throws MyException;
	
	/**
	 * Almacena los datos de un estudiantePorAcudiente en la db.
	 * @param estudiantePorAcudiente Objeto de la clase {@link EstudiantePorAcudiente} con la información necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando el estudiantePorAcudiente.
	 */
	public void insert(EstudiantePorAcudiente estudiantePorAcudiente) throws MyException;
	
	/**
	 * Actualiza los datos de un estudiantePorAcudiente en la db.
	 * @param estudiantePorAcudiente Objeto de la clase {@link EstudiantePorAcudiente} con la información necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando el estudiantePorAcudiente.
	 */
	public void update(EstudiantePorAcudiente estudiantePorAcudiente) throws MyException;
	
	/**
	 * Elimina los datos de un estudiantePorAcudiente en la db.
	 * @param estudiantePorAcudiente Objeto de la clase {@link EstudiantePorAcudiente} con la información necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando el estudiantePorAcudiente.
	 */
	public void delete(EstudiantePorAcudiente estudiantePorAcudiente) throws MyException;

}
