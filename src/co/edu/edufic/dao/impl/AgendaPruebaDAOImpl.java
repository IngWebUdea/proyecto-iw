package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.AgendaPruebaDAO;
import co.edu.edufic.dto.AgendaPrueba;
import co.edu.edufic.dto.IdAgendaPrueba;
import co.edu.edufic.exception.MyException;

public class AgendaPruebaDAOImpl implements AgendaPruebaDAO {

	private SessionFactory sessionFactory;

	@Override
	public List<AgendaPrueba> allAgendaPruebas() throws MyException {
		
		Session session = null;
		Criteria criteria = null;
		List<AgendaPrueba> agendaPruebas = new ArrayList<AgendaPrueba>();
		
		try{
			
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(AgendaPrueba.class);
			
			agendaPruebas = criteria.list();			
		}catch(HibernateException e){
			throw new MyException("Error consultando las agendaPruebas en la db");
		}
		
		return agendaPruebas;
	}

	@Override
	public AgendaPrueba findById(IdAgendaPrueba idAgendaPrueba) throws MyException {

		Session session = null;
		AgendaPrueba agendaPrueba = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			agendaPrueba = (AgendaPrueba)session.get(AgendaPrueba.class, idAgendaPrueba);
			
		}catch(HibernateException e){
			throw new MyException("Error consultando la agendaPrueba en la db");
		}
		
		return agendaPrueba;
	}

	@Override
	public void insert(AgendaPrueba agendaPrueba) throws MyException {
		
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(agendaPrueba);
			
		}catch(HibernateException e){
			throw new MyException("Error guardando la agendaPrueba en la db");
		}
	}

	@Override
	public void update(AgendaPrueba agendaPrueba) throws MyException {

		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.update(agendaPrueba);
			
		}catch(HibernateException e){
			throw new MyException("Error actualizando la agendaPrueba en la db");
		}

	}

	@Override
	public void delete(AgendaPrueba agendaPrueba) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();			
			session.delete(agendaPrueba);
			
		}catch(HibernateException e){
			throw new MyException("Error borrando la agendaPrueba en la db");
		}

	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
