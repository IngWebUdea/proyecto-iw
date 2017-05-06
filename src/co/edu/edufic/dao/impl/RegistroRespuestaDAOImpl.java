package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.RegistroRespuestaDAO;
import co.edu.edufic.dto.IdRegistroRespuesta;
import co.edu.edufic.dto.RegistroRespuesta;
import co.edu.edufic.exception.MyException;

public class RegistroRespuestaDAOImpl implements RegistroRespuestaDAO {

	private SessionFactory sessionFactory;

	@Override
	public List<RegistroRespuesta> allRegistroRespuestas() throws MyException {
		
		Session session = null;
		Criteria criteria = null;
		List<RegistroRespuesta> registroRespuestas = new ArrayList<RegistroRespuesta>();
		
		try{
			
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(RegistroRespuesta.class);
			
			registroRespuestas = criteria.list();			
		}catch(HibernateException e){
			throw new MyException("Error consultando los registroRespuestas en la db");
		}
		
		return registroRespuestas;
	}

	@Override
	public RegistroRespuesta findById(IdRegistroRespuesta idRegistroRespuesta) throws MyException {

		Session session = null;
		RegistroRespuesta registroRespuesta = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			registroRespuesta = (RegistroRespuesta)session.get(RegistroRespuesta.class, idRegistroRespuesta);
			
		}catch(HibernateException e){
			throw new MyException("Error consultando el registroRespuesta en la db");
		}
		
		return registroRespuesta;
	}

	@Override
	public void insert(RegistroRespuesta registroRespuesta) throws MyException {
		
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(registroRespuesta);
			
		}catch(HibernateException e){
			throw new MyException("Error guardando el registroRespuesta en la db");
		}
	}

	@Override
	public void update(RegistroRespuesta registroRespuesta) throws MyException {

		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.update(registroRespuesta);
			
		}catch(HibernateException e){
			throw new MyException("Error actualizando el registroRespuesta en la db");
		}

	}

	@Override
	public void delete(RegistroRespuesta registroRespuesta) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();			
			session.delete(registroRespuesta);
			
		}catch(HibernateException e){
			throw new MyException("Error borrando el registroRespuesta en la db");
		}

	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
