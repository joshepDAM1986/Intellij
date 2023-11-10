package org.example.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;


public class DOM_Create_Modify {
    public static void main(String[] args) {

        final String ruta = "src/main/resources/agenda.xml";
        final String nuevo = "src/main/resources/agenda_modificada.xml";
        try {
            // Cargar el archivo XML
            File xmlFile = new File(ruta);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Agregar un nuevo elemento <persona>
            Element nuevaPersona = doc.createElement("persona");
            Element nuevoNombre = doc.createElement("nombre");
            nuevoNombre.appendChild(doc.createTextNode("Alice"));
            Element nuevaEdad = doc.createElement("edad");
            nuevaEdad.appendChild(doc.createTextNode("28"));
            nuevaPersona.appendChild(nuevoNombre);
            nuevaPersona.appendChild(nuevaEdad);
            doc.getDocumentElement().appendChild(nuevaPersona);

            // Modificar el elemento <nombre> de la primera persona
            NodeList nombres = doc.getElementsByTagName("nombre");
            Element primerNombre = (Element) nombres.item(0);
            primerNombre.setTextContent("NuevoNombre");

            // Eliminar el elemento <edad> de la segunda persona
            NodeList edades = doc.getElementsByTagName("persona");
            Element segundaPersona = (Element) edades.item(1);
            segundaPersona.getParentNode().removeChild(segundaPersona);

            // Guardar los cambios en un nuevo archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(nuevo));
            transformer.transform(source, result);

            System.out.println("Cambios realizados y guardados con éxito.");
        } catch (Exception e) {
            System.out.println("ERROR: Error al modificar el fichero XML\n" + e.getMessage());
            e.printStackTrace();
        }
    }
}
