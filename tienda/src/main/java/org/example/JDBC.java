package org.example;

import java.sql.*;

public class JDBC {

    public static Connection conectar() {
        try {
            String url = "jdbc:mariadb://localhost:3306/tienda";
            Connection cn = DriverManager.getConnection(url, "usr_tienda", "Tienda#23");
            return cn;
        } catch (Exception e) {
            System.out.println("Error!!!! " + e.getMessage());
        }
        return null;
    }

    public static void probarConexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println("Error!!!: " + e.getMessage());
            System.err.print("ClassNotFoundException: " + e.getMessage());
        }
    }

    public static void insertar() {
        try {
            String url = "jdbc:mariadb://localhost:3306/tienda";
            Connection cn = DriverManager.getConnection(url, "usr_tienda", "Tienda#23");
            Statement stmt = cn.createStatement();
            String sql = "INSERT INTO tienda.producto('nombre', " +
                    "'descripcion', 'precio', 'pais')" +
                    " VALUES ('frambuesa', 'frambuesa de importación, " +
                    "'3', 'Portugal);";
            int filasInsertadas = stmt.executeUpdate(sql);
            System.out.println("Filas insertadas: " + filasInsertadas);
            stmt.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error!!!! " + e.getMessage());
        }
    }

    public static void lectura(Connection cn) {
        try {
            Statement stmt= cn.createStatement();

            String sql="SELECT * FROM producto " +
                    "WHERE pais='españa'";
            System.out.println(sql);

            ResultSet resultado = stmt.executeQuery(sql);
            System.out.println("Listado de productos españoles:\n");
            int numFilas=0;
            while(resultado.next()){
                System.out.println("Producto: "
                +resultado.getString("nombre")
                        +", "+" precio: "
                +resultado.getFloat("precio"));
                numFilas++;
            }
            System.out.println("\nFilas leidas: "+ numFilas);
            stmt.close();
            }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

