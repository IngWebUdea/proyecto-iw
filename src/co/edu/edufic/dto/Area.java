package co.edu.edufic.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para los datos de la tabla areas en la db eduficticia
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class Area implements Serializable {
	
	private Integer idArea;		//Identificador del �rea.
	private String area;		//Nombre del �rea.
	
	public Integer getIdArea() {
		return idArea;
	}
	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
}
