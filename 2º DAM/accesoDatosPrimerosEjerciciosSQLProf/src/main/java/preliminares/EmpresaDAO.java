package preliminares;

import java.sql.*;
import java.time.LocalDate;

public class EmpresaDAO {
    private String host;
    private String base_datos;
    private String usuario;
    private String password;


    public EmpresaDAO(String host, String base_datos, String usuario, String password) {
        this.host = host;
        this.base_datos = base_datos;
        this.usuario = usuario;
        this.password = password;
    }


    public void ejercicio1(String nombre, String localizacion) {

    }

    public void ejercicio2(String nombre_dep) {

    }

    public void ejercicio3(String apellido_emp) {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            conexion = establecerConexion();
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
//            String query="SELECT a.apellido" +
//                         "FROM empleados a " +
//                         "INNER JOIN empleados b ON a.id = b.jefe " +
//                         "WHERE a.apellido='"+apellido_emp+"'";
//            resultado = sentencia.executeQuery(query);
//            System.out.println(query);
            String query = "SELECT a.apellido " +
                    "FROM empleados a " +
                    "INNER JOIN empleados b ON a.id = b.jefe " +
                    "WHERE a.apellido=?";
            sentencia = conexion.prepareStatement(query);
            sentencia.setString(1, apellido_emp);
            System.out.println(sentencia.toString());
            resultado = sentencia.executeQuery();


            if (!resultado.next()) {
                String sql_delete = "DELETE FROM empleados " +
                        "WHERE apellido = '" + apellido_emp + "'";
                sentencia.executeUpdate(sql_delete);
                System.out.println("Empleado borrado");
            } else {
                System.out.println("No se puede borrar un jefe");
            }


        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, sentencia, resultado);
        }
    }

    public void ejercicio4(Double porcentaje) {

    }

    public void ejercicio5(Double cantidad, String cargo) {

    }

    public String ejercicio6(Double limite) {
        return null;
    }

    public String ejercicio7(Double limite, String cargo) {
        return null;
    }

    public Double ejercicio8() {
        return null;
    }

    public String ejercicio9(Integer año) {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String res = "";
        try {
            conexion = establecerConexion();
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql_select =
                    "SELECT apellido " +
                            "FROM empleados " +
                            "WHERE YEAR(fecha_alta) < " + año;

            sentencia = conexion.prepareStatement(sql_select);
            resultado = sentencia.executeQuery();

            while (resultado.next()) {
                res += resultado.getString(1) + "\n";
            }

        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, sentencia, resultado);
        }

        return res;
    }

    public Double ejercicio10(String cargo) {
        return null;
    }

    public String ejercicio11() {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            conexion = establecerConexion();
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql = "";
            sentencia = conexion.prepareStatement(sql);
            resultado = sentencia.executeQuery();

        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, sentencia, resultado);
        }
        return null;
    }

    public String ejercicio12() {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            conexion = establecerConexion();
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql = "";
            sentencia = conexion.prepareStatement(sql);
            resultado = sentencia.executeQuery();

        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, sentencia, resultado);
        }
        return null;
    }

    public String ejercicio13() {
        return null;
    }

    public String ejercicio14() {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String res = "";
        try {
            conexion = establecerConexion();
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql = "";


            String sql_select =
                    "SELECT apellido " +
                            "FROM empleados " +
                            "ORDER BY salario DESC LIMIT 1";

            sentencia = conexion.prepareStatement(sql_select);
            resultado = sentencia.executeQuery();

            if (resultado.next()) {
                res += resultado.getString(1) + "\n";
            }


        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, sentencia, resultado);
        }
        return res;
    }

    public String ejercicio15() {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            conexion = establecerConexion();
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql = "";

            sentencia = conexion.prepareStatement(sql);
            resultado = sentencia.executeQuery();

        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, sentencia, resultado);
        }
        return null;
    }

    public String ejercicio16(String apellido_emp) {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String res = "";
        try {
            conexion = establecerConexion();
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql = "SELECT d.nombre " +
                    "FROM departamentos d " +
                    "JOIN empleados e ON d.id=e.departamento " +
                    "WHERE e.apellido=?";
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, apellido_emp);
            resultado = sentencia.executeQuery();
            //PROCESAR EL RESULTADO

            if (resultado.next()) {
                res = resultado.getString(1) + "\n";
            } else {
                System.out.println("No existe ese empleado");
            }


        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, sentencia, resultado);
        }
        return res;
    }

    public String ejercicio17(String nombre_dep) {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String res = "";
        try {
            conexion = establecerConexion();
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql = "SELECT e.apellido " +
                    "FROM empleados e " +
                    "JOIN departamentos d ON e.departamento=d.id " +
                    "WHERE d.nombre=?";
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,nombre_dep);

            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                res += resultado.getString(1) + "\n";
            }

        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, sentencia, resultado);
        }
        return res;
    }

    public String ejercicio18(String apellido_emp) {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String res = "";
        try {
            conexion = establecerConexion();
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql="SELECT s.apellido\n" +
                    "FROM EMPLEADOS j\n" +
                    "JOIN EMPLEADOS s ON j.id = s.jefe\n" +
                    "WHERE j.apellido=?";
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,apellido_emp);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                res += resultado.getString(1) + "\n";
            }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, sentencia, resultado);
        }
        return res;
    }

    public String ejercicio19() {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String res = "";
        try {
            conexion = establecerConexion();
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql = "SELECT E.apellido " +
                    "FROM empleados E " +
                    "LEFT JOIN empleados S ON E.id = S.jefe " +
                    "WHERE S.jefe IS NULL";
            sentencia = conexion.prepareStatement(sql);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                res += resultado.getString(1) + "\n";
            }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, sentencia, resultado);
        }
        return res;
    }


    public String ejercicio20() {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String res = "";
        try {
            conexion = establecerConexion();
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql = "SELECT d.nombre,COALESCE(sum(e.salario),0) as total_dep " +
                    "FROM departamentos d " +
                    "LEFT JOIN empleados e ON d.id=e.departamento " +
                    "GROUP BY d.id";
            sentencia = conexion.prepareStatement(sql);
            System.out.println(sentencia.toString());
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                res += resultado.getString(1) + ":" +
                        resultado.getDouble(2) + "\n";
            }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, sentencia, resultado);
        }
        return res;
    }

    public void ejercicio21(String apellido_emp, String cargo, Double salario, Double comision, String nombre_dep) {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            conexion = establecerConexion();
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql = "SELECT id " +
                    "FROM departamentos " +
                    "WHERE nombre=?";
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, nombre_dep);
            resultado = sentencia.executeQuery();

            if (!resultado.next()) {
                throw new RuntimeException("No existe el departamento");
            }
            String sql_insert = "INSERT INTO EMPLEADOS " +
                    "VALUES (NULL,?,?,NULL,?,?,?,?)";
            sentencia = conexion.prepareStatement(sql_insert);
            sentencia.setString(1, apellido_emp);
            sentencia.setString(2, cargo);
            sentencia.setDate(3, Date.valueOf(LocalDate.now()));
            sentencia.setDouble(4, salario);
            sentencia.setDouble(5, comision);
            sentencia.setInt(6, resultado.getInt(1));

            sentencia.executeUpdate();
            System.out.println("Insertado trabajador con éxito");
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, sentencia, resultado);
        }
    }

    public Connection establecerConexion() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://" + this.host + "/" + this.base_datos, this.usuario, this.password);
    }

    public void cerrarConexion(Connection conexion, PreparedStatement sentencia, ResultSet resultado) {
        try {
            if (resultado != null) resultado.close();

            if (sentencia != null) sentencia.close();

            if (conexion != null) conexion.close();

        } catch (SQLException exception) {
            System.out.println("Error al cerrar la conexión\n" + exception.getMessage());
            exception.printStackTrace();
        }
    }

    public void metodoPlantilla() {
//                Connection conexion = null;
//                Statement statement = null;
//                ResultSet resultSet = null;
//
//                try {
//                    Connection conexion = DriverManager.getConnection("jdbc:mysql://" + this.host + "/" + this.base_datos,
//                            this.usuario, //usuario de la BD
//                            this.password); //contraseña
//
//

//
//            String sql_select = "SELECT * FROM empleados "
//                    + "WHERE ocupacion ='" + cargo + "'AND fecha_alta='" + fecha + "'";
//            Statement sentencia_select = conexion.createStatement();
//
//            ResultSet resul = sentencia_select.executeQuery(sql_select);
//
//            while (resul.next()) {
//
//            }
//            resul.close(); //Cerrar ResultSet
//            sentencia_select.close(); // Cerrar Statement
//            conexion.close(); // Cerrar conexión
//
//            String sql_insert = "INSERT INTO departamentos VALUES ('" + nombre + "', '" + localizacion + "')";
//            System.out.println(sql_insert);
//            Statement sentencia_insert = conexion.createStatement();
//            filas = sentencia_insert.executeUpdate(sql_insert);
//            System.out.println("Filas afectadas: " + filas);
//            sentencia_insert.close(); // Cerrar Statement
//            conexion.close(); // Cerrar conexion
//
//            resul.close(); //Cerrar ResultSet
//            sentencia_prepa_select.close(); // Cerrar Statement
//            conexion.close(); // Cerrar conexión
//        } catch (SQLException exception) {
//            System.out.println("Error de SQL\n"+exception.getMessage());
//            exception.printStackTrace();
//        } finally {
//            if (resultSet != null) resultSet.close();
//            if (statement != null) statement.close();
//            if (conexion != null) conexion.close();
//        }
    }


}
