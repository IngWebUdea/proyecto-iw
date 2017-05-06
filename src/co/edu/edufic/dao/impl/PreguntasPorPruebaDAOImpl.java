package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.PreguntasPorPruebaDAO;
import co.edu.edufic.dto.IdPreguntasPorPrueba;
import co.edu.edufic.dto.PreguntasPorPrueba;
import co.edu.edufic.exception.MyException;

public class PreguntasPorPruebaDAOImpl implements PreguntasPorPruebaDAO {
	
	private SessionFactory sessionFactory;

	@Override
	public List<PreguntasPorPrueba> allPreguntasPorPruebas() throws MyException {
		
		Session session = null;
		Criteria criteria = null;
		List<PreguntasPorPrueba> preguntasPorPruebas = new ArrayList<PreguntasPorPrueba>();
		
		try{
			
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(PreguntasPorPrueba.class);
			
			preguntasPorPruebas = criteria.list();			
		}catch(HibernateException e){
			throw new MyException("Error consultando las preguntasPorPruebas en la db");
		}
		
		return preguntasPorPruebas;
	}

	@Override
	public PreguntasPorPrueba findById(IdPreguntasPorPrueba idPreguntasPorPrueba) throws MyException {

		Session session = null;
		PreguntasPorPrueba preguntasPorPrueba = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			preguntasPorPrueba = (PreguntasPorPrueba)session.get(PreguntasPorPrueba.class, idPreguntasPorPrueba);
			
		}catch(HibernateException e){
			throw new MyException("Error consultando la preguntasPorPrueba en la db");
		}
		
		return preguntasPorPrueba;
	}

	@Override
	public void insert(PreguntasPorPrueba preguntasPorPrueba) throws MyException {
		
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(preguntasPorPrueba);
			
		}catch(HibernateException e){
			throw new MyException("Error guardando la preguntasPorPrueba en la db");
		}
	}

	@Override
	public void update(PreguntasPorPrueba preguntasPorPrueba) throws MyException {

		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.update(preguntasPorPrueba);
			
		}catch(HibernateException e){
			throw new MyException("Error actualizando la preguntasPorPrueba en la db");
		}

	}

	@Override
	public void delete(PreguntasPorPrueba preguntasPorPrueba) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();			
			session.delete(preguntasPorPrueba);
			
		}catch(HibernateException e){
			throw new MyException("Error borrando la preguntasPorPrueba en la db");
		}

	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
