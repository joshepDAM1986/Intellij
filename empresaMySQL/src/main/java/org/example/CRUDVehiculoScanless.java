package org.example;
import java.sql.*;

    public class CRUDVehiculoScanless {

        static public Statement conectar() {
            try {
                String url = "jdbc:mariadb://localhost:3306/empresa";
                Connection cn = DriverManager.getConnection(url,
                        "usr_empresa", "Empresa#23");
                Statement stmt = cn.createStatement();
                return stmt;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }

        /*
            public static boolean insertarVehiculoScanless(Statement stmt, String matricula, String fechMatriculacion, String tipoEnergia, String conductor) {
                boolean resultado = false;
                try {
                    String sql = "INSERT INTO empresa.vehiculo(matricula," +
                            "fechMatriculacion,TipoEnergia,conductor)" +
                            "VALUES ('" + matricula + "'," +
                            " '" + fechMatriculacion + "'," +
                            " '" + tipoEnergia + "'," +
                            " '" + conductor + "');";

                    System.out.println(sql);
                    int filasInsertadas = stmt.executeUpdate(sql);
                    System.out.println("Filas insertadas: " + filasInsertadas);
                    return filasInsertadas > 0;
                } catch (Exception e) {
                    System.out.println("Error!!!!: " + e.getMessage());
                    return false;
                }
            }

         */
        public static boolean insertarVehiculoScanless(Statement stmt, String matricula, String fechMatriculacion, String tipoEnergia, String conductor) {
            try {
                String query = "INSERT INTO empresa.vehiculo (matricula, fechMatriculacion, tipoEnergia, conductor) " +
                        "VALUES ('" + matricula + "', '" + fechMatriculacion + "', ";

                if (tipoEnergia == null) {
                    query += "NULL, ";
                } else {
                    query += "'" + tipoEnergia + "', ";
                }

                if (conductor == null) {
                    query += "NULL)";
                } else {
                    query += "'" + conductor + "')";
                }

                int filasInsertadas = stmt.executeUpdate(query);
                System.out.println("Filas insertadas: " + filasInsertadas);
                return filasInsertadas > 0;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }
        }

        public static Vehiculo consultarVehiculoScanless(Statement stmt, String matricula) {
            try {
                String query = "SELECT * FROM empresa.vehiculo WHERE matricula = '"
                        + matricula + "'";
                ResultSet resultados = stmt.executeQuery(query);
                Vehiculo encontrado = null;
                while (resultados.next()) {
                    encontrado
                            = new Vehiculo(resultados.getString("matricula"),
                            resultados.getString("fechMatriculacion"),
                            resultados.getString("tipoEnergia"),
                            resultados.getString("conductor"));
                }
                System.out.println("Encontrada: " + encontrado);
                return encontrado;
            } catch (SQLException ex) {
                System.err.print("SQLException: " + ex.getMessage());
                return null;
            }
        }
/*
    public static boolean modificarVehiculoScanless(Statement  stmt, int id, String matricula,
                                String fechMatriculacion, String tipoEnergia, String conductor) {
        try {
            String query = "UPDATE empresa.vehiculo " +
                    "SET matricula = '" + matricula + "', " +
                    "fechMatriculacion = '" + fechMatriculacion + "', " +
                    "tipoEnergia = '" + tipoEnergia + "', " +
                    "conductor = '" + conductor + "' " +
                    "WHERE id = " + id;

            int filasModificadas = stmt.executeUpdate(query);
            System.out.println("Filas modificadas: " + filasModificadas);
            return filasModificadas > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
*/
public static boolean modificarVehiculoScanless(Statement stmt, int id, String matricula, String fechMatriculacion, String tipoEnergia, String conductor) {
    try {
        String query = "UPDATE empresa.vehiculo " +
                "SET matricula = '" + matricula + "', " +
                "fechMatriculacion = '" + fechMatriculacion + "', ";

        if (tipoEnergia == null) {
            query += "tipoEnergia = NULL, ";
        } else {
            query += "tipoEnergia = '" + tipoEnergia + "', ";
        }

        if (conductor == null) {
            query += "conductor = NULL ";
        } else {
            query += "conductor = '" + conductor + "' ";
        }

        query += "WHERE id = " + id;

        int filasModificadas = stmt.executeUpdate(query);
        System.out.println("Filas modificadas: " + filasModificadas);
        return filasModificadas > 0;
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        return false;
    }
}
        public static boolean borrarVehiculoScanless(Statement stmt, String matricula) {
            try {
                String query = "DELETE FROM empresa.vehiculo "
                        + "WHERE matricula='" + matricula + "'";

                int filasBorradas = stmt.executeUpdate(query);
                System.out.println("Filas borradas: " + filasBorradas);
                return filasBorradas > 0;
            } catch (Exception e) {
                System.out.println("Error!!" + e.getMessage());
                return false;
            }
        }
    }


