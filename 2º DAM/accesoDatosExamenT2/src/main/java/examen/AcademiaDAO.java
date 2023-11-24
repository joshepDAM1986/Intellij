package examen;

import java.sql.*;

public class AcademiaDAO {
    private String host;
    private String base_datos;
    private String usuario;
    private String password;

    public AcademiaDAO(String host, String base_datos, String usuario, String password) {
        this.host = host;
        this.base_datos = base_datos;
        this.usuario = usuario;
        this.password = password;
    }
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

    //EJERCICIO 1
    public void evaluar(String alumno, String tareaDescripcion, String fechaEntrega, Double puntuacion) {
        try {
            conexion = establecerConexion();
            Integer idAlumno = devolverIdAlumnoDni(alumno, conexion);
            Integer idTarea = devolverIdTareaDescripcion(tareaDescripcion, conexion);

            if (idAlumno == null) {
                throw new RuntimeException("El alumno no existe");
            }

            if (idTarea == null) {
                throw new RuntimeException("La tarea no existe");
            } else {

                String insert = "INSERT INTO evaluacion " +
                        "VALUES (16,?, ?, ?, ?)";
                statement = conexion.prepareStatement(insert);
                statement.setInt(1, idAlumno);
                statement.setInt(2, idTarea);
                statement.setString(3, fechaEntrega);
                statement.setDouble(4, puntuacion);
                statement.executeUpdate();

            }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
    }

    //EJERCICIO 2
    public String mejorExpediente() {
        String resultado="";
            try {
                conexion = establecerConexion();
                String select =
                        "SELECT a.nombre as alumnoNombre, AVG(e.puntuacion) " +
                                "FROM alumnos a JOIN evaluacion e " +
                                "ON a.id=e.alumno_id " +
                                "GROUP BY a.nombre " +
                                "ORDER BY e.puntuacion DESC " +
                                "LIMIT 1";
                statement = conexion.prepareStatement(select);
                resultSet = statement.executeQuery();
                if(resultSet.next()){
                    resultado+=resultSet.getString("alumnoNombre");
                }
            } catch (SQLException exception) {
                System.out.println("Error de SQL\n" + exception.getMessage());
                exception.printStackTrace();
            } finally {
                cerrarConexion(conexion, statement, resultSet);
            }
            return resultado;
        }

    //EJERCICIO 3
    public void borrarTareas(Integer mes,Integer año) {
    }

    //EJERCICIO 4
    public String alumnosVagos() {
        String resultado="";
        try {
            conexion = establecerConexion();
            String select =
                    "SELECT a.nombre " +
                            "FROM alumnos a " +
                            "LEFT JOIN evaluacion e " +
                            "ON a.id=e.alumno_id " +
                            "LEFT JOIN tareas t " +
                            "ON e.tarea_id=t.id " +
                            "WHERE e.alumno_id IS NULL;";
            statement = conexion.prepareStatement(select);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                resultado+=resultSet.getString(1);
            }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return resultado;
    }

    //EJERCICIO 5
    public void borrarSinUtilizar() {
        try {
            conexion = establecerConexion();
            String deleteSql="DELETE a FROM asignaturas a " +
                    "LEFT JOIN tareas t " +
                    "ON a.id=t.asignatura_id " +
                    "WHERE t.asignatura_id " +
                    "IS NULL";
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

    //EJERCICIO 6
    public Double peorTarea(String tarea) {
        return null;
    }


    //EJERCICIO 7
    public String resumenAsignaturas() {
        return null;
    }

    //plantillas crear y cerrar conexion consultas preparadas
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

    private Integer devolverIdAlumnoDni(String nombre, Connection conexion) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer id = null;
        String existe = "SELECT id FROM alumnos WHERE nombre=?";
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

    private Integer devolverIdTareaDescripcion(String descripcion, Connection conexion) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer id = null;
        String existe = "SELECT id FROM tareas WHERE descripcion=?";
        try {
            statement = conexion.prepareStatement(existe);
            statement.setString(1, descripcion);
            resultSet = statement.executeQuery();
            if (resultSet.next()) id = resultSet.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}