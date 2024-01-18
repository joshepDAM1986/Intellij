package org.examenProcesos1;

import java.util.Arrays;

public class Memoria {
    final public static int ELEMENTOS = 8000;
    private int[] datos = new int[ELEMENTOS];
    private int contador;

    public int  getContador() {
        return contador;
    }
    public Memoria() {
        Arrays.fill(datos, 0);
        contador = 0;
    }

    public void incrementarContador() {
        contador++;
    }

    public int[] getDatos() {
        return datos;
    }

    public void activarDato(int i) {
        datos[i] = 1;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
}