package br.com.alura.ProjectoChallengueLiterAlura.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
