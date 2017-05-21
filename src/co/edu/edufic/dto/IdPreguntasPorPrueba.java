package co.edu.edufic.dto;

import java.io.Serializable;

/**
 *  Clase DTO para almacenar la clave compuesta de la tabla rel_preguntas_prueba de la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
public class IdPreguntasPorPrueba implements Serializable {
	
	private Prueba prueba;		//Identificador de la prueba.
	private Pregunta pregunta;	//Identificador de la pregunta.
	public Prueba getPrueba() {
		return prueba;
	}
	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}
	public Pregunta getPregunta() {
		return pregunta;
	}
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	
}
