/**
 * 
 */
package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.PaisDAO;
import co.edu.edufic.dto.Pais;
import co.edu.edufic.exception.MyException;

/**
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public class PaisDAOImpl implements PaisDAO {
	
	private SessionFactory sessionFactory;			//Propiedad para el trabajo con Spring
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	

	/* (non-Javadoc)
	 * @see co.edu.edufic.dao.PaisDAO#allPaises()
	 */
	@Override
	public List<Pais> allPaises() throws MyException {
		
		Session session = null;
		Criteria criteria = null;
		List<Pais> paises = new ArrayList<Pais>();
		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Pais.class);
			
			paises = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error consultando los paises en la db");
		}
		
		return paises;
	}

	/* (non-Javadoc)
	 * @see co.edu.edufic.dao.PaisDAO#findById(java.lang.Integer)
	 */
	@Override
	public Pais findById(Integer idPais) throws MyException {
		
		Session session = null;		
		Pais pais = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			pais = (Pais)session.get(Pais.class, idPais);
		}catch(HibernateException e){
			throw new MyException("Error consultando el país en la db");
		}
		
		return pais;
	}

	/* (non-Javadoc)
	 * @see co.edu.edufic.dao.PaisDAO#insert(co.edu.edufic.dto.Pais)
	 */
	@Override
	public void insert(Pais pais) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(pais);
		} catch(HibernateException e){
			throw new MyException("Error almacenando el país en la db");
		}
	}

	/* (non-Javadoc)
	 * @see co.edu.edufic.dao.PaisDAO#update(co.edu.edufic.dto.Pais)
	 */
	@Override
	public void update(Pais pais) throws MyException {
		
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.update(pais);
		} catch(HibernateException e){
			throw new MyException("Error actualizando el país en la db");
		}
	}

	/* (non-Javadoc)
	 * @see co.edu.edufic.dao.PaisDAO#delete(co.edu.edufic.dto.Pais)
	 */
	@Override
	public void delete(Pais pais) throws MyException {
		
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.delete(pais);
		} catch(HibernateException e){
			throw new MyException("Error borrando el país en la db");
		}
	}

}
