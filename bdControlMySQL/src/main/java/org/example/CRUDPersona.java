package org.example;

import java.sql.*;
public class CRUDPersona {

    /*
    ------------------------------------------------------------------------------
                                    PERSONA
    ------------------------------------------------------------------------------
     */

    public static void insertarPersona() {
        try {
            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");
            Statement stmt = cn.createStatement();

            String sql = "INSERT INTO empresa.persona(dni, nombre, apellido1, apellido2, fechaNacimiento) " +
                    "VALUES ('75412476C', 'Jaime', 'Molina', 'Granados', '2002-08-10');";

            int filasInsertadas = stmt.executeUpdate(sql);
            System.out.println("Filas insertadas: " + filasInsertadas);
            stmt.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error!!!! " + e.getMessage());
        }
    }


    public static void lecturaPersona(Connection cn) {
        try {
            Statement stmt = cn.createStatement();

            String sql = "SELECT * FROM persona "
                    + "WHERE nombre='Jose'";
            System.out.println(sql);

            ResultSet resultados = stmt.executeQuery(sql);
            System.out.println("Listado de personas de nombre Jose");

            int nFilas = 0;

            while(resultados.next()) {
                System.out.println("Persona: "
                        + resultados.getString("dni")
                        + ", Nombre: "
                        + resultados.getString("nombre"));
                nFilas++;
            }

            System.out.println("Filas leidas: " + nFilas);
        } catch(Exception e) {
            System.out.println("Error!!!! " + e.getMessage());
        }
    }


    public static void lecturaPersonaID(Connection cn, String dni) {
        try {
            Statement stmt = cn.createStatement();

            String sql = "SELECT * FROM persona WHERE dni='" + dni + "'";

            System.out.println(sql);

            ResultSet resultado = stmt.executeQuery(sql);
            int nFilas = 0;
            while(resultado.next()) {
                System.out.println("Persona: " + resultado.getString("nombre")
                + ", " + " apellido: " + resultado.getString("apellido1"));
                nFilas++;
            }
            System.out.println("\nFilas leídas: " + nFilas);
            stmt.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void modificarPersona(Connection cn, String dni, String nombre, String apellido1, String apellido2, Date fechaNacimiento) {
        try {
            Statement stmt = cn.createStatement();
            String sql = "UPDATE persona SET nombre = '" + nombre + "'," +
                    " apellido1='" + apellido1 + "'," +
                    " apellido2='" + apellido2 + "'," +
                    " fechaNacimiento='" + fechaNacimiento + "'" +
                    " WHERE dni='" + dni + "'";
            System.out.println(sql);

            int filasActualizadas = stmt.executeUpdate(sql);
            System.out.println("Filas modificadas: " + filasActualizadas);

            stmt.close();
        } catch(Exception e) {
            System.out.println("Error modificado: " + e.getMessage());
        }
    }


    public static void eliminarPersona(Connection cn, String dni) {
        try {
            Statement stmt = cn.createStatement();
            String sql = "DELETE FROM persona " + "WHERE dni='" + dni + "'";
            System.out.println(sql);

            int filasEliminadas = stmt.executeUpdate(sql);
            System.out.println("Filas eliminadas: " + filasEliminadas);

            stmt.close();
        } catch(Exception e) {
            System.out.println("Error eliminando: " + e.getMessage());
        }
    }


    /*
    ------------------------------------------------------------------------------
                                    TRABAJADOR
    ------------------------------------------------------------------------------
     */

    public static void insertarTrabajador() {
        try {
            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");
            Statement stmt = cn.createStatement();

            String sql = "INSERT INTO empresa.trabajador(numeroRegistroPersonal , fechaIncorporacion, puesto, dni) " +
                    "VALUES ('12345', '2020-11-15', 'Becario', '75884752A');";

            int filasInsertadas = stmt.executeUpdate(sql);
            System.out.println("Filas insertadas: " + filasInsertadas);
            stmt.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error!!!! " + e.getMessage());
        }
    }
}