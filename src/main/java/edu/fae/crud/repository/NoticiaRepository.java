package edu.fae.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.fae.crud.model.Noticia;

/**
 * 
 * @author robson
 *
 */
@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long>{
	
	public List<Noticia> findByTituloLike(String titulo);
	
}
