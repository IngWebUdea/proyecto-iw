package co.edu.edufic.ws;

import java.rmi.RemoteException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.edufic.bl.PersonaBL;
import co.edu.edufic.dto.Persona;
import co.edu.edufic.exception.MyException;

/**
 * Clase para el manejo de los servicios correspondientes a las personas en el sistema
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@Path("persona")
@Component
@Transactional
public class PersonaWS {
	
	@Autowired private PersonaBL personaBL;
	
	/**
	 * Servicio para consultar una persona dado su documento de identidad
	 * @param idPersona Dcumento de identidad
	 * @return Objeto de la clase {@link Persona}
	 * @throws RemoteException
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Persona searchById(@QueryParam("idPersona") String idPersona) throws RemoteException {
		Persona persona = null;
		try{
			persona = personaBL.searchByDoc(idPersona);
		}catch(MyException e){
			throw new RemoteException(e.getMessage()); 
		}		
		return persona;
	}
	
}
