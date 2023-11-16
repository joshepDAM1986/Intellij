package ejercicio3;

import java.sql.*;
import java.time.LocalDate;

public class TiendaDAO {
    private String host;
    private String base_datos;
    private String usuario;
    private String password;

    Connection conexion = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;


    public TiendaDAO(String host, String base_datos, String usuario, String password) {
        this.host = host;
        this.base_datos = base_datos;
        this.usuario = usuario;
        this.password = password;
    }

    public void añadirVenta(String cliente,String producto, Integer ventas){
        try {
            conexion = establecerConexion();
            Integer id_cliente = devolverIdClienteNombre(cliente, conexion);
            Integer id_producto = devolverIdProductoNombre(producto, conexion);

            if (id_cliente != null || id_producto!=null) {

                    String insert = "INSERT INTO ventas " +
                            "VALUES (NULL,?, ?, ?, ?)";
                    statement = conexion.prepareStatement(insert);
                    statement.setInt(1, id_producto);
                    statement.setInt(2, id_cliente);
                statement.setDate(3, Date.valueOf(LocalDate.now()));
                    statement.setInt(4, ventas);

                    int filasAfectadas = statement.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Venta insertada exitosamente");
                    }
                }else{
                    System.out.println("El cliente o el producto no existe");
                }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
    }

    public String comprasCliente(String cliente){
        String resultado="";
        try {
            conexion = establecerConexion();
            Integer id_cliente = devolverIdClienteNombre(cliente,conexion);
            if(id_cliente!=null) {
                String select = "SELECT p.nombre, v.unidades " +
                        "FROM productos p " +
                        "JOIN ventas v ON p.id = v.producto " +
                        "JOIN clientes c ON c.id = v.cliente " +
                        "WHERE c.id = ?";
                statement = conexion.prepareStatement(select);
                statement.setInt (1, id_cliente);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    resultado += resultSet.getString(1)+" "+
                                 resultSet.getInt(2)+"\n";
                }
            }else{
                System.out.println("No existe el cliente");
            }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return  resultado;
    }

    public Double recaudacionTotal(){
        Double resultado=0.0;
        try {
            conexion = establecerConexion();
                String select = "SELECT SUM(p.precio*v.unidades) FROM productos p JOIN ventas v ON p.id=v.producto";
                statement = conexion.prepareStatement(select);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    resultado += resultSet.getDouble(1);
                }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return  resultado;
    }

    public String porCategorias(){
        String resultado="";
        try {
            conexion = establecerConexion();

                String select = "SELECT ca.nombre AS nombre_categoria, " +
                        "COALESCE(SUM(v.unidades),0) AS unidades_vendidas " +
                        "FROM categorias ca " +
                        "LEFT JOIN productos p " +
                        "ON ca.id = p.categoria_id " +
                        "LEFT JOIN ventas v " +
                        "ON p.id = v.producto " +
                        "GROUP BY ca.nombre";
                statement = conexion.prepareStatement(select);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    resultado += resultSet.getString("nombre_categoria")+" "+
                            resultSet.getInt("unidades_vendidas")+"\n";
                }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return  resultado;
    }


    public String ultimaVenta(){
        String resultado="";
        try {
            conexion = establecerConexion();

            String select = "SELECT cl.nombre AS nombre_cliente, " +
                            "p.nombre AS nombre_producto, " +
                            "v.fecha AS fecha_venta " +
                            "FROM clientes cl " +
                            "JOIN ventas v " +
                            "ON cl.id = v.cliente " +
                            "JOIN productos p " +
                            "ON p.id = v.producto " +
                            "GROUP BY cl.nombre " +
                            "ORDER BY v.fecha DESC";
            statement = conexion.prepareStatement(select);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                resultado += resultSet.getString("nombre_cliente")+" "+
                        resultSet.getString("nombre_producto")+" "+
                        resultSet.getString("fecha_venta")+"\n";
            }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return  resultado;
    }

    public String masVendido(){
        String resultado="";
        try {
            conexion = establecerConexion();

            String select = "SELECT p.nombre AS nombre_producto, " +
                    "SUM(v.unidades) AS unidades_vendidas " +
                    "FROM productos p " +
                    "JOIN ventas v " +
                    "ON p.id = v.producto " +
                    "GROUP BY p.nombre " +
                    "LIMIT 1";
            statement = conexion.prepareStatement(select);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                resultado += resultSet.getString("nombre_producto")+" "+
                        resultSet.getString("unidades_vendidas")+"\n";
            }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return  resultado;
    }

    public String sinVentas(){
        String resultado="";
        try {
            conexion = establecerConexion();

            String select = "SELECT p.nombre AS nombre_producto " +
                    "FROM productos p " +
                    "LEFT JOIN ventas v " +
                    "ON p.id = v.producto " +
                    "WHERE v.unidades IS NULL;";
            statement = conexion.prepareStatement(select);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                resultado += resultSet.getString("nombre_producto")+"\n";
            }
        } catch (SQLException exception) {
            System.out.println("Error de SQL\n" + exception.getMessage());
            exception.printStackTrace();
        } finally {
            cerrarConexion(conexion, statement, resultSet);
        }
        return  resultado;
    }


    public void borrarProveedor(String nombre) {
        try {
            conexion = establecerConexion();

            // Obtener el ID del proveedor
            Integer idProveedor = devolverIdProveedorNombre(nombre, conexion);
            if (idProveedor != null) {
                String deleteProductosSql = "DELETE FROM productos WHERE proveedor_id=?";
                statement = conexion.prepareStatement(deleteProductosSql);
                statement.setInt(1, idProveedor);
                int filasAfectadasProductos = statement.executeUpdate();

                String deleteProveedorSql = "DELETE FROM proveedores WHERE id=?";
                statement = conexion.prepareStatement(deleteProveedorSql);
                statement.setInt(1, idProveedor);
                int filasAfectadasProveedor = statement.executeUpdate();

                if (filasAfectadasProductos > 0 || filasAfectadasProveedor > 0) {
                    System.out.println("Proveedor y productos borrados con éxito");
                }else{
                    System.out.println("No se pudieron realizar cambios");
                }
            }else{
                System.out.println("No existe el proveedor");
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

    private Integer devolverIdClienteNombre(String nombre, Connection conexion) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer id = null;
        String existe = "SELECT id FROM clientes WHERE nombre=?";
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

    private Integer devolverIdProductoNombre(String nombre, Connection conexion) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer id = null;
        String existe = "SELECT id FROM productos WHERE nombre=?";
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

    private Integer devolverIdProveedorNombre(String nombre, Connection conexion) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer id = null;
        String existe = "SELECT id FROM proveedores WHERE nombre=?";
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
