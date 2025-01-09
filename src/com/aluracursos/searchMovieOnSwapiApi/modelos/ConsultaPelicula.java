package com.aluracursos.searchMovieOnSwapiApi.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPelicula {

    public PeliculaSwapi buscaPelicula(int numeroDePelicula){

        String endpoint = "https://swapi.py4e.com/api/films/" + numeroDePelicula;

        // Configuración de seguimiento de redirecciones
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .build();


        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), PeliculaSwapi.class);
        } catch (Exception  e) {
            throw new RuntimeException("No enecontre esta pelicula");
        }




    }
}
