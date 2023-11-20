package ejercicio1;

import java.sql.*;

public class HoldingDAO {
    private String host;
    private String base_datos;
    private String usuario;
    private String password;

    public HoldingDAO(String host, String base_datos, String usuario, String password) {
        this.host = host;
        this.base_datos = base_datos;
        this.usuario = usuario;
        this.password = password;
    }

    public void agregarEmpleado(String nombre, String apellidos, String fecha_nacimiento, String categoria, String email, String contratacion, Double salario, String empresa) {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conexion = establecerConexion();
            Integer id_empresa = devolverIdEmpresaNombre(empresa, conexion);

            if (id_empresa != null) {
                String existe = "SELECT email " +
                        "FROM empleados WHERE email=?";
                statement = conexion.prepareStatement(existe);
                statement.setString(1, email);
                resultSet = statement.executeQuery();

                if (!resultSet.next()) {
                    String insert = "INSERT INTO empleados " +
                            "VALUES (NULL,?, ?, ?, ?, ?, ?, ?, ?)";
                    statement = conexion.prepareStatement(insert);
                    statement.setString(1, fecha_nacimiento);
                    statement.setString(2, categoria);
                    statement.setString(3, email);
                    statement.setString(4, nombre);
                    statement.setString(5, apellidos);
                    statement.setString(6, contratacion);
                    statement.setDouble(7, salario);
                    statement.setInt(8, id_empresa);

                    int filasAfectadas = statement.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Empleado insertado exitosamente");
                    }
                }else{
                    System.out.println("Empleado ya existe");
                }
            }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
    }

    public void subirSueldo(String empresa, Double subida) {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            conexion = establecerConexion();
            Integer id_empresa = devolverIdEmpresaNombre(empresa, conexion);

            if (id_empresa != null) {

                    String updateSql = "UPDATE empleados " +
                            "SET salario = salario + ? " +
                            "WHERE empresa_id= ?";
                    statement = conexion.prepareStatement(updateSql);
                    statement.setDouble(1, subida);
                    statement.setInt(2,id_empresa);

                    int filasAfectadas = statement.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Sueldo incrementado");
                    }else{
                        System.out.println("No se pudo subir el sueldo");
                }
            }else{
                System.out.println("No se encuentra la empresa");
            }

        }catch (SQLException exception) {
                System.out.println("Error de SQL\n" + exception.getMessage());
                exception.printStackTrace();
            } finally {
                cerrarConexion(conexion, statement, resultSet);
            }
        }

    public void trasladarEmpleado(String emplead, String empresa) {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            conexion = establecerConexion();
            Integer id_empresa = devolverIdEmpresaNombre(empresa, conexion);

            if (id_empresa != null) {
                String updateSql = "UPDATE empleados " +
                        "SET empresa_id =? " +
                        "WHERE nombre=?";
                statement = conexion.prepareStatement(updateSql);
                statement.setInt(1, id_empresa);
                statement.setString(2,emplead);

                int filasAfectadas = statement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Empleado trasladado");
                }else{
                    System.out.println("No se pudo trasladar al empleado");
                }
            }else{
                System.out.println("No se encuentra la empresa");
            }

        }catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
    }

    public String empleadosEmpresa(String empresa) {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String resultado="";
        try {
            conexion = establecerConexion();
            Integer id_empresa = devolverIdEmpresaNombre(empresa, conexion);

            if (id_empresa != null) {
                String selectSql = "SELECT nombre " +
                        "FROM empleados " +
                        "WHERE empresa_id= ? ";
                statement = conexion.prepareStatement(selectSql);
                statement.setInt(1, id_empresa);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    resultado += resultSet.getString(1) + "\n";
                }
            }else{
                System.out.println("No se encuentra la empresa");
            }

        }catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return resultado;
    }

    public void crearCoche(String modelo, String fabricante, Double cc, Integer año, String empleado) {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conexion = establecerConexion();
            Integer id_empleado = devolverIdEmpleadoNombre(empleado, conexion);

            if (id_empleado != null) {
                    String insert = "INSERT INTO coches (cc, fabricante, modelo, año_lanzamiento, empleado_id)" +
                            "VALUES (?, ?, ?, ?, ?)";
                    statement = conexion.prepareStatement(insert);
                    statement.setDouble(1, cc);
                    statement.setString(2, fabricante);
                    statement.setString(3, modelo);
                    statement.setInt(4, año);
                    statement.setInt(5, id_empleado);

                    int filasAfectadas = statement.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Coche insertado exitosamente");
                    }else{
                        System.out.println("No pudo insertarse el coche");
                    }
                }else{
                    System.out.println("Empleado no existe");
                }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
    }

    public Double costeProyecto(String proyecto) {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Double resultado=0.0;
        try {
            conexion = establecerConexion();
            Integer id_proyecto = devolverIdProyectoNombre(proyecto, conexion);
            if (id_proyecto != null) {
                String selectSql = "SELECT e.salario " +
                        "FROM empleados e " +
                        "JOIN empleados_proyectos ep " +
                        "ON e.id = ep.empleado_id " +
                        "WHERE ep.proyecto_id = ?";
                statement = conexion.prepareStatement(selectSql);
                statement.setInt(1, id_proyecto);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    resultado += resultSet.getDouble(1);
                }
            }else{
                System.out.println("No se encuentra el proyecto");
            }
        }catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return resultado;
    }

    public String resumenProyectos() {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder resultado= new StringBuilder();
        try {
            conexion = establecerConexion();
                String selectSql = "SELECT p.titulo AS proyecto, e.nombre, " +
                        "COALESCE(e.salario,0), " +
                        "SUM(e.salario) " +
                        "FROM proyectos p " +
                        "LEFT JOIN empleados_proyectos ep " +
                        "ON p.id = ep.proyecto_id " +
                        "LEFT JOIN empleados e " +
                        "ON e.id=ep.empleado_id " +
                        "GROUP BY e.nombre " +
                        "ORDER BY p.titulo, e.nombre";
                statement = conexion.prepareStatement(selectSql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String proyecto = resultSet.getString("proyecto");
                    resultado.append(resultSet.getString(1)).append(" ").append(resultSet.getString(2)).append(" ").append((costeProyecto(proyecto))).append("\n");
                }
        }catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return resultado.toString();
    }

    public Integer empleadosSinCoche() {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int resultado=0;
        try {
            conexion = establecerConexion();
            String selectSql = "SELECT COUNT(e.id) " +
                    "FROM empleados e " +
                    "LEFT JOIN coches c " +
                    "ON e.id=c.empleado_id " +
                    "WHERE empleado_id is NULL";
            statement = conexion.prepareStatement(selectSql);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                resultado +=+resultSet.getInt(1);
            }
        }catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return resultado;
    }

    public void BorrarProyectosSinEmp() {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            conexion = establecerConexion();
//                String selectSql = "SELECT p.nombre " +
//                        "FROM proyectos p " +
//                        "LEFT JOIN empleados_proyectos ep " +
//                        "ON p.id=ep.proyecto_id " +
//                        "WHERE empleado_id is NULL";
//                statement = conexion.prepareStatement(selectSql);
//                resultSet = statement.executeQuery();
//
//                while(resultSet.next()){
//                    int proyectoId = resultSet.getInt("id");
//
//                    String deleteSql="DELETE FROM proyectos WHERE id=?";
//                    statement = conexion.prepareStatement(deleteSql);
//                    statement.setInt(1, proyectoId);
//                    statement.executeUpdate();
//                }
            String deleteSql="DELETE p " +
                    "FROM proyectos p " +
                    "LEFT JOIN empleados_proyectos ep " +
                    "ON p.id=ep.proyecto_id " +
                    "LEFT JOIN empleados e " +
                    "ON ep.empleado_id=e.id " +
                    "WHERE e.nombre IS NULL";
            statement = conexion.prepareStatement(deleteSql);
            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Cambios realizados");
            }else{
                System.out.println("No pudieron realizarse cambios");
            }

        }catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
    }

    public void BorrarAño(Integer año) {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int filasAfectadasTotal=0;

        try {
            conexion = establecerConexion();

            String selectSql = "SELECT ep.empleado_id " +
                    "FROM empleados_proyectos ep " +
                    "JOIN empleados e " +
                    "ON ep.empleado_id=e.id " +
                    "JOIN proyectos p " +
                    "ON p.id=ep.proyecto_id " +
                    "WHERE YEAR(p.comienzo)=?";
            statement = conexion.prepareStatement(selectSql);
            statement.setInt(1,año);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int empleadosProyectosId = resultSet.getInt("empleado_id");

                String deleteSql = "DELETE FROM empleados_proyectos " +
                        "WHERE empleado_id=?";
                statement = conexion.prepareStatement(deleteSql);
                statement.setInt(1, empleadosProyectosId);
                int filasAfectadas1 = statement.executeUpdate();

                String deleteSql2 = "DELETE FROM proyectos " +
                        "WHERE YEAR(comienzo)=?";
                statement = conexion.prepareStatement(deleteSql2);
                statement.setInt(1, año);
                int filasAfectadas2 = statement.executeUpdate();

                filasAfectadasTotal += filasAfectadas1 + filasAfectadas2;
            }

            if (filasAfectadasTotal > 0) {
                System.out.println("Cambios hechos");
            } else {
                System.out.println("No se pudieron realizar cambios");
            }
        }catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
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

    private Integer devolverIdEmpresaNombre(String nombre, Connection conexion) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer id = null;
        String existe = "SELECT id FROM empresas WHERE razon_social=?";
        try {
            statement = conexion.prepareStatement(existe);
            statement.setString(1, nombre);
            resultSet = statement.executeQuery();
            if (resultSet.next()) id = resultSet.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    private Integer devolverIdEmpleadoNombre(String nombre, Connection conexion) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer id = null;
        String existe = "SELECT id FROM empleados WHERE nombre=?";
        try {
            statement = conexion.prepareStatement(existe);
            statement.setString(1, nombre);
            resultSet = statement.executeQuery();
            if (resultSet.next()) id = resultSet.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
        }

    private Integer devolverIdProyectoNombre(String titulo, Connection conexion) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer id = null;
        String existe = "SELECT id FROM proyectos WHERE titulo=?";
        try {
            statement = conexion.prepareStatement(existe);
            statement.setString(1, titulo);
            resultSet = statement.executeQuery();
            if (resultSet.next()) id = resultSet.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}
