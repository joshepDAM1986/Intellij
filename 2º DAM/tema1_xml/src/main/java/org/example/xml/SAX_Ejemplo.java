package org.example.xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAX_Ejemplo {

    public static void main(String[] args) {
        final String ruta = "src/main/resources/agenda.xml";
        try {
            // Cargar el archivo XML
            File xmlFile = new File(ruta);

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean inElement = false;
                String currentElement = "";

                public void startDocument() {
                    System.out.println("Comienzo del documento");
                }

                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    inElement = true;
                    currentElement = qName;
                    System.out.println("Comienzo del elemento: '" + qName + "'");
                }

                public void characters(char[] ch, int start, int length) {
                    if (inElement) {
                        String content = String.copyValueOf(ch,start,length).trim();
                        if (!content.isEmpty()) {
                            System.out.println("Contenido: '" + content + "'");
                        }
                    }
                }

                public void endElement(String uri, String localName, String qName) {
                    inElement = false;
                    System.out.println("Fin del elemento: '" + qName + "'");
                }

                public void endDocument() {
                    System.out.println("Fin del documento");
                }
            };

            saxParser.parse(xmlFile, handler);

        } catch (Exception e) {
            System.out.println("ERROR: Error al acceder el fichero XML\n" + e.getMessage());
            e.printStackTrace();
        }
    }
}
