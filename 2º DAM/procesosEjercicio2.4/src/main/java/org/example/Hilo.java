package org.example;

import java.util.Random;


public class Hilo implements Runnable {
    private static int contadorHilos = 1;
    private int id;
    private NumeroOculto numeroOculto;

    public Hilo(NumeroOculto numeroOculto) {
        this.numeroOculto = numeroOculto;
        this.id = contadorHilos++;
    }

    @Override
    public void run() {
        while (true) {
            int propuesta = new Random().nextInt(101); // Número aleatorio entre 0 y 100
            int resultado = numeroOculto.propuestaNumero(propuesta);

            if (resultado == 1) {
                System.out.println("Hilo " + id + " ha ganado, acerto el numero " + propuesta);
                break;
            } else if (resultado == -1) {
                System.out.println("Hilo " + id + " ha terminado. porque otro hilo ya ha acerto el numero.");
                break;
            } else if (resultado == 0) {
                // Número repetido, intentar de nuevo
            } else {
                System.out.println("Hilo " + id + " propuso el numero " + propuesta);
            }
        }
    }
}

