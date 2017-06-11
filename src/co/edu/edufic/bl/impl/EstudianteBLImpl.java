package co.edu.edufic.bl.impl;

import java.util.Date;

import co.edu.edufic.bl.EstudianteBL;
import co.edu.edufic.dao.EstudiantePorAcudienteDAO;
import co.edu.edufic.dao.PersonaDAO;
import co.edu.edufic.dao.UsuarioDAO;
import co.edu.edufic.dto.EstudiantePorAcudiente;
import co.edu.edufic.dto.IdEstudiantePorAcudiente;
import co.edu.edufic.exception.MyException;

public class EstudianteBLImpl implements EstudianteBL{
	
	PersonaDAO personaDAO;
	EstudiantePorAcudienteDAO estudiantePorAcudienteDAO;
	UsuarioDAO usuarioDAO;

	@Override
	public void asignarAcudiente(String idAcudiente, String idEstudiante, String usuarioCrea) throws MyException {
		
		IdEstudiantePorAcudiente id;
		EstudiantePorAcudiente estudiantePorAcudiente;
		
		if(idAcudiente.isEmpty() || idAcudiente == null){
			throw new MyException("El campo documento del acudiente es requerido");
		}		
		if(personaDAO.findById(idAcudiente) == null){
			throw new MyException("La persona acudiente debe estar registrada en el sistema para completar la acción");
		}		
		if(idEstudiante.isEmpty() || idEstudiante == null){
			throw new MyException("El campo documento del estudiante es requerido");
		}
		if(personaDAO.findById(idEstudiante) == null){
			throw new MyException("La persona estudiante debe estar registrada en el sistema para completar la acción");
		}
		if(usuarioCrea.isEmpty() || usuarioCrea == null){
			throw new MyException("El campo usuario creador es requerido");
		}
		if(usuarioDAO.findById(usuarioCrea) == null){
			throw new MyException("El usuario creador debe estar registrado en el sistema para completar la acción");
		}
		
		id = new IdEstudiantePorAcudiente();
		id.setIdAcudiente(idAcudiente);
		id.setIdEstudiante(idEstudiante);		
		if(estudiantePorAcudienteDAO.findById(id) != null){
			throw new MyException("El estudiante ya tiene asignado este acudiente");
		}
		
		estudiantePorAcudiente = new EstudiantePorAcudiente();
		estudiantePorAcudiente.setIdEstudiantePorAcudiente(id);
		estudiantePorAcudiente.setActivo(Boolean.TRUE);
		estudiantePorAcudiente.setUsuarioCrea(usuarioCrea);
		estudiantePorAcudiente.setFechaCrea(new Date());
		estudiantePorAcudienteDAO.insert(estudiantePorAcudiente);
		
	}

	public PersonaDAO getPersonaDAO() {
		return personaDAO;
	}

	public void setPersonaDAO(PersonaDAO personaDAO) {
		this.personaDAO = personaDAO;
	}

	public EstudiantePorAcudienteDAO getEstudiantePorAcudienteDAO() {
		return estudiantePorAcudienteDAO;
	}

	public void setEstudiantePorAcudienteDAO(EstudiantePorAcudienteDAO estudiantePorAcudienteDAO) {
		this.estudiantePorAcudienteDAO = estudiantePorAcudienteDAO;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
}
