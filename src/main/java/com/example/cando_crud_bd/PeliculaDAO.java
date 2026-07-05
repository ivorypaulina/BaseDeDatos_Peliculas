package com.example.cando_crud_bd.dao;

import com.example.cando_crud_bd.model.Pelicula;
import java.util.List;

public interface PeliculaDAO {

    void crear(Pelicula pelicula);

    List<Pelicula> listar();

    void actualizar(Pelicula pelicula);

    void eliminar(int id);
}