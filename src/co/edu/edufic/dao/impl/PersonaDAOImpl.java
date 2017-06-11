package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.PersonaDAO;
import co.edu.edufic.dto.Persona;
import co.edu.edufic.exception.MyException;

public class PersonaDAOImpl implements PersonaDAO {

	SessionFactory sessionFactory;	

	@Override
	public List<Persona> allPersonas() throws MyException {
		Session session = null;
		Criteria criteria = null;
		List<Persona> personas = new ArrayList<Persona>();		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Persona.class);
			personas = criteria.list();			
		}catch(HibernateException e){
			throw new MyException("Error consultando las personas en la db");
		}		
		return personas;
	}

	@Override
	public Persona findById(String idPersona) throws MyException {		
		Session session = null;
		Persona persona = null;		
		try{
			session = sessionFactory.getCurrentSession();
			persona = (Persona)session.get(Persona.class, idPersona);			
		}catch(HibernateException e){
			throw new MyException("Error consultando la persona en la db");
		}		
		return persona;
	}

	@Override
	public void insert(Persona persona) throws MyException {		
		Session session = null;		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(persona);			
		}catch(HibernateException e){
			throw new MyException("Error consultando las personas en la db");
		}
	}

	@Override
	public void update(Persona persona) throws MyException {		
		Session session = null;		
		try{
			session = sessionFactory.getCurrentSession();
			session.update(persona);			
		}catch(HibernateException e){
			throw new MyException("Error actualizando la persona en la db");
		}

	}

	@Override
	public void delete(Persona persona) throws MyException {		
		Session session = null;		
		try{
			session = sessionFactory.getCurrentSession();
			session.delete(persona);			
		}catch(HibernateException e){
			throw new MyException("Error borrando la persona en la db");
		}
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
