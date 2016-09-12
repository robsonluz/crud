package edu.fae.crud.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	private String situacao = "Nova";
	
	@ManyToMany
	private List<Tag> tags = new ArrayList<>();
	
	@ManyToOne
	private Categoria categoria;
	
	public Noticia() {
	}
	public Noticia(String titulo, String texto, Categoria categoria) {
		this.titulo = titulo;
		this.texto = texto;
		this.categoria = categoria;
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
}
