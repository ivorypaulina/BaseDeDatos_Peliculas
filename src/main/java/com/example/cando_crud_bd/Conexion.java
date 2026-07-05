package com.example.cando_crud_bd.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
            "jdbc:postgresql://db.howcpnxyqcskcxxtebnn.supabase.co:5432/postgres?sslmode=require";

    private static final String USER = "postgres";

    private static final String PASSWORD = "1234pelis#Ivory";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}