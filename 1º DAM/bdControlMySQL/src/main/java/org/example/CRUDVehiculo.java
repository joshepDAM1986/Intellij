package org.example;

import java.sql.*;
import java.util.Arrays;

public class CRUDVehiculo {

    /*
    ------------------------------------------------------------------------------
                                    VEHÍCULO
    ------------------------------------------------------------------------------
     */
    public static void insertarVehiculo() {
        try {
            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");
            Statement stmt = cn.createStatement();

            /*
            ----------------------------
            INSERTAR VEHÍCULOS DE 1 en 1
            ----------------------------

            String sql = "INSERT INTO empresa.vehiculo(id, matricula, fechaMatriculacion, conductor) " +
                    "VALUES (1, '123ABC', '2020-07-15', '11111111B');";

            int filasInsertadas = stmt.executeUpdate(sql);
            System.out.println("Filas insertadas: " + filasInsertadas);
            */

            String[] sqlQueries = {
                    "INSERT INTO empresa.vehiculo(matricula, fechaMatriculacion, conductor) " +
                    "VALUES ('123ABC', '2020-07-15', '12345678A');",
                    "INSERT INTO empresa.vehiculo(matricula, fechaMatriculacion, conductor) " +
                            "VALUES ('456DEF', '1999-04-27', '75884752A');",
                    "INSERT INTO empresa.vehiculo(matricula, fechaMatriculacion, conductor) " +
                            "VALUES ('321CBA', '2015-03-01', NULL);"
                    };

            int totalFilasInsertadas = 0;
            for (String sql : sqlQueries) {
                int filasInsertadas = stmt.executeUpdate(sql);
                totalFilasInsertadas += filasInsertadas;
            }

            System.out.println("Filas insertadas: " + totalFilasInsertadas);
            stmt.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error!!!! " + e.getMessage());
        }
    }


//    public static void insertarCoche() {
//        try {
//            String url = "jdbc:mariadb://localhost:3306/empresa";
//            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");
//            Statement stmt = cn.createStatement();
//
//            String sql = "INSERT INTO empresa.persona(dni, nombre, apellido1, apellido2, fechaNacimiento, numeroRegistroPersonal , fechaIncorporacion, puesto) " +
//                    "VALUES ('22222222B', 'Jaime', 'Molina', 'Granados', '2002-12-13', '123', '2020-11-15', 'Becario');";
//
//            int filasInsertadas = stmt.executeUpdate(sql);
//            System.out.println("Filas insertadas: " + filasInsertadas);
//            stmt.close();
//            cn.close();
//        } catch (Exception e) {
//            System.out.println("Error!!!! " + e.getMessage());
//        }
//    }


    public static void lecturaVehiculo(Connection cn) {
        try {
            Statement stmt = cn.createStatement();

            String sql = "SELECT * FROM vehiculo "
                    + "WHERE fechaMatriculacion='2020-07-15'";
            System.out.println(sql);

            ResultSet resultados = stmt.executeQuery(sql);
            System.out.println("Listado de vehículos matriculados el 2020-12-13");

            int nFilas = 0;

            while(resultados.next()) {
                System.out.println("Vehículo: "
                        + resultados.getInt("id")
                        + ", Matrícula: "
                        + resultados.getString("matricula"));
                nFilas++;
            }

            System.out.println("Filas leidas: " + nFilas);
        } catch(Exception e) {
            System.out.println("Error!!!! " + e.getMessage());
        }
    }


    public static void lecturaVehículoID(Connection cn, int id) {
        try {
            Statement stmt = cn.createStatement();

            String sql = "SELECT * FROM vehiculo WHERE id='" + id + "'";

            System.out.println(sql);

            ResultSet resultado = stmt.executeQuery(sql);
            int nFilas = 0;
            while(resultado.next()) {
                System.out.println("Matricula: " + resultado.getString("matricula") +
                        ", " + " fechaMatriculacion: " + resultado.getDate("fechaMatriculacion"));
                nFilas++;
            }
            System.out.println("\nFilas leídas: " + nFilas);
            stmt.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void modificarVehiculo(Connection cn, int id, String matricula, Date fechaMatriculacion, String dni) {
        try {
            Statement stmt = cn.createStatement();
            String sql = "UPDATE vehiculo SET matricula = '" + matricula + "'," +
                    " fechaMatriculacion='" + fechaMatriculacion + "'," +
                    " conductor='" + dni + "'" +
                    " WHERE id='" + id + "'";

            System.out.println(sql);

            int filasActualizadas = stmt.executeUpdate(sql);
            System.out.println("Filas modificadas: " + filasActualizadas);

            stmt.close();
        } catch(Exception e) {
            System.out.println("Error modificado: " + e.getMessage());
        }
    }


    public static void eliminarVehiculo(Connection cn, int id) {
        try {
            Statement stmt = cn.createStatement();
            String sql = "DELETE FROM vehiculo " + "WHERE id=" + id;
            System.out.println(sql);

            int filasEliminadas = stmt.executeUpdate(sql);
            System.out.println("Filas eliminadas: " + filasEliminadas);

            stmt.close();
        } catch(Exception e) {
            System.out.println("Error eliminando: " + e.getMessage());
        }
    }


    /*
    ------------------------------------------------------------------------------
                                    COCHE
    ------------------------------------------------------------------------------
     */

    public static void insertarCoche() {
        try {
            String url = "jdbc:mariadb://localhost:3306/empresa";
            Connection cn = DriverManager.getConnection(url, "usr_empresa", "Empresa#23");
            Statement stmt = cn.createStatement();

            String sql = "INSERT INTO empresa.coche(id, tipoEnergia) " +
                    "VALUES (2, 'Eléctrico');";

            int filasInsertadas = stmt.executeUpdate(sql);
            System.out.println("Filas insertadas: " + filasInsertadas);

            stmt.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error!!!! " + e.getMessage());
        }
    }
}