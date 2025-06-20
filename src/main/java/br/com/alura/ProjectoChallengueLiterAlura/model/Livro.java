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

    @Column(length = 3000)
    private List<String> resumen = new ArrayList<>();
    @Column(name = "download_count")
    private Integer downloadCount;
    private List<String> categoria;

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

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<String> getResumen() {
        return resumen;
    }

    public void setResumen(List<String> resumen) {
        this.resumen = resumen;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public List<String> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<String> categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Livro" +
                "titulo='" + titulo + '\'' +
                ", language=" + language +
                ", autorList=" + autorList +
                ", resumen=" + resumen +
                ", downloadCount=" + downloadCount;
    }
}
