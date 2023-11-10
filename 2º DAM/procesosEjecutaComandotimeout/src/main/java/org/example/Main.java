package org.example;


import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
public class Main {


    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder(
                new String[]{"cmd.exe", "/k", "java -version"});
        System.out.println("Se ejecuta comando: % s\n"+ Arrays.toString(args));
        pb.inheritIO();
        pb.redirectErrorStream(true);
        int MAX_TIEMPO=5000;
        try {
            Process p = pb.start();
            if (!p.waitFor(MAX_TIEMPO, TimeUnit.MILLISECONDS)) {
                p.destroy();
                System.out.println("AVISO: No ha terminado en "+MAX_TIEMPO+" ms"+"\n");
            }
            else{
                System.out.println("El proceso terminó antes del tiempo estipulado");
                p.destroy();
                p.exitValue();
            }
        } catch (IOException e) {
            System.err.println("Error durante ejecución. Información detallada");
            System.err.println("----------------------------------------------");
            e.printStackTrace();
            System.err.println("----------------------------------------------");
            System.exit(1);
        } catch (InterruptedException ex) {
            System.err.println("Proceso interrumpido");
            System.exit(2);
            }
        System.exit(0);
        }
    }
