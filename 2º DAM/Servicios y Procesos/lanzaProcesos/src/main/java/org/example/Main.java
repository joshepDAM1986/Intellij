package org.example;

import java.io.IOException;
import java.util.Arrays;

public class Main {
//    public static int MAX_TIEMPO = 11;

    public static void main(String[] args) {
        if (args.length <= 0) {
            System.out.println("No se ha indicado ningún comando");
            System.exit(1);
        }

        ProcessBuilder pb = new ProcessBuilder(args);
        pb.inheritIO();

        try {
            Process p = pb.start();
            int i = 0;
            boolean fin = false;
//            int codRet = p.waitFor();

            while (!fin) {
                if (p.isAlive()) {
                    System.out.printf("Verificación %d: Proceso está vivo.%n", i++);
                } else {
                    System.out.println("Proceso no está vivo.");
                    fin = true;
                }

                if (!fin) {
                    Thread.sleep(5000);
                }


            }

//            System.out.println("La ejecución de " + Arrays.toString(args) + " devuelve " + codRet);
        } catch (IOException e) {
            System.out.println("Error ejecutando el proceso");
            e.printStackTrace();
            System.exit(2);
        } catch (InterruptedException e) {
            System.out.println("Proceso interrumpido");
            System.exit(3);
        }
    }
}
