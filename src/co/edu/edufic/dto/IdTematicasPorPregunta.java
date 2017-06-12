package co.edu.edufic.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para almacenar la clave compuesta de la tabla tematicas_has_preguntas en la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public class IdTematicasPorPregunta implements Serializable {
	
	private Integer idTematica;		//Identificador de la temática.
	private Pregunta pregunta;		//Identificador de la pregunta.	
	
	public Integer getIdTematica() {
		return idTematica;
	}
	public void setIdTematica(Integer idTematica) {
		this.idTematica = idTematica;
	}
	public Pregunta getPregunta() {
		return pregunta;
	}
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
}
