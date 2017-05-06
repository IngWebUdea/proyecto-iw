package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.GradoDAO;
import co.edu.edufic.dto.Grado;
import co.edu.edufic.exception.MyException;

public class GradoDAOImpl implements GradoDAO {

	private SessionFactory sessionFactory;

	@Override
	public List<Grado> allGrados() throws MyException {
		
		Session session = null;
		Criteria criteria = null;
		List<Grado> grados = new ArrayList<Grado>();
		
		try{
			
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Grado.class);
			
			grados = criteria.list();			
		}catch(HibernateException e){
			throw new MyException("Error consultando los grados en la db");
		}
		
		return grados;
	}

	@Override
	public Grado findById(Integer idGrado) throws MyException {

		Session session = null;
		Grado grado = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			grado = (Grado)session.get(Grado.class, idGrado);
			
		}catch(HibernateException e){
			throw new MyException("Error consultando el grado en la db");
		}
		
		return grado;
	}

	@Override
	public void insert(Grado grado) throws MyException {
		
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(grado);
			
		}catch(HibernateException e){
			throw new MyException("Error guardando el grado en la db");
		}
	}

	@Override
	public void update(Grado grado) throws MyException {

		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.update(grado);
			
		}catch(HibernateException e){
			throw new MyException("Error actualizando el grado en la db");
		}
	}

	@Override
	public void delete(Grado grado) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();			
			session.delete(grado);
			
		}catch(HibernateException e){
			throw new MyException("Error borrando el grado en la db");
		}
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
