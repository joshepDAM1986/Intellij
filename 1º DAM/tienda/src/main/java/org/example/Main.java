package org.example;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
//        JDBC.probarConexion();
//        JDBC.insertar();

        try {
            Statement stmt = JDBC.conectar();
            if (stmt!=null) {
                if (JDBC.insertar(stmt, "Melón", 3.5f,
                        "Con jamón",
                        "España"))
                        System.out.println("Insertado melón");
                else System.out.println("No melón");
            }
            else System.out.println("No se ha podido " +
                    "establecer la conexión");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}