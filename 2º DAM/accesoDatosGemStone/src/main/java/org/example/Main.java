package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {
        realizarOperacionesBasicas();
    }

    public static void realizarOperacionesBasicas() {
        // Configuración de conexión a GemStone/S
        String jdbcUrl = "jdbc:gemfirexd://localhost:1527/mibasededatos";
        String usuario = "root";
        String contraseña = "";

        try {
            // Establecer la conexión
            Connection conexion = DriverManager.getConnection(jdbcUrl, usuario, contraseña);

            // Crear una tabla y realizar operaciones básicas
            crearTabla(conexion);
            insertarDatos(conexion);
            recuperarDatos(conexion);

            // Cerrar la conexión
            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void crearTabla(Connection conexion) throws Exception {
        // Crear una tabla
        String sqlCrearTabla = "CREATE TABLE mitabla (id INT, nombre VARCHAR(255))";
        try (PreparedStatement declaracion = conexion.prepareStatement(sqlCrearTabla)) {
            declaracion.execute();
        }
    }

    private static void insertarDatos(Connection conexion) throws Exception {
        // Insertar datos
        String sqlInsertarDatos = "INSERT INTO mitabla VALUES (?, ?)";
        try (PreparedStatement declaracion = conexion.prepareStatement(sqlInsertarDatos)) {
            declaracion.setInt(1, 1);
            declaracion.setString(2, "Ejemplo");
            declaracion.execute();
        }
    }

    private static void recuperarDatos(Connection conexion) throws Exception {
        // Recuperar datos
        String sqlRecuperarDatos = "SELECT * FROM mitabla";
        try (PreparedStatement declaracion = conexion.prepareStatement(sqlRecuperarDatos);
             ResultSet conjuntoResultados = declaracion.executeQuery()) {

            while (conjuntoResultados.next()) {
                int id = conjuntoResultados.getInt("id");
                String nombre = conjuntoResultados.getString("nombre");
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }
        }
    }
}