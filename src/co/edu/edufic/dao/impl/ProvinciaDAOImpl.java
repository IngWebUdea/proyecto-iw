package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.ProvinciaDAO;
import co.edu.edufic.dto.Provincia;
import co.edu.edufic.exception.MyException;

public class ProvinciaDAOImpl implements ProvinciaDAO {

	SessionFactory sessionFactory;
	
	@Override
	public List<Provincia> allProvincias() throws MyException {

		Session session = null;
		Criteria criteria = null;
		List<Provincia> provincias = new ArrayList<Provincia>();
		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Provincia.class);
			provincias = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error consultando las provincias en la db");
		}
		
		return provincias;
	}

	@Override
	public Provincia findById(Integer idProvincia) throws MyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Provincia provincia) throws MyException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Provincia provincia) throws MyException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Provincia provincia) throws MyException {
		// TODO Auto-generated method stub

	}
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
