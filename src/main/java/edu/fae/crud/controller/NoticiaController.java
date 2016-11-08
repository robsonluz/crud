package edu.fae.crud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.fae.crud.model.Message;
import edu.fae.crud.model.Noticia;
import edu.fae.crud.repository.NoticiaRepository;
import edu.fae.crud.service.FilesService;

/**
 * 
 * @author robson
 *
 */
@RestController
@RequestMapping("/api/noticias")
public class NoticiaController {
	@Autowired NoticiaRepository noticiaRepository;
	@Autowired FilesService filesService;

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
	
	/**
	 * Upload da imagem da Noticia
	 */
	@RequestMapping(value="/{id}/upload", method=RequestMethod.POST)
	public Noticia upload(@PathVariable Long id, @RequestParam("file") MultipartFile file) 
			throws IOException {
		Noticia noticia = noticiaRepository.findOne(id);
		
		//Salva o arquivo na pasta do servidor
		String imageName = filesService.saveFile(file);
		//Guardamos na base somente o nome da imagem
		noticia.setImagem(imageName);
		
		noticiaRepository.save(noticia);
		return noticia;
	}
	
	@RequestMapping(value="/imagens")
	public void getImagem(@RequestParam("src") String imagem, HttpServletRequest request, 
			HttpServletResponse response) {
		filesService.showFile(imagem, request, response);
	}
	
}
