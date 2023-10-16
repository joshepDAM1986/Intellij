package org.example.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOM {
    public static void main(String[] args) {
        final String ruta = "src/main/resources/agenda.xml";
        try {
            // Cargar el archivo XML
            File xmlFile = new File(ruta);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Normalizar el documento (opcional, pero puede ser útil)
            doc.getDocumentElement().normalize();

            // Obtener la lista de nodos 'persona'
            NodeList nodeList = doc.getElementsByTagName("persona");

            // Recorrer la lista de nodos 'persona'
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Obtener los valores de 'nombre' y 'edad'
                    String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                    String edad = element.getElementsByTagName("edad").item(0).getTextContent();

                    // Imprimir los valores
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Edad: " + edad);
                    System.out.println("------------------");
                }
            }
        } catch (SAXException ex) {
            System.out.println("ERROR: El formato XML del fichero no es correcto\n"+ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("ERROR: Se ha producido un error el leer el fichero\n"+ex.getMessage());
            ex.printStackTrace();
        } catch (ParserConfigurationException ex) {
            System.out.println("ERROR: No se ha podido crear el generador de documentos XML\n"+ex.getMessage());
            ex.printStackTrace();
        }
    }
}
