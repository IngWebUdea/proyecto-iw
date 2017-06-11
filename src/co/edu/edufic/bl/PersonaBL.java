package co.edu.edufic.bl;

import java.util.Date;

import co.edu.edufic.dto.Persona;
import co.edu.edufic.exception.MyException;

/**
 * Interface para los métodos permitidos para las personas en la capa de lógica de negocio
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface PersonaBL {
	
	/**
	 * Crea una persona en el sistema
	 * @param persona Objeto de la clase {@link Persona} 
	 * @throws MyException
	 */
	public void create(String idPersona, String nombre, String apellido, String telefono, String email, 
			String institucion,	Date fechaNacimiento, Integer idTipoDoc, Integer idCiudad) throws MyException;
	
	/**
	 * Obtiene una persona dado su documento de identidad
	 * @param idPersona Documento de identidad de la persona
	 * @return Objeto de la clase {@link Persona} con id dado
	 * @throws MyException
	 */
	public Persona searchByDoc(String idPersona) throws MyException;	
	
}
