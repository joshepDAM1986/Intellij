package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            Connection cn = conectar();
            if (cn != null) {

                XMLtoDatabase.insertarXml();
                //XMLtoDatabaseRival.insertarXml();

                cn.close();
            } else {
                System.out.println("No se pudo conectar");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static Connection conectar() {
        try {
            String url = "jdbc:mariadb://localhost:3306/batallaxml";
            Connection cn = DriverManager.getConnection(url, "usr_batalla", "Batalla#23");
            return cn;
        } catch (Exception e) {
            System.out.println("Error!!!! " + e.getMessage());
        }
        return null;
    }
}