package edu.fae.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author robson
 *
 */
@Entity
public class Noticia {
	@Id
	@GeneratedValue
	private Long id;
	private String titulo;
	private String texto;
	
	public Noticia() {
	}
	public Noticia(String titulo, String texto) {
		this.titulo = titulo;
		this.texto = texto;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
