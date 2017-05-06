package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.Persona;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los métodos permitidos para las personas en el sistema
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface PersonaDAO {
	
	/**
	 * Obtiene la lista de personas de la db.
	 * @return Lista de personas.
	 * @throws MyException Ocurre cuando hay un error en con la conexión a la db.
	 */
	public List<Persona> allPersonas() throws MyException;
	
	/**
	 * Obtiene una persona dado su id en la db.
	 * @param idPersona Identificador de la persona en la db.
	 * @return persona con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexión con la db
	 */
	public Persona findById(Integer idPersona) throws MyException;
	
	/**
	 * Almacena los datos de una persona en la db.
	 * @param persona Objeto de la clase {@link Persona} con la información necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando el persona.
	 */
	public void insert(Persona persona) throws MyException;
	
	/**
	 * Actualiza los datos de una persona en la db.
	 * @param persona Objeto de la clase {@link Persona} con la información necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando el persona.
	 */
	public void update(Persona persona) throws MyException;
	
	/**
	 * Elimina los datos de una persona en la db.
	 * @param persona Objeto de la clase {@link Persona} con la información necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando el persona.
	 */
	public void delete(Persona persona) throws MyException;
	
}