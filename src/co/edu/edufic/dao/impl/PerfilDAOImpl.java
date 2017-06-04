package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.edufic.dao.PerfilDAO;
import co.edu.edufic.dto.Perfil;
import co.edu.edufic.exception.MyException;

public class PerfilDAOImpl implements PerfilDAO {
	
	private SessionFactory sessionFactory;

	@Override
	public List<Perfil> allPerfiles() throws MyException {
		
		Session session = null;
		Criteria criteria = null;
		List<Perfil> perfiles = new ArrayList<Perfil>();
		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Perfil.class);
			perfiles = criteria.list();
			
		}catch(HibernateException e){
			throw new MyException("Error consultando los usuarios en la db");
		}
		
		return perfiles;
	}

	@Override
	public Perfil findById(Integer idPerfil) throws MyException {
		Session session = null;
		Perfil perfil = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			perfil = (Perfil)session.get(Perfil.class, idPerfil);
			
		}catch(HibernateException e){
			throw new MyException("Error consultando el perfil en la db");
		}
		
		return perfil;
	}
	
	@Override
	public Perfil findByCode(String codePerfil) throws MyException {
		Session session = null;
		Criteria criteria = null;
		Perfil perfil = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Perfil.class);
			criteria.add(Restrictions.eq("codigo", codePerfil));
			perfil = (Perfil)criteria.uniqueResult();
			
		}catch(HibernateException e){
			throw new MyException("Error consultando el perfil en la db");
		}
		
		return perfil;
	}

	@Override
	public void insert(Perfil perfil) throws MyException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Perfil perfil) throws MyException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Perfil perfil) throws MyException {
		// TODO Auto-generated method stub

	}
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
