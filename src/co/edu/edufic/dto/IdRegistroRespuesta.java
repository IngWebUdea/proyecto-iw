package co.edu.edufic.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO almacenar la clave primaria compuesta de la tabla registro_respuestas de la db eduficticia.
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class IdRegistroRespuesta implements Serializable {
	
	private Usuario usuarioId;		//Identificador del usuario que presenta la prueba.
	private Prueba pruebaId;		//Identificador de la prueba.
	private Pregunta preguntaId;	//Identificador de la pregunta.
	
	public Usuario getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Prueba getPruebaId() {
		return pruebaId;
	}
	public void setPruebaId(Prueba pruebaId) {
		this.pruebaId = pruebaId;
	}
	public Pregunta getPreguntaId() {
		return preguntaId;
	}
	public void setPreguntaId(Pregunta preguntaId) {
		this.preguntaId = preguntaId;
	}

}
