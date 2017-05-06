package co.edu.edufic.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para la tabla tipos_doc en la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class TipoDoc implements Serializable{
	
	private Integer idTipoDoc;			//Identificador del tipo de documento
	private String tipo;				//Descripción del tipo de documento
	
	public Integer getIdTipoDoc() {
		return idTipoDoc;
	}
	public void setIdTipoDoc(Integer idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
