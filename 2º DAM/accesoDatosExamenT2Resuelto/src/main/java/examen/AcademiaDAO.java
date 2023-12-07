package examen;

import java.sql.*;

public class AcademiaDAO {
    private String host;
    private String base_datos;
    private String usuario;
    private String password;
    private Connection connection = null;
    private PreparedStatement stmt = null;
    private ResultSet res = null;


    public AcademiaDAO(String host, String base_datos, String usuario, String password) {
        this.host = host;
        this.base_datos = base_datos;
        this.usuario = usuario;
        this.password = password;
    }

    //EJERCICIO 1 Completar el método evaluar que recibe el nombre de un alumno, nombre de una tarea, fecha de realización y una puntuación, inserta una nueva evaluación en la tabla. Hay que comprobar que el alumno y la tarea existen en la base de datos lanzando una RuntimeException en caso contrario. Suponemos que no se intenta evaluar a un alumno la misma tarea 2 veces por lo que no es necesario comprobarlo.
    public void evaluar(String alumno,String tarea,String fecha_entrega,Double puntuaacion) {
        try {
            connection = establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            String select ="SELECT id from alumnos WHERE nombre = ?";
            stmt = connection.prepareStatement(select);
            stmt.setString(1,alumno);
            res = stmt.executeQuery();
            if (res.next()){
                int idAlumno = res.getInt(1);
                String select2 ="SELECT id from tareas WHERE descripcion = ?";
                stmt = connection.prepareStatement(select2);
                stmt.setString(1,tarea);
                res = stmt.executeQuery();
                if (res.next()){
                    int idTarea = res.getInt(1);
                    String insert = "INSERT INTO evaluacion VALUES(?,?,?,?,?)";
                    stmt = connection.prepareStatement(insert);
                    stmt.setInt(1,16);
                    stmt.setInt(2,idAlumno);
                    stmt.setInt(3,idTarea);
                    stmt.setString(4,fecha_entrega);
                    stmt.setDouble(5,puntuaacion);
                    int fila = stmt.executeUpdate();
                    System.out.println("Filas insertadas:"+fila);

                }else {
                    throw new RuntimeException("La tarea no existe");
                }
            }else {
                throw new RuntimeException("El alumno no existe");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            cerrarConexion(connection,stmt,res);
        }
    }

    //EJERCICIO 2 Completar el método mejorExpediente que devuelve el nombre del alumno con mejor expediente atendiendo a la media de sus tareas evaluadas. Suponemos que al menos hay un alumno en la base de datos. Hay que completar testMejor donde el resultado esperado según los datos en este caso es Carlos Ruiz.
    public String mejorExpediente() {
        String resultado ="";
        try {
            connection = establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            String select ="SELECT a.nombre FROM alumnos a JOIN evaluacion e ON e.alumno_id = a.id GROUP BY a.nombre ORDER BY e.puntuacion DESC LIMIT 1";
            stmt = connection.prepareStatement(select);
            res = stmt.executeQuery();
            if (res.next()){
                resultado = res.getString(1);
            }else {
                resultado ="No se han encontrado resultados";
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            cerrarConexion(connection,stmt,res);
        }
        return resultado;
    }

    //EJERCICIO 3 Completar el método borrarTareas que a partir de un número entero que representa un año y otro que representa un mes borre todas la tareas con fecha de entrega en dicho año y mes, borrando previamente las evaluaciones realizadas asociadas a las mismas.
    public void borrarTareas(Integer mes,Integer año) {
        int numEva = 0;
        int numTar = 0;
        try {
            connection = establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            String selec = "SELECT t.id FROM tareas t WHERE YEAR(fecha_entrega)=? and Month(fecha_entrega) = ?";
            stmt = connection.prepareStatement(selec);
            stmt.setInt(1,año);
            stmt.setInt(2,mes);
            res = stmt.executeQuery();
            while (res.next()){
                int idTarea = res.getInt(1);
                String delete = "DELETE  FROM evaluacion  WHERE tarea_id=?";
                stmt = connection.prepareStatement(delete);
                stmt.setInt(1,idTarea);
                numEva += stmt.executeUpdate();
                String delete2 = "DELETE  FROM tareas  WHERE id=?";
                stmt = connection.prepareStatement(delete2);
                stmt.setInt(1,idTarea);
                numTar += stmt.executeUpdate();
            }
            System.out.println("Evaluaciones  borradas:"+numEva+"\n" +
                    "Tareas borradas:"+numTar);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            cerrarConexion(connection,stmt,res);
        }
    }
    //EJERCICIO 4 Completar el método alumnosVagos que devuelve el nombre de los alumnos que no han realizado ninguna tarea todavía. Hay que completar testVagos.
    public String alumnosVagos() {
        String resultado = "";
        try {
            connection = establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            String select ="SELECT a.nombre FROM alumnos a LEFT JOIN evaluacion e ON e.alumno_id = a.id WHERE e.id IS NULL";
            stmt = connection.prepareStatement(select);
            res=stmt.executeQuery();
            while (res.next()){
                resultado += res.getString(1)+"\n";
            }
            if (resultado.equals("")){
                resultado = "No hay alumnos vagos";
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            cerrarConexion(connection,stmt,res);
        }
        return resultado;
    }

    //EJERCICIO 5 Completar el método borrarSinUtilizar que borre las asignaturas que no tienen tareas asignadas.
    public void borrarSinUtilizar() {
        try {
            connection = establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            String delete = "DELETE a FROM asignaturas a LEFT JOIN tareas t ON t.asignatura_id = a.id WHERE t.id IS NULL";
            stmt = connection.prepareStatement(delete);
            int filas = stmt.executeUpdate();
            System.out.println("Filas borradas:"+filas);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            cerrarConexion(connection,stmt,res);
        }
    }

    //EJERCICIO 6 Completar el método peorTarea que dado el nombre de un tarea nos devuelve un Double con  la peor nota de dicha tarea entregada por un alumno. Podemos suponer que la tarea existe en la base de datos por lo que no es necesario comprobarlo. Hay que completar testPeor.
    public Double peorTarea(String tarea) {
        Double resultado = 0.0;
        ResultSet resSet = null;
        try {
            connection = establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            String select ="SELECT e.puntuacion FROM tareas t JOIN evaluacion e ON e.tarea_id = t.id WHERE t.descripcion = ? ORDER BY e.puntuacion LIMIT 1";
            stmt = connection.prepareStatement(select);
            stmt.setString(1,tarea);
            resSet = stmt.executeQuery();
            if (resSet.next()){
                resultado = resSet.getDouble(1);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            cerrarConexion(connection,stmt,resSet);
        }
        return resultado;
    }

    //EJERCICIO 7 Completar el método resumenAsignaturas que devuelve un String con el nombre de cada asignaturas con cada una de sus tareas y para cada tarea el nombre y la nota del alumno con peor nota en esa tarea. Lo que devuelve el metodo se debe ajustar al formato que aparece en el testResumen.
    public String resumenAsignaturas() {
        String resultado = "";
        try {
            connection = establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            String select ="SELECT nombre FROM asignaturas";
            stmt = connection.prepareStatement(select);
            res = stmt.executeQuery();
            while (res.next()){
                String asignaturaNombre = res.getString(1);
                resultado +="======================\n"+
                "ASIGNATURA:"+asignaturaNombre+"\n" +
                        "TAREAS:"+"\n" +
                        asignaturaTareas(asignaturaNombre);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            cerrarConexion(connection,stmt,res);
        }
        return resultado;
    }
    private String asignaturaTareas(String nombre){
        String resultado ="";
        ResultSet newRes = null;
        try {
            connection = establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            String select ="SELECT t.descripcion FROM asignaturas a JOIN tareas t ON t.asignatura_id = a.id WHERE a.nombre = ?";
            stmt = connection.prepareStatement(select);
            stmt.setString(1,nombre);
            newRes = stmt.executeQuery();
            while (newRes.next()){
                String tarea = newRes.getString(1);
                resultado += tarea+"-->"+peorTarea(tarea)+"\n";
            }
            if (resultado.equals("")){
                resultado = "Sin Tareas\n";
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            cerrarConexion(connection,stmt,newRes);
        }
        return resultado;
    }

    //plantillas crear y cerrar conexion consultas preparadas
    public static Connection establecerConexion(String host, String base_datos, String usuario, String password) throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://" + host + "/" + base_datos, usuario, password);
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

    public void metodoPlantilla() {

//        Connection conexion = null;
//        PreparedStatement sentencia = null;
//        ResultSet resultado = null;
//
//       //CONSULTAS PREPARADAS
//        //INSERT UPDATE DELETE
//        String sql_prepa_insert = "INSERT INTO departamentos VALUES (NULL,?, ?)";
//        PreparedStatement sentencia_prepa_insert = conexion.prepareStatement(sql_prepa_insert);
//        sentencia_prepa_insert.setString(1, nombre);
//        sentencia_prepa_insert.setString(2, localizacion);
//        filas = sentencia_prepa_insert.executeUpdate();
//        System.out.println("Filas afectadas: " + filas);

//
//        //SELECT
//        String sql_prepa_select = "SELECT * FROM empleados WHERE ocupacion =? AND fecha_alta=?";
//        PreparedStatement sentencia_prepa_select = conexion.prepareStatement(sql_prepa_select);
//        sentencia_prepa_select.setString(1, ocupacion);
//        sentencia_prepa_select.setString(2, fecha);
//        ResultSet resul_prepa = sentencia_prepa_select.executeQuery();
//        while (resul_prepa.next()) {
//
//        }
    }


}
