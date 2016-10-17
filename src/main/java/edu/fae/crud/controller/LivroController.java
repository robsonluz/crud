package edu.fae.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.fae.crud.model.Livro;
import edu.fae.crud.model.Message;
import edu.fae.crud.repository.LivroRepository;

/**
 * 
 * @author robson
 *
 */
@RestController
@RequestMapping("/api/livros")
public class LivroController {
	@Autowired LivroRepository livroRepository;

	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Livro> find() {
		return livroRepository.findAll();	
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public Livro save(@RequestBody Livro livro) {
		livroRepository.save(livro);
		return livro;
	}	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Livro show(@PathVariable Long id) {
		return livroRepository.findOne(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public Message delete(@PathVariable Long id) {
		livroRepository.delete(id);
		return Message.OK;
	}			
}
