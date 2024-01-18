package org.example1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long tiempoInicial = System.currentTimeMillis();
        Memoria c = new Memoria();
        Modificador e = new Modificador(c);

        System.out.println("Comienzo del proceso de los datos");
        e.run();
        System.out.println(("Contador de datos modificados: " + e.getContador()));
        System.out.println("Finalización del proceso de los datos: "
                + (System.currentTimeMillis() - tiempoInicial)/1000 + " segundos");

        System.out.println(Arrays.toString(c.getDatos()));
        System.out.println(c.getDatos().length);
    }
}
