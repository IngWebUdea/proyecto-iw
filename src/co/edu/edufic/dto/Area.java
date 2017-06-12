package co.edu.edufic.dto;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para los datos de la tabla areas en la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class Area implements Serializable {
	
	private Integer idArea;				//Identificador del área.
	private String area;				//Nombre del área.
	private Set<Tematica> tematicas;	//teamticas asociadas al área
	
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
	public Set<Tematica> getTematicas() {
		return tematicas;
	}
	public void setTematicas(Set<Tematica> tematicas) {
		this.tematicas = tematicas;
	}
	
}
