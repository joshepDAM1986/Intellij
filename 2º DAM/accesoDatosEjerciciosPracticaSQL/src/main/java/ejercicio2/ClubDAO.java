package ejercicio2;

import java.sql.*;
import java.time.LocalDate;

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

            String existe = "SELECT e.nombre, e.fecha " +
                    "FROM eventos e " +
                    "WHERE nombre=? and fecha=?";
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

            String existe = "SELECT s.nombre, s.alta " +
                    "FROM socios s " +
                    "WHERE nombre=?";
            statement = conexion.prepareStatement(existe);
            statement.setString(1, nombre);
            resultSet = statement.executeQuery();

            if (!resultSet.next()) {
                String insert = "INSERT INTO socios " +
                        "VALUES (NULL,? ,? )";
                statement = conexion.prepareStatement(insert);
                statement.setString(1, nombre);
                statement.setDate(2,Date.valueOf(LocalDate.now()));

                int filasAfectadas = statement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Socio insertado exitosamente");
                }
            } else {
                System.out.println("Socio ya existe");
            }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
    }

    public void apuntarseEvento(String socio,String evento){
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            conexion = establecerConexion();
            Integer id_socio = devolverIdSocioNombre(socio,conexion);
            Integer id_evento = devolverIdEventoNombre(evento,conexion);

            if(id_socio!=null || id_evento!=null){
                String insert = "INSERT INTO inscripciones " +
                        "VALUES (NULL,? ,? )";
                statement = conexion.prepareStatement(insert);
                statement.setInt(1, id_socio);
                statement.setInt(2,id_evento);

                int filasAfectadas = statement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Socio inscrito exitosamente");
                }
            } else {
                System.out.println("Socio o evento no existe");
            }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
    }

    public String eventosSocio(String socio){
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String resultado = "";

        try {
            conexion = establecerConexion();
            Integer id_socio = devolverIdSocioNombre(socio,conexion);
            if(id_socio!=null) {
                String select = "SELECT e.nombre " +
                        "FROM eventos e " +
                        "JOIN inscripciones i " +
                        "ON e.id=i.evento " +
                        "JOIN socios s " +
                        "ON s.id=i.socio " +
                        "WHERE s.nombre=? ORDER BY e.nombre";
                statement = conexion.prepareStatement(select);
                statement.setString(1, socio);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                            resultado +=resultSet.getString(1)+"\n";
                }
            }else{
                System.out.println("No existe el socio");
                }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return  resultado;
    }

    private String sociosEvento(String evento){
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String resultado="";
        try {
            conexion = establecerConexion();
            String selectSql="SELECT s.nombre FROM socios s " +
                    "JOIN inscripciones i ON s.id=i.socio "+
                    "JOIN eventos e ON i.evento=e.id "+
                    "WHERE e.nombre=?";
            statement=conexion.prepareStatement(selectSql);
            statement.setString(1,evento);
            resultSet=statement.executeQuery();

            while(resultSet.next()){
                resultado+=resultSet.getString(1)+"\n";
            }

        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return resultado;
    }

    public String resumenEventos() {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String resultado = "";

        try {
            conexion = establecerConexion();
            String selectSql="SELECT * FROM eventos";
            statement=conexion.prepareStatement(selectSql);
            resultSet= statement.executeQuery();
            while (resultSet.next()){
                String nombre=resultSet.getString("nombre");
                resultado+=nombre+"\n"+
                        "Fecha:"+resultSet.getString("fecha")+"\n"+
                        sociosEvento(nombre)+
                        "======================\n";
            }

        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return resultado;
    }

    public String valoracionesEvento(String evento){
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String resultado = "";

        try {
            conexion = establecerConexion();
            Integer id_evento = devolverIdEventoNombre(evento,conexion);
            if(id_evento!=null) {
                String select = "SELECT re.comentario " +
                        "FROM resenas_eventos re " +
                        "JOIN eventos e " +
                        "ON re.evento_id=e.id " +
                        "WHERE e.nombre=?";
                statement = conexion.prepareStatement(select);
                statement.setString(1, evento);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    resultado += resultSet.getString(1)+"\n";
                }
            }else{
                System.out.println("No existe el evento");
            }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return  resultado;
    }

    public String eventoMultitudinario(){
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String resultado="";
        try {
            conexion = establecerConexion();
                String select = "SELECT e.nombre FROM eventos e " +
            "JOIN inscripciones i ON e.id=i.evento "+
                    "GROUP BY i.evento "+
                    "ORDER BY COUNT(*) DESC, e.nombre ASC " +
                    "LIMIT 1";
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
        return resultado ;
    }

    public String sinSocios(){
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String resultado="";
        try {
            conexion = establecerConexion();
            String select = "SELECT e.nombre " +
                    "FROM eventos e " +
                    "LEFT JOIN inscripciones i " +
                    "ON e.id=i.evento " +
                    "LEFT JOIN socios s " +
                    "ON s.id=i.socio " +
                    "WHERE s.nombre IS NULL";
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
        return resultado ;
    }

    public String mejorValorado(){
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        StringBuilder resultado=new StringBuilder();
        try {
            conexion = establecerConexion();
            String select = "SELECT e.nombre as eventoNombre, AVG(re.puntuacion) " +
                    "FROM eventos e " +
                    "JOIN resenas_eventos re " +
                    "ON e.id=re.evento_id " +
                    "ORDER BY re.puntuacion  " +
                    "LIMIT 1";
            statement = conexion.prepareStatement(select);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                String eventoNombre=resultSet.getString("eventoNombre");
                Double rePuntuacion=resultSet.getDouble(2);
                resultado.append("Evento: ").append(eventoNombre).append("\n");
                resultado.append("Puntuacion: ").append(rePuntuacion).append("\n");
            }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return resultado.toString();
    }

    public void borrarEventos(Integer año){
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
                conexion = establecerConexion();
                String delete = "DELETE FROM eventos " +
                        "WHERE YEAR(fecha) <?";
                statement = conexion.prepareStatement(delete);
                statement.setInt(1, año);

                int filasAfectadas = statement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Eventos borrados exitosamente");
            } else {
                System.out.println("No se borro ningun evento");
            }
        } catch (SQLException exception) {
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

    private Integer devolverIdSocioNombre(String nombre, Connection conexion) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer id = null;
        String existe = "SELECT id FROM socios WHERE nombre=?";
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
    private Integer devolverIdEventoNombre(String nombre, Connection conexion) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer id = null;
        String existe = "SELECT id FROM eventos WHERE nombre=?";
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
