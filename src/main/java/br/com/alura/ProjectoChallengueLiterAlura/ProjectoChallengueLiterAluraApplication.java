package br.com.alura.ProjectoChallengueLiterAlura;

import br.com.alura.ProjectoChallengueLiterAlura.principal.Principal;
import br.com.alura.ProjectoChallengueLiterAlura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectoChallengueLiterAluraApplication implements CommandLineRunner {

    @Autowired
    private LivroRepository repositorio;

    public static void main(String[] args) {
        SpringApplication.run(ProjectoChallengueLiterAluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal(repositorio);
        principal.exibeMenu();
    }
}
