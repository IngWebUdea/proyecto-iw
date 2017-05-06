package co.edu.edufic.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para almacenar la clave primaria compuesta de la tabla rel_estudiante_acudiente de la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class IdEstudiantePorAcudiente implements Serializable {

	private Persona estudianteId;		//Identificador del estudiante PK
	private Persona acudienteId;		//Identificador del acudiente PK
	private Grupo grupoId;				//Identificador del grupo PK.	
	
	public Persona getEstudianteId() {
		return estudianteId;
	}
	public void setEstudianteId(Persona estudianteId) {
		this.estudianteId = estudianteId;
	}
	public Persona getAcudienteId() {
		return acudienteId;
	}
	public void setAcudienteId(Persona acudienteId) {
		this.acudienteId = acudienteId;
	}
	public Grupo getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(Grupo grupoId) {
		this.grupoId = grupoId;
	}
	
}
