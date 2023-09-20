package org.example;

import javax.xml.transform.Result;
import java.sql.*;

public class JDBC {

    static public Statement conectar() {
        try {
            String url = "jdbc:mariadb://localhost:3306/tienda";
            Connection cn = DriverManager.getConnection(url,
                    "usr_tienda", "Tienda#23");
            Statement stmt = cn.createStatement();
            return stmt;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
        static public boolean insertar(Statement stmt, String nombre,
                                       float precio, String descripcion, String pais)
        {
            boolean resultado = false;
            try {
                String sql="INSERT INTO tienda.producto(nombre," +
                        "descripcion, precio, pais)" +
                        " VALUES ('" + nombre + "'," +
                        " '" + descripcion + "'," +
                        " '" + precio + "'," +
                        " '" + pais + "');";
                System.out.println(sql);
                int filasInsertadas = stmt.executeUpdate(sql);
                System.out.println("Filas insertadas: " + filasInsertadas);
                return filasInsertadas > 0;
            }
            catch (Exception e) {
                System.out.println("Error!!!!: " + e.getMessage());
                return false;
            }
        }

    public static Fruta consultar(Statement stmt, String nombre) {
        try {
            // Operaciones CRUD
            String query = "SELECT * FROM producto WHERE nombre = '"
                    + nombre + "'";
            // Mostramos por pantalla la consulta para probar que funciona directamente en PHP myadmin
            System.out.println(query);
            ResultSet resultados = stmt.executeQuery(query);
            Fruta encontrada = null;
            while (resultados.next()) {
                encontrada
                        = new Fruta(resultados.getString("nombre"),
                        resultados.getFloat("precio"),
                        resultados.getString("descripcion"),
                        resultados.getString("pais"));
            }
            System.out.println("Encontrado: " + encontrada.getNombre());
            return encontrada;

        } catch (SQLException ex) {
            System.err.print("SQLException: " + ex.getMessage());
            return null;        }

    }

    static public void modificar(Statement stmt, int id,
         String nombre, String descripcion, float precio, String pais)
    {
        try {
            String sql="UPDATE producto " +
                    "SET nombre= '" + nombre + "'," +
                    " descripcion='" + descripcion + "'," +
                    " precio='" + precio + "'," +
                    " pais='" + pais + "'" +
                    " WHERE id='" + id + "'";
            System.out.println(sql);

            int filasModificadas = stmt.executeUpdate(sql);
            System.out.println("Filas modificadas: " + filasModificadas);

        }
        catch (Exception e) {
            System.out.println("Error modificando: " + e.getMessage());
        }
    }
}
