package org.example;

import java.sql.*;

public class Main2 {
    public static void main(String[] args) {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            conexion = establecerConexion();

            conexion.setAutoCommit(false);
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql_ingresar = "UPDATE cuentas " +
                    "SET saldo=saldo+1000 " +
                    "WHERE numero='66778899001234567890'";
            sentencia = conexion.prepareStatement(sql_ingresar);
            sentencia.executeUpdate();

            if(Math.random()<0.5){
                throw new Error();
            }

            String sql_sacar = "UPDATE cuentas " +
                    "SET saldo=saldo-1000 " +
                    "WHERE numero='12345678901122334455'";
            sentencia = conexion.prepareStatement(sql_sacar);
            sentencia.executeUpdate();

            conexion.commit();
            System.out.println("Transaccion completada con exito");
        } catch (SQLException exception) {
            System.out.println("Error en la transacción");
            System.out.println("Volvemos hacia atrás");
            try {
                conexion.rollback();
            } catch (SQLException e) {
                System.out.println("Error al  hacer rollback");
            }
        } finally {
            cerrarConexion(conexion, sentencia, resultado);
        }
    }

    public static Connection establecerConexion() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/banco", "root", "");
    }

    public static void cerrarConexion(Connection conexion, PreparedStatement sentencia, ResultSet resultado) {
        try {
            if (resultado != null) resultado.close();

            if (sentencia != null) sentencia.close();

            if (conexion != null) conexion.close();

        } catch (SQLException exception) {
            System.out.println("Error al cerrar la conexión\n" + exception.getMessage());
            exception.printStackTrace();
        }
    }
}