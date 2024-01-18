package org.examenProcesos2;

import java.util.Random;

public class Main {
        public static void main(String[] args) {

            Parking parking = new Parking(50); // Parking para 50 coches

            Random r = new Random();

            int tMinParaEntradaCoche = 100;
            int tMaxParaEntradaCoche = 500;

            System.out.println(">>>>>>>>>>>> Comienza simulación.");

            for (int i = 1;; i++) {

                int tEntradaCoche = tMinParaEntradaCoche + r.nextInt(
                        tMaxParaEntradaCoche - tMinParaEntradaCoche
                );

                try {
                    Thread.sleep(tEntradaCoche);
                } catch (InterruptedException ex) {
                    System.out.printf("Interrumpido proceso principal");
                }

                String matricula = "" + i;
                Thread hiloCoche = new Thread(new Coche(parking, matricula));
                hiloCoche.start();

            }
        }
    }