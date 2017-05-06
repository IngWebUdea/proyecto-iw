package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.GrupoDAO;
import co.edu.edufic.dto.Grupo;
import co.edu.edufic.exception.MyException;

public class GrupoDAOImpl implements GrupoDAO {

	private SessionFactory sessionFactory;

	@Override
	public List<Grupo> allGrupos() throws MyException {
		
		Session session = null;
		Criteria criteria = null;
		List<Grupo> grupos = new ArrayList<Grupo>();
		
		try{
			
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Grupo.class);
			
			grupos = criteria.list();			
		}catch(HibernateException e){
			throw new MyException("Error consultando los grupos en la db");
		}
		
		return grupos;
	}

	@Override
	public Grupo findById(String idGrupo) throws MyException {

		Session session = null;
		Grupo grupo = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			grupo = (Grupo)session.get(Grupo.class, idGrupo);
			
		}catch(HibernateException e){
			throw new MyException("Error consultando el grupo en la db");
		}
		
		return grupo;
	}

	@Override
	public void insert(Grupo grupo) throws MyException {
		
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(grupo);
			
		}catch(HibernateException e){
			throw new MyException("Error guardando el grupo en la db");
		}
	}

	@Override
	public void update(Grupo grupo) throws MyException {

		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.update(grupo);
			
		}catch(HibernateException e){
			throw new MyException("Error actualizando el grupo en la db");
		}

	}

	@Override
	public void delete(Grupo grupo) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();			
			session.delete(grupo);
			
		}catch(HibernateException e){
			throw new MyException("Error borrando el grupo en la db");
		}

	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
