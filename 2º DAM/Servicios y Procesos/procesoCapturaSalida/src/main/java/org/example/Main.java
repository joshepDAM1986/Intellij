package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        if (args.length <= 0) {
            System.out.println("Debe indicarse un comando a ejecutar.");
            System.exit(1);
        }

        ProcessBuilder pb = new ProcessBuilder(args);
        try {
            Process p = pb.start();
            try (Stream<String> lines = new BufferedReader(new InputStreamReader(p.getInputStream())).lines()) {
                int codRet = p.waitFor();
                System.out.println("La ejecución de " + Arrays.toString(args)
                        + " devuelve " + codRet
                        + " " + (codRet == 0 ? "(ejecución correcta)" : "(ERROR)"));
                System.out.println("Salida del proceso");
                System.out.println("------------------");
                lines.forEach(System.out::println);
                System.out.println("-------------------");
            }
        } catch (IOException e) {
            System.err.println("Error durante la ejecución del proceso");
            System.err.println("Información detallada");
            System.err.println("-------------------");
            e.printStackTrace();
            System.err.println("-------------------");
            System.exit(2);
        } catch (InterruptedException ex) {
            System.err.println("Proceso Interrumpido");
            System.exit(3);
        }
    }
}