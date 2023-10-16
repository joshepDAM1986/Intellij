package org.example.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOM_Children {
    public static void main(String[] args) {

        final String ruta = "src/main/resources/empleados.xml";

        try {
            File xmlFile = new File(ruta);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            //Obtener la lista de nodos que tienen etiqueta "EMPLEADO"
            NodeList listaEmpleados = doc.getElementsByTagName("empleado");
            //Recorrer la lista de empleados
            for (int i = 0; i < listaEmpleados.getLength(); i++) {
                //Obtener de la lista un empleado tras otro
                Node empleado = listaEmpleados.item(i);
                System.out.println("Empleado " + i);
                System.out.println("==========");

                //Obtener la lista de los datos que contiene ese empleado
                NodeList datosEmpleado = empleado.getChildNodes();
                //Recorrer la lista de los datos que contiene el empleado
                for (int j = 0; j < datosEmpleado.getLength(); j++) {
                    //Obtener de la lista de datos un dato tras otro
                    Node dato = datosEmpleado.item(j);

                    //Comprobar que el dato se trata de un nodo de tipo Element
                    if (dato.getNodeType() == Node.ELEMENT_NODE) {
                        //Mostrar el nombre del tipo de dato
                        System.out.print(dato.getNodeName() + ": ");
                        //El valor está contenido en un hijo del nodo Element
                        Node datoContenido = dato.getFirstChild();
                        //Mostrar el valor contenido en el nodo que debe ser de tipo Text
                        if (datoContenido != null && datoContenido.getNodeType() == Node.TEXT_NODE) {
                            System.out.println(datoContenido.getNodeValue());
                        }
                    }
                }
                //Se deja un salto de línea de separación entre cada empleado
                System.out.println();
            }

        } catch (SAXException ex) {
            System.out.println("ERROR: El formato XML del fichero no es correcto\n" + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("ERROR: Se ha producido un error el leer el fichero\n" + ex.getMessage());
            ex.printStackTrace();
        } catch (ParserConfigurationException ex) {
            System.out.println("ERROR: No se ha podido crear el generador de documentos XML\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
