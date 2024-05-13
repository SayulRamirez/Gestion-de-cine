package com.metaphorce.modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorPelicula {

    private final List<Pelicula> peliculas;

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

    public List<Pelicula> obtenerPeliculas() {
        return peliculas;
    }

    public List<Pelicula> obtenerPeliculasDisponibles() {

        List<Pelicula> peliculasDisponibles = new ArrayList<>();

        for (Pelicula pelicula : peliculas) {

            if (pelicula.getDisponible()) {
                peliculasDisponibles.add(pelicula);
            }
        }

        return peliculasDisponibles;
    }

    public List<Pelicula> obtenerPeliculasNoDisponibles() {
        List<Pelicula> peliculasNoDisponibles = new ArrayList<>();

        for (Pelicula pelicula : peliculas) {

            if (!pelicula.getDisponible()) {
                peliculasNoDisponibles.add(pelicula);
            }
        }

        return peliculasNoDisponibles;
    }

    public void marcarComoDisponible(Integer id) {

        if (id == null) {
            return;
        }

        for (Pelicula pelicula : peliculas) {

            if (pelicula.getId().equals(id)) {
                pelicula.setDisponible(true);

                break;
            }
        }
    }

    public void marcarComoNoDisponible(Integer id) {

        if (id == null) {
            return;
        }

        for (Pelicula pelicula : peliculas) {

            if (pelicula.getId().equals(id)) {
                pelicula.setDisponible(false);

                break;
            }
        }
    }
}
