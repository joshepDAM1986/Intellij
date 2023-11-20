package ejercicio3;

import utilidades.BasesDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TiendaDAO {
    private String host;
    private String base_datos;
    private String usuario;
    private String password;


    public TiendaDAO(String host, String base_datos, String usuario, String password) {
        this.host = host;
        this.base_datos = base_datos;
        this.usuario = usuario;
        this.password = password;
    }

    public void añadirVenta(String cliente,String producto, Integer ventas){
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

    public String comprasCliente(String cliente){
        return null;
    }

    public Double recaudacionTotal(){
        return null;
    }


    public String porCategorias(){
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
        return null;
    }

    public String ultimaVenta(){
        return null;
    }

    public String masVendido(){
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
        return null;
    }

    public String sinVentas(){
        return null;
    }


    public void borrarProveedor(String nombre){
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





}
