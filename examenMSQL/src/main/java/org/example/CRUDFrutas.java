package org.example;

import java.sql.*;
import java.util.List;

/**
 * Esta clase proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar)
 * en una tabla de frutas en una base de datos.
 */
public class CRUDFrutas {

    /**
     * Establece una conexión con la base de datos.
     *
     * @return una instancia del objeto Statement para ejecutar consultas SQL en la base de datos.
     */

    static public Statement conectar() {
        try {
            String url = "jdbc:mariadb://localhost:3306/frutas";
            Connection cn = DriverManager.getConnection(url,
                    "usr_frutas", "Frutas#23");
            Statement stmt = cn.createStatement();
            return stmt;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    /**
     * Inserta una nueva fruta en la base de datos.
     *
     * @param stmt        una instancia del objeto Statement para ejecutar la consulta SQL.
     * @param nombre      el nombre de la fruta.
     * @param descripcion la descripción de la fruta.
     * @param precio      el precio de la fruta.
     * @param pais        el identificador del país de origen de la fruta.
     * @return true si la fruta se insertó correctamente, false en caso contrario.
     */

    public static boolean insertarFrutas(Statement stmt, String nombre, String descripcion, float precio, int pais) {
        try {
            String sql = "INSERT INTO frutas.frutas(nombre," +
                    "descripcion, precio, pais)" +
                    "VALUES ('" + nombre + "', " +
                    " '" + descripcion + "', " +
                    " " + precio + ", " +
                    " " + pais + ");";

            System.out.println(sql);
            int filasInsertadas = stmt.executeUpdate(sql);
            System.out.println("Filas insertadas: " + filasInsertadas);
            boolean resultado = false;
            resultado = filasInsertadas > 0;
            System.out.println("Insertado: " + resultado);
            return resultado;
        } catch (Exception e) {
            System.out.println("Error!!!!: " + e.getMessage());
            return false;
        }
    }

    /**
     * Consulta una fruta en la base de datos por su identificador.
     *
     * @param stmt una instancia del objeto Statement para ejecutar la consulta SQL.
     * @param id   el identificador de la fruta a consultar.
     * @return un objeto Frutas que representa la fruta encontrada, o null si no se encontró ninguna fruta.
     */
    public static Frutas consultarFrutas(Statement stmt, int id) {
        try {
            String query = "SELECT * FROM frutas.frutas WHERE id = '"
                    + id + "'";
            ResultSet resultados = stmt.executeQuery(query);
            Frutas encontrada = null;
            while (resultados.next()) {
                encontrada
                        = new Frutas(resultados.getString("nombre"),
                        resultados.getString("descripcion"),
                        resultados.getFloat("precio"),
                        resultados.getInt("pais"));
            }
            System.out.println("Encontrada: " + encontrada);
            return encontrada;
        }
        catch (SQLException ex) {
            System.err.print("SQLException: " + ex.getMessage());
            return null;
        }
    }

    /**
     * Modifica una fruta en la base de datos.
     *
     * @param stmt        una instancia del objeto Statement para ejecutar la consulta SQL.
     * @param id          el identificador de la fruta a modificar.
     * @param nombre      el nuevo nombre de la fruta.
     * @param descripcion la nueva descripción de la fruta.
     * @param precio      el nuevo precio de la fruta.
     * @param pais        el nuevo identificador del país de origen de la fruta.
     * @return true si la fruta se modificó correctamente, false en caso contrario.
     */
    public static boolean modificarFrutas(Statement  stmt, int id, String nombre, String descripcion, float precio,int pais) {
        try {
            String query = "UPDATE frutas.frutas " +
                    "SET nombre = '" + nombre + "', " +
                    "descripcion = '" + descripcion + "', " +
                    "precio = '" + precio + "', " +
                    "pais = " + pais + " " +
                    "WHERE id = '" + id + "'";

            int filasModificadas = stmt.executeUpdate(query);
            System.out.println("Filas modificadas: " + filasModificadas);
            boolean resultado = false;
            resultado = filasModificadas > 0;
            System.out.println("Modificado: " + resultado);
            return resultado;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    /**
     * Borra la fruta que tiene el id indicado y devuelve true si lo consigue y false si no.
     * @param stmt una instancia del objeto Statement para ejecutar la consulta SQL.
     * @param id ID de la fruta
     * @return true si la fruta se borró correctamente, false en caso contrario.
     */
    public static boolean borrarFrutas(Statement stmt, int id){
        try{
            String query = "DELETE FROM frutas.frutas "
                    +"WHERE id='" + id + "'";

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

    /**
     * Te lista todas las frutas con sus datos y el pais al que pertenecen en ingles.
     * @param stmt una instancia del objeto Statement para ejecutar la consulta SQL.
     * @return true si la consulta fuincionó o false si no.
     */
    public static boolean datosFrutaIngles(Statement stmt) {
        try {
            String sql = "SELECT f.id, f.nombre, f.descripcion, f.precio, p.ingles FROM frutas f JOIN pais p ON f.pais = p.id";

            ResultSet resultados = stmt.executeQuery(sql);

            int filasLeidas = 0;

            while (resultados.next()) {
                System.out.println("Fruta: "
                        + resultados.getString("nombre") + ", "
                        + resultados.getString("descripcion") +
                        "\nPrecio: " + resultados.getFloat("precio") +
                        "\nPais: " + resultados.getString("ingles"));
                filasLeidas++;
            }
            System.out.println("Filas leídas: " + filasLeidas);
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    /**
     * Te enseña la media de todos los precios de las frutas
     * @param stmt una instancia del objeto Statement para ejecutar la consulta SQL.
     * @return true si la consulta fuincionó o false si no.
     */
    public static boolean mediaPrecioFrutas(Statement stmt) {
        try {
            String sql = "SELECT f.id, f.nombre, f.descripcion, f.precio, AVG(f.precio) AS media FROM frutas f JOIN pais p ON f.pais = p.id";

            ResultSet resultados = stmt.executeQuery(sql);
            System.out.println();

            int filasLeidas = 0;

            while (resultados.next()) {
                System.out.println("Media de todos los precios: "
                        + resultados.getFloat("media") + " €.");
                filasLeidas++;
            }
            System.out.println("Filas leídas: " + filasLeidas);
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
