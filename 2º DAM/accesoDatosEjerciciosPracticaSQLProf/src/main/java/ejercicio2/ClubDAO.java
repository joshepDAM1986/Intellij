package ejercicio2;

import utilidades.BasesDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClubDAO {

    private String host;
    private String base_datos;
    private String usuario;
    private String password;


    public ClubDAO(String host, String base_datos, String usuario, String password) {
        this.host = host;
        this.base_datos = base_datos;
        this.usuario = usuario;
        this.password = password;
    }

    public void crearEvento(String nombre,String fecha){

    }

    public void añadirSocio(String nombre){

    }


    public void apuntarseEvento(String socio,String evento){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            conexion = BasesDatos.establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql="SELECT id FROM socios WHERE nombre=?";
            sentencia=conexion.prepareStatement(sql);
            sentencia.setString(1,socio);
            resultado=sentencia.executeQuery();
            if(!resultado.next()){
                throw new RuntimeException("El socio no existe");
            }

            int id_socio=resultado.getInt(1);

            sql="SELECT id FROM eventos WHERE nombre=?";
            sentencia= conexion.prepareStatement(sql);
            sentencia.setString(1,evento);
            resultado=sentencia.executeQuery();
            if(!resultado.next()){
                throw new RuntimeException("El evento no existe");
            }

            int id_evento=resultado.getInt(1);

            String sql_insert="INSERT INTO inscripciones " +
                    "VALUES (NULL,?,?)";
            sentencia=conexion.prepareStatement(sql_insert);
            sentencia.setInt(1,id_socio);
            sentencia.setInt(2,id_evento);
            sentencia.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            BasesDatos.cerrarConexion(conexion, sentencia, resultado);
        }
    }

    public String eventosSocio(String socio){
        return null;
    }

    private String sociosEvento(String evento){
        Connection conexion=null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String salida="";
        try {
            conexion = BasesDatos.establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql="SELECT s.nombre FROM eventos e " +
                    "JOIN inscripciones i ON e.id=i.evento "+
                    "JOIN socios s ON i.socio=s.id "+
                    "WHERE e.nombre=?";
            sentencia=conexion.prepareStatement(sql);
            sentencia.setString(1,evento);
            resultado=sentencia.executeQuery();

            while(resultado.next()){
                salida+=resultado.getString(1)+"\n";
            }

        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            BasesDatos.cerrarConexion(conexion,sentencia,resultado);
        }
        return salida;
    }

    public String resumentEventos(){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String salida="";
        try {
            conexion = BasesDatos.establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
        String selectSql="SELECT * FROM eventos";
        sentencia=conexion.prepareStatement(selectSql);
        resultado= sentencia.executeQuery();
        while (resultado.next()){
            String nombre=resultado.getString("nombre");
            salida+=nombre+"\n"+
                    "Fecha:"+resultado.getString("fecha")+"\n"+
                    sociosEvento(nombre)+
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

    public String valoracionesEvento(String evento){

        return null;
    }

    public String eventoMultitudinario(){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String evento=null;
        try {
            conexion = BasesDatos.establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql="SELECT e.nombre FROM eventos e " +
                    "JOIN inscripciones i ON e.id=i.evento "+
                    "GROUP BY i.evento"+
                    "ORDER BY count(*) DESC" +
                    "LIMIT 1";
            sentencia=conexion.prepareStatement(sql);
            resultado=sentencia.executeQuery();
            resultado.next();
            evento=resultado.getString(1);


        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            BasesDatos.cerrarConexion(conexion, sentencia, resultado);
        }
        return evento;
    }

    public String sinSocios(){
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

    public String mejorValorado(){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        String mejor_valorado=null;
        try {
            conexion = BasesDatos.establecerConexion(this.host,this.base_datos,this.usuario,this.password);
            // Realizar operaciones con la base de datos usando la conexión y la sentencia
            String sql="SELECT e.nombre FROM eventos e " +
                    "JOIN resenas_eventos r ON e.id=r.evento_id "+
                    "GROUP BY r.evento_id "+
                    "ORDER BY avg(r.puntuacion) DESC " +
                    "LIMIT 1";
            sentencia=conexion.prepareStatement(sql);
            resultado=sentencia.executeQuery();
            resultado.next();
            mejor_valorado=resultado.getString(1);
            System.out.println(mejor_valorado);
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            BasesDatos.cerrarConexion(conexion, sentencia, resultado);
        }
        return mejor_valorado;
    }

    public void borrarEventos(Integer año){
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
