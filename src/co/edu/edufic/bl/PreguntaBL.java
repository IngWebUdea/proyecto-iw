package co.edu.edufic.bl;

import java.util.Date;
import java.util.List;

import co.edu.edufic.dto.Pregunta;
import co.edu.edufic.dto.Usuario;
import co.edu.edufic.exception.MyException;

/**
 * Interface para los métodos permitidos para las preguntas en la capa de lógica de negocio
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface PreguntaBL {

	/**
	 * Método para el registro de una pregunta por parte de un usuario.
	 * @param texto Enunciado de la pregunta.
	 * @param numOpciones Cantidad de opciones que tiene la pregunta.
	 * @param jsonOpciones Arrego JSON con las opciones de la pregunta.
	 * @param optCorrecta Opción correcta a la pregunta.
	 * @param nivelDificultad Nivel de dificultad de la pregunta.
	 * @param idtematica Identificador de la temática a la que pertenece la pregunta.
	 * @param loginUsuarioCrea Nombre de usuario creador de la pregunta.
	 * @throws MyException Ocurre cuando hay un error en la creación de la pregunta.
	 */
	public void registrarPregunta(String texto, Integer numOpciones, String jsonOpciones, Character optCorrecta, 
			Character nivelDificultad, Integer idTematica, String loginUsuarioCrea, Date fechaCrea)throws MyException;
	
	/**
	 * Consulta las preguntas que pertenecen a una temática específica.
	 * @param idTematica Identificador de la temática.
	 * @return Lista con las preguntas pertenecientes a la temática dada.
	 * @throws MyException Ocurre cuando hay un error consultando las preguntas en la db.
	 */
	public List<Pregunta> preguntasPorTematica(Integer idTematica) throws MyException;
	
	/**
	 * Consulta las preguntas que pertenecen a un área específica.
	 * @param idArea Identificador del área.
	 * @return Lista con las preguntas pertenecientes al área dada.
	 * @throws MyException Ocurre cuando hay un error consultando las preguntas en la db.
	 */ 
	public List<Pregunta> preguntasPorArea(Integer idArea) throws MyException;
	
	public List<Pregunta> preguntas() throws MyException;
	
	
	
	
	
}
