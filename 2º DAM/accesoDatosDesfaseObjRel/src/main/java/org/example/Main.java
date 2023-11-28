package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            // 1. crear conexion
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/taller",
                    "root", "");

            // 2. Sentencia
            statement = conexion.prepareStatement("SELECT * FROM coches;");
            resultSet = statement.executeQuery();

            // 3. Procesar resultados
            List<Coche> cars = new ArrayList<>();
            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String modelo = resultSet.getString("modelo");
                String fabricante = resultSet.getString("fabricante");
                Integer numCilindros = resultSet.getInt("num_cilindros");
                Double numCV = resultSet.getDouble("num_cv");
                Coche coche = new Coche(
                        id, modelo, fabricante, numCilindros, numCV);
                cars.add(coche);
            }
            System.out.println(cars);

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            try { if (resultSet != null) resultSet.close(); } catch (Exception e) { e.printStackTrace();}
            try { if (statement != null) statement.close(); } catch (Exception e) {}
            try { if (conexion != null) conexion.close(); } catch (Exception e) {}
        }
    }
}