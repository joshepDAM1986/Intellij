package org.example;

import java.sql.*;


public class Main {
    public static void main(String[] args) {
        //JDBC.conectar()
        // JDBC.probarConexion();
        //JDBC.insertar();

        try {
            Connection cn = JDBC.conectar();
            JDBC.lectura(cn);
        }
        catch (Exception e) {
            System.out.println("Error!!" + e.getMessage());
        }
    }
}
