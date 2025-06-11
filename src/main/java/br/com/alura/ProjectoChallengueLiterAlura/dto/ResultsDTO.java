package br.com.alura.ProjectoChallengueLiterAlura.dto;

import br.com.alura.ProjectoChallengueLiterAlura.model.DadosLivro;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record ResultsDTO(Integer count,
                         String next,
                         String previous,
                         @JsonAlias("results") List<DadosLivro> resultados) {
}
