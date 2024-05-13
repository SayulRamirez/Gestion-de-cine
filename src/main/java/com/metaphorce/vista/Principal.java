package com.metaphorce.vista;

import com.metaphorce.modelo.GestorPelicula;
import com.metaphorce.modelo.Pelicula;

import java.util.List;

public class Principal {
    public static void main(String[] args) {

        Pelicula hobbit = new Pelicula("El hobbit");
        Pelicula madagascar = new Pelicula("Madagascar");
        Pelicula starWars = new Pelicula("Star wars");
        Pelicula elOrigen = new Pelicula("El origen");
        Pelicula helloween = new Pelicula("Helloween");

        GestorPelicula gestor = new GestorPelicula();

        // Se agregan las peliculas al gestor
        gestor.agregarPelicula(hobbit);
        gestor.agregarPelicula(madagascar);
        gestor.agregarPelicula(starWars);
        gestor.agregarPelicula(elOrigen);
        gestor.agregarPelicula(helloween);

        // Se marcan algunas peliculas como no dispobibles
        gestor.marcarComoNoDisponible(madagascar.getId());
        gestor.marcarComoNoDisponible(starWars.getId());
        gestor.marcarComoNoDisponible(elOrigen.getId());

        // Se marca una pelicula no diponible como disponible
        gestor.marcarComoDisponible(starWars.getId());

        // Eliminando una pelicula
        gestor.eliminarPelicula(madagascar.getId());

        // Se obtienen todas las peliculas, las disponibles y las no disponibles
        List<Pelicula> peliculas = gestor.obtenerPeliculas();
        List<Pelicula> disponibles = gestor.obtenerPeliculasDisponibles();
        List<Pelicula> noDisponibles = gestor.obtenerPeliculasNoDisponibles();

        // Se imprime por consola los valores de las listas
        System.out.println("Todas las peliculas");
        peliculas.forEach(System.out::println);

        System.out.println("Peliculas disponibles");
        disponibles.forEach(System.out::println);

        System.out.println("Peliculas no disponibles");
        noDisponibles.forEach(System.out::println);
    }
}
