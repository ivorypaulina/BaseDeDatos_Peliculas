package com.example.cando_crud_bd.model;

import java.time.LocalDate;

public class Pelicula {

    private int id;
    private String titulo;
    private String genero;
    private String director;
    private int duracion;
    private LocalDate estreno;
    private boolean disponible;

    public Pelicula() {
    }

    public Pelicula(String titulo, String genero, String director, int duracion, LocalDate estreno, boolean disponible) {
        this.titulo = titulo;
        this.genero = genero;
        this.director = director;
        this.duracion = duracion;
        this.estreno = estreno;
        this.disponible = disponible;
    }

    public Pelicula(int id, String titulo, String genero, String director, int duracion, LocalDate estreno, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.director = director;
        this.duracion = duracion;
        this.estreno = estreno;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getDirector() {
        return director;
    }

    public int getDuracion() {
        return duracion;
    }

    public LocalDate getEstreno() {
        return estreno;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setEstreno(LocalDate estreno) {
        this.estreno = estreno;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}