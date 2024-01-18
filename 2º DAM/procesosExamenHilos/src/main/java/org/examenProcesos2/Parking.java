package org.examenProcesos2;

class Parking { // Objeto compartido entre los hilos

    private final int numPlazas;
    private final String[] plazasOcupadas; // Para cada una se guarda la matrícula

    public Parking(int numPlazas) {
        this.numPlazas = numPlazas;
        this.plazasOcupadas = new String[numPlazas];
    }

    /**
     * @return Devuelve número de plaza libre, o -1 si no hay ninguna libre.
     */
    public synchronized int getPlazaLibre(String matricula) {
        int result = -1;
        for (int i = 0; i < numPlazas && result < 0; i++) {
            if (plazasOcupadas[i] == null) {
                result = i + 1;
                plazasOcupadas[i] = matricula;
            }
        }

        if (result < 0) {
            try {
                System.out.printf("[##] Coche con matrícula %s debe esperar a que quede alguna plaza libre.\n", matricula);
                wait();
            } catch (InterruptedException ex) {
                System.out.printf("Interrupción mientras %s espera plaza libre.\n", matricula);
            }
        }

        return result;
    }

    /**
     * @param plaza
     */
    public synchronized void salir(int plaza) {
        plazasOcupadas[plaza - 1] = null;
        notify(); // Notificar a los coches que están esperando una plaza
    }
}