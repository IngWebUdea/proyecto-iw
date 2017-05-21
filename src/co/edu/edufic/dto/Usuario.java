package co.edu.edufic.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * Clase DTO para los datos de la tabla usuarios en la db eduficticia.
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class Usuario implements Serializable {
	
	private String login;						//Nombre de usuario.
	private String password;					//Clave de acceso al sistema.
	private Boolean activo;						//Indica si el usuario está activo en el sistema.
	private Usuario usuarioCrea;				//Usuario que crea.
	private Usuario usuarioModifica;			//Usuario que modifica.
	private Date fechaCrea;						//Fecha en la que se crea el usuario.
	private Date fechaModifica;					//Fecha en la que se modifica el cliente.
	private Persona persona;					//Persona a la que corresponde el usuario.	
	private Set<PerfilPorUsuario> perfiles;		//Perfiles asociados al usuario	
	
	public Usuario(){
		
	}
	
	/**
	 * Constructor con parámetros minimos necesarios para la persistencia en db.
	 * @param login Nombre de usuario.
	 * @param password Clave de acceo al sistema.
	 * @param activo Indica si un usuario esta activo dentro del sistema.
	 * @param usuarioCrea Login del usuario creador.
	 * @param fechaCrea Fecha en que se crea el usuario.
	 * @param persona Persona a la que pertenece el usuario.
	 * @param perfiles Conjunto de perfiles asignados al usuario.
	 */
	public Usuario(String login, String password, Boolean activo, Usuario usuarioCrea, Date fechaCrea, Persona persona,
			Set<PerfilPorUsuario> perfiles) {
		this.login = login;
		this.password = password;
		this.activo = activo;
		this.usuarioCrea = usuarioCrea;
		this.fechaCrea = fechaCrea;
		this.persona = persona;
		this.perfiles = perfiles;
	}
	public Set<PerfilPorUsuario> getPerfiles() {
		return perfiles;
	}
	public void setPerfiles(Set<PerfilPorUsuario> perfiles) {
		this.perfiles = perfiles;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
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
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
