package co.edu.edufic.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
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

import co.edu.edufic.bl.PreguntaBL;
import co.edu.edufic.dto.Pregunta;
import co.edu.edufic.exception.MyException;

/**
 * Clase para manejar los servicios para las preguntas dentro del sistema
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@Path("pregunta")
@Component
@Transactional
public class PreguntaWS {
	
	@Autowired private PreguntaBL preguntaBL;
	
	/**
	 * Servicio para consultar las preguntas por temática
	 * @param idTematica Identificador de la temática
	 * @return Listado de preguntas en formato JSON
	 * @throws RemoteException
	 */	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Pregunta> preguntasPorTematica(@QueryParam("idTematica") String idTematica) throws RemoteException{
		
		List<Pregunta> preguntas = new ArrayList<Pregunta>();
		Integer id;
		
		try{
			id = Integer.parseInt(idTematica);
			preguntas = preguntaBL.preguntasPorTematica(id);
		}catch(MyException e){
			throw new RemoteException(e.getMessage());
		}
		return preguntas;
	}
	
	/**
	 * Servicio para registrar preguntas en el sistema.
	 * @param texto Enunciado de la pregunta.
	 * @param numOpciones Cantidad de opciones de la pregunta.
	 * @param jsonOpciones Opcines de respuesta a la pregunta.
	 * @param optCorrecta Opcion correcta.
	 * @param nivelDificultad Nivel de dificulltad estimado de la pregunta.
	 * @param idTematica Identificador de la temática a la que pertenece la pregunta.
	 * @param loginUsuarioCrea Login del usuario que crea la pregunta.
	 * @return Mensaje de confirmación de exito.
	 * @throws RemoteException
	 */
	@Produces(MediaType.TEXT_PLAIN)
	@POST
	public String insertarPregunta(
			@QueryParam("texto") String texto, 
			@QueryParam("numOpciones") Integer numOpciones, 
			@QueryParam("jsonOpciones") String jsonOpciones,
			@QueryParam("optCorrecta") String optCorrecta,
			@QueryParam("nivelDificultad") String nivelDificultad, 
			@QueryParam("idTematica") Integer idTematica, 
			@QueryParam("loginUsuarioCrea") String loginUsuarioCrea) throws RemoteException {
		
		try{
			
			preguntaBL.registrarPregunta(texto, numOpciones, jsonOpciones, optCorrecta.charAt(0), nivelDificultad.charAt(0), idTematica, loginUsuarioCrea);
		}catch(MyException e){
			throw new RemoteException(e.getMessage());
		}
		return "Done";		
	}
}



