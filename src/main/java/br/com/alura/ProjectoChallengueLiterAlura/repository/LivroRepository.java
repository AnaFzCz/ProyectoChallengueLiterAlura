package br.com.alura.ProjectoChallengueLiterAlura.repository;

import br.com.alura.ProjectoChallengueLiterAlura.dto.AutorResumenDTO;
import br.com.alura.ProjectoChallengueLiterAlura.model.Autor;
import br.com.alura.ProjectoChallengueLiterAlura.model.Language;
import br.com.alura.ProjectoChallengueLiterAlura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface LivroRepository extends JpaRepository<Livro, Long> {

// Consulta con libros por separado
//    @Query("SELECT a.nomeAutor, a.birthYear, a.deathYear,l.titulo AS tituloLivro FROM Autor a  JOIN a.livro l")
//    List<AutorResumenDTO> autoresRegistrados();

    @Query(value = "SELECT a.nome_autor, a.birth_year ,a.death_year, STRING_AGG(l.titulo, ', ') AS titulos FROM autores a INNER JOIN livros l ON a.livro_id = l.id GROUP BY a.nome_autor, a.birth_year, a.death_year", nativeQuery = true)
    List<AutorResumenDTO> autoresRegistrados();


    @Query(value = "SELECT  a.nome_autor, a.birth_year, a.death_year, STRING_AGG(l.titulo, ', ') AS titulos FROM autores a INNER JOIN livros l ON a.livro_id = l.id WHERE  a.birth_year<= :anoPesquisar AND (a.death_year IS NULL OR a.death_year>= :anoPesquisar) GROUP BY a.nome_autor, a.birth_year, a.death_year", nativeQuery = true)
    List<AutorResumenDTO> autoresVivosDeterminadoAno(@Param("anoPesquisar") int anoPesquisar);

    //SELECT * FROM livros  WHERE language= 'EN'


    List<Livro> findByLanguage(Language language);
}
