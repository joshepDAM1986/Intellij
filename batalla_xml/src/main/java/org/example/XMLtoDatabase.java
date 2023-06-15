package org.example;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class XMLtoDatabase {
    public static void insertarXml() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batallaxml", "usr_batalla", "Batalla#23");
            // Cargar el archivo XML
            File xmlFile = new File("productos.xml");

            // Crear un objeto DocumentBuilder para analizar el XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Opcionalmente, puedes normalizar el documento XML
            doc.getDocumentElement().normalize();

            // Obtener la lista de elementos "producto"
            NodeList nodeList = doc.getElementsByTagName("producto");

            // Recorrer los elementos "producto" y realizar la inserción en la base de datos
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                    String descripcion = element.getElementsByTagName("descripcion").item(0).getTextContent();
                    String categoria = element.getElementsByTagName("categoria").item(0).getTextContent();
                    float precio = Float.parseFloat(element.getElementsByTagName("precio").item(0).getTextContent());
                    String fecha = element.getElementsByTagName("fecha").item(0).getTextContent();
                    int stock = Integer.parseInt(element.getElementsByTagName("stock").item(0).getTextContent());
                    String alergenos = element.getElementsByTagName("alergenos").item(0).getTextContent();

                    // Preparar la sentencia SQL para la inserción
                    String sql = "INSERT INTO productos (nombre, descripcion, categoria, precio, fecha, stock, alergenos) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement = cn.prepareStatement(sql);

                    statement.setString(1, nombre);
                    statement.setString(2, descripcion);
                    statement.setString(3, categoria);
                    statement.setFloat(4, precio);
                    statement.setString(5, fecha);
                    statement.setInt(6, stock);
                    statement.setString(7, alergenos);

                    // Ejecutar la sentencia SQL
                    statement.executeUpdate();
                }
            }
            System.out.println("Registros insertados con éxito");
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}