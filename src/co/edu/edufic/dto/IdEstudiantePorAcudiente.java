package co.edu.edufic.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para almacenar la clave primaria compuesta de la tabla rel_estudiante_acudiente de la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public class IdEstudiantePorAcudiente implements Serializable {

	private String idEstudiante;		//Identificador del estudiante PK
	private String idAcudiente;		//Identificador del acudiente PK
	
	public String getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(String idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	public String getIdAcudiente() {
		return idAcudiente;
	}
	public void setIdAcudiente(String idAcudiente) {
		this.idAcudiente = idAcudiente;
	}

}
