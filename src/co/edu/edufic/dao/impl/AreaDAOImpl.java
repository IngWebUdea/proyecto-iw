package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.AreaDAO;
import co.edu.edufic.dto.Area;
import co.edu.edufic.exception.MyException;

public class AreaDAOImpl implements AreaDAO {

	private SessionFactory sessionFactory;

	@Override
	public List<Area> allAreas() throws MyException {
		
		Session session = null;
		Criteria criteria = null;
		List<Area> areas = new ArrayList<Area>();		
		try{			
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Area.class);			
			areas = criteria.list();			
		}catch(HibernateException e){
			throw new MyException("Error consultando las áreas en la db");
		}		
		return areas;
	}

	@Override
	public Area findById(Integer idArea) throws MyException {
		Session session = null;
		Area area = null;		
		try{
			session = sessionFactory.getCurrentSession();
			area = (Area)session.get(Area.class, idArea);			
		}catch(HibernateException e){
			throw new MyException("Error consultando el área en la db");
		}
		
		return area;
	}

	@Override
	public void insert(Area area) throws MyException {		
		Session session = null;		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(area);			
		}catch(HibernateException e){
			throw new MyException("Error guardando el área en la db");
		}
	}

	@Override
	public void update(Area area) throws MyException {
		Session session = null;		
		try{
			session = sessionFactory.getCurrentSession();
			session.update(area);
			
		}catch(HibernateException e){
			throw new MyException("Error actualizando el área en la db");
		}

	}

	@Override
	public void delete(Area area) throws MyException {
		Session session = null;		
		try{
			session = sessionFactory.getCurrentSession();			
			session.delete(area);
			
		}catch(HibernateException e){
			throw new MyException("Error borrando el área en la db");
		}

	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
