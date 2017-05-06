package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.TematicaDAO;
import co.edu.edufic.dto.Tematica;
import co.edu.edufic.exception.MyException;

public class TematicaDAOImpl implements TematicaDAO {

	private SessionFactory sessionFactory;

	@Override
	public List<Tematica> allTematicas() throws MyException {
		
		Session session = null;
		Criteria criteria = null;
		List<Tematica> tematicas = new ArrayList<Tematica>();
		
		try{
			
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Tematica.class);
			
			tematicas = criteria.list();			
		}catch(HibernateException e){
			throw new MyException("Error consultando las temáticas en la db");
		}
		
		return tematicas;
	}

	@Override
	public Tematica findById(Integer idTematica) throws MyException {

		Session session = null;
		Tematica tematica = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			tematica = (Tematica)session.get(Tematica.class, idTematica);
			
		}catch(HibernateException e){
			throw new MyException("Error consultando la temática en la db");
		}
		
		return tematica;
	}

	@Override
	public void insert(Tematica tematica) throws MyException {
		
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(tematica);
			
		}catch(HibernateException e){
			throw new MyException("Error guardando la temática en la db");
		}
	}

	@Override
	public void update(Tematica tematica) throws MyException {

		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.update(tematica);
			
		}catch(HibernateException e){
			throw new MyException("Error actualizando la temática en la db");
		}

	}

	@Override
	public void delete(Tematica tematica) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();			
			session.delete(tematica);
			
		}catch(HibernateException e){
			throw new MyException("Error borrando la temática en la db");
		}

	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
