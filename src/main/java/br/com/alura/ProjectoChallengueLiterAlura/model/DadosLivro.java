package br.com.alura.ProjectoChallengueLiterAlura.model;

import br.com.alura.ProjectoChallengueLiterAlura.dto.AutorDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(@JsonAlias("title") String titulo,
                         @JsonAlias("authors") List<AutorDTO> authors,
                         @JsonAlias("languages") List<String> language)
        //   @JsonAlias("summaries") String resumen)
{

}
