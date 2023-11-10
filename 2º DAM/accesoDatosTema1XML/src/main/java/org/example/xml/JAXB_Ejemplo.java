package org.example.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JAXB_Ejemplo {
    public static void main(String[] args) {
        final String ruta = "src/main/resources/agenda.xml";
        try {
            // Cargar el archivo XML
            File xmlFile = new File(ruta);

            JAXBContext context = JAXBContext.newInstance(Datos.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Datos datos = (Datos) unmarshaller.unmarshal(xmlFile);

            List<Persona> personas = datos.getPersonas();
            for (Persona persona : personas) {
                System.out.println("Nombre: " + persona.getNombre());
                System.out.println("Edad: " + persona.getEdad());
                System.out.println();
            }
        } catch(Exception e) {
            System.out.println("ERROR: Error al acceder el fichero XML\n" + e.getMessage());
            e.printStackTrace();
        }
    }
}
