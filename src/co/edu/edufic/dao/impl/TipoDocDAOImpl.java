
package co.edu.edufic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.edufic.dao.TipoDocDAO;
import co.edu.edufic.dto.TipoDoc;
import co.edu.edufic.exception.MyException;

/**
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public class TipoDocDAOImpl implements TipoDocDAO {

	private SessionFactory sessionFactory;
	
	@Override
	public List<TipoDoc> allTiposDoc() throws MyException {

		Session session = null;
		Criteria criteria = null;
		List<TipoDoc> tiposDoc =  new ArrayList<TipoDoc>();
		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(TipoDoc.class);			
			tiposDoc = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error consultando los tipos de documento en la db");
		}		
		return tiposDoc;
	}
	
	@Override
	public TipoDoc findById(Integer idTipoDoc) throws MyException {
		
		Session session = null;		
		TipoDoc tipoDoc = null;		
		try{
			session = sessionFactory.getCurrentSession();
			tipoDoc = (TipoDoc)session.get(TipoDoc.class, idTipoDoc);					
		}catch(HibernateException e){
			throw new MyException("Error consultando el país en la db");
		}		
		return tipoDoc;
	}
	
	@Override
	public void insert(TipoDoc tipoDoc) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(tipoDoc);			
		}catch(HibernateException e){
			throw new MyException("Error almacenando el país en la db");
		}
	}
	
	@Override
	public void update(TipoDoc tipoDoc) throws MyException {
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.update(tipoDoc);			
		}catch(HibernateException e){
			throw new MyException("Error actualizando el país en la db");
		}
	}
	
	@Override
	public void delete(TipoDoc tipoDoc) throws MyException {
		Session session = null;		
		try{
			session = sessionFactory.getCurrentSession();
			session.delete(tipoDoc);			
		}catch(HibernateException e){
			throw new MyException("Error borrando el país en la db");
		}
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
