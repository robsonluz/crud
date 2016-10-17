package edu.fae.crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.fae.crud.model.Capitulo;
import edu.fae.crud.model.Categoria;
import edu.fae.crud.model.Livro;
import edu.fae.crud.model.Noticia;
import edu.fae.crud.model.Tag;
import edu.fae.crud.repository.CategoriaRepository;
import edu.fae.crud.repository.LivroRepository;
import edu.fae.crud.repository.NoticiaRepository;
import edu.fae.crud.repository.TagRepository;

@SpringBootApplication
public class CrudApplication {

	//Dados iniciais da base de dados
	@Bean
	CommandLineRunner runner(NoticiaRepository noticiaRepository, CategoriaRepository categoriaRepository, TagRepository tagRepository, LivroRepository livroRepository){
		return args -> {
			
			Categoria artigos = 
					categoriaRepository.save(new Categoria("Artigos"));
			
			Categoria esportes = 
					categoriaRepository.save(new Categoria("Esportes"));			
			
			noticiaRepository.save(new Noticia("FAE realiza o I Simpósio de Direito Penal", "Evento, aberto ao público, reuniu especialistas no Teatro Bom Jesus", artigos));
			noticiaRepository.save(new Noticia("Dia do Psicólogo na FAE", "Veja como foi a celebração dos alunos e professores da graduação", artigos));
			noticiaRepository.save(new Noticia("Sustentabilidade em foco", "FAE participou de um dos principais eventos sobre o tema no Brasil", esportes));
			noticiaRepository.save(new Noticia("Pedagogia: curso promove debates sobre carreira", "Profissionais convidadas compartilharam experiências e apontaram tendências do mercado de trabalho", esportes));
			
			tagRepository.save(new Tag("Automóveis"));
			tagRepository.save(new Tag("Culinária"));
			tagRepository.save(new Tag("Política"));
			tagRepository.save(new Tag("Saúde"));
			
			Livro l = new Livro("Livro 1", "ABC1");
			l.getCapitulos().add(new Capitulo("Cap 1"));
			l.getCapitulos().add(new Capitulo("Cap 2"));
			l.getCapitulos().add(new Capitulo("Cap 3"));
					
			livroRepository.save(l);
			livroRepository.save(new Livro("Livro 2", "ABC2"));
			livroRepository.save(new Livro("Livro 3", "ABC3"));
			
		};
	}		
	
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
}
