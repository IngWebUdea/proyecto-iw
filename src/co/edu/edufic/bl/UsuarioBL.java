package co.edu.edufic.bl;

import co.edu.edufic.exception.MyException;

/**
 * Interface para los m�todos permitidos para los usuarios en la capa de l�gica de negocio
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
public interface UsuarioBL {
	
	/**
	 * M�todo para validar que un usuario pueda  ingresar al sistema mediante un 
	 * usuario y contrase�a v�lidos dentr del sistema.
	 * @param login Nombre de usuario en el sistema.
	 * @param pwd Contrase�a del usuario en el sistema.
	 * @throws MyException Ocurre cuando hay inconsistencia en los datos propocinados por el usuairo.
	 */
	public void autenticar(String login, String pwd) throws MyException;
	
	/**
	 * M�todo para validar si un usuario dado posee un perfil espec�co.
	 * @param login
	 * @param idPerfil
	 * @return
	 * @throws MyException
	 */
	public boolean validarPerfil(String login, Integer idPerfil)  throws MyException;
	

}
