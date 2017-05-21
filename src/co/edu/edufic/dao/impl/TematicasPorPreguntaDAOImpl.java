package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.TematicasPorPreguntaDAO;
import co.edu.edufic.dto.IdTematicasPorPregunta;
import co.edu.edufic.dto.TematicasPorPregunta;
import co.edu.edufic.exception.MyException;

public class TematicasPorPreguntaDAOImpl implements TematicasPorPreguntaDAO {

	private SessionFactory sessionFactory;

	@Override
	public List<TematicasPorPregunta> allTematicasPorPreguntas() throws MyException {
		
		Session session = null;
		Criteria criteria = null;
		List<TematicasPorPregunta> tematicasPorPreguntas = new ArrayList<TematicasPorPregunta>();
		
		try{			
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(TematicasPorPregunta.class);	
			
			tematicasPorPreguntas = criteria.list();			
		}catch(HibernateException e){
			throw new MyException("Error consultando las tematicasPorPreguntas en la db");
		}		
		return tematicasPorPreguntas;
	}
	
	@Override
	public  List<TematicasPorPregunta> allTematicasPorPreguntasByTematica(Integer idTematica) throws MyException {
		
		Session session = null;
		Query query = null;
		String strQuery = "";
		 List<TematicasPorPregunta> tematicasPorPreguntas;		
		
		try{
			strQuery = "select t from TematicasPorPregunta t where t.idTematicasPorPregunta.tematica.idTematica=:idTematica";
			session = sessionFactory.getCurrentSession();
			query = session.createQuery(strQuery);
			query.setParameter("idTematica", idTematica);			
			tematicasPorPreguntas = query.list();
				
		}catch(HibernateException e){
			throw new MyException("Error consultando las tematicasPorPreguntas con parámetro en la db");
		}
		return tematicasPorPreguntas;
	}	

	@Override
	public TematicasPorPregunta findById(IdTematicasPorPregunta idTematicasPorPregunta) throws MyException {

		Session session = null;
		TematicasPorPregunta tematicasPorPregunta = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			tematicasPorPregunta = (TematicasPorPregunta)session.get(TematicasPorPregunta.class, idTematicasPorPregunta);
			
		}catch(HibernateException e){
			throw new MyException("Error consultando la tematicasPorPregunta en la db");
		}
		
		return tematicasPorPregunta;
	}

	@Override
	public void insert(TematicasPorPregunta tematicasPorPregunta) throws MyException {
		
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(tematicasPorPregunta);
			
		}catch(HibernateException e){
			throw new MyException("Error guardando la tematicasPorPregunta en la db");
		}
	}

	@Override
	public void update(TematicasPorPregunta tematicasPorPregunta) throws MyException {

		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.update(tematicasPorPregunta);
			
		}catch(HibernateException e){
			throw new MyException("Error actualizando la tematicasPorPregunta en la db");
		}

	}

	@Override
	public void delete(TematicasPorPregunta tematicasPorPregunta) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();			
			session.delete(tematicasPorPregunta);
			
		}catch(HibernateException e){
			throw new MyException("Error borrando la tematicasPorPregunta en la db");
		}

	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
