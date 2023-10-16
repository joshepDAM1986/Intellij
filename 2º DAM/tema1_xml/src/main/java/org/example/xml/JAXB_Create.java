package org.example.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class JAXB_Create {
    public static void main(String[] args) {
        final String ruta = "src/main/resources/datos.xml";

        try {
            // Crear un objeto Datos con una lista de Personas
            Datos datos = new Datos();
            List<Persona> personas = datos.getPersonas();

            Persona persona1 = new Persona();
            persona1.setNombre("John");
            persona1.setEdad(30);
            personas.add(persona1);

            Persona persona2 = new Persona();
            persona2.setNombre("Jane");
            persona2.setEdad(25);
            personas.add(persona2);



            // Crear el contexto de JAXB
            JAXBContext context = JAXBContext.newInstance(Datos.class);

            // Crear el objeto Marshaller
            Marshaller marshaller = context.createMarshaller();

            // Configurar la salida para formatear el XML
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Marshalling: Convertir el objeto Datos en XML y guardarlo en un archivo
            marshaller.marshal(datos, new File(ruta));

            System.out.println("Objeto Datos guardado en el archivo XML correctamente.");
        } catch (Exception e) {
            System.out.println("ERROR: Error al guardar el objeto Datos en el archivo XML\n" + e.getMessage());
            e.printStackTrace();
        }
    }
}

