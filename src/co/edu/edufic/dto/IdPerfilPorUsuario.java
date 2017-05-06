package co.edu.edufic.dto;

import java.io.Serializable;

/**
 * Clase encargada de almacenar la clave compuesta de la tabla rel_perfiles_usuarios
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public class IdPerfilPorUsuario implements Serializable {
	
	private Usuario idUsuario;		//Identificador del usuario.
	private Perfil idPerfil;		//Identificador del perfil.
	
	public Usuario getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Perfil getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Perfil idPerfil) {
		this.idPerfil = idPerfil;
	}
}
