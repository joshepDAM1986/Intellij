package ejercicio2;

import java.sql.*;

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

    public void crearEvento(String nombre,String fecha) {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            conexion = establecerConexion();

            String existe = "SELECT e.nombre, e.fecha FROM eventos e WHERE nombre=? and fecha=?";
            statement = conexion.prepareStatement(existe);
            statement.setString(1, nombre);
            statement.setString(2, fecha);
            resultSet = statement.executeQuery();

            if (!resultSet.next()) {
                String insert = "INSERT INTO eventos " +
                        "VALUES (NULL,?, ?)";
                statement = conexion.prepareStatement(insert);
                statement.setString(1, nombre);
                statement.setString(2, fecha);

                int filasAfectadas = statement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Evento insertado exitosamente");
                }
            } else {
                System.out.println("Evento ya existe");
            }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
    }

    public void añadirSocio(String nombre){
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            conexion = establecerConexion();

            String existe = "SELECT s.nombre, s.alta FROM socios e WHERE nombre=?";
            statement = conexion.prepareStatement(existe);
            statement.setString(1, nombre);
            resultSet = statement.executeQuery();

            if (!resultSet.next()) {
                String insert = "INSERT INTO socios (nombre, alta)" +
                        "VALUES (?, ?)";
                statement = conexion.prepareStatement(insert);
                statement.setString(1, nombre);
//                statement.set(2, );

                int filasAfectadas = statement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Evento insertado exitosamente");
                }
            } else {
                System.out.println("Evento ya existe");
            }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
    }


    public void apuntarseEvento(String socio,String evento){

    }

    public String eventosSocio(String socio){
        return null;
    }

    public String resumentEventos() {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String resultado = "";

        try {
            conexion = establecerConexion();
                String select = "SELECT e.nombre, e.fecha, s.nombre FROM eventos e JOIN inscripciones i ON e.id=i.evento JOIN socios s ON s.id=i.socio ORDER BY e.nombre";
                statement = conexion.prepareStatement(select);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    resultado += resultSet.getString(1)+" "+
                                 resultSet.getString(2)+" "+
                                 resultSet.getString(3)+"\n";
                }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return  resultado;
    }

    public String valoracionesEvento(String evento){
        return null;
    }

    public String eventoMultitudinario(){
        return null;
    }

    public String sinSocios(){
        return null;
    }

    public String mejorValorado(){
        return null;
    }

    public void borrarEventos(Integer año){

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

    private Integer devolverIdSocioNombre(String nombre, Connection conexion) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer id = null;
        String existe = "SELECT id FROM socio WHERE nombre=?";
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
}
