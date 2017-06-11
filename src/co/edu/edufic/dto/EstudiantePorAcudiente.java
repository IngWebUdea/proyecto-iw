package co.edu.edufic.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *  Clase DTO para los datos de la tabla rel_estudiante_acudiente de la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class EstudiantePorAcudiente implements Serializable {	
	
	private IdEstudiantePorAcudiente idEstudiantePorAcudiente;		//Clave primaria compuesta.
	private String idGrupo;											//Identificador del grupo.	
	private Boolean activo;											//Indica si el estudiante está activo en el sistema.
	private String usuarioCrea;										//Usuario que crea el estuduante.
	private String usuarioModifica;									//Usuario que modifica el estudiante.
	private Date fechaCrea;											//Fecha de creación del estudiante.
	private Date fechaModifica;										//Fecha de modificación del estudiante.
	
	public IdEstudiantePorAcudiente getIdEstudiantePorAcudiente() {
		return idEstudiantePorAcudiente;
	}
	public void setIdEstudiantePorAcudiente(IdEstudiantePorAcudiente idEstudiantePorAcudiente) {
		this.idEstudiantePorAcudiente = idEstudiantePorAcudiente;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public String getUsuarioCrea() {
		return usuarioCrea;
	}
	public void setUsuarioCrea(String usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}
	public String getUsuarioModifica() {
		return usuarioModifica;
	}
	public void setUsuarioModifica(String usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}
	public Date getFechaCrea() {
		return fechaCrea;
	}
	public void setFechaCrea(Date fechaCrea) {
		this.fechaCrea = fechaCrea;
	}
	public Date getFechaModifica() {
		return fechaModifica;
	}
	public void setFechaModifica(Date fechaModifica) {
		this.fechaModifica = fechaModifica;
	}
	public String getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
	}
	
}
