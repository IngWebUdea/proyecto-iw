package co.edu.edufic.bl;

import co.edu.edufic.exception.MyException;

/**
 * Interface para los métodos permitidos para los usuarios en la capa de lógica de negocio
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface UsuarioBL {
	
	/**
	 * Método para validar que un usuario pueda  ingresar al sistema mediante un 
	 * usuario y contraseña válidos dentr del sistema.
	 * @param login Nombre de usuario en el sistema.
	 * @param pwd Contraseña del usuario en el sistema.
	 * @throws MyException Ocurre cuando hay inconsistencia en los datos propocinados por el usuairo.
	 */
	public void autenticar(String login, String pwd) throws MyException;
	
	/**
	 * Método para validar si un usuario dado posee un perfil especíco.
	 * @param login
	 * @param idPerfil
	 * @return
	 * @throws MyException
	 */
	public boolean validarPerfil(String login, Integer idPerfil)  throws MyException;
	

}
