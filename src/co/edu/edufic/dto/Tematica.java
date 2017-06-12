package co.edu.edufic.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para los datos de la tabla tematicas en la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class Tematica implements Serializable {
	
	private Integer idTematica;		//Identificador de la temática.
	private String tematica;		//Nombre de la temática.
	private String sugAprend;		//Sugerencia de aprendizaje para la temática
	private Integer idArea;			//Área a la que pertenece la temática.
	
	public Integer getIdTematica() {
		return idTematica;
	}
	public void setIdTematica(Integer idTematica) {
		this.idTematica = idTematica;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public String getSugAprend() {
		return sugAprend;
	}
	public void setSugAprend(String sugAprend) {
		this.sugAprend = sugAprend;
	}
	public Integer getIdArea() {
		return idArea;
	}
	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}
	
}
