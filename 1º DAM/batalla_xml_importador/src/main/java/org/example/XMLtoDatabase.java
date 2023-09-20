package org.example;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
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
            DateTimeFormatter DateTimeFormatter=null;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // Obtener los datos del elemento "producto"
                    Element element = (Element) node;
                    String nombre = sanitize(element.getElementsByTagName("nombre").item(0).getTextContent());
                    String descripcion = sanitize(element.getElementsByTagName("descripcion").item(0).getTextContent());
                    String categoria = sanitize(element.getElementsByTagName("categoria").item(0).getTextContent());
                    float precio = Float.parseFloat(element.getElementsByTagName("precio").item(0).getTextContent());
                    String fechaString = sanitize(element.getElementsByTagName("fecha").item(0).getTextContent());
                    LocalDate fecha = LocalDate.parse(fechaString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    int stock = Integer.parseInt(element.getElementsByTagName("stock").item(0).getTextContent());
                    String alergenos = sanitize(element.getElementsByTagName("alergenos").item(0).getTextContent());

                    // Eliminar palabras duplicadas en el campo "alergenos"
                    alergenos = removeDuplicateWords(alergenos);

                    // Verificar si los datos ya existen en la base de datos
                    if (!dataExistsInDatabase(cn, nombre, descripcion, categoria, precio, fecha, stock, alergenos)) {
                        // Los datos no existen, proceder con la inserción
                        insertDataIntoDatabase(cn, nombre, descripcion, categoria, precio, fecha, stock, alergenos);
                    }
                }
            }
            System.out.println("Registros no existentes insertados con éxito");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String removeDuplicateWords(String input) {
        // Dividir el campo en palabras individuales
        String[] words = input.split("\\s+");

        // Crear un conjunto para almacenar palabras únicas
        Set<String> uniqueWords = new HashSet<>();

        // Eliminar palabras duplicadas y conservar solo las únicas
        for (String word : words) {
            uniqueWords.add(word);
        }

        // Construir la nueva cadena sin palabras duplicadas
        StringBuilder result = new StringBuilder();
        for (String word : uniqueWords) {
            result.append(word).append(" ");
        }

        return result.toString().trim();
    }

    private static boolean dataExistsInDatabase(Connection cn, String nombre, String descripcion, String categoria, float precio, LocalDate fecha, int stock, String alergenos) throws Exception {
        boolean exists = false;
        String sql = "SELECT COUNT(*) FROM producto WHERE nombre = ? AND descripcion = ? AND categoria = ? AND fecha = ?";
        PreparedStatement statement = cn.prepareStatement(sql);
        statement.setString(1, nombre);
        statement.setString(2, descripcion);
        statement.setString(3, categoria);
        statement.setDate(4, java.sql.Date.valueOf(fecha));

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            exists = (count > 0);
        }

        resultSet.close();
        statement.close();

        return exists;
    }

    private static void insertDataIntoDatabase(Connection cn, String nombre, String descripcion, String categoria, float precio, LocalDate fecha, int stock, String alergenos) throws Exception {
        // Preparar la sentencia SQL para la inserción
        String sql = "INSERT INTO producto (nombre, descripcion, categoria, precio, fecha, stock, alergenos) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = cn.prepareStatement(sql);
        statement.setString(1, nombre);
        statement.setString(2, descripcion);
        statement.setString(3, categoria);
        statement.setFloat(4, precio);
        statement.setDate(5, java.sql.Date.valueOf(fecha));
        statement.setInt(6, stock);
        statement.setString(7, alergenos);

        // Ejecutar la sentencia SQL
        statement.executeUpdate();

        statement.close();
    }

    private static String sanitize(String input) {
        // Definir una expresión regular para encontrar caracteres especiales y reemplazarlos por una cadena vacía
        String regex = "[^a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s-]";
        return input.replaceAll(regex, "");
    }

    public static void main(String[] args) {
        insertarXml();
    }
}
