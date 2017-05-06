package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.EstudiantePorAcudienteDAO;
import co.edu.edufic.dto.EstudiantePorAcudiente;
import co.edu.edufic.dto.IdEstudiantePorAcudiente;
import co.edu.edufic.exception.MyException;

public class EstudiantePorAcudienteDAOImpl implements EstudiantePorAcudienteDAO {

	private SessionFactory sessionFactory;

	@Override
	public List<EstudiantePorAcudiente> allEstudiantePorAcudientes() throws MyException {
		
		Session session = null;
		Criteria criteria = null;
		List<EstudiantePorAcudiente> estudiantePorAcudientes = new ArrayList<EstudiantePorAcudiente>();
		
		try{
			
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(EstudiantePorAcudiente.class);
			
			estudiantePorAcudientes = criteria.list();			
		}catch(HibernateException e){
			throw new MyException("Error consultando los estudiantePorAcudientes en la db");
		}
		
		return estudiantePorAcudientes;
	}

	@Override
	public EstudiantePorAcudiente findById(IdEstudiantePorAcudiente idEstudiantePorAcudiente) throws MyException {

		Session session = null;
		EstudiantePorAcudiente estudiantePorAcudiente = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			estudiantePorAcudiente = (EstudiantePorAcudiente)session.get(EstudiantePorAcudiente.class, idEstudiantePorAcudiente);
			
		}catch(HibernateException e){
			throw new MyException("Error consultando el estudiantePorAcudiente en la db");
		}
		
		return estudiantePorAcudiente;
	}

	@Override
	public void insert(EstudiantePorAcudiente estudiantePorAcudiente) throws MyException {
		
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(estudiantePorAcudiente);
			
		}catch(HibernateException e){
			throw new MyException("Error guardando el estudiantePorAcudiente en la db");
		}
	}

	@Override
	public void update(EstudiantePorAcudiente estudiantePorAcudiente) throws MyException {

		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.update(estudiantePorAcudiente);
			
		}catch(HibernateException e){
			throw new MyException("Error actualizando el estudiantePorAcudiente en la db");
		}

	}

	@Override
	public void delete(EstudiantePorAcudiente estudiantePorAcudiente) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();			
			session.delete(estudiantePorAcudiente);
			
		}catch(HibernateException e){
			throw new MyException("Error borrando el estudiantePorAcudiente en la db");
		}

	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
