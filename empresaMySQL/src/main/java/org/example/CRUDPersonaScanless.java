package org.example;

import java.sql.*;
import java.util.Scanner;


public class CRUDPersonaScanless {

    static public Statement conectar() {
        try {
            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url,
                    "usr_empresa", "Empresa#23");
            Statement stmt = cn.createStatement();
            return stmt;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static boolean insertarPersonaScanless(Statement stmt, String dni, String nombre, int numRegistro) {
        boolean resultado = false;
        try {
            String sql = "INSERT INTO empresa.persona(dni," +
                    "nombre, numRegistro)" +
                    "VALUES ('" + dni + "'," +
                    " '" + nombre + "'," +
                    " '" + numRegistro + "');";

            System.out.println(sql);
            int filasInsertadas = stmt.executeUpdate(sql);
            System.out.println("Filas insertadas: " + filasInsertadas);
            return filasInsertadas > 0;
        } catch (Exception e) {
            System.out.println("Error!!!!: " + e.getMessage());
            return false;
        }
    }
    public static Persona consultarPersonaScanless(Statement stmt, String dni) {
        try {
            String query = "SELECT * FROM empresa.persona WHERE dni = '"
                    + dni + "'";
            ResultSet resultados = stmt.executeQuery(query);
            Persona encontrada = null;
            while (resultados.next()) {
                encontrada
                        = new Persona(resultados.getString("dni"),
                        resultados.getString("nombre"),
                        resultados.getInt("numRegistro"));
            }
            System.out.println("Encontrada: " + encontrada);
            return encontrada;
        }
        catch (SQLException ex) {
            System.err.print("SQLException: " + ex.getMessage());
            return null;
        }
    }

    public static boolean modificarPersonaScanless(Statement  stmt, int id, String dni, String nombre, int numRegistro) {
        try {
            String query = "UPDATE empresa.persona " +
                    "SET dni = '" + dni + "', " +
                    "nombre = '" + nombre + "', " +
                    "numRegistro = " + numRegistro + " " +
                    "WHERE id = '" + id + "'";

            int filasModificadas = stmt.executeUpdate(query);
            System.out.println("Filas modificadas: " + filasModificadas);
            return filasModificadas > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public static boolean borrarPersonaScanless(Statement stmt, String dni){
        try{
            String query = "DELETE FROM empresa.persona "
                    +"WHERE dni='" + dni + "'";

            int filasBorradas = stmt.executeUpdate(query);
            System.out.println("Filas borradas: "+ filasBorradas);
            boolean resultado = false;
            resultado = filasBorradas > 0;
            System.out.println("Borrado: " + resultado);
            return resultado;
        }

        catch(Exception e){
            System.out.println("Error!!"+ e.getMessage());
            return false;
        }
    }
}

