package com.metaphorce.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestorPeliculaTest {

    private GestorPelicula gestorPelicula;
    private Pelicula pelicula;

    @BeforeEach
    void setup() {
        pelicula = new Pelicula("El señor de los anillos");
        gestorPelicula = new GestorPelicula();
    }

    @Test
    void cuandoSeCreaUnGestorDePeliculaLaListaEstaVacia() {

        List<Pelicula> peliculas = gestorPelicula.getPeliculas();

        assertTrue(peliculas.isEmpty());
    }

    @Test
    void cuandoSeAgregaUnaPeliculaNueva() {

        gestorPelicula.agregarPelicula(pelicula);

        List<Pelicula> peliculas = gestorPelicula.getPeliculas();

        assertFalse(peliculas.isEmpty());
        assertEquals(1, peliculas.size());
    }
}
