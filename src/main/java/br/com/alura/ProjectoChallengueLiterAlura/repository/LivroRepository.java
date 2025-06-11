package br.com.alura.ProjectoChallengueLiterAlura.repository;

import br.com.alura.ProjectoChallengueLiterAlura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
