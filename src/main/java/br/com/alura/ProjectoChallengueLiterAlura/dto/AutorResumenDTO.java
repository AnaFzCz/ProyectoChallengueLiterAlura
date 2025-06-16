package br.com.alura.ProjectoChallengueLiterAlura.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AutorResumenDTO(String name,
                              @JsonProperty("birth_year") Integer birthYear,
                              @JsonProperty("death_year") Integer deathYear,
                              String titulos) {

}
