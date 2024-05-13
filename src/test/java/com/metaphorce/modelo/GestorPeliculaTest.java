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

    @Test
    void cuandoSeEliminaUnaPeliculaPorSuId() {

        gestorPelicula.agregarPelicula(new Pelicula("Star wars"));
        gestorPelicula.agregarPelicula(pelicula);

        gestorPelicula.eliminarPelicula(pelicula.getId());

        List<Pelicula> peliculas = gestorPelicula.getPeliculas();

        assertFalse(peliculas.isEmpty());
        assertEquals(1, peliculas.size());
        assertFalse(peliculas.contains(pelicula));
    }

    @Test
    void cuandoAlEliminarUnaPeliculaElIdEsNulo() {

        gestorPelicula.agregarPelicula(new Pelicula("Star wars"));
        gestorPelicula.agregarPelicula(pelicula);

        gestorPelicula.eliminarPelicula(null);

        List<Pelicula> peliculas = gestorPelicula.getPeliculas();

        assertFalse(peliculas.isEmpty());
        assertEquals(2, peliculas.size());
    }

    @Test
    void cuandoAlEliminarUnaPeliculaNoSeEncuentraPorSuId() {

        gestorPelicula.agregarPelicula(new Pelicula("Star wars"));
        gestorPelicula.agregarPelicula(pelicula);

        Pelicula superman = new Pelicula("Superman");

        gestorPelicula.eliminarPelicula(superman.getId());

        List<Pelicula> peliculas = gestorPelicula.getPeliculas();

        assertFalse(peliculas.isEmpty());
        assertEquals(2, peliculas.size());
        assertFalse(peliculas.contains(superman));
    }
}
