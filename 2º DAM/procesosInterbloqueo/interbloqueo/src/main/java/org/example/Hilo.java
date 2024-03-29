package org.example;

class Hilo implements Runnable {
    Cuenta cl, c2;
    String nomHilo;
    Hilo (Cuenta c1, Cuenta c2, String nomHilo) {
        this.cl = c1;
        this.c2 = c2;
        this.nomHilo = nomHilo;
    }
    @Override
    public void run() {
        int cantidad = 10;
        int numTransf = 0;
        for (int i = 0; i < 10000; i++) {
            if (GestorTransferencias.transferencia(cl, c2, cantidad)) { numTransf++;
            }
        }
        System.out.printf(
                "**** FIN de %s, %d transferencias hechas de %s a %s.\n", this.getNomHilo(), numTransf, cl.getNumCuenta(), c2.getNumCuenta());
    }
    public String getNomHilo() { return nomHilo;
    }
}