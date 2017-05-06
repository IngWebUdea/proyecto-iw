package co.edu.edufic.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;



/**
 * Clase DTO para los datos de la tabla pruebas de la db eduficticia
 * @author Andr�s Castro -- andres.castrop@udea.edu.co
 *
 */
@XmlRootElement
public class Prueba implements Serializable {
	
	private String codigo;			//C�digo de identificaci�n de la prueba.
	private Categoria categoria;	//Categor�a de la prueba.
	private Integer numPreguntas;	//N�mero de preguntas que contiene la prueba.
	private Time duracion;			//Duraci�n de la prueba.
	private Date fechaCrea;			//Fecha de creaci�n de la prueba.
	private Usuario usuarioCrea;	//Usuario que crea la prueba.
	private Boolean aleatoria;		//Indica si la prueba es generada de manera aleatoria.
	private String descripcion;		//Descripci�n de la prueba.
	
	private Set<PreguntasPorPrueba> preguntas;
	
	public Set<PreguntasPorPrueba> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(Set<PreguntasPorPrueba> preguntas) {
		this.preguntas = preguntas;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Integer getNumPreguntas() {
		return numPreguntas;
	}
	public void setNumPreguntas(Integer numPreguntas) {
		this.numPreguntas = numPreguntas;
	}
	public Time getDuracion() {
		return duracion;
	}
	public void setDuracion(Time duracion) {
		this.duracion = duracion;
	}
	public Date getFechaCrea() {
		return fechaCrea;
	}
	public void setFechaCrea(Date fechaCrea) {
		this.fechaCrea = fechaCrea;
	}
	public Usuario getUsuarioCrea() {
		return usuarioCrea;
	}
	public void setUsuarioCrea(Usuario usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}
	public Boolean getAleatoria() {
		return aleatoria;
	}
	public void setAleatoria(Boolean aleatoria) {
		this.aleatoria = aleatoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
		
}
