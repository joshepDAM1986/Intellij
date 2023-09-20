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

public class XMLtoDatabaseRival {
    public static void insertarXml() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/batallaxml", "usr_batalla", "Batalla#23");
            // Cargar el archivo XML
            File xmlFile = new File("restaurante.xml");

            // Crear un objeto DocumentBuilder para analizar el XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Opcionalmente, puedes normalizar el documento XML
            doc.getDocumentElement().normalize();

            // Obtener la lista de elementos "producto"
            NodeList nodeList = doc.getElementsByTagName("plato");

            // Recorrer los elementos "producto" y realizar la inserción en la base de datos
            DateTimeFormatter DateTimeFormatter=null;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // Obtener los datos del elemento "producto"
                    Element element = (Element) node;
                    String nombre = sanitize(element.getElementsByTagName("nombre").item(0).getTextContent());
                    String categoria = sanitize(element.getElementsByTagName("categoria").item(0).getTextContent());
                    float precio = Float.parseFloat(element.getElementsByTagName("precio").item(0).getTextContent());
                    String ingredientes = sanitize(element.getElementsByTagName("ingredientes").item(0).getTextContent());
                    int tiempoPreparacion = Integer.parseInt(element.getElementsByTagName("tiempoPreparacion").item(0).getTextContent());
                    String fechaCreacion = sanitize(element.getElementsByTagName("fecha").item(0).getTextContent());
                    String descripcion = sanitize(element.getElementsByTagName("descripcion").item(0).getTextContent());
                    int cantidadDisponible = Integer.parseInt(element.getElementsByTagName("cantidadDisponible").item(0).getTextContent());



                    // Verificar si los datos ya existen en la base de datos
                    if (!dataExistsInDatabase(cn, nombre, categoria, precio, ingredientes, tiempoPreparacion, fechaCreacion, descripcion, cantidadDisponible)) {
                        // Los datos no existen, proceder con la inserción
                        insertDataIntoDatabase(cn, nombre, categoria, precio, ingredientes, tiempoPreparacion, fechaCreacion, descripcion, cantidadDisponible);
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

    private static boolean dataExistsInDatabase(Connection cn, String nombre, String categoria, float precio, String ingredientes, int tiempoPreparacion, String fechaCreacion, String descripcion, int cantidadDisponible) throws Exception {
        boolean exists = false;
        String sql = "SELECT COUNT(*) FROM plato WHERE nombre = ? AND descripcion = ? AND categoria = ? AND fecha = ?";
        PreparedStatement statement = cn.prepareStatement(sql);
        statement.setString(1, nombre);
        statement.setString(2, categoria);
        statement.setString(3, descripcion);
        statement.setString(4, fechaCreacion);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            exists = (count > 0);
        }

        resultSet.close();
        statement.close();

        return exists;
    }

    private static void insertDataIntoDatabase(Connection cn, String nombre, String categoria, float precio, String ingredientes, int tiempoPreparacion, String fechaCreacion, String descripcion, int cantidadDisponible) throws Exception {
        // Preparar la sentencia SQL para la inserción
        String sql = "INSERT INTO producto (nombre, categoria, precio, ingredientes, tiempoPreparacion, fechaCreacion, descripcion, cantidadDisponible) VALUES (?, ?, ?, ?, ?, ?, ?,?)";

        PreparedStatement statement = cn.prepareStatement(sql);
        statement.setString(1, nombre);
        statement.setString(2, categoria);
        statement.setFloat(3, precio);
        statement.setString(4, ingredientes);
        statement.setInt(5, tiempoPreparacion);
        statement.setString(6, fechaCreacion);
        statement.setString(7, descripcion);
        statement.setInt(8, cantidadDisponible);

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
