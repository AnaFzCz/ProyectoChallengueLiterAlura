package br.com.alura.ProjectoChallengueLiterAlura.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeAutor;
    private Integer birthYear;
    private Integer deathYear;
    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    public Autor() {

    }

    public Autor(String nome, Integer nacimiento, Integer fallecimiento) {
        this.nomeAutor = nome;
        this.birthYear = nacimiento;
        this.deathYear = fallecimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
