package org.example;
public class Main {
    public static void main(String[] args) {
        String inputXML = "entregaWeb_paises.xml";
        String inputXSL = "entregaWeb_paises.xsl";
        String outputXML = "entregaWeb_paises_Resultado.html";

        try {
            Conversor.convertXMLusingXSL(inputXML, inputXSL, outputXML);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}