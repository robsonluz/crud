package edu.fae.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.fae.crud.model.Categoria;
import edu.fae.crud.repository.CategoriaRepository;

/**
 * 
 * @author robson
 *
 */
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
	@Autowired CategoriaRepository categoriaRepository;

	/**
	 * @return Retorna todas as categorias
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
		
}
