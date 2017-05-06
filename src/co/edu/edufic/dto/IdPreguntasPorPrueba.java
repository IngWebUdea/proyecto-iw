package co.edu.edufic.dto;

import java.io.Serializable;

/**
 *  Clase DTO para almacenar la clave compuesta de la tabla rel_preguntas_prueba de la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public class IdPreguntasPorPrueba implements Serializable {
	
	private Prueba pruebaId;		//Identificador de la prueba.
	private Pregunta preguntaId;	//Identificador de la pregunta.
	
	public Prueba getPruebaId() {
		return pruebaId;
	}
	public void setPruebaId(Prueba pruebaId) {
		this.pruebaId = pruebaId;
	}
	public Pregunta getPreguntaId() {
		return preguntaId;
	}
	public void setPreguntaId(Pregunta preguntaId) {
		this.preguntaId = preguntaId;
	}
	
}
