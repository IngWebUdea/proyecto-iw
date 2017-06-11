package co.edu.edufic.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para lso datos de la tabla rel_perfiles_usuarios en la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class PerfilPorUsuario implements Serializable {

	private IdPerfilPorUsuario idPerfilPorUsuario;	//Clave primaria compuesta.

	public IdPerfilPorUsuario getIdPerfilPorUsuario() {
		return idPerfilPorUsuario;
	}

	public void setIdPerfilPorUsuario(IdPerfilPorUsuario idPerfilPorUsuario) {
		this.idPerfilPorUsuario = idPerfilPorUsuario;
	}

}
