package br.com.alura.ProjectoChallengueLiterAlura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDTO(@JsonAlias("name")String name,
                       @JsonAlias("birth_year") Integer birthYear,
                       @JsonAlias("death_year") Integer deathYear) {

}
