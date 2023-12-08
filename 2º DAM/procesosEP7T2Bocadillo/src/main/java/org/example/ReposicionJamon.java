package org.example;

class ReposicionJamon implements Runnable {
    private final Almacen almacen;

    public ReposicionJamon(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (true) {
            almacen.reponerJamon();

            // Dormir durante 12 horas antes de la próxima reposición
            try {
                Thread.sleep(12 * 60 * 60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}