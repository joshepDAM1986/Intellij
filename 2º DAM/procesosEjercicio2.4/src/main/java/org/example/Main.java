package org.example;

//    Un hilo debe generar un número al azar entre cero y cien, que deben intentar adivinar otros diez hilos. Si un hilo
//    acierta el número, debe terminar su ejecución inmediatamente. Y el resto de los hilos deben también terminar su
//    ejecución en cuanto propongan un número y se les avise de que otro hilo ya ha acertado el número.
//    Se propone utilizar una clase NumeroOculto con un método int propuestaNumero (int num) que devuelva los
//    siguientes valores:
//
//    a) - 1 si el juego ya ha terminado porque un hilo ha adivinado el número. b) 1 si el número propuesto (num) es el
//    número oculto.
//    c) O en otro caso.
//    No hace falta crear una clase para el hilo que genera el número al azar. Es el hilo inicial, que ejecuta el método
//    main, y que crea el resto de los hilos.

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NumeroOculto numeroOculto = new NumeroOculto();
        List<Thread> hilos = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread hilo = new Thread(new Hilo(numeroOculto));
            hilos.add(hilo);
            hilo.start();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join(); // Esperar a que cada hilo termine
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("El juego ha terminado, los hilos han sido interrumpidos.");
    }
}



