package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.PreguntaDAO;
import co.edu.edufic.dto.Pregunta;
import co.edu.edufic.exception.MyException;

public class PreguntaDAOImpl implements PreguntaDAO {
	
	private SessionFactory sessionFactory;

	@Override
	public List<Pregunta> allPreguntas() throws MyException {		
		Session session = null;
		Criteria criteria = null;
		List<Pregunta> preguntas = new ArrayList<Pregunta>();
		
		try{			
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Pregunta.class);			
			preguntas = criteria.list();	
			
		}catch(HibernateException e){
			throw new MyException("Error consultando las preguntas en la db");
		}		
		return preguntas;
	}
	
//	@Override
//	public List<Pregunta> allPreguntasByTematica(Integer idTematica) throws MyException{
//		Session session = null;
//		Criteria criteria = null;
//		List<Pregunta> preguntas = new ArrayList<Pregunta>();
//		
//		try{			
//			session = sessionFactory.getCurrentSession();
//			criteria = session.createCriteria(Pregunta.class);			
//			preguntas = criteria.list();	
//			
//		}catch(HibernateException e){
//			throw new MyException("Error consultando las preguntas en la db");
//		}		
//		return preguntas;
//	}
//	

	@Override
	public Pregunta findById(Integer idPregunta) throws MyException {

		Session session = null;
		Pregunta pregunta = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			pregunta = (Pregunta)session.get(Pregunta.class, idPregunta);
			
		}catch(HibernateException e){
			throw new MyException("Error consultando la pregunta en la db");
		}
		
		return pregunta;
	}

	@Override
	public void insert(Pregunta pregunta) throws MyException {
		
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(pregunta);
			
		}catch(HibernateException e){
			throw new MyException("Error guardando la pregunta en la db");
		}
	}

	@Override
	public void update(Pregunta pregunta) throws MyException {

		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.update(pregunta);
			
		}catch(HibernateException e){
			throw new MyException("Error actualizando la pregunta en la db");
		}

	}

	@Override
	public void delete(Pregunta pregunta) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();			
			session.delete(pregunta);
			
		}catch(HibernateException e){
			throw new MyException("Error borrando la pregunta en la db");
		}

	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
