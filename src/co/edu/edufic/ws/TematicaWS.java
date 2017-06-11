package co.edu.edufic.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.edufic.bl.TematicaBL;
import co.edu.edufic.dto.Pregunta;
import co.edu.edufic.dto.Tematica;
import co.edu.edufic.exception.MyException;

/**
 * Clase para el manejo de los servicios correspondientes a las temáticas en el sistema
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@Path("tematica")
@Component
@Transactional
public class TematicaWS {
	
	@Autowired private TematicaBL tematicaBL;	
	
	/**
	 * Servicio para consultar todas las temáticas del sistema
	 * @return Listado con las temáticas del sistema
	 * @throws RemoteException Cunado ocurre un error al traer la información por el servicio
	 */
//	@Produces(MediaType.APPLICATION_JSON)
//	@GET
//	public List<Tematica> allTematicas() throws RemoteException {
//		
//		List<Tematica> tematicas = new ArrayList<Tematica>();		
//		try{
//			tematicas = tematicaBL.tematicas();
//		}catch(MyException e){
//			throw new RemoteException(e.getMessage());
//		}
//		return tematicas;
//	}
	
	/**
	 * Servicio para consultar todas las temáticas del sistema dada el área a la que pertenecen.
	 * @return Listado con las temáticas del sistema filtradas por área.
	 * @throws RemoteException Cunado ocurre un error al traer la información por el servicio
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Tematica> allTematicasByArea(@QueryParam("idArea") Integer idArea) throws RemoteException {
		
		List<Tematica> tematicas = new ArrayList<Tematica>();		
		try{
			tematicas = tematicaBL.tematicasByArea(idArea);
		}catch(MyException e){
			throw new RemoteException(e.getMessage());
		}
		return tematicas;
	}
	
	/**
	 * Servicio para consultar una temática dado su identificador único
	 * @param idTematica
	 * @return Tematica con el id dado
	 * @throws RemoteException
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Tematica searchById(@QueryParam("idTematica") Integer idTematica) throws RemoteException {		
		Tematica tematica = null;		
		try{
			tematica = tematicaBL.tematicaById(idTematica);
		}catch(MyException e){
			throw new RemoteException(e.getMessage());
		}
		
		return tematica;
	}
	
	/**
	 * Servicio para consultar todas las preguntas existentes de una temática dada.
	 * @param idTematica Identificador de la tematica.
	 * @return Listado con las preguntas de la temática dada.
	 * @throws RemoteException
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@PUT
	public List<Pregunta> preguntasByIdTematica(@QueryParam("idTematica") Integer idTematica) throws RemoteException {
		
		List<Pregunta> preguntas = new ArrayList<Pregunta>();
		try{
			preguntas = tematicaBL.preguntasByIdTematica(idTematica);
		}catch(MyException e){
			throw new RemoteException(e.getMessage()); 
		}
		
		return preguntas;
	}

}
