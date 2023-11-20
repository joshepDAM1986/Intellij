package ejercicio4;

import java.sql.*;

public class DiscograficaDAO {
    private String host;
    private String base_datos;
    private String usuario;
    private String password;

    public DiscograficaDAO(String host, String base_datos, String usuario, String password) {
        this.host = host;
        this.base_datos = base_datos;
        this.usuario = usuario;
        this.password = password;
    }

    Connection conexion = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public  void aumentarPrecio(String genero, Double porcentaje){
        try {
            conexion = establecerConexion();

                String updateSql = "UPDATE albumes " +
                        "SET precio = ROUND(precio * (1+?/100),2) " +
                        "WHERE genero= ?";
                statement = conexion.prepareStatement(updateSql);
                statement.setDouble(1, porcentaje);
                statement.setString(2,genero);

                int filasAfectadas = statement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Sueldo incrementado");
                }else{
                    System.out.println("No se pudo subir el precio");
                }

        }catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
    }

    public String masReciente(){
        String resultado="";
        try {
            conexion = establecerConexion();
            String select = "SELECT a.titulo AS nombre_album, " +
                    "a.fecha AS fecha_lanzamiento " +
                    "FROM albumes a " +
                    "ORDER BY a.fecha DESC";
            statement = conexion.prepareStatement(select);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                resultado += resultSet.getString("nombre_album")+" "+
                        resultSet.getString("fecha_lanzamiento")+"\n";
            }else{
                System.out.println("Sin resultados");
            }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return  resultado;
    }

    public String calificacionAlbun(String titulo){
        String resultado="";
        int duracionTotal=0;

        try {
            conexion = establecerConexion();
            Integer idAlbum= devolverIdAlbumNombre(titulo,conexion);
            if (idAlbum!=null) {
                String select = "SELECT SUM(c.duracion) AS duracionTotal " +
                        "FROM canciones c " +
                        "JOIN albumes a " +
                        "ON c.id_album = a.id " +
                        "WHERE a.id= ?";
                statement = conexion.prepareStatement(select);
                statement.setInt(1, idAlbum);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    duracionTotal += resultSet.getInt("duracionTotal");
                }
                if (duracionTotal>=20){
                    resultado="Duración extendida";
                }else{
                    resultado="Duración mínima";
                }
            }else{
                throw new RuntimeException("No existe ese album");
            }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return  resultado;
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

    private Integer devolverIdAlbumNombre(String titulo, Connection conexion) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer id = null;
        String existe = "SELECT id FROM albumes WHERE titulo=?";
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
