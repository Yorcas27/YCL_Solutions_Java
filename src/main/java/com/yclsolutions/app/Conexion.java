package com.yclsolutions.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/ycl_solutions_db";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "123456";

    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión a MySQL establecida correctamente.");
            return conexion;

        } catch (SQLException e) {
            System.out.println("Error al conectar con MySQL.");
            System.out.println("Detalle: " + e.getMessage());
            return null;
        }
    }
}
