package co.edu.edufic.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para los datos de la tabla grados en la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class Grado implements Serializable {
	
	private Integer idGrado;			//Identificación del grado en la db.
	private String descripcion;			//Nombre del grado.
	
	public Integer getIdGrado() {
		return idGrado;
	}
	public void setIdGrado(Integer idGrado) {
		this.idGrado = idGrado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
