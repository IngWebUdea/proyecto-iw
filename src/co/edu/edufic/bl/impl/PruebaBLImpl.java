package co.edu.edufic.bl.impl;

import java.sql.Time;
import java.util.Date;

import co.edu.edufic.bl.PruebaBL;
import co.edu.edufic.dao.CategoriaDAO;
import co.edu.edufic.dao.PreguntaDAO;
import co.edu.edufic.dao.PruebaDAO;
import co.edu.edufic.dao.TematicasPorPreguntaDAO;
import co.edu.edufic.dao.UsuarioDAO;
import co.edu.edufic.dto.Categoria;
import co.edu.edufic.dto.Prueba;
import co.edu.edufic.dto.Usuario;
import co.edu.edufic.exception.MyException;

public class PruebaBLImpl implements PruebaBL {
	
	PruebaDAO pruebaDAO; 
	UsuarioDAO usuarioDAO;
	PreguntaDAO preguntaDAO;
	CategoriaDAO categoriaDAO;
	TematicasPorPreguntaDAO tematicasPorPreguntaDAO;
	
	@Override
	public void registrarPrueba(String codigo, String categoriaId, Integer numPreguntas, Time duracion, Date fechaCrea,
			String loginUsuarioCrea, Boolean aleatoria, String descripcion) throws MyException {

		Prueba prueba = null;
		Usuario usuarioCrea = null;
		Categoria categoria = null;
		
		if(codigo.isEmpty() || codigo ==null){
			throw new MyException("El código de la prueba es requerido");
		}
		if(categoriaId.isEmpty() || categoriaId ==null){
			throw new MyException("La categoría de la prueba es requerido");
		}
		if(numPreguntas ==null){
			throw new MyException("El número de preguntas de la prueba es requerido");
		}
		if(duracion ==null){
			throw new MyException("La duración de la prueba es requerido");
		}
		if(fechaCrea ==null){
			throw new MyException("La fecha de registro de la prueba es requerido");
		}
		if(loginUsuarioCrea.isEmpty() || loginUsuarioCrea ==null){
			throw new MyException("El usuario que reegistra la prueba es requerido");
		}
		if(aleatoria == null){
			throw new MyException("Debe decir si la prueba es aleatoria o no");
		}
		if(descripcion.isEmpty() || descripcion ==null){
			throw new MyException("La descripción de la prueba es requerida");
		}
		
		usuarioCrea = usuarioDAO.findById(loginUsuarioCrea);
		if(usuarioCrea == null){
			throw new MyException("Usuario no registrado en el sistema");
		}
		
		categoria = categoriaDAO.findById(categoriaId);
		if(categoria == null){
			throw new MyException("La categoría asignada no esatá registrada en el sistema");
		}
		
		prueba = new  Prueba();
		
		prueba.setCodigo(codigo);
		prueba.setCategoria(categoria);
		prueba.setNumPreguntas(numPreguntas);
		prueba.setDuracion(duracion);
		prueba.setUsuarioCrea(usuarioCrea);
		prueba.setAleatoria(aleatoria);
		prueba.setDescripcion(descripcion);
				
		pruebaDAO.insert(prueba);

	}
	
	

	public PruebaDAO getPruebaDAO() {
		return pruebaDAO;
	}
	public void setPruebaDAO(PruebaDAO pruebaDAO) {
		this.pruebaDAO = pruebaDAO;
	}
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	public PreguntaDAO getPreguntaDAO() {
		return preguntaDAO;
	}
	public void setPreguntaDAO(PreguntaDAO preguntaDAO) {
		this.preguntaDAO = preguntaDAO;
	}
	
	public CategoriaDAO getCategoriaDAO() {
		return categoriaDAO;
	}
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}
	public TematicasPorPreguntaDAO getTematicasPorPreguntaDAO() {
		return tematicasPorPreguntaDAO;
	}
	public void setTematicasPorPreguntaDAO(TematicasPorPreguntaDAO tematicasPorPreguntaDAO) {
		this.tematicasPorPreguntaDAO = tematicasPorPreguntaDAO;
	}
	
}
