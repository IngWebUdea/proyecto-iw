package co.edu.edufic.dao;

import java.util.List;

import co.edu.edufic.dto.IdPreguntasPorPrueba;
import co.edu.edufic.dto.PreguntasPorPrueba;
import co.edu.edufic.exception.MyException;

/**
 * Interface que define los métodos permitidos para las preguntasPorPruebas en el sistema
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface PreguntasPorPruebaDAO {	
	/**
	 * Obtiene la lista de preguntasPorPruebas de la db.
	 * @return Lista de preguntasPorPruebas.
	 * @throws MyException Ocurre cuando hay un error en la conexión a la db.
	 */
	public List<PreguntasPorPrueba> allPreguntasPorPruebas() throws MyException;
	
	/**
	 * Obtiene una preguntasPorPrueba dado su id en la db.
	 * @param idPreguntasPorPrueba Identificador de la preguntasPorPrueba en la db.
	 * @return preguntasPorPrueba con el identificador dado.
	 * @throws MyException Cuando hay un error en la conexión con la db
	 */
	public PreguntasPorPrueba findById(IdPreguntasPorPrueba idPreguntasPorPrueba) throws MyException;
	
	/**
	 * Almacena los datos de una preguntasPorPrueba en la db.
	 * @param preguntasPorPrueba Objeto de la clase {@link PreguntasPorPrueba} con la información necesaria para ser almacenado.
	 * @throws MyException Ocurre cuando hay un error almacenando la preguntasPorPrueba.
	 */
	public void insert(PreguntasPorPrueba preguntasPorPrueba) throws MyException;
	
	/**
	 * Actualiza los datos de una preguntasPorPrueba en la db.
	 * @param preguntasPorPrueba Objeto de la clase {@link PreguntasPorPrueba} con la información necesaria para ser actualizado.
	 * @throws MyException Ocurre cuando hay un error actualizando la preguntasPorPrueba.
	 */
	public void update(PreguntasPorPrueba preguntasPorPrueba) throws MyException;
	
	/**
	 * Elimina los datos de una preguntasPorPrueba en la db.
	 * @param preguntasPorPrueba Objeto de la clase {@link PreguntasPorPrueba} con la información necesaria para ser eliminado.
	 * @throws MyException Ocurre cuando hay un error eliminando la preguntasPorPrueba.
	 */
	public void delete(PreguntasPorPrueba preguntasPorPrueba) throws MyException;
	

}
