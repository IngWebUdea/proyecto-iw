
package co.edu.edufic.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para la tabla paises en la db eduficticia
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class Pais implements Serializable {
	
	private Integer idPais;			//Identificador del pais
	private String codigo;			//C�digo del pais
	private String pais;			//Nombre del pais
	
	public Integer getIdPais() {
		return idPais;
	}
	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

}
