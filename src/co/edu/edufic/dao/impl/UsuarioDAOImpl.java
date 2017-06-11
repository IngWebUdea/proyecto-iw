package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.UsuarioDAO;
import co.edu.edufic.dto.PerfilPorUsuario;
import co.edu.edufic.dto.Usuario;
import co.edu.edufic.exception.MyException;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	private SessionFactory sessionFactory;

	@Override
	public List<Usuario> allUsuarios() throws MyException {
		
		Session session = null;
		Criteria criteria = null;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try{			
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Usuario.class);			
			usuarios = criteria.list();			
		}catch(HibernateException e){
			throw new MyException("Error consultando los usuarios en la db");
		}		
		return usuarios;
	}

	@Override
	public Usuario findById(String idUsuario) throws MyException {

		Session session = null;
		Usuario usuario = null;		
		try{
			session = sessionFactory.getCurrentSession();
			usuario = (Usuario)session.get(Usuario.class, idUsuario);
			
		}catch(HibernateException e){
			throw new MyException("Error consultando el usuario en la db");
		}		
		return usuario;
	}

	@Override
	public void insert(Usuario usuario) throws MyException {		
		Session session = null;		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(usuario);
			
		}catch(HibernateException e){
			throw new MyException("Error guardando el usuario en la db");
		}
	}

	@Override
	public void update(Usuario usuario) throws MyException {

		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.update(usuario);
			
		}catch(HibernateException e){
			throw new MyException("Error actualizando el usuario en la db");
		}

	}

	@Override
	public void delete(Usuario usuario) throws MyException {
		Session session = null;		
		try{
			session = sessionFactory.getCurrentSession();
			usuario.setActivo(Boolean.FALSE);
			session.update(usuario);
			
		}catch(HibernateException e){
			throw new MyException("Error borrando el usuario en la db");
		}

	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
