package co.edu.edufic.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para los datos dela tabla personas de la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class Persona implements Serializable {
	
	private String idPersona;			//Identificador de la persona en la db.
	private String nombre;				//Nombre de la persona.
	private String apellido;			//Apellido de las persona.
	private String telefono;			//Número telefónico de la persona.
	private String email;				//Correo electrónico de la persona.
	private String institucion;			//Institución educativa a la que pertenece.
	private Date fechaNacimiento;		//Fecha de naciamiento de la persona.
	private TipoDoc tipoDocumento;		//Tipo de documento de la persona.
	private Ciudad ciudad;				//Ciudad de residencia de la persona.
	
	public String getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInstitucion() {
		return institucion;
	}
	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public TipoDoc getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDoc tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
}
