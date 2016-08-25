package edu.fae.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.fae.crud.model.Categoria;

/**
 * 
 * @author robson
 *
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}
