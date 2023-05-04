package org.example;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            leer();
        }
        catch(NombreFicheroIncorrectoException e){
            System.out.println(e.getMessage());
        }

    }

    public static String leer() throws NombreFicheroIncorrectoException {
        String fichero = "dato.txt";
        try (Scanner file =
                     new Scanner(new File(fichero))) {
            if (file.hasNextLine())
                return file.nextLine();
        }
        catch(FileNotFoundException e){
            if (!nombreCorrecto(fichero)) {
                throw new NombreFicheroIncorrectoException("Nombre incorrecto: "
                        + fichero);
            }
            else System.out.println("Otra excepción no controlada correctamente");
        }
        return "";
    }

    /**
     *
     * @param nombre
     * @return Verdadero si el nombre es correcto
     */
    public static boolean nombreCorrecto(String nombre)
    {
        //System.out.println(nombre.split("\\.")[0]);
        return (Objects.equals(nombre.split("\\.")[0], "datos"));
    }
}