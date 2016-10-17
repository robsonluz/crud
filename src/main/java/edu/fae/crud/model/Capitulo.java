package edu.fae.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Capitulo {
	@Id
	@GeneratedValue
	private Long id;
	private String titulo;
	private String sinopse;
	
	public Capitulo() {
	}
	
	public Capitulo(String titulo) {
		this.titulo = titulo;
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

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	
}
