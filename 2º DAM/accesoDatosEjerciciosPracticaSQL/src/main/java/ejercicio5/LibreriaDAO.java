package ejercicio5;

import java.sql.*;
import java.time.LocalDate;

public class LibreriaDAO {
    private String host;
    private String base_datos;
    private String usuario;
    private String password;

    public LibreriaDAO(String host, String base_datos, String usuario, String password) {
        this.host = host;
        this.base_datos = base_datos;
        this.usuario = usuario;
        this.password = password;
    }

    Connection conexion = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public void agregarLibro(String isbn, String titulo, String autor){
        try {
            conexion = establecerConexion();
                String existe = "SELECT isbn " +
                        "FROM libros WHERE isbn=?";
                statement = conexion.prepareStatement(existe);
                statement.setString(1, isbn);
                resultSet = statement.executeQuery();

                if (!resultSet.next()) {
                    String insert = "INSERT INTO libros " +
                            "VALUES (NULL,?, ?, ?)";
                    statement = conexion.prepareStatement(insert);
                    statement.setString(1, isbn);
                    statement.setString(2, titulo);
                    statement.setString(3, autor);

                    int filasAfectadas = statement.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Libro insertado exitosamente");
                    }
                }else{
                    throw new RuntimeException("El ISBN ya existe");
                }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
    }

    public void realizarPrestamo(String isbn, String dni){
        try {
            conexion = establecerConexion();
            Integer socioId = devolverIdSocioDni(dni, conexion);
            Integer libroId = devolverIdLibroIsbn(isbn, conexion);
            LocalDate fechaActual= LocalDate.now();
            LocalDate fechaDevolucion= fechaActual.plusDays(10);
            if (socioId != null) {
                if (libroId != null) {
                    String insert = "INSERT INTO prestamos " +
                            "VALUES (NULL,?, ?, ?, ?)";
                    statement = conexion.prepareStatement(insert);
                    statement.setInt(1, libroId);
                    statement.setInt(2, socioId);
                    statement.setDate(3, Date.valueOf(fechaActual));
                    statement.setDate(4, Date.valueOf(fechaDevolucion));

                    int filasAfectadas = statement.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Préstamo añadido correctamente");
                    }
                } else {
                    throw new RuntimeException("El ISBN no existe");
                }
            } else {
                throw new RuntimeException("El socio no existe");
            }
        }catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
    }

    public String masActivo(){
        String resultado="";
        try {
            conexion = establecerConexion();
            String select = "SELECT s.dni AS dniSocio " +
                    "FROM socios s " +
                    "JOIN prestamos p " +
                    "ON s.id=p.socio " +
                    "GROUP BY s.id " +
                    "ORDER BY COUNT(s.id) DESC " +
                    "LIMIT 1";
            statement = conexion.prepareStatement(select);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                resultado += resultSet.getString("dniSocio")+"\n";
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

    public void borrarSinUso(){
        try {
            conexion = establecerConexion();

            String deleteSql="DELETE l " +
                    "FROM libros l " +
                    "LEFT JOIN prestamos p " +
                    "ON l.id=p.libro " +
                    "WHERE p.socio IS NULL";
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

    private Integer devolverIdSocioDni(String dni, Connection conexion) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer id = null;
        String existe = "SELECT id FROM socios WHERE dni=?";
        try {
            statement = conexion.prepareStatement(existe);
            statement.setString(1, dni);
            resultSet = statement.executeQuery();
            if (resultSet.next()) id = resultSet.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    private Integer devolverIdLibroIsbn(String isbn, Connection conexion) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer id = null;
        String existe = "SELECT id FROM libros WHERE isbn=?";
        try {
            statement = conexion.prepareStatement(existe);
            statement.setString(1, isbn);
            resultSet = statement.executeQuery();
            if (resultSet.next()) id = resultSet.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}

