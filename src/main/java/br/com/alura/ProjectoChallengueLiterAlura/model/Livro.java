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
    @Column(length = 500)
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Language language;
    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autorList = new ArrayList<>();
    //    @Lob
    @Column(length = 2000)
    private List<String> resumen = new ArrayList<>();
    private Integer download_count;

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
        this.resumen = dadosLivro.resumen();
        this.download_count = dadosLivro.download_count();
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

    public List<Autor> getAutorList() {
        return autorList;
    }

    public void setAutorList(List<Autor> autorList) {
        this.autorList = autorList;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<String> getResumen() {
        return resumen;
    }

    public void setResumen(List<String> resumen) {
        this.resumen = resumen;
    }

    public Integer getDownload_count() {
        return download_count;
    }

    public void setDownload_count(Integer download_count) {
        this.download_count = download_count;
    }

    @Override
    public String toString() {
        return "Livro" +
                "titulo='" + titulo + '\'' +
                ", language=" + language +
                ", autorList=" + autorList +
                ", resumen=" + resumen +
                ", download_count=" + download_count;
    }
}
