package com.aluracursos.searchMovieOnSwapiApi.principal;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalBusqueda {
    public static void main(String[] args) {
        Scanner obtenerPeliculaID = new Scanner(System.in);
        System.out.println("Ingresa el ID de la Pelicula (1-6)");

        var busquedaPelicula = obtenerPeliculaID.nextLine();

        String endpoint = "http://swapi.py4e.com/api/films/" + busquedaPelicula;
        System.out.println(endpoint);

        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response);
            String json = response.body();
            System.out.println(json);
            System.out.println("Hola");
        }catch (Exception e){
            System.out.println("Error: verifique la direccion");
        }







    }
}
