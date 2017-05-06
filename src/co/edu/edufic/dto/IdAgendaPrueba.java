package co.edu.edufic.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para almacenar la clave primaria compuesta de la tabla agenda_pruebas de la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class IdAgendaPrueba implements Serializable {
	
	private Prueba pruebaId;					//Identificador de la prueba.
	private Grupo grupoId;						//Identificador del grupo.
	private Date fechaAplica;					//Fecha que se aplica la prueba.
	
	public Prueba getPruebaId() {
		return pruebaId;
	}
	public void setPruebaId(Prueba pruebaId) {
		this.pruebaId = pruebaId;
	}
	public Grupo getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(Grupo grupoId) {
		this.grupoId = grupoId;
	}
	public Date getFechaAplica() {
		return fechaAplica;
	}
	public void setFechaAplica(Date fechaAplica) {
		this.fechaAplica = fechaAplica;
	}

}
