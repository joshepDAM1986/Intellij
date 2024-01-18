package org.example;

import java.util.Random;
public class Main {
    private static int hojasDeLechuga = 6;
    private static int tomates = 3;
    private static int jamon = 500;
    private static int tiempoTranscurrido = 0;
    public static void main(String[] args) {
        // Crear los trabajadores
        for (int i = 1; i <= 4; i++) {
            Thread worker = new Thread(new Trabajador(i));
            worker.start();
        }
        // Crear el hilo de reposición
        Thread reposicionThread = new Thread(() -> {
            while (true) {
                reposicionarIngredientes();
                try {
                    Thread.sleep(1000); // Reposición cada segundo
                    tiempoTranscurrido++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        reposicionThread.start();
    }
    static class Trabajador implements Runnable {
        private int numeroTrabajador;
        private Random random = new Random();
        public Trabajador(int numeroTrabajador) {
            this.numeroTrabajador = numeroTrabajador;
        }
        @Override
        public void run() {
            while (true) {
                // Trabajar un tiempo aleatorio entre 2 y 4 horas
                int tiempoTrabajo = 2 + random.nextInt(3); // 2, 3, o 4 horas
                trabajar(tiempoTrabajo);
                // Preparar bocadillo
                prepararBocadillo();
                // Mostrar estado actual
                mostrarEstado();
                // Esperar un tiempo antes de repetir el ciclo
                try {
                    Thread.sleep(1000);
                    tiempoTranscurrido++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        private void trabajar(int horas) {
            System.out.println("Trabajador " + numeroTrabajador + " trabaja " + horas + " horas.");
        }
        private void prepararBocadillo() {
            // Verificar si hay suficientes ingredientes
            if (hojasDeLechuga >= 2 && tomates >= 1 && jamon >= 100) {
                // Preparar bocadillo
                hojasDeLechuga -= 2;
                tomates -= 1;
                jamon -= 100;
                System.out.println("Trabajador " + numeroTrabajador + " prepara un bocadillo.");
            } else {
                // No hay suficientes ingredientes, esperar a la reposición
                System.out.println("No hay suficientes ingredientes. Trabajador " + numeroTrabajador +
                        " espera la reposición.");
            }
        }
        private void mostrarEstado() {
            System.out.println("Estado actual: Lechuga=" + hojasDeLechuga +
                    ", Tomates=" + tomates +
                    ", Jamón=" + jamon);
        }
    }
    private static synchronized void reposicionarIngredientes() {
        // Reposicionar lechuga cada 8 segundos
        if (tiempoTranscurrido % 8 == 0) {
            hojasDeLechuga = 6;
            System.out.println("Reposición de hojas de lechuga.");
        }
        // Reposicionar tomates cada 5 segundos
        if (tiempoTranscurrido % 5 == 0) {
            tomates = 3;
            System.out.println("Reposición de tomates.");
        }
        // Reposicionar jamón cada 12 segundos
        if (tiempoTranscurrido % 12 == 0) {
            jamon = 500;
            System.out.println("Reposición de jamón.");
        }
    }
}