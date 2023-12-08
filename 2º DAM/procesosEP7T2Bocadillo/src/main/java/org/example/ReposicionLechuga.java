package org.example;

class ReposicionLechuga implements Runnable {
    private final Almacen almacen;

    public ReposicionLechuga(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (true) {
            almacen.reponerLechuga();

            // Dormir durante 8 horas antes de la próxima reposición
            try {
                Thread.sleep(8 * 60 * 60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}