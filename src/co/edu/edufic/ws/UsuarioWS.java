package co.edu.edufic.ws;

import java.rmi.RemoteException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.edufic.bl.UsuarioBL;
import co.edu.edufic.exception.MyException;


/**
 * Clase para manejra los servicios concernientes a los usuarios dentro del sistema
 * 
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@Path("usuario")
@Component
@Transactional
public class UsuarioWS {
	
	@Autowired private UsuarioBL usuarioBL;
	
	/**
	 * Servicio para autenticar un ususario dentro del sistema
	 * @param login Nombre de usuario del sistema
	 * @param password Contraseña de acceso al sistema
	 * @return Respuesta de confirmación Done.
	 * @throws RemoteException Counado falla la autenticación.
	 */
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	public String autenticar(@QueryParam("login") String login, @QueryParam("password") String password) throws RemoteException{
		
		try{
			usuarioBL.autenticar(login, password);			
		}catch(MyException e){
			throw new RemoteException(e.getMessage());
		}		
		return "Done!";
	}
}
