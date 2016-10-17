package edu.fae.crud.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Livro {
	@Id
	@GeneratedValue
	private Long id;
	private String titulo;
	private String isbn;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Capitulo> capitulos = new ArrayList<>();
	
	public Livro() {
	}
	
	public Livro(String titulo, String isbn) {
		this.titulo = titulo;
		this.isbn = isbn;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<Capitulo> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}
	
	
}
