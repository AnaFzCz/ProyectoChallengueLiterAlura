package br.com.alura.ProjectoChallengueLiterAlura.principal;


import br.com.alura.ProjectoChallengueLiterAlura.dto.AutorResumenDTO;
import br.com.alura.ProjectoChallengueLiterAlura.dto.ResultsDTO;
import br.com.alura.ProjectoChallengueLiterAlura.model.Autor;
import br.com.alura.ProjectoChallengueLiterAlura.model.DadosLivro;
import br.com.alura.ProjectoChallengueLiterAlura.model.Language;
import br.com.alura.ProjectoChallengueLiterAlura.model.Livro;
import br.com.alura.ProjectoChallengueLiterAlura.repository.LivroRepository;
import br.com.alura.ProjectoChallengueLiterAlura.service.ConsumoApi;
import br.com.alura.ProjectoChallengueLiterAlura.service.ConverteDados;


import java.util.*;
import java.util.stream.Collectors;


public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    private final String ENDERECO = "http://gutendex.com/books/?search=";
    private LivroRepository repositorio;

    private List<DadosLivro> dadosLivro = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autor = new ArrayList<>();
    private Optional<Livro> livroBusca;

    public Principal(LivroRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {

        var opcao = -1;

        while (opcao != 0) {
            var menu = """
                    ************* MENU************
                    
                    1- Buscar livro por titulo
                    2- Listar livros registrados
                    3- Listar autores registrados
                    4- Listar autores vivos em um determinado ano
                    5- Listar livros em um determinado idioma
                    
                    0- Salir
                    
                    """;
            System.out.println(menu);
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    buscarLivroPorTitulo();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosEmDeterminadoAno();
                    break;
                case 5:
                    listarLivrosEmDeterminadoIdioma();
                    break;
                case 6:
                    Top10descargados();
                    break;
                case 7:
                    BuscarAutorPorNome();
                case 8:
                    BuscarPorCategoria();
                case 0:
                    System.out.println("Saindo do Menu.....");
                    break;
                default:
                    System.out.println("Opcao inexistente");
                    break;
            }

        }


    }

    private void Top10descargados() {

    }

    private void BuscarAutorPorNome() {
    }

    private void BuscarPorCategoria() {
    }

    private DadosLivro getDadosLivro() {
        System.out.println("Digite o título do livro");
        var tituloLivro = scanner.nextLine();
        var json = consumoApi.obterDados(ENDERECO + tituloLivro.replace(" ", "+"));
        ResultsDTO resultados = converteDados.obterDados(json, ResultsDTO.class);
        // System.out.println(json);
        return resultados.resultados().getFirst();
    }

    private void buscarLivroPorTitulo() {
        DadosLivro dados = getDadosLivro();
        dadosLivro.add(dados);
        Livro livro = new Livro(dados);
        repositorio.save(livro);
        System.out.println(dados);

    }

    private void listarLivrosRegistrados() {

        livros = repositorio.findAll();
        System.out.println("\nLISTA DE LIBROS REGISTRADOS\n");
        livros.forEach(l -> System.out.printf("\n******************************** \nLibro: %s \nIdioma: %s \nResumen:%s \nN° descargas: %d\n", l.getTitulo(), l.getLanguage(), l.getResumen(), l.getDownload_count()));

    }

    private void listarAutoresRegistrados() {


        List<AutorResumenDTO> listaLivros = repositorio.autoresRegistrados();
        System.out.println("\nLISTA DE AUTORES REGISTRADOS\n");
        listaLivros.forEach(a -> System.out.printf("\n********************************** \nAutor: %s \nAno de nascimento: %d \nAno de falecimento: %d \nLibro: %s\n", a.name(), a.birthYear(), a.deathYear(), a.titulos()));

    }

    private void listarAutoresVivosEmDeterminadoAno() {
        System.out.println("Digite o ano que deseja pesquisar:\n");
        var anoPesquisar = scanner.nextInt();
        scanner.nextLine();
        List<AutorResumenDTO> autorVivoAno = repositorio.autoresVivosDeterminadoAno(anoPesquisar);
        System.out.println("\nAUTORES VIVOS EN DETERMINADO AÑO\n");
        autorVivoAno.forEach(a -> System.out.printf("\n********************************** \nAutor: %s \nAno de nascimento: %d \nAno de falecimento: %d \nLibro: %s\n", a.name(), a.birthYear(), a.deathYear(), a.titulos()));

    }

    private void listarLivrosEmDeterminadoIdioma() {
        System.out.println("Digite o idioma para realizar a búsqueda:\n");
        System.out.println("""
                * en - Espanhol
                * es - Inglés
                * fr - Francés
                * de - Alemán
                * pt - Portugués
                * ru - Ruso
                * zh - Chino
                
                """);
        var idiomaElegido = scanner.nextLine();
        Language language = Language.fromString(idiomaElegido);
        System.out.println("LISTA DE LIVROS ESCRITO EM " + idiomaElegido);
        List<Livro> listaIdioma = repositorio.findByLanguage(language);
        listaIdioma.forEach(l -> System.out.printf("\n******************************** \nLibro: %s \nIdioma: %s \nResumen:%s \nN° descargas: %d\n", l.getTitulo(), l.getLanguage(), l.getResumen(), l.getDownload_count()));

    }
}
