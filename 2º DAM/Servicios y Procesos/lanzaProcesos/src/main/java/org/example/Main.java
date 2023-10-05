package org.example;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        if (args.length <= 0) {
            System.out.println("No se ha indicado ningún comando");
            System.exit(1);
        }

        ProcessBuilder pb = new ProcessBuilder(args);
        pb.inheritIO();

        try {
            Process p = pb.start();
            long tInicio=System.currentTimeMillis();
            int i = 0;
            boolean fin = false;

            while (!fin) {

                if (p.isAlive()) {
                    System.out.printf("Verificación %d: Proceso está vivo.%n", i++);
                    long tActual=System.currentTimeMillis();
                    if ((tActual - tInicio) > 10000){
                        p.destroy();
                        System.out.println("Proceso destruido");
                    }
                } else {
                    System.out.println("Proceso no está vivo.");
                    fin = true;
                }

                if (!fin) {
                    Thread.sleep(3000);
                }
            }
            int codRet = p.exitValue();

            System.out.println("La ejecución de " + Arrays.toString(args) + " devuelve " + codRet);
        } catch (IOException e) {
            System.out.println("Error ejecutando el proceso");
            e.printStackTrace();
            System.exit(2);
        } catch (InterruptedException e) {
            System.out.println("Proceso interrumpido");
            System.exit(3);
        }
        System.exit(0);
    }
}
