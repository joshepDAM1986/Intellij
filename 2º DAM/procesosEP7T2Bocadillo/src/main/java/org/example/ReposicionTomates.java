package org.example;

class ReposicionTomates implements Runnable {
    private final Almacen almacen;

    public ReposicionTomates(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (true) {
            almacen.reponerTomates();

            // Dormir durante 5 horas antes de la próxima reposición
            try {
                Thread.sleep(5 * 60 * 60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}