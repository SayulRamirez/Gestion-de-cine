package com.metaphorce.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PeliculaTest {

    @Test
    void cuandoSeCreaUnaPeliculaSusValoresNoSonNulos() {

        Pelicula pelicula = new Pelicula("Star wars");

        Integer id = pelicula.getId();
        String nombre = pelicula.getNombre();
        Boolean disponible = pelicula.getDisponible();

        assertNotNull(id);
        assertNotNull(nombre);
        assertNotNull(disponible);
    }

    @Test
    void cuandoSeCreaUnaPeliculaLaDisponibilidadEsTrue() {

        Pelicula pelicula = new Pelicula("Star wars");

        boolean disponible = pelicula.getDisponible();

        assertTrue(disponible);
    }

    @Test
    void cuandoSeCreanVariasPeliculasSuIdEsDiferente() {

        Pelicula pelicula = new Pelicula("Star wars");

        Pelicula elResplandor = new Pelicula("El resplandor");

        Pelicula elHobbit = new Pelicula("El hobbit");

        int idPelicula = pelicula.getId();
        int idElResplandor = elResplandor.getId();
        int idElHobbit = elHobbit.getId();

        assertNotEquals(idPelicula, idElResplandor);
        assertNotEquals(idPelicula, idElHobbit);
        assertNotEquals(idElHobbit, idElResplandor);
    }

    @Test
    void cuandoSeCambiaLaDisponibilidadDeLaPeliculaAFalse() {
        Pelicula pelicula = new Pelicula("Star wars");

        pelicula.setDisponible(false);

        assertFalse(pelicula.getDisponible());
    }

    @Test
    void cuandoSeCambiaLaDisponibilidadDeLaPeliculaATrueDespuesDeFalse() {
        Pelicula pelicula = new Pelicula("Star wars");

        pelicula.setDisponible(false);

        pelicula.setDisponible(true);

        assertTrue(pelicula.getDisponible());
    }
}
