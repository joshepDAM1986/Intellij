package org.example;

public class MainReader {
    public static void main(String[] args) {
        // Flujo de caracteres destinado a la lectura de ficheros de texto
        Reader.fileReader();
        System.out.println();


        // Permite leer información de otro Reader utilizando un buffer interno que
        // mejora el rendimiento
        Reader.bufferedReader();
        System.out.println();


        // Tipo especial de BufferReader que lleva un conteo del número de línea
        // que está leyendo en cada momento
        Reader.lineNumberReader();
        System.out.println();


        // Flujo de caracteres que recoge en un buffer los datos provenientes
        // de un array de caracteres
        Reader.charArrayReader();
        System.out.println();


        // Flujo de caracteres que recoge en un buffer los datos provenientes
        // de un String
        Reader.stringReader();
        System.out.println();
    }
}
