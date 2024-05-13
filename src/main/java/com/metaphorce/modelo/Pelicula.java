package com.metaphorce.modelo;

public class Pelicula {

    private final Integer id;
    private final String nombre;
    private Boolean disponible;
    private static Integer idContador = 1;

    public Pelicula(String nombre) {
        this.nombre = nombre;
        this.id = idContador;
        this.disponible = true;

        idContador++;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getDisponible() {
        return disponible;
    }
}
