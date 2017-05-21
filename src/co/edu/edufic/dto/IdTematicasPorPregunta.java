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
	
	private Tematica tematica;		//Identificador de la temática.
	private Pregunta pregunta;		//Identificador de la pregunta.	
	
	public Tematica getTematica() {
		return tematica;
	}
	public void setTematica(Tematica tematica) {
		this.tematica = tematica;
	}
	public Pregunta getPregunta() {
		return pregunta;
	}
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
}
