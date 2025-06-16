package br.com.alura.ProjectoChallengueLiterAlura.dto;

import br.com.alura.ProjectoChallengueLiterAlura.model.Language;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDTO(
        Long id,
        @JsonAlias("title") String titulo,
        @JsonAlias("languages") List<String> language,
        @JsonAlias("summaries") List<String> resumen,
        @JsonAlias("download_count") Integer downloadCount,
        @JsonAlias("subjects") List<String> categoria) {
}
