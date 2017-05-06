package co.edu.edufic.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para almacenar la clave compuesta de la tabla tematicas_has_preguntas en la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class IdTematicasPorPregunta implements Serializable {
	
	private Tematica idTematica;		//Identificador de la temática.
	private Pregunta idPregunta;		//Identificador de la pregunta.
	
	
	public Tematica getIdTematica() {
		return idTematica;
	}
	public void setIdTematica(Tematica idTematica) {
		this.idTematica = idTematica;
	}
	public Pregunta getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(Pregunta idPregunta) {
		this.idPregunta = idPregunta;
	}
}
