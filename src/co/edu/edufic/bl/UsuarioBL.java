package co.edu.edufic.bl;

import java.util.Set;

import co.edu.edufic.dto.PerfilPorUsuario;
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
	 * M�todo para validar si un perfil dado se enecentra dentro de los perfiles asociados a un usuario.
	 * @param perfilesUsuario Conjunto de perfiles de un usuario �.
	 * @param idPerfil Identificador del perfil que se requiere validar.
	 * @throws MyException Cuando hay un error en la sonsulta del perfil
	 */
	public void validarPerfil(Set<PerfilPorUsuario> perfilesUsuario, Integer idPerfil)  throws MyException;
	

}
