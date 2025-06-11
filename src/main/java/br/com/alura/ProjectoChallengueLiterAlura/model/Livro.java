package br.com.alura.ProjectoChallengueLiterAlura.model;

import br.com.alura.ProjectoChallengueLiterAlura.dto.AutorDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Language language;
    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autorList = new ArrayList<>();

    public Livro() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();
        this.language = Language.fromString(dadosLivro.language().get(0));


        for (AutorDTO dto : dadosLivro.authors()) {
            Autor autor = new Autor(dto.name(), dto.birthYear(), dto.deathYear());
            autor.setLivro(this);
            this.autorList.add(autor);
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguageL(Language languageL) {
        this.language = languageL;
    }

    public List<Autor> getAutorList() {
        return autorList;
    }

    public void setAutorList(List<Autor> autorList) {
        this.autorList = autorList;
    }
}
