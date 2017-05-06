package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.CiudadDAO;
import co.edu.edufic.dto.Ciudad;
import co.edu.edufic.exception.MyException;

public class CiudadDAOImpl implements CiudadDAO {
	
	SessionFactory sessionFactory;

	@Override
	public List<Ciudad> allCiudades() throws MyException {
		Session session = null;
		Criteria criteria = null;
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Ciudad.class);
			ciudades = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error consultando las ciudades en la db");
		}
		return ciudades;
	}

	@Override
	public Ciudad findById(Integer idCiudad) throws MyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Ciudad ciudad) throws MyException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Ciudad ciudad) throws MyException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Ciudad ciudad) throws MyException {
		// TODO Auto-generated method stub

	}
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
