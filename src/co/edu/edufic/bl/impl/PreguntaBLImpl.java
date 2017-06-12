package co.edu.edufic.bl.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.edufic.bl.PreguntaBL;
import co.edu.edufic.bl.UsuarioBL;
import co.edu.edufic.dao.PerfilPorUsuarioDAO;
import co.edu.edufic.dao.PreguntaDAO;
import co.edu.edufic.dao.TematicaDAO;
import co.edu.edufic.dao.TematicasPorPreguntaDAO;
import co.edu.edufic.dao.UsuarioDAO;
import co.edu.edufic.dto.IdTematicasPorPregunta;
import co.edu.edufic.dto.PerfilPorUsuario;
import co.edu.edufic.dto.Pregunta;
import co.edu.edufic.dto.Tematica;
import co.edu.edufic.dto.TematicasPorPregunta;
import co.edu.edufic.dto.Usuario;
import co.edu.edufic.exception.MyException;

public class PreguntaBLImpl implements PreguntaBL {
	
	public enum PERMISOS_REG_PREG {ADM, ACD, DCN, SCR, DRC};
	@Autowired UsuarioBL usuarioBL;
	
	PreguntaDAO preguntaDAO;
	UsuarioDAO usuarioDAO;
	PerfilPorUsuarioDAO perfilPorUsuarioDAO;
	TematicaDAO tematicaDAO;
	TematicasPorPreguntaDAO tematicasPorPreguntaDAO;
	

	@Override
	public void registrarPregunta(String texto, Integer numOpciones, String jsonOpciones, Character optCorrecta,
			Character nivelDificultad, Integer idTematica, String loginUsuarioCrea) throws MyException {
		
		Pregunta pregunta = null;	
		Tematica tematica = null;		
		Boolean checkPerfil = Boolean.FALSE;
		TematicasPorPregunta tematicasPorPregunta = null;
		IdTematicasPorPregunta idTematicasPorPregunta = null;
		Set<PerfilPorUsuario> perfiles = null;
		
		
		//se validan que los campos sean no vacíos
		if(texto.isEmpty() || texto ==null){
			throw new MyException("El enunciado de la pregunta es requerido");
		}		
		if(numOpciones ==null){
			throw new MyException("Debe especificar un número de opciones de la pregunta");
		}		
		if(jsonOpciones.isEmpty() || jsonOpciones ==null){
			throw new MyException("Debe especificar las opciones de la pregunta");
		}		
		if(optCorrecta.equals("") || optCorrecta ==null){
			throw new MyException("Debe especificar una opción correcta para la pregunta");
		}		
		if(nivelDificultad.equals("") || nivelDificultad ==null){
			throw new MyException("Debe especificar el nivel de dificultad para la pregunta");
		}
		if(loginUsuarioCrea.isEmpty() || loginUsuarioCrea ==null){
			throw new MyException("El usuario que registra la pregunta es requerido");
		}
		if(usuarioDAO.findById(loginUsuarioCrea) == null){
			throw new MyException("Usuario no registrado en el sistema");
		}
		if(idTematica.equals("") || idTematica == null){
			throw new MyException("Debe especificar una temática para la pregunta");
		}
		tematica = tematicaDAO.findById(idTematica);
		if(tematica == null){
			throw new MyException("Temática no registrada en el sistema");
		}		
		//comproobar si el usuario puede crear preguntas según su perfil				
		perfiles = usuarioDAO.findById(loginUsuarioCrea).getPerfiles();		
		for(PERMISOS_REG_PREG permisos : PERMISOS_REG_PREG.values()){
			if(usuarioBL.validarPerfilByCode(perfiles, permisos.toString())){
				checkPerfil = Boolean.TRUE;
				break;
			}
		}		
		if(!checkPerfil){
			throw new MyException("El usuario no tiene permisos para esta acción");
		}
		
		pregunta = new Pregunta();		
		pregunta.setTexto(texto);
		pregunta.setNumOpt(numOpciones);
		pregunta.setOpciones(jsonOpciones);
		pregunta.setOptCorrecta(optCorrecta);
		pregunta.setNumOpt(numOpciones);
		pregunta.setNivelDif(nivelDificultad);
		pregunta.setUsuarioCrea(loginUsuarioCrea);
		pregunta.setFechaCrea(new Date());		
		preguntaDAO.insert(pregunta);	
		
		idTematicasPorPregunta = new IdTematicasPorPregunta();
		idTematicasPorPregunta.setIdTematica(idTematica);
		idTematicasPorPregunta.setPregunta(pregunta);
		tematicasPorPreguntaDAO.insert(tematicasPorPregunta);
	}
	
	@Override
	public List<Pregunta> preguntasPorTematica(Integer idTematica) throws MyException {
		
		List<Pregunta> preguntas = new ArrayList<Pregunta>();
		
		if(idTematica == null){
			throw new MyException("El campo temática es requerido");
		}		
		
		if(tematicaDAO.findById(idTematica) == null){
			throw new MyException("Temática no registrada en el sistema");
		}		
		preguntas = tematicasPorPreguntaDAO.allPreguntasByTematica(idTematica);
		if(preguntas.isEmpty()){
			throw new MyException("No existen preguntas asociadas a la temática");
		}
		return preguntas;
	}
	
	@Override
	public List<Pregunta> preguntasPorArea(Integer idArea) throws MyException{
		
		List<Pregunta> preguntas = new ArrayList<Pregunta>();	
		
		
		return preguntas;
	}
	
	@Override
	public List<Pregunta> preguntas() throws MyException{
		List<Pregunta> preguntas = new ArrayList<Pregunta>();		
		preguntas = preguntaDAO.allPreguntas();
		return preguntas;
	}
	
	public TematicaDAO getTematicaDAO() {
		return tematicaDAO;
	}
	public void setTematicaDAO(TematicaDAO tematicaDAO) {
		this.tematicaDAO = tematicaDAO;
	}
	public PreguntaDAO getPreguntaDAO() {
		return preguntaDAO;
	}
	public void setPreguntaDAO(PreguntaDAO preguntaDAO) {
		this.preguntaDAO = preguntaDAO;
	}
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	public TematicasPorPreguntaDAO getTematicasPorPreguntaDAO() {
		return tematicasPorPreguntaDAO;
	}
	public void setTematicasPorPreguntaDAO(TematicasPorPreguntaDAO tematicasPorPreguntaDAO) {
		this.tematicasPorPreguntaDAO = tematicasPorPreguntaDAO;
	}
	public PerfilPorUsuarioDAO getPerfilPorUsuarioDAO() {
		return perfilPorUsuarioDAO;
	}
	public void setPerfilPorUsuarioDAO(PerfilPorUsuarioDAO perfilPorUsuarioDAO) {
		this.perfilPorUsuarioDAO = perfilPorUsuarioDAO;
	}
	
		
}
