package co.edu.edufic.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO para almacenar los datos de la tabla preguntas en la db eduficticia
 * @author Andrés Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class Pregunta implements Serializable {
	
	private Integer idPregunta;						//Identificador de la pregunta
	private String texto;							//Texto o cuerpo de la pregunta.
	private Integer numOpt;							//Número de opciones que tendrá la pregunta.
	private String opciones;						//Ociones de la pregunta.
	private Character optCorrecta;					//Opción correcta de la pregunta.
	private Character nivelDif;						//Nivel de dificultad de la pregunta.
	private String imgPath;							//Ruta de la imagen de la pregunta si esxiste.
	private Time tiempoRta;							//Tiempo estimado para resolver la pregunta.
	private String solucion;						//Solución a la pregunta.
	private String sugEspecifica;					//Sugerencia el aprendizaje específico con la pregunta.
	private String usuarioCrea;					//Usuario que crea la pregunta.
	private Date fechaCrea;							//Fecha de creación de la pregunta.
	//private Set<TematicasPorPregunta> tematicas;	//Conjunt de temáticas de la pregunta
	
	public String getSugEspecifica() {
		return sugEspecifica;
	}
	public void setSugEspecifica(String sugEspecifica) {
		this.sugEspecifica = sugEspecifica;
	}
	public Integer getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(Integer idPregunta) {
		this.idPregunta = idPregunta;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Integer getNumOpt() {
		return numOpt;
	}
	public void setNumOpt(Integer numOpt) {
		this.numOpt = numOpt;
	}
	public String getOpciones() {
		return opciones;
	}
	public void setOpciones(String opciones) {
		this.opciones = opciones;
	}
	public Character getOptCorrecta() {
		return optCorrecta;
	}
	public void setOptCorrecta(Character optCorrecta) {
		this.optCorrecta = optCorrecta;
	}
	public Character getNivelDif() {
		return nivelDif;
	}
	public void setNivelDif(Character nivelDif) {
		this.nivelDif = nivelDif;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public Time getTiempoRta() {
		return tiempoRta;
	}
	public void setTiempoRta(Time tiempoRta) {
		this.tiempoRta = tiempoRta;
	}
	public String getSolucion() {
		return solucion;
	}
	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}		
	public String getUsuarioCrea() {
		return usuarioCrea;
	}
	public void setUsuarioCrea(String usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}
	public Date getFechaCrea() {
		return fechaCrea;
	}
	public void setFechaCrea(Date fechaCrea) {
		this.fechaCrea = fechaCrea;
	}
//	public Set<TematicasPorPregunta> getTematicas() {
//		return tematicas;
//	}
//	public void setTematicas(Set<TematicasPorPregunta> tematicas) {
//		this.tematicas = tematicas;
//	}
		
}
