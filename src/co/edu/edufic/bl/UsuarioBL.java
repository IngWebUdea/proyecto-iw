package co.edu.edufic.bl;

import java.util.Set;

import co.edu.edufic.dto.PerfilPorUsuario;
import co.edu.edufic.exception.MyException;

/**
 * Interface para los métodos permitidos para los usuarios en la capa de lógica de negocio
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public interface UsuarioBL {
	
	/**
	 * Método para validar que un usuario pueda  ingresar al sistema mediante un 
	 * nombre de usuario y contraseña válidos dentro del sistema.
	 * @param login Nombre de usuario en el sistema.
	 * @param pwd Contraseña del usuario en el sistema.
	 * @throws MyException Ocurre cuando hay inconsistencia en los datos propocinados por el usuairo.
	 */
	public void autenticar(String login, String pwd) throws MyException;
	
	/**
	 * Método para validar si un perfil dado se enecuentra dentro de los perfiles asociados a un usuario.
	 * @param perfilesUsuario Conjunto de perfiles de un usuario.
	 * @param idPerfil Identificador del perfil que se requiere validar.
	 * @throws MyException Cuando hay un error en la sonsulta del perfil
	 */
	public Boolean validarPerfil(Set<PerfilPorUsuario> perfilesUsuario, Integer idPerfil)  throws MyException;
	
	/**
	 * Método para validar si un código de perfil dado se enecuentra dentro de los perfiles asociados a un usuario.
	 * @param perfilesUsuario Conjunto de perfiles de un usuario
	 * @param codePerfil Código del perfil que se requiere validar.
	 * @return Verdadero si el perfil se validado
	 * @throws MyException
	 */
	public Boolean validarPerfilByCode(Set<PerfilPorUsuario> perfilesUsuario, String codePerfil)  throws MyException;

}
