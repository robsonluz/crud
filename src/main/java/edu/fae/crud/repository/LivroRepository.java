package edu.fae.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.fae.crud.model.Livro;

/**
 * 
 * @author robson
 *
 */
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
	
}
