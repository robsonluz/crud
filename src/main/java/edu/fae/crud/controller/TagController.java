package edu.fae.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.fae.crud.model.Tag;
import edu.fae.crud.repository.TagRepository;

/**
 * 
 * @author robson
 *
 */
@RestController
@RequestMapping("/api/tags")
public class TagController {
	@Autowired TagRepository tagRepository;

	/**
	 * @return Retorna todas as tags
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Tag> findAll() {
		return tagRepository.findAll();
	}
		
}




