package ejercicio1;

import utilidades.BasesDatos;

import java.sql.*;
import java.time.LocalDate;

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

    public void agregarEmpleado(String nombre,String apellidos,String fecha_nacimiento,String categoria,String email,String contratacion,Double salario,String empresa){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            conexion = BasesDatos.establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql="SELECT id FROM empleados WHERE nombre=?";
            sentencia=conexion.prepareStatement(sql);
            sentencia.setString(1,nombre);
            resultado=sentencia.executeQuery();
            if(resultado.next()){
                throw new RuntimeException("El empleado ya existe");
            }

            sql="SELECT id FROM empresas WHERE razon_social=?";
            sentencia= conexion.prepareStatement(sql);
            sentencia.setString(1,empresa);
            resultado=sentencia.executeQuery();
            if(!resultado.next()){
                throw new RuntimeException("La empresa no existe");
            }
            int id_empresa=resultado.getInt(1);

            String sql_insert="INSERT INTO empleados " +
                    "VALUES (NULL,?,?,?,?,?,?,?,?)";
            sentencia=conexion.prepareStatement(sql_insert);
            sentencia.setString(1,fecha_nacimiento);
            sentencia.setString(2,categoria);
            sentencia.setString(3,email);
            sentencia.setString(4,nombre);
            sentencia.setString(5,apellidos);
            sentencia.setString(6,contratacion);
            sentencia.setDouble(7,salario);
            sentencia.setInt(8,id_empresa);
            System.out.println(sentencia.toString());
            int filas=sentencia.executeUpdate();
            if(filas==1){
                System.out.println("Empleado creado correctamente");
            }else{
                System.out.println("No se ha podido introducir la información");
            }

        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            BasesDatos.cerrarConexion(conexion, sentencia, resultado);
        }
    }

    public void subirSueldo(String empresa,Double subida){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            conexion = BasesDatos.establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            // Realizar operaciones con la base de datos usando la conexión y la sentencia


        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            BasesDatos.cerrarConexion(conexion, sentencia, resultado);
        }
    }

    public void trasladarEmpleado(String emplead,String empresa){

    }

    public String empleadosEmpresa(String empresa){
        return null;
    }

    public void crearCoche(String modelo,String fabricante,Double cc,String lanzamiento,Integer año,String empleado){

    }

    public Double costeProyecto(String proyecto){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            conexion = BasesDatos.establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql="SELECT sum(e.salario) FROM proyectos p " +
                       "JOIN empleados_proyectos ep ON p.id=ep.proyecto_id "+
                       "JOIN empleados e ON ep.empleado_id=e.id "+
                       "WHERE p.titulo=?";
            sentencia=conexion.prepareStatement(sql);
            sentencia.setString(1,proyecto);
            resultado=sentencia.executeQuery();
            resultado.next();
            return resultado.getDouble(1);


        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            BasesDatos.cerrarConexion(conexion, sentencia, resultado);
        }
        return null;
    }

    private String empleadosProyecto(String proyecto){
        Connection conexion=null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String salida="";
        try {
            conexion = BasesDatos.establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql="SELECT e.nombre,e.apellidos FROM proyectos p " +
                       "JOIN empleados_proyectos ep ON p.id=ep.proyecto_id "+
                       "JOIN empleados e ON ep.empleado_id=e.id "+
                       "WHERE p.titulo=?";
            sentencia=conexion.prepareStatement(sql);
            sentencia.setString(1,proyecto);
            resultado=sentencia.executeQuery();

            while(resultado.next()){
                salida+=resultado.getString(1)+" "+
                       resultado.getString(2)+"\n";
            }


        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            BasesDatos.cerrarConexion(conexion,sentencia,resultado);
        }
        return salida;
    }

    public String resumenProyectos(){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String salida="";
        try {
            conexion = BasesDatos.establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            // Realizar operaciones con la base de datos usando la conexión y la sentencia

            String sql="SELECT * FROM proyectos";
            sentencia=conexion.prepareStatement(sql);
            resultado=sentencia.executeQuery();

            while(resultado.next()){
                String titulo=resultado.getString("titulo");
                salida+=titulo+"\n"+
                        "Fecha:"+resultado.getString("comienzo")+"\n"+
                        empleadosProyecto(titulo)+
                        "Coste:"+costeProyecto(titulo)+"\n"+
                        "======================\n";
            }




        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            BasesDatos.cerrarConexion(conexion, sentencia, resultado);
        }
        return salida;
    }

    public Integer empleadosSinCoche(){
        return null;
    }

    public void BorrarProyectosSinEmp(){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            conexion = BasesDatos.establecerConexion(this.host,this.base_datos,this.usuario,this.password);

//            String sql="SELECT id FROM proyectos " +
//                    "LEFT JOIN empleados_proyectos " +
//                    "ON proyectos.id = empleados_proyectos.proyecto_id " +
//                    "WHERE empleados_proyectos.proyecto_id IS NULL";



            String sql="DELETE proyectos FROM proyectos " +
                       "LEFT JOIN empleados_proyectos " +
                       "ON proyectos.id = empleados_proyectos.proyecto_id " +
                       "WHERE empleados_proyectos.proyecto_id IS NULL";

            sentencia = conexion.prepareStatement(sql);

            sentencia.executeUpdate();


        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            BasesDatos.cerrarConexion(conexion, sentencia, resultado);
        }
    }


    private void borrarProyecto(Integer id){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            conexion = BasesDatos.establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            String sql="DELETE FROM proyectos " +
                    "WHERE proyectos.id=?";
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1,id);
            sentencia.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            BasesDatos.cerrarConexion(conexion, sentencia, resultado);
        }
    }

    private void borrarEmpleadosProyecto(Integer id){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            conexion = BasesDatos.establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            String sql="DELETE FROM empleados_proyectos " +
                       "WHERE empleados_proyectos.proyecto_id=?";
            sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1,id);
            sentencia.executeUpdate();




        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            BasesDatos.cerrarConexion(conexion, sentencia, resultado);
        }
    }

    public void BorrarAño(Integer año){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            conexion = BasesDatos.establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            String sql="SELECT id FROM proyectos p WHERE YEAR(p.comienzo)=?";
                        sentencia=conexion.prepareStatement(sql);
            sentencia.setInt(1,año);
            System.out.println(sentencia.toString());

            resultado=sentencia.executeQuery();

            while(resultado.next()){
                Integer id_proyecto=resultado.getInt(1);
                borrarEmpleadosProyecto(id_proyecto);
                borrarProyecto(id_proyecto);
            }

        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            BasesDatos.cerrarConexion(conexion, sentencia, resultado);
        }
    }

}
