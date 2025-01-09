package com.aluracursos.searchMovieOnSwapiApi.principal;

import com.aluracursos.searchMovieOnSwapiApi.modelos.ConsultaPelicula;
import com.aluracursos.searchMovieOnSwapiApi.modelos.GeneradorDeArchivo;
import com.aluracursos.searchMovieOnSwapiApi.modelos.Pelicula;
import com.aluracursos.searchMovieOnSwapiApi.modelos.PeliculaSwapi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalBusqueda {
    public static void main(String[] args) throws IOException {
        Scanner obtenerPeliculaID = new Scanner(System.in);
        List<Pelicula> peliculas = new ArrayList<>();

        while (true){

            System.out.println("Ingresa el numero de la pelicula star wars que quiere consultar");
            var numeroDePelicula = Integer.valueOf(obtenerPeliculaID.nextLine());

            ConsultaPelicula consulta = new ConsultaPelicula();


            if ( numeroDePelicula < 1 || numeroDePelicula > 7 ){
                System.out.println("El ID de la Pelicula aún no esta disponible, intenté con otro ID");
                break;
            }

            try {

                PeliculaSwapi pelicula = consulta.buscaPelicula(numeroDePelicula);
                Pelicula miPelicula = new Pelicula(pelicula);

                System.out.println(miPelicula);

                peliculas.add(miPelicula);


            }catch (NumberFormatException e){
                System.out.println("Numero no encontrado" + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizamdo la aplicación");
            }

            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(peliculas);


        }

    }
}
