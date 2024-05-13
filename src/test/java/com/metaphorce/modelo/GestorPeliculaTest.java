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

        List<Pelicula> peliculas = gestorPelicula.obtenerPeliculas();

        assertTrue(peliculas.isEmpty());
    }

    @Test
    void cuandoSeAgregaUnaPeliculaNueva() {

        gestorPelicula.agregarPelicula(pelicula);

        List<Pelicula> peliculas = gestorPelicula.obtenerPeliculas();

        assertFalse(peliculas.isEmpty());
        assertEquals(1, peliculas.size());
    }

    @Test
    void cuandoSeEliminaUnaPeliculaPorSuId() {

        gestorPelicula.agregarPelicula(new Pelicula("Star wars"));
        gestorPelicula.agregarPelicula(pelicula);

        gestorPelicula.eliminarPelicula(pelicula.getId());

        List<Pelicula> peliculas = gestorPelicula.obtenerPeliculas();

        assertFalse(peliculas.isEmpty());
        assertEquals(1, peliculas.size());
        assertFalse(peliculas.contains(pelicula));
    }

    @Test
    void cuandoAlEliminarUnaPeliculaElIdEsNulo() {

        gestorPelicula.agregarPelicula(new Pelicula("Star wars"));
        gestorPelicula.agregarPelicula(pelicula);

        gestorPelicula.eliminarPelicula(null);

        List<Pelicula> peliculas = gestorPelicula.obtenerPeliculas();

        assertFalse(peliculas.isEmpty());
        assertEquals(2, peliculas.size());
    }

    @Test
    void cuandoAlEliminarUnaPeliculaNoSeEncuentraPorSuId() {

        gestorPelicula.agregarPelicula(new Pelicula("Star wars"));
        gestorPelicula.agregarPelicula(pelicula);

        Pelicula superman = new Pelicula("Superman");

        gestorPelicula.eliminarPelicula(superman.getId());

        List<Pelicula> peliculas = gestorPelicula.obtenerPeliculas();

        assertFalse(peliculas.isEmpty());
        assertEquals(2, peliculas.size());
        assertFalse(peliculas.contains(superman));
    }

    @Test
    void cuandoSeObtienenTodasLasPeliculasYLaListaNoEstaVacia() {

        gestorPelicula.agregarPelicula(pelicula);
        gestorPelicula.agregarPelicula(new Pelicula("El hobbit"));
        gestorPelicula.agregarPelicula(new Pelicula("Superman"));
        gestorPelicula.agregarPelicula(new Pelicula("El mundo mágico de terabitia"));

        List<Pelicula> peliculas = gestorPelicula.obtenerPeliculas();

        assertFalse(peliculas.isEmpty());
        assertEquals(4, peliculas.size());
    }

    @Test
    void cuandoSeObtienenLasPeliculasDisponiblesEstaVacia() {
        Pelicula hobbit = new Pelicula("El hobbit");
        Pelicula terabitia = new Pelicula("El mundo mágico de terabitia");
        Pelicula superman = new Pelicula("Superman");

        pelicula.setDisponible(false);
        hobbit.setDisponible(false);
        terabitia.setDisponible(false);
        superman.setDisponible(false);

        gestorPelicula.agregarPelicula(pelicula);
        gestorPelicula.agregarPelicula(hobbit);
        gestorPelicula.agregarPelicula(superman);
        gestorPelicula.agregarPelicula(terabitia);

        List<Pelicula> peliculas = gestorPelicula.obtenerPeliculasDisponibles();

        assertTrue(peliculas.isEmpty());
    }

    @Test
    void cuandoSeObtienenLasPeliculasDisponiblesNoEstaVacia() {

        Pelicula hobbit = new Pelicula("El hobbit");
        Pelicula terabitia = new Pelicula("El mundo mágico de terabitia");
        Pelicula superman = new Pelicula("Superman");

        pelicula.setDisponible(false);
        superman.setDisponible(false);

        gestorPelicula.agregarPelicula(pelicula);
        gestorPelicula.agregarPelicula(hobbit);
        gestorPelicula.agregarPelicula(superman);
        gestorPelicula.agregarPelicula(terabitia);

        List<Pelicula> peliculas = gestorPelicula.obtenerPeliculasDisponibles();

        assertFalse(peliculas.isEmpty());
        assertEquals(2, peliculas.size());
        assertTrue(peliculas.contains(hobbit));
        assertTrue(peliculas.contains(terabitia));
    }

    @Test
    void cuandoSeObtienenLasPeliculasNoDisponiblesEstaVacia() {
        Pelicula hobbit = new Pelicula("El hobbit");
        Pelicula terabitia = new Pelicula("El mundo mágico de terabitia");
        Pelicula superman = new Pelicula("Superman");

        gestorPelicula.agregarPelicula(pelicula);
        gestorPelicula.agregarPelicula(hobbit);
        gestorPelicula.agregarPelicula(superman);
        gestorPelicula.agregarPelicula(terabitia);

        List<Pelicula> peliculas = gestorPelicula.obtenerPeliculasNoDisponibles();

        assertTrue(peliculas.isEmpty());
    }

    @Test
    void cuandoSeObtienenLasPeliculasNoDisponiblesNoEstaVacia() {

        Pelicula hobbit = new Pelicula("El hobbit");
        Pelicula terabitia = new Pelicula("El mundo mágico de terabitia");
        Pelicula superman = new Pelicula("Superman");

        pelicula.setDisponible(false);
        superman.setDisponible(false);

        gestorPelicula.agregarPelicula(pelicula);
        gestorPelicula.agregarPelicula(hobbit);
        gestorPelicula.agregarPelicula(superman);
        gestorPelicula.agregarPelicula(terabitia);

        List<Pelicula> peliculas = gestorPelicula.obtenerPeliculasNoDisponibles();

        assertFalse(peliculas.isEmpty());
        assertEquals(2, peliculas.size());
        assertTrue(peliculas.contains(pelicula));
        assertTrue(peliculas.contains(superman));
    }

    @Test
    void cuandoSeMarcaComoDisponiblePeroElIdEsNull() {
        Pelicula hobbit = new Pelicula("El hobbit");
        hobbit.setDisponible(false);

        gestorPelicula.agregarPelicula(pelicula);
        gestorPelicula.agregarPelicula(hobbit);
        gestorPelicula.agregarPelicula(new Pelicula("El mundo mágico de terabitia"));
        gestorPelicula.agregarPelicula(new Pelicula("Superman"));

        gestorPelicula.marcarComoDisponible(null);

        List<Pelicula> disponibles = gestorPelicula.obtenerPeliculasDisponibles();
        List<Pelicula> noDisponibles = gestorPelicula.obtenerPeliculasNoDisponibles();

        assertFalse(disponibles.isEmpty());
        assertEquals(3, disponibles.size());

        assertFalse(noDisponibles.isEmpty());
        assertEquals(1, noDisponibles.size());
    }

    @Test
    void cuandoSeMarcaComoDisponiblePeroNoEstaLaPelicula() {
        Pelicula hobbit = new Pelicula("El hobbit");
        hobbit.setDisponible(false);

        gestorPelicula.agregarPelicula(pelicula);
        gestorPelicula.agregarPelicula(hobbit);
        gestorPelicula.agregarPelicula(new Pelicula("El mundo mágico de terabitia"));
        gestorPelicula.agregarPelicula(new Pelicula("Superman"));

        gestorPelicula.marcarComoDisponible(123);

        List<Pelicula> disponibles = gestorPelicula.obtenerPeliculasDisponibles();
        List<Pelicula> noDisponibles = gestorPelicula.obtenerPeliculasNoDisponibles();

        assertFalse(disponibles.isEmpty());
        assertEquals(3, disponibles.size());

        assertFalse(noDisponibles.isEmpty());
        assertEquals(1, noDisponibles.size());
    }

    @Test
    void cuandoSeMarcaComoDisponible() {

        Pelicula hobbit = new Pelicula("El hobbit");
        hobbit.setDisponible(false);

        gestorPelicula.agregarPelicula(pelicula);
        gestorPelicula.agregarPelicula(new Pelicula("El mundo mágico de terabitia"));
        gestorPelicula.agregarPelicula(hobbit);
        gestorPelicula.agregarPelicula(new Pelicula("Superman"));

        gestorPelicula.marcarComoDisponible(hobbit.getId());

        List<Pelicula> disponibles = gestorPelicula.obtenerPeliculasDisponibles();
        List<Pelicula> noDisponibles = gestorPelicula.obtenerPeliculasNoDisponibles();

        assertFalse(disponibles.isEmpty());
        assertEquals(4, disponibles.size());
        assertTrue(disponibles.contains(hobbit));

        assertTrue(noDisponibles.isEmpty());
    }

    @Test
    void cuandoSeMarcaComoNoDisponiblePeroElIdEsNull() {
        Pelicula hobbit = new Pelicula("El hobbit");
        hobbit.setDisponible(false);

        gestorPelicula.agregarPelicula(pelicula);
        gestorPelicula.agregarPelicula(hobbit);
        gestorPelicula.agregarPelicula(new Pelicula("El mundo mágico de terabitia"));
        gestorPelicula.agregarPelicula(new Pelicula("Superman"));

        gestorPelicula.marcarComoNoDisponible(null);

        List<Pelicula> disponibles = gestorPelicula.obtenerPeliculasDisponibles();
        List<Pelicula> noDisponibles = gestorPelicula.obtenerPeliculasNoDisponibles();

        assertFalse(disponibles.isEmpty());
        assertEquals(3, disponibles.size());

        assertFalse(noDisponibles.isEmpty());
        assertEquals(1, noDisponibles.size());
    }

    @Test
    void cuandoSeMarcaComoNoDisponiblePeroNoEstaLaPelicula() {
        Pelicula hobbit = new Pelicula("El hobbit");
        hobbit.setDisponible(false);

        gestorPelicula.agregarPelicula(pelicula);
        gestorPelicula.agregarPelicula(hobbit);
        gestorPelicula.agregarPelicula(new Pelicula("El mundo mágico de terabitia"));
        gestorPelicula.agregarPelicula(new Pelicula("Superman"));

        gestorPelicula.marcarComoNoDisponible(123);

        List<Pelicula> disponibles = gestorPelicula.obtenerPeliculasDisponibles();
        List<Pelicula> noDisponibles = gestorPelicula.obtenerPeliculasNoDisponibles();

        assertFalse(disponibles.isEmpty());
        assertEquals(3, disponibles.size());

        assertFalse(noDisponibles.isEmpty());
        assertEquals(1, noDisponibles.size());
    }

    @Test
    void cuandoSeMarcaComoNoDisponible() {

        Pelicula hobbit = new Pelicula("El hobbit");

        gestorPelicula.agregarPelicula(pelicula);
        gestorPelicula.agregarPelicula(new Pelicula("El mundo mágico de terabitia"));
        gestorPelicula.agregarPelicula(hobbit);
        gestorPelicula.agregarPelicula(new Pelicula("Superman"));

        gestorPelicula.marcarComoNoDisponible(hobbit.getId());

        List<Pelicula> disponibles = gestorPelicula.obtenerPeliculasDisponibles();
        List<Pelicula> noDisponibles = gestorPelicula.obtenerPeliculasNoDisponibles();

        assertFalse(disponibles.isEmpty());
        assertEquals(3, disponibles.size());

        assertFalse(noDisponibles.isEmpty());
        assertEquals(1, noDisponibles.size());
        assertTrue(noDisponibles.contains(hobbit));
    }
}
