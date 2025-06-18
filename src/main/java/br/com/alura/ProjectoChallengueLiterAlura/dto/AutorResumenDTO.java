package br.com.alura.ProjectoChallengueLiterAlura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AutorResumenDTO(String name,
                              @JsonAlias("birth_year") Integer birthYear,
                              @JsonAlias("death_year") Integer deathYear,
                              String titulos) {

}
