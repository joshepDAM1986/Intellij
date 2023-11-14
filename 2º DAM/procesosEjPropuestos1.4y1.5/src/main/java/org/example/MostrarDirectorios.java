package org.example;

import java.io.File;
import java.io.IOException;

public class MostrarDirectorios {
    public static void mostrarDirectorio() {
        String directorio="C:\\Users\\garci\\OneDrive\\Documentos\\DAM";
        try {
            // Creamos el proceso
            ProcessBuilder pbDefecto = new ProcessBuilder("cmd.exe", "/c", "dir");

            // Redirección del proceso a la consola para poder visualizarlo
            pbDefecto.inheritIO();
            // Iniciamos el proceso
            Process p = pbDefecto.start();
            // Esperamos a que el proceso termine
            int exitCode = p.waitFor();
            // Imprimimos el código de salida en la consola
            System.out.println("\nLos comando han finalizado con código de salida: " + exitCode);

            //Cambiamos el directorio donde ejecutar el segundo comando
            pbDefecto.directory(new File(directorio));

            // Redirección del segundo proceso a la consola para poder visualizarlo
            pbDefecto.inheritIO();

            // Iniciamos el segundo proceso
            Process p2 = pbDefecto.start();
            // Esperamos a que el segundo proceso termine
            int exitCode2 = p2.waitFor();
            // Imprimimos el código de salida en la consola
            System.out.println("\nEl segundo comando ha finalizado con código de salida: " + exitCode2);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}