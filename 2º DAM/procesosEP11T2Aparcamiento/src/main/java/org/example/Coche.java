package org.example;

class Coche implements Runnable {
    private int matricula;
    private Aparcamiento aparcamiento;

    public Coche(int matricula, Aparcamiento aparcamiento) {
        this.matricula = matricula;
        this.aparcamiento = aparcamiento;
    }

    @Override
    public void run() {
        try {
            // Coche intenta entrar al aparcamiento
            aparcamiento.entrar(matricula);

            // Simular tiempo de permanencia en el aparcamiento (10 a 20 segundos)
            Thread.sleep((int) (Math.random() * 11000) + 10000);

            // Coche sale del aparcamiento
            aparcamiento.salir(matricula);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}