package org.example;
public class Main {
    public static void main(String[] args) {
        String inputXML = "elSeñorAnillos.xml";
        String inputXSL = "elSeñorAnillos.xsl";
        String outputXML = "elSeñorAnillosResultado.html";

        try {
            Conversor.convertXMLusingXSL(inputXML, inputXSL, outputXML);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}