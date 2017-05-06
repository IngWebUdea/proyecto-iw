package co.edu.edufic.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para los datos de la tabla tematicas_has_preguntas en la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class TematicasPorPregunta implements Serializable {
	
	private IdTematicasPorPregunta idTematicasPorPregunta;		//Clave primaria compuesta.
	

	public IdTematicasPorPregunta getIdTematicasPorPregunta() {
		return idTematicasPorPregunta;
	}

	public void setIdTematicasPorPregunta(IdTematicasPorPregunta idTematicasPorPregunta) {
		this.idTematicasPorPregunta = idTematicasPorPregunta;
	}
}
