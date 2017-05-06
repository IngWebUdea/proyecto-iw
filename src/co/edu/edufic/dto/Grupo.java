package co.edu.edufic.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para los datos de la tabla grupos en la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class Grupo implements Serializable {
	
	private String idGrupos;		//Identificador de un grupo.
	private String aula;			//Codigo del aula.
	private Grado idGrado;			//Identificador del grado.
	
	public String getIdGrupos() {
		return idGrupos;
	}
	public void setIdGrupos(String idGrupos) {
		this.idGrupos = idGrupos;
	}
	public String getAula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	public Grado getIdGrado() {
		return idGrado;
	}
	public void setIdGrado(Grado idGrado) {
		this.idGrado = idGrado;
	}
}
