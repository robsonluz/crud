package edu.fae.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.fae.crud.model.Message;
import edu.fae.crud.model.Noticia;
import edu.fae.crud.repository.NoticiaRepository;

/**
 * 
 * @author robson
 *
 */
@RestController
@RequestMapping("/api/noticias")
public class NoticiaController {
	@Autowired NoticiaRepository noticiaRepository;

	/**
	 * @return Busca noticias notícias
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Noticia> find(@RequestParam(required=false) String texto) {
		if(texto!=null) {
			return noticiaRepository.findByTituloLike("%" + texto + "%");	
		}else{
			return noticiaRepository.findAll();	
		}		
	}
	
	
	/**
	 * Insere uma notícia na base de dados
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	public Noticia save(@RequestBody Noticia noticia) {
		noticiaRepository.save(noticia);
		return noticia;
	}	
	
	/**
	 * Retorna uma notícia por id
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Noticia show(@PathVariable Long id) {
		return noticiaRepository.findOne(id);
	}
	
	/**
	 * Aprova uma notícia
	 */
	@RequestMapping(value="/{id}/aprovar", method=RequestMethod.POST)
	public Noticia aprovar(@PathVariable Long id) {
		Noticia noticia = noticiaRepository.findOne(id);
		noticia.setSituacao("Aprovada");
		noticiaRepository.save(noticia);
		return noticia;
	}	
	
	/**
	 * Remove uma notícia por id
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public Message delete(@PathVariable Long id) {
		noticiaRepository.delete(id);
		return Message.OK;
	}			
	
}
