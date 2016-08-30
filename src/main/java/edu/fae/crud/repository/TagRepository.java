package edu.fae.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.fae.crud.model.Tag;

/**
 * 
 * @author robson
 *
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{
	
}
