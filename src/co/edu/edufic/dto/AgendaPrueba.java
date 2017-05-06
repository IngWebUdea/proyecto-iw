package co.edu.edufic.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para los datos de la tabla agenda_pruebas de la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class AgendaPrueba implements Serializable {
	
	private IdAgendaPrueba idAgendaPrueba;		//Clave primaria compuesta.
	private Usuario usuarioEncargado;			//Usuario que aplica la prueba.
	private Usuario usuarioCrea;				//Usuario que crea la prueba.
	private Usuario usuarioModifica;			//Usuario que modifica la prueba.
	private Usuario usuarioCancela;				//Usuario que cancela la prueba.	
	private Date fechaCrea;						//Fecha que se crea la prueba.
	private Date fechaMoodifica;				//Fecha que se modifica la prueba.
	private Date fechaCancela;					//Fecha que se cancela la prueba.
	private Boolean cancelado;					//Indica si una prueba ha sido cancelada.
	
	
	public IdAgendaPrueba getIdAgendaPrueba() {
		return idAgendaPrueba;
	}
	public void setIdAgendaPrueba(IdAgendaPrueba idAgendaPrueba) {
		this.idAgendaPrueba = idAgendaPrueba;
	}
	public Usuario getUsuarioEncargado() {
		return usuarioEncargado;
	}
	public void setUsuarioEncargado(Usuario usuarioEncargado) {
		this.usuarioEncargado = usuarioEncargado;
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
	public Usuario getUsuarioCancela() {
		return usuarioCancela;
	}
	public void setUsuarioCancela(Usuario usuarioCancela) {
		this.usuarioCancela = usuarioCancela;
	}	
	public Date getFechaCrea() {
		return fechaCrea;
	}
	public void setFechaCrea(Date fechaCrea) {
		this.fechaCrea = fechaCrea;
	}
	public Date getFechaMoodifica() {
		return fechaMoodifica;
	}
	public void setFechaMoodifica(Date fechaMoodifica) {
		this.fechaMoodifica = fechaMoodifica;
	}
	public Date getFechaCancela() {
		return fechaCancela;
	}
	public void setFechaCancela(Date fechaCancela) {
		this.fechaCancela = fechaCancela;
	}
	public Boolean getCancelado() {
		return cancelado;
	}
	public void setCancelado(Boolean cancelado) {
		this.cancelado = cancelado;
	}
	
	
}
