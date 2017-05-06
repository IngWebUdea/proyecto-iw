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
	private Boolean activo;											//Indica si el estudiante está activo en el sistema.
	private Usuario usuarioCrea;									//Usuario que crea el estuduante.
	private Usuario usuarioModifica;								//Usuario que modifica el estudiante.
	private Date fechaCrea;											//Fecha de creación del estudiante.
	private Date fechaModifica;										//Fecha de modificación del estudiante.
	
	public EstudiantePorAcudiente(){ }

	/**
	 * Constructo r para instanciar objetos de la clase con los parámetros mínimos necesarios para la persistencnia
	 * @param idEstudiantePorAcudiente Clave primaria compuesta 
	 * @param activo Indica si el el estudiante es activo o no en el sistema
	 * @param usuarioCrea Usuario que crea el Estudiante
	 * @param fechaCrea Fecha de creación del Estudiante
	 */
	public EstudiantePorAcudiente(IdEstudiantePorAcudiente idEstudiantePorAcudiente, Boolean activo,
			Usuario usuarioCrea, Date fechaCrea) {
		
		this.idEstudiantePorAcudiente = idEstudiantePorAcudiente;
		this.activo = activo;
		this.usuarioCrea = usuarioCrea;
		this.fechaCrea = fechaCrea;
	}
	
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public Usuario getUsuarioCrea() {
		return usuarioCrea;
	}
	public void setUsuarioCrea(Usuario usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}
	public Usuario getUsuarioModifica() {
		return usuarioModifica;
	}
	public void setUsuarioModifica(Usuario usuarioModifica) {
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

	public IdEstudiantePorAcudiente getIdEstudiantePorAcudiente() {
		return idEstudiantePorAcudiente;
	}

	public void setIdEstudiantePorAcudiente(IdEstudiantePorAcudiente idEstudiantePorAcudiente) {
		this.idEstudiantePorAcudiente = idEstudiantePorAcudiente;
	}
	
}
