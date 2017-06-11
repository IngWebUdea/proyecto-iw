package co.edu.edufic.bl.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.edufic.bl.TematicaBL;
import co.edu.edufic.dao.AreaDAO;
import co.edu.edufic.dao.PreguntaDAO;
import co.edu.edufic.dao.TematicaDAO;
import co.edu.edufic.dao.TematicasPorPreguntaDAO;
import co.edu.edufic.dto.Area;
import co.edu.edufic.dto.Pregunta;
import co.edu.edufic.dto.Tematica;
import co.edu.edufic.dto.TematicasPorPregunta;
import co.edu.edufic.exception.MyException;

public class TematicaBLImp implements TematicaBL {
	
	TematicaDAO tematicaDAO;
	TematicasPorPreguntaDAO tematicasPorPreguntaDAO;
	AreaDAO areaDAO;

	@Override
	public List<Tematica> tematicas() throws MyException {
		
		List<Tematica> tematicas = new ArrayList<Tematica>();
		tematicas = tematicaDAO.allTematicas();
		
		return tematicas;
	}
	
	@Override
	public List<Tematica> tematicasByArea(Integer idArea) throws MyException {
		
		List<Tematica> tematicas = new ArrayList<Tematica>();
		Area area = null;
		
		if(idArea.equals(null)){
			new Exception("El campo área es requerido");
		}	
		
		area = areaDAO.findById(idArea);
		if(area.equals(null)){
			new Exception("El área especificada no se encuentra en el sistema");
		}		
		tematicas = tematicaDAO.allTematicasByArea(idArea);
		return tematicas;
	}	
	
	@Override
	public Tematica tematicaById(Integer idTematica) throws MyException {

		Tematica tematica = null;		
		if(idTematica.equals(null)){
			new Exception("El campo temática es requerido");
		}		
		tematica = tematicaDAO.findById(idTematica);
		
		return tematica;
	}
	
	public List<Pregunta> preguntasByIdTematica(Integer idTematica) throws MyException {
		
		List<TematicasPorPregunta> tematicasPorPregunta = new ArrayList<TematicasPorPregunta>();
		List<Pregunta> preguntas = new ArrayList<Pregunta>();
		if(idTematica.equals(null)){
			new Exception("El campo temática es requerido");
		}
		
		tematicasPorPregunta = tematicasPorPreguntaDAO.allTematicasPorPreguntasByTematica(idTematica);	
		for(TematicasPorPregunta tpr : tematicasPorPregunta){
			preguntas.add(tpr.getIdTematicasPorPregunta().getPregunta());
		}
		
		return preguntas;
	}

	@Override
	public void registrarTematica(String nombreTematica, Integer idArea, String sugAprend) throws MyException {
		
		Tematica tematica = null;
		Area area = null;
		
		if(nombreTematica.isEmpty() || nombreTematica.equals("")){
			new Exception("El campo nombre de temática es requerido");
		}
		if(idArea.equals(null)){
			new Exception("El campo área es requerido");
		}
		
		area = areaDAO.findById(idArea);
		if(area.equals(null)){
			new Exception("El área especificada no se encuentra en el sistema");
		}
		if(sugAprend.length() > 512){
			new Exception("El campo sugerencia de aprendizaje no puede superar 512 caracteres de longitud");
		}		
				
		tematica = new Tematica();
		tematica.setTematica(nombreTematica);
		tematica.setArea(area);
		tematica.setSugAprend(sugAprend);		
		tematicaDAO.insert(tematica);		
	}	
	
	public TematicaDAO getTematicaDAO() {
		return tematicaDAO;
	}
	public void setTematicaDAO(TematicaDAO tematicaDAO) {
		this.tematicaDAO = tematicaDAO;
	}
	public TematicasPorPreguntaDAO getTematicasPorPreguntaDAO() {
		return tematicasPorPreguntaDAO;
	}
	public void setTematicasPorPreguntaDAO(TematicasPorPreguntaDAO tematicasPorPreguntaDAO) {
		this.tematicasPorPreguntaDAO = tematicasPorPreguntaDAO;
	}
	public AreaDAO getAreaDAO() {
		return areaDAO;
	}
	public void setAreaDAO(AreaDAO areaDAO) {
		this.areaDAO = areaDAO;
	}
		
}
