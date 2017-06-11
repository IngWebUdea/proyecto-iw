package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.PerfilPorUsuarioDAO;
import co.edu.edufic.dto.IdPerfilPorUsuario;
import co.edu.edufic.dto.PerfilPorUsuario;
import co.edu.edufic.exception.MyException;

public class PerfilPorUsuarioDAOImpl implements PerfilPorUsuarioDAO {

	SessionFactory sessionFactory;
	
	@Override
	public List<PerfilPorUsuario> allPerfilesPorUsuario() throws MyException {

		Session session = null;
		Criteria criteria = null;
		List<PerfilPorUsuario> perfilesPorUsuario = new ArrayList<PerfilPorUsuario>();
		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(PerfilPorUsuario.class);
			perfilesPorUsuario = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error consultando los perfiles en la db");
		}
		return perfilesPorUsuario;
	}

	@Override
	public PerfilPorUsuario findById(IdPerfilPorUsuario idPerfilPorUsuario) throws MyException {
		
		Session session = null;
		PerfilPorUsuario perfilPorUsuario = null;
		try{
			session = sessionFactory.getCurrentSession();
			perfilPorUsuario = (PerfilPorUsuario)session.get(PerfilPorUsuario.class, idPerfilPorUsuario);
		}catch(HibernateException e){
			throw new MyException("Error consultando el perfil en la bd");
		}		
		return perfilPorUsuario;
	}

	@Override
	public void insert(PerfilPorUsuario perfilPorUsuario) throws MyException {
		
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			session.save(perfilPorUsuario);
		}catch(HibernateException e){
			throw new MyException("Error guardando el perfil en la bd");
		}

	}

	@Override
	public void update(PerfilPorUsuario perfilPorUsuario) throws MyException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(PerfilPorUsuario perfilPorUsuario) throws MyException {
		// TODO Auto-generated method stub

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
