package com.example.cando_crud_bd.dao;

import com.example.cando_crud_bd.db.Conexion;
import com.example.cando_crud_bd.model.Pelicula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAOImpl implements PeliculaDAO {

    @Override
    public void crear(Pelicula pelicula) {
        String sql = "INSERT INTO peliculas(titulo, genero, director, duracion, estreno, disponible) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getGenero());
            ps.setString(3, pelicula.getDirector());
            ps.setInt(4, pelicula.getDuracion());
            ps.setDate(5, Date.valueOf(pelicula.getEstreno()));
            ps.setBoolean(6, pelicula.isDisponible());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pelicula> listar() {
        List<Pelicula> lista = new ArrayList<>();
        String sql = "SELECT * FROM peliculas ORDER BY id";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();

                pelicula.setId(rs.getInt("id"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setGenero(rs.getString("genero"));
                pelicula.setDirector(rs.getString("director"));
                pelicula.setDuracion(rs.getInt("duracion"));
                pelicula.setEstreno(rs.getDate("estreno").toLocalDate());
                pelicula.setDisponible(rs.getBoolean("disponible"));

                lista.add(pelicula);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void actualizar(Pelicula pelicula) {
        String sql = "UPDATE peliculas SET titulo = ?, genero = ?, director = ?, duracion = ?, estreno = ?, disponible = ? WHERE id = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getGenero());
            ps.setString(3, pelicula.getDirector());
            ps.setInt(4, pelicula.getDuracion());
            ps.setDate(5, Date.valueOf(pelicula.getEstreno()));
            ps.setBoolean(6, pelicula.isDisponible());
            ps.setInt(7, pelicula.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM peliculas WHERE id = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}