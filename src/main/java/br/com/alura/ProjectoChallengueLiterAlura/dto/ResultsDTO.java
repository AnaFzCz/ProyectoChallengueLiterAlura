package br.com.alura.ProjectoChallengueLiterAlura.dto;

import br.com.alura.ProjectoChallengueLiterAlura.model.DadosLivro;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultsDTO(Integer count,
                         String next,
                         String previous,
                         @JsonAlias("results") List<DadosLivro> resultados) {
}
