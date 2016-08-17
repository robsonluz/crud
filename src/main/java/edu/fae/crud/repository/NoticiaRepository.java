package edu.fae.crud.repository;

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
	
}
