package br.com.alura.ProjectoChallengueLiterAlura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            System.out.println(" Error al convertir JSON:");
            System.out.println(json); // Muestra el JSON recibido
            e.printStackTrace(); // Muestra el error exacto
            throw new RuntimeException("Error al deserializar JSON: " + e.getMessage(), e);
        }
    }
}
