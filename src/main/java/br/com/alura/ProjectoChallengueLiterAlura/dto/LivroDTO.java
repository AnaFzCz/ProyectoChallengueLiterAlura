package br.com.alura.ProjectoChallengueLiterAlura.dto;

import br.com.alura.ProjectoChallengueLiterAlura.model.Language;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record LivroDTO(
        Long id,
        String titulo,
        @JsonAlias("languages") List<String> language) {
}
