package com.metaphorce.modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorPelicula {

    private List<Pelicula> peliculas;

    public GestorPelicula() {
        peliculas = new ArrayList<>();
    }

    public void agregarPelicula(Pelicula pelicula) {
        this.peliculas.add(pelicula);
    }

    public void eliminarPelicula(Integer id) {

        if (id == null) {
            return;
        }

        Pelicula peliculaAEliminar = null;

        for (Pelicula pelicula : peliculas) {

            if (pelicula.getId().equals(id)) {
                peliculaAEliminar = pelicula;

                break;
            }
        }

        if (peliculaAEliminar != null) {
            peliculas.remove(peliculaAEliminar);
        }
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }
}
