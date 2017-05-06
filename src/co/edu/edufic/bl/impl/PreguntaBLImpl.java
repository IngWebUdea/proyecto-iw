package co.edu.edufic.bl.impl;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import co.edu.edufic.bl.PreguntaBL;
import co.edu.edufic.dao.PreguntaDAO;
import co.edu.edufic.dao.TematicaDAO;
import co.edu.edufic.dao.TematicasPorPreguntaDAO;
import co.edu.edufic.dao.UsuarioDAO;
import co.edu.edufic.dto.IdTematicasPorPregunta;
import co.edu.edufic.dto.Pregunta;
import co.edu.edufic.dto.Tematica;
import co.edu.edufic.dto.TematicasPorPregunta;
import co.edu.edufic.dto.Usuario;
import co.edu.edufic.exception.MyException;

public class PreguntaBLImpl implements PreguntaBL {
	
	PreguntaDAO preguntaDAO;
	UsuarioDAO usuarioDAO;
	TematicaDAO tematicaDAO;
	TematicasPorPreguntaDAO tematicasPorPreguntaDAO;
	

	@Override
	public void registrarPregunta(String texto, Integer numOpciones, String jsonOpciones, Character optCorrecta,
			Character nivelDificultad, Integer idTematica, String loginUsuarioCrea, Date fechaCrea) throws MyException {
		
		Pregunta pregunta = null;
		Usuario usuarioCrea = null;
		Tematica tematica = null;
		TematicasPorPregunta tematicasPorPregunta = null;
		IdTematicasPorPregunta idTematicasPorPregunta = null;
		Set<TematicasPorPregunta> tematicas = null;
		
		//JSONObject json;
		
		
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
			throw new MyException("Debe especificar una opción correcta para la pregunta la pregunta");
		}		
		if(nivelDificultad.equals("") || nivelDificultad ==null){
			throw new MyException("Debe especificar el nivel de dificultad para la pregunta la pregunta");
		}
		if(loginUsuarioCrea.isEmpty() || loginUsuarioCrea ==null){
			throw new MyException("El usuario que registra la pregunta es requerido");
		}		
		
		usuarioCrea = usuarioDAO.findById(loginUsuarioCrea);
		if(usuarioCrea == null){
			throw new MyException("Usuario no registrado en el sistema");
		}
		
		tematica = tematicaDAO.findById(idTematica);
		if(tematica == null){
			throw new MyException("Temática no registrada en el sistema");
		}
		
		pregunta = new Pregunta();
		
		pregunta.setTexto(texto);
		pregunta.setNumOpt(numOpciones);
		pregunta.setOpciones(jsonOpciones);
		pregunta.setOptCorrecta(optCorrecta);
		pregunta.setNumOpt(numOpciones);
		pregunta.setNivelDif(nivelDificultad);
		pregunta.setUsuarioCrea(usuarioCrea);
		pregunta.setFechaCrea(fechaCrea);
		
		preguntaDAO.insert(pregunta);	
		
		//Se insertan un objeto en el set que contiene las temáticas
		idTematicasPorPregunta = new IdTematicasPorPregunta();
		idTematicasPorPregunta.setIdPregunta(pregunta);		
		idTematicasPorPregunta.setIdTematica(tematica);
		
		tematicasPorPregunta = new TematicasPorPregunta();
		tematicasPorPregunta.setIdTematicasPorPregunta(idTematicasPorPregunta);		
		
		tematicas = new Set<TematicasPorPregunta>() {
			
			@Override
			public <T> T[] toArray(T[] a) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Iterator<TematicasPorPregunta> iterator() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean addAll(Collection<? extends TematicasPorPregunta> c) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean add(TematicasPorPregunta e) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		tematicas.add(tematicasPorPregunta);
		
		pregunta.setTematicas(tematicas);
		
		tematicasPorPreguntaDAO.insert(tematicasPorPregunta);				
		

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
	
		
}
