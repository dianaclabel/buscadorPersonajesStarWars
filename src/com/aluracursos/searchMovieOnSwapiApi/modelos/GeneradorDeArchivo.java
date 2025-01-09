package com.aluracursos.searchMovieOnSwapiApi.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneradorDeArchivo {

    public  void guardarJson(List<Pelicula> peliculas) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter("peliculas.json");
        escritura.write(gson.toJson(peliculas));
        escritura.close();
    }
}
