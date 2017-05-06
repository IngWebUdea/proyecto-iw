package co.edu.edufic.dto;

import java.io.Serializable;
import java.sql.Time;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para los datos de la tabla registro_respuestas de la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class RegistroRespuesta implements Serializable {
	
	private IdRegistroRespuesta idRegistroRespuesta;		//Clave primaria compuesta.
	private Character respuesta;							//Respuesta seleccionada entre las opciones.
	private Time demora;									//Tiempo que se demora en responder la preguta.
	private Boolean respondida;								//Indica si la pregunta ha sido respondida o no.
	
	
	public Character getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(Character respuesta) {
		this.respuesta = respuesta;
	}
	public Time getDemora() {
		return demora;
	}
	public void setDemora(Time demora) {
		this.demora = demora;
	}
	public Boolean getRespondida() {
		return respondida;
	}
	public void setRespondida(Boolean respondida) {
		this.respondida = respondida;
	}
	public IdRegistroRespuesta getIdRegistroRespuesta() {
		return idRegistroRespuesta;
	}
	public void setIdRegistroRespuesta(IdRegistroRespuesta idRegistroRespuesta) {
		this.idRegistroRespuesta = idRegistroRespuesta;
	}
	
	
}
