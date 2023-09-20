package org.example;

public class Main {
    public static void main(String[] args) {

        // Permite escribir caracteres hacia un fichero de texto
        Writer.fileWriter();


        // Posibilita escribir información de otro Writer utilizando un buffer
        // interno que mejora el rendimiento
        Writer.bufferedWriter();


        // Permite usar un array de caracteres como Writer
        Writer.charArrayWriter();


        // Implementación de la clase Writer. Permite escribir una cadena de caracteres
        // en cualquier OutputStream
        Writer.printWriter();


        // Flujo de caracteres que recoge su salida en un buffer y que puede
        // utilizarse para construir un String
        Writer.stringWriter();
    }
}