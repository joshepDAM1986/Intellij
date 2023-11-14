package org.example;

import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class NumeroOculto {
    private int numeroOculto;
    private boolean juegoTerminado;
    private Set<Integer> numerosPropuestos;

    public NumeroOculto() {
        // Constructor: inicializa el número oculto y las variables de estado
        Random random = new Random();
        this.numeroOculto = random.nextInt(101); // Número aleatorio entre 0 y 100
        this.juegoTerminado = false;
        this.numerosPropuestos = new HashSet<>();
    }

    public synchronized int propuestaNumero(int num) {
        // Método para realizar una propuesta de número
        if (juegoTerminado) {
            return -1; // El juego ya ha terminado
        } else if (num == numeroOculto) {
            juegoTerminado = true;
            return 1; // Número correcto
        } else if (numerosPropuestos.contains(num)) {
            return 0; // Número repetido
        } else {
            numerosPropuestos.add(num);
            return 2; // Número propuesto correctamente y no repetido
        }
    }

    public synchronized boolean isJuegoTerminado() {
        // Método para verificar si el juego ha terminado
        return juegoTerminado;
    }
}