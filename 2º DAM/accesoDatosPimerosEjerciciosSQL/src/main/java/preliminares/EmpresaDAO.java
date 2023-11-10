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
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //comprobar si existe
            String existe = "SELECT * FROM departamentos WHERE nombre = '" + nombre + "' AND localizacion = '" + localizacion + "'";
            resultSet = statement.executeQuery(existe);

            //si existe mostrar mensaje
            if (resultSet.next()) {
                System.out.println("Departamento existente, no se ha insertado.");
                return;
            }

            //crear consulta
            String insertSql = "INSERT INTO departamentos (nombre, localizacion) VALUES ('" + nombre + "', '" + localizacion + "')";

            //ejecutar consulta
            statement.executeUpdate(insertSql);

            //si se inserta mostrar mensaje
            System.out.println("Departamento insertado");
        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
    }


    public void ejercicio2(String nombre_dep) {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //comprobar si no existe
            String existe = "SELECT * FROM departamentos WHERE nombre = '" + nombre_dep + "'";
            resultSet = statement.executeQuery(existe);

            //si existe mostrar mensaje
            if (!resultSet.next()) {
                System.out.println("Departamento no existe.");
                return;
            }

            //crear consulta
            String deleteSql = "DELETE FROM departamentos WHERE nombre = '" + nombre_dep + "'";

            //ejecutar consulta
            statement.executeUpdate(deleteSql);

            //si se inserta mostrar mensaje
            System.out.println("Departamento borrado");
        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
    }

    public void ejercicio3(String apellido_emp) {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //comprobar si no existe
            String existe = "SELECT * FROM empleados WHERE apellido = '" + apellido_emp + "'";
            resultSet = statement.executeQuery(existe);

            //si existe mostrar mensaje
            if (!resultSet.next()) {
                System.out.println("Empleado no existe.");
                return;
            }

            //crear consulta
            String deleteSql = "DELETE FROM empleados WHERE apellido = '" + apellido_emp + "'";

            //ejecutar consulta
            statement.executeUpdate(deleteSql);

            //si se inserta mostrar mensaje
            System.out.println("Empleado borrado");
        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
    }

    public void ejercicio4(Double porcentaje) {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //crear consulta
            String updateSql = "UPDATE empleados SET salario = salario * (1 + " + porcentaje / 100 + ")";

            //ejecutar consulta
            statement.executeUpdate(updateSql);

            //si se inserta mostrar mensaje
            System.out.println("Saslario incrementado");
        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
    }

    public void ejercicio5(Double cantidad,String cargo) {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //crear consulta
            String updateSql = "UPDATE empleados SET salario = salario + '" + cantidad + "' WHERE cargo ='" + cargo + "'";

            //ejecutar consulta
            statement.executeUpdate(updateSql);

            //si se inserta mostrar mensaje
            System.out.println("Saslario incrementado");
        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
    }

    public String ejercicio6(Double limite) {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String resultado="";
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //crear consulta
            String selectSql = "SELECT apellido FROM empleados WHERE salario > '"+limite+"'";
            resultSet = statement.executeQuery(selectSql);
           while(resultSet.next()){
               resultado+= resultSet.getString(1)+"\n";          }
        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
        return resultado;
    }

    public String ejercicio7(Double limite,String cargo) {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String resultado="";
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //crear consulta
            String selectSql = "SELECT apellido FROM empleados WHERE salario > '" + limite + "' and cargo = '" + cargo + "'";
            resultSet = statement.executeQuery(selectSql);
            while(resultSet.next()){
                resultado+= resultSet.getString(1)+"\n";          }
        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
        return resultado;
    }

    public Double ejercicio8() {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Double resultado=0.0;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //crear consulta
            String selectSql = "SELECT SUM(salario) FROM empleados";
            resultSet = statement.executeQuery(selectSql);
            while(resultSet.next()){
                resultado+= resultSet.getDouble(1);          }
        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
        return resultado;
    }

    public String ejercicio9(Integer año) {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String resultado="";
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //crear consulta
            String selectSql = "SELECT apellido FROM empleados WHERE YEAR (fecha_alta) < " + año;
            resultSet = statement.executeQuery(selectSql);
            while(resultSet.next()){
                resultado+= resultSet.getString(1)+"\n";          }
        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
        return resultado;
    }

    public Double ejercicio10(String cargo) {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Double resultado=0.0;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //crear consulta
            String selectSql = "SELECT SUM(salario) FROM empleados WHERE cargo = '"+cargo+"'";
            resultSet = statement.executeQuery(selectSql);
            while(resultSet.next()){
                resultado+= resultSet.getDouble(1);          }
            //ejecutar consulta
        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
        return resultado;
    }

    public String ejercicio11() {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String resultado="";
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //crear consulta
            String selectSql = "SELECT DISTINCT cargo FROM empleados";
            resultSet = statement.executeQuery(selectSql);
            while(resultSet.next()){
                resultado+= resultSet.getString(1)+"\n";          }

        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
        return resultado;
    }

    public String ejercicio12() {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String resultado="";
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //crear consulta
            String selectSql = "SELECT DISTINCT cargo, sum(salario) FROM empleados GROUP BY cargo ORDER BY id";
            resultSet = statement.executeQuery(selectSql);
            while(resultSet.next()){
                resultado+= resultSet.getString(1)+":"+resultSet.getInt(2)+"\n"; }

        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
        return resultado;
    }

    public String ejercicio13() {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String resultado="";
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //crear consulta
            String selectSql = "SELECT apellido FROM empleados WHERE jefe IS NULL";
            resultSet = statement.executeQuery(selectSql);
            while(resultSet.next()){
                resultado+= resultSet.getString(1)+"\n";}

        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
        return resultado;
    }

    public  String ejercicio14() {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String resultado="";
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //crear consulta
            String selectSql = "SELECT apellido FROM empleados order by salario DESC LIMIT 1";
            resultSet = statement.executeQuery(selectSql);
            while(resultSet.next()){
                resultado+= resultSet.getString(1)+"\n";}

        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
        return resultado;
    }

    public  String ejercicio15() {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String resultado="";
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //crear consulta
            String selectSql = "SELECT apellido FROM empleados order by fecha_alta ASC LIMIT 1";
            resultSet = statement.executeQuery(selectSql);
            while(resultSet.next()){
                resultado+= resultSet.getString(1)+"\n";}

        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
        return resultado;
    }

    public  String ejercicio16(String apellido_emp) {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String departamento="";

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //crear consulta
            String selectSql = "SELECT d.nombre FROM departamentos d JOIN empleados e on d.id = e.departamento WHERE e.apellido = '"+apellido_emp+"'";

            //ejecutar consulta
            resultSet = statement.executeQuery(selectSql);
            // Verificar si hay alguna fila en el conjunto de resultados
            if (resultSet.next()) {
                departamento += resultSet.getString(1);
            }

        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
        return departamento;
    }

    public String ejercicio17(String nombre_dep) {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String apellido="";

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //crear consulta
            String selectSql = "SELECT e.apellido FROM empleados e JOIN departamentos d on d.id = e.departamento WHERE d.nombre = '"+nombre_dep+"'";

            //ejecutar consulta
            resultSet = statement.executeQuery(selectSql);
            // Verificar si hay alguna fila en el conjunto de resultados
            while(resultSet.next()) {
                apellido += resultSet.getString(1)+"\n";
            }

        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
        return apellido;
    }

    public String ejercicio18(String apellido_emp) {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String apellido="";

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //crear consulta
            String selectSql = "SELECT apellido FROM empleados WHERE jefe = (SELECT id FROM empleados WHERE apellido = '" + apellido_emp + "') AND departamento = (SELECT departamento FROM EMPLEADOS WHERE apellido = '" + apellido_emp + "')";

            //ejecutar consulta
            resultSet = statement.executeQuery(selectSql);
            // Verificar si hay alguna fila en el conjunto de resultados
            while(resultSet.next()) {
                apellido += resultSet.getString(1)+"\n";
            }

        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de sql");
        } finally {
            //cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
        return apellido;
    }

    public String ejercicio19() {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String resultado = "";
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //crear consulta
            String selectSql = "SELECT apellido FROM empleados WHERE id NOT IN (SELECT DISTINCT jefe FROM empleados WHERE jefe IS NOT NULL)";
            resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                resultado += resultSet.getString(1) + "\n";
            }

            // si se inserta mostrar mensaje
            System.out.println("Consulta ejecutada correctamente");
        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de SQL");
        } finally {
            // cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
        return resultado;
    }


    public String ejercicio20() {
        Connection conexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String resultado = "";
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
            statement = conexion.createStatement();

            //crear consulta
            String selectSql = "SELECT d.nombre, COALESCE(SUM(e.salario), 0) FROM departamentos d LEFT JOIN empleados e ON d.id = e.departamento GROUP BY d.nombre";
            resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                resultado += resultSet.getString(1)+":"+resultSet.getInt(2)+"\n";
            }

            // si se inserta mostrar mensaje
            System.out.println("Consulta ejecutada correctamente");
        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new RuntimeException("Error de SQL");
        } finally {
            // cerrar procesos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                throw new RuntimeException("Error al cerrar");
            }
        }
        return resultado;
    }
    public void ejercicio21(String apellido_emp,String cargo, Double salario,Double comision,String nombre_dep) {

    }

//    public void metodoPlantilla() {
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



