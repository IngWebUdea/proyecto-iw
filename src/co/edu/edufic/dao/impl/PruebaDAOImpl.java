package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.PruebaDAO;
import co.edu.edufic.dto.Prueba;
import co.edu.edufic.exception.MyException;

public class PruebaDAOImpl implements PruebaDAO {

	private SessionFactory sessionFactory;

	@Override
	public List<Prueba> allPruebas() throws MyException {
		
		Session session = null;
		Criteria criteria = null;
		List<Prueba> pruebas = new ArrayList<Prueba>();
		
		try{
			
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Prueba.class);
			
			pruebas = criteria.list();			
		}catch(HibernateException e){
			throw new MyException("Error consultando las pruebas en la db");
		}
		
		return pruebas;
	}

	@Override
	public Prueba findById(Integer idPrueba) throws MyException {

		Session session = null;
		Prueba prueba = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			prueba = (Prueba)session.get(Prueba.class, idPrueba);
			
		}catch(HibernateException e){
			throw new MyException("Error consultando la prueba en la db");
		}
		
		return prueba;
	}

	@Override
	public void insert(Prueba prueba) throws MyException {
		
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(prueba);
			
		}catch(HibernateException e){
			throw new MyException("Error guardando la prueba en la db");
		}
	}

	@Override
	public void update(Prueba prueba) throws MyException {

		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.update(prueba);
			
		}catch(HibernateException e){
			throw new MyException("Error actualizando la prueba en la db");
		}

	}

	@Override
	public void delete(Prueba prueba) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();			
			session.delete(prueba);
			
		}catch(HibernateException e){
			throw new MyException("Error borrando la prueba en la db");
		}

	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
