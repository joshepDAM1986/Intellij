package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class CRUD {
    public static Connection conectar() {
        try {
            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");
            return cn;
        } catch(Exception e) {
            System.out.println("Error!!!! " + e.getMessage());
        }
        return null;
    }


    public static void probarConexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println("Error!!!!: " + e.getMessage());
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }
    }
}