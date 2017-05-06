package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.CategoriaDAO;
import co.edu.edufic.dto.Categoria;
import co.edu.edufic.exception.MyException;

public class CategoriaDAOImpl implements CategoriaDAO {

	private SessionFactory sessionFactory;

	@Override
	public List<Categoria> allCategorias() throws MyException {
		
		Session session = null;
		Criteria criteria = null;
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		try{
			
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Categoria.class);
			
			categorias = criteria.list();			
		}catch(HibernateException e){
			throw new MyException("Error consultando las categorías en la db");
		}
		
		return categorias;
	}

	@Override
	public Categoria findById(String idCategoria) throws MyException {

		Session session = null;
		Categoria categoria = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			categoria = (Categoria)session.get(Categoria.class, idCategoria);
			
		}catch(HibernateException e){
			throw new MyException("Error consultando la categoría en la db");
		}
		
		return categoria;
	}

	@Override
	public void insert(Categoria categoria) throws MyException {
		
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(categoria);
			
		}catch(HibernateException e){
			throw new MyException("Error guardando la categoría en la db");
		}
	}

	@Override
	public void update(Categoria categoria) throws MyException {

		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.update(categoria);
			
		}catch(HibernateException e){
			throw new MyException("Error actualizando la categoría en la db");
		}

	}

	@Override
	public void delete(Categoria categoria) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();			
			session.delete(categoria);
			
		}catch(HibernateException e){
			throw new MyException("Error borrando la categoría en la db");
		}

	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
