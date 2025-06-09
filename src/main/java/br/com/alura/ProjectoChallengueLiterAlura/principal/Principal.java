package br.com.alura.ProjectoChallengueLiterAlura.principal;


import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);

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
                default:
                    System.out.println("Opcao inexistente");
            }

        }


    }

    private void buscarLivroPorTitulo() {
    }

    private void listarLivrosRegistrados() {
    }

    private void listarAutoresRegistrados() {
    }

    private void listarAutoresVivosEmDeterminadoAno() {
    }

    private void listarLivrosEmDeterminadoAno() {
    }
}
