package co.edu.edufic.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *  Clase DTO para los datos de la tabla rel_preguntas_prueba de la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class PreguntasPorPrueba implements Serializable {
	
	private IdPreguntasPorPrueba idPreguntasPorPrueba;		//Clave primaria compuesta

	public IdPreguntasPorPrueba getIdPreguntasPorPrueba() {
		return idPreguntasPorPrueba;
	}

	public void setIdPreguntasPorPrueba(IdPreguntasPorPrueba idPreguntasPorPrueba) {
		this.idPreguntasPorPrueba = idPreguntasPorPrueba;
	}

}
