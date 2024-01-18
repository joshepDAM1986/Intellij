package org.examenProcesos2;

import java.util.Random;

class Coche implements Runnable {

    private final Parking parking;
    private final String matricula;

    private final int MIN_TIEMPO_APARCADO = 10000;
    private final int MAX_TIEMPO_APARCADO = 20000;

    Coche(Parking parking, String matricula) {
        this.parking = parking;
        this.matricula = matricula;
    }

    @Override
    public void run() {
        int plaza = -1;

        System.out.printf("># Coche con matrícula %s intenta entrar.\n", this.matricula);

        // Espera para conseguir plaza
        while (plaza < 0) {
            plaza = parking.getPlazaLibre(matricula);
        }

        System.out.printf("_ Coche con matrícula %s aparca en plaza %d.\n", matricula, plaza);

        // Entra en parking y espera para salir un tiempo aleatorio.
        Random r = new Random();
        int tiempoAparcado = this.MIN_TIEMPO_APARCADO
                + r.nextInt(MAX_TIEMPO_APARCADO - MIN_TIEMPO_APARCADO);
        try {
            System.out.printf("Coche con matrícula %s va a permanecer en plaza %d durante %d ms.\n", matricula, plaza, tiempoAparcado);
            Thread.sleep(tiempoAparcado);
        } catch (InterruptedException ex) {
            System.out.printf("Interrupción mientras coche con matrícula %s está aparcado en plaza %d.\n", this.matricula, plaza);
        }

        // Abandona parking
        synchronized (this.parking) {
            parking.salir(plaza);
            System.out.printf("< Coche con matrícula %s abandona el parking, estaba en plaza %d.\n", matricula, plaza);
        }

    }

}