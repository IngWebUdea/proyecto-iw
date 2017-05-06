package co.edu.edufic.bl;

import java.util.Date;
import java.util.List;

import co.edu.edufic.dto.Pregunta;
import co.edu.edufic.dto.Usuario;
import co.edu.edufic.exception.MyException;

/**
 * Interface para los m�todos permitidos para las preguntas en la capa de l�gica de negocio
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
public interface PreguntaBL {

	/**
	 * M�todo para el registro de una pregunta por parte de un usuario.
	 * @param texto Enunciado de la pregunta.
	 * @param numOpciones Cantidad de opciones que tiene la pregunta.
	 * @param jsonOpciones Arrego JSON con las opciones de la pregunta.
	 * @param optCorrecta Opci�n correcta a la pregunta.
	 * @param nivelDificultad Nivel de dificultad de la pregunta.
	 * @param idtematica Identificador de la tem�tica a la que pertenece la pregunta.
	 * @param loginUsuarioCrea Nombre de usuario creador de la pregunta.
	 * @throws MyException Ocurre cuando hay un error en la creaci�n de la pregunta.
	 */
	public void registrarPregunta(String texto, Integer numOpciones, String jsonOpciones, Character optCorrecta, 
			Character nivelDificultad, Integer idtematica, String loginUsuarioCrea, Date fechaCrea)throws MyException;
	
	
	
}
