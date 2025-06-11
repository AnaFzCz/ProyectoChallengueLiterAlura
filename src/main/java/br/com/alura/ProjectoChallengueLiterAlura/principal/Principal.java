package br.com.alura.ProjectoChallengueLiterAlura.principal;


import br.com.alura.ProjectoChallengueLiterAlura.dto.ResultsDTO;
import br.com.alura.ProjectoChallengueLiterAlura.model.DadosLivro;
import br.com.alura.ProjectoChallengueLiterAlura.model.Livro;
import br.com.alura.ProjectoChallengueLiterAlura.repository.LivroRepository;
import br.com.alura.ProjectoChallengueLiterAlura.service.ConsumoApi;
import br.com.alura.ProjectoChallengueLiterAlura.service.ConverteDados;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    private final String ENDERECO = "http://gutendex.com/books/?search=";
    private LivroRepository repositorio;
    private List<Livro> dadosLivro = new ArrayList<>();

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
                    listarLivrosEmDeterminadoAno();
                    break;
                case 0:
                    System.out.println("Saindo do Menu.....");
                    break;
                default:
                    System.out.println("Opcao inexistente");
                    break;
            }

        }


    }

    private DadosLivro getDadosLivro() {
        System.out.println("Digite o título do livro");
        var tituloLivro = scanner.nextLine();
        var json = consumoApi.obterDados(ENDERECO + tituloLivro.replace(" ", "+"));
        //   DadosLivro dados = converteDados.obterDados(json, DadosLivro.class);
        ResultsDTO resultados = converteDados.obterDados(json, ResultsDTO.class);
        System.out.println(json);
        return resultados.resultados().get(0);
    }

    private void buscarLivroPorTitulo() {
        DadosLivro dados = getDadosLivro();
        Livro livro = new Livro(dados);

        System.out.println(dados);

    }


    private void listarLivrosRegistrados() {
        System.out.println("opcao 2");
    }

    private void listarAutoresRegistrados() {
        System.out.println("opcao 3");
    }

    private void listarAutoresVivosEmDeterminadoAno() {
        System.out.println("opcao 4");
    }

    private void listarLivrosEmDeterminadoAno() {
        System.out.println("opcao 5");
    }
}
