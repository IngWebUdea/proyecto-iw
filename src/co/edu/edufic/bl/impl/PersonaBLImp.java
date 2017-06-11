package co.edu.edufic.bl.impl;

import java.util.Date;

import co.edu.edufic.bl.PersonaBL;
import co.edu.edufic.dao.CiudadDAO;
import co.edu.edufic.dao.EstudiantePorAcudienteDAO;
import co.edu.edufic.dao.PersonaDAO;
import co.edu.edufic.dao.TipoDocDAO;
import co.edu.edufic.dao.UsuarioDAO;
import co.edu.edufic.dto.Ciudad;
import co.edu.edufic.dto.EstudiantePorAcudiente;
import co.edu.edufic.dto.IdEstudiantePorAcudiente;
import co.edu.edufic.dto.Persona;
import co.edu.edufic.dto.TipoDoc;
import co.edu.edufic.exception.MyException;
import co.edu.edufic.util.Validaciones;

public class PersonaBLImp implements PersonaBL {
	
	PersonaDAO personaDAO;
	TipoDocDAO tipoDocDAO;
	CiudadDAO ciudadDAO;
	
	@Override
	public void create(String idPersona, String nombre, String apellido, String telefono, String email, 
			String institucion,	Date fechaNacimiento, Integer idTipoDoc, Integer idCiudad) throws MyException {	
		
		TipoDoc tipoDoc;
		Ciudad ciudad;
		Persona persona;
		
		if(idPersona.isEmpty() || idPersona == null){
			throw new MyException("El campo documento es requerido");
		}	
		if(personaDAO.findById(idPersona) != null){
			throw new MyException("La persona ya se encuentra en el sistema");
		}
		if(nombre.isEmpty() || nombre == null){
			throw new MyException("El campo nombre es requerido");
		}		
		if(apellido.isEmpty() || apellido == null){
			throw new MyException("El campo apellido es requerido");
		}
		if(telefono.isEmpty() || telefono == null){
			throw new MyException("El campo teléfono es requerido");
		}
		if(email.isEmpty() || email == null){
			throw new MyException("El campo email es requerido");
		}
		if(!Validaciones.isEmail(email)){
			throw new MyException("El email es incorrecto");
		}
		if(institucion.isEmpty() || institucion == null){
			throw new MyException("El campo institución es requerido");
		}
		if(fechaNacimiento == null){
			throw new MyException("El campo fecha de nacimiento es requerido");
		}
		//agregar validacion para fechas de nacimiento incosistentes nacer despues de la fecha actual
		// o tener menos cierta edad
		if(idTipoDoc == null){
			throw new MyException("El campo tipo de documento es requerido");
		}
		tipoDoc = tipoDocDAO.findById(idTipoDoc);
		if(tipoDoc == null){
			throw new MyException("El Tipo de documento en erróneo");
		}	
		if(idCiudad == null){
			throw new MyException("El campo Ciudad es requerido");
		}
		ciudad = ciudadDAO.findById(idCiudad);
		if(ciudad == null){
			throw new MyException("Ciudad no encontrada");
		}
		
		
		persona = new Persona();
		persona.setIdPersona(idPersona);
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setTelefono(telefono);
		persona.setEmail(email);
		persona.setInstitucion(institucion);
		persona.setFechaNacimiento(fechaNacimiento);
		persona.setTipoDocumento(tipoDoc);
		persona.setCiudad(ciudad);
		
		personaDAO.insert(persona);

	}

	@Override
	public Persona searchByDoc(String idPersona) throws MyException {
		
		Persona persona;
		
		if(idPersona.isEmpty() || idPersona == null){
			throw new MyException("El campo documento es requerido");
		}
		persona = personaDAO.findById(idPersona);
		if(persona == null){
			throw new MyException("La persona no se encuentra en el sistema");
		}
		return persona;
	}
	
	public PersonaDAO getPersonaDAO() {
		return personaDAO;
	}

	public void setPersonaDAO(PersonaDAO personaDAO) {
		this.personaDAO = personaDAO;
	}

	public TipoDocDAO getTipoDocDAO() {
		return tipoDocDAO;
	}

	public void setTipoDocDAO(TipoDocDAO tipoDocDAO) {
		this.tipoDocDAO = tipoDocDAO;
	}

	public CiudadDAO getCiudadDAO() {
		return ciudadDAO;
	}

	public void setCiudadDAO(CiudadDAO ciudadDAO) {
		this.ciudadDAO = ciudadDAO;
	}
}
