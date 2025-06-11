package br.com.alura.ProjectoChallengueLiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDate;

public record DadosAutor(@JsonAlias("name") String name,
                         @JsonAlias("birth_year") Integer birthYear,
                         @JsonAlias("death_year") Integer deathYear) {
}
