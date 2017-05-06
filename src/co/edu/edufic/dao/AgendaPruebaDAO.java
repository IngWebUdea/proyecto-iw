package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.AgendaPrueba;
import co.edu.edufic.dto.IdAgendaPrueba;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los m�todos permitidos para las agendaPruebas en el sistema
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
public interface AgendaPruebaDAO {
	/**
	 * Obtiene la lista de agendaPruebas de la db.
	 * @return Lista de agendaPruebas.
	 * @throws MyException Ocurre cuando hay un error en la conexi�n a la db.
	 */
	public List<AgendaPrueba> allAgendaPruebas() throws MyException;
	
	/**
	 * Obtiene una agendaPrueba dado su id en la db.
	 * @param idAgendaPrueba Identificador de la agendaPrueba en la db.
	 * @return agendaPrueba con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexi�n con la db
	 */
	public AgendaPrueba findById(IdAgendaPrueba idAgendaPrueba) throws MyException;
	
	/**
	 * Almacena los datos de una agendaPrueba en la db.
	 * @param agendaPrueba Objeto de la clase {@link AgendaPrueba} con la informaci�n necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando la agendaPrueba.
	 */
	public void insert(AgendaPrueba agendaPrueba) throws MyException;
	
	/**
	 * Actualiza los datos de una agendaPrueba en la db.
	 * @param agendaPrueba Objeto de la clase {@link AgendaPrueba} con la informaci�n necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando la agendaPrueba.
	 */
	public void update(AgendaPrueba agendaPrueba) throws MyException;
	
	/**
	 * Elimina los datos de una agendaPrueba en la db.
	 * @param agendaPrueba Objeto de la clase {@link AgendaPrueba} con la informaci�n necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando la agendaPrueba.
	 */
	public void delete(AgendaPrueba agendaPrueba) throws MyException;
}
