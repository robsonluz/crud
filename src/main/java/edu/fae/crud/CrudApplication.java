package edu.fae.crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.fae.crud.model.Categoria;
import edu.fae.crud.model.Noticia;
import edu.fae.crud.model.Tag;
import edu.fae.crud.repository.CategoriaRepository;
import edu.fae.crud.repository.NoticiaRepository;
import edu.fae.crud.repository.TagRepository;

@SpringBootApplication
public class CrudApplication {

	//Dados iniciais da base de dados
	@Bean
	CommandLineRunner runner(NoticiaRepository noticiaRepository, CategoriaRepository categoriaRepository, TagRepository tagRepository){
		return args -> {
			
			Categoria artigos = 
					categoriaRepository.save(new Categoria("Artigos"));
			
			Categoria esportes = 
					categoriaRepository.save(new Categoria("Esportes"));			
			
			noticiaRepository.save(new Noticia("Notícia 1", "Texto da Notícia 1", artigos));
			noticiaRepository.save(new Noticia("Notícia 2", "Texto da Notícia 2", artigos));
			noticiaRepository.save(new Noticia("Notícia 3", "Texto da Notícia 3", esportes));
			noticiaRepository.save(new Noticia("Notícia 4", "Texto da Notícia 4", esportes));
			
			tagRepository.save(new Tag("Automóveis"));
			tagRepository.save(new Tag("Culinária"));
			tagRepository.save(new Tag("Política"));
			tagRepository.save(new Tag("Saúde"));
			
		};
	}		
	
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
}
