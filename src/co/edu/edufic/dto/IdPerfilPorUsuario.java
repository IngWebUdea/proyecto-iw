package co.edu.edufic.dto;

import java.io.Serializable;

/**
 * Clase encargada de almacenar la clave compuesta de la tabla rel_perfiles_usuarios
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public class IdPerfilPorUsuario implements Serializable {
	
	private Usuario usuario;		//Identificador del usuario.
	private Perfil perfil;			//Identificador del perfil.
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
}
