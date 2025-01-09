package com.aluracursos.searchMovieOnSwapiApi.modelos;

public class Pelicula {
    private String nombre;
    private String director;
    private String fechaDePublicacion;
    private String productor;

    public Pelicula(String nombre, String director, String fechaDePublicacion, String productor) {
        this.nombre = nombre;
        this.director = director;
        this.fechaDePublicacion = fechaDePublicacion;
        this.productor = productor;
    }

    public Pelicula( PeliculaSwapi pelicula ) {
        this.nombre = pelicula.title();
        this.director = pelicula.director();
        this.fechaDePublicacion = pelicula.release_date();
        this.productor = pelicula.producer();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public void setFechaDePublicacion(String fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    @Override
    public String toString() {
        return
                "(nombre='" + nombre +
                "', director='" + director +
                "', fechaDePublicacion='" + fechaDePublicacion +
                "', productor='" + productor  +
                "')";
    }
}
