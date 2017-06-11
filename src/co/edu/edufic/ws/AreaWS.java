package co.edu.edufic.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.edufic.bl.AreaBL;
import co.edu.edufic.dto.Area;
import co.edu.edufic.exception.MyException;

/**
 * Clase para el manejo de los servicios web correspondientes a las �reas 
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
@Path("area")
@Component
@Transactional
public class AreaWS {
	
	@Autowired private AreaBL areaBL;

	/**
	 * Servicio para consultar todas las �reas del sistema.
	 * @return Lista de �reas
	 * @throws RemoteException
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Area> allAreas() throws RemoteException {
		
		 List<Area> areas = new ArrayList<Area>();		 
		 try{
			 areas = areaBL.areas();
		 }catch(MyException e){
			throw new RemoteException(e.getMessage());
		 }		 
		 return areas;
	}
	
	/**
	 * Servicio para consultar un �rea dado su identificador
	 * @param idArea Identificador del �rea.
	 * @return �rea con el id dado.
	 * @throws RemoteException
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Area searchById(@QueryParam("idArea") Integer idArea) throws RemoteException {
		 
		Area area = null;		
		try{
			area = areaBL.areaById(idArea);
		}catch(MyException e){
			throw new RemoteException(e.getMessage());
		}
		return area;
	}
	
}
