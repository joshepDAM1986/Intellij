package org.example;

public class Persona implements Runnable{
        private final String nombre;
        private final Almacen almacen;

        public Persona(String nombre, Almacen almacen) {
            this.nombre = nombre;
            this.almacen = almacen;
        }

        @Override
        public void run() {
            while (true) {
                int hojasLechugaConsumidas = 2;
                int tomatesConsumidos = 1;
                int jamonConsumido = 100;

                // Consumir ingredientes
                almacen.consumirIngredientes(hojasLechugaConsumidas, tomatesConsumidos, jamonConsumido);

                // Preparar bocadillo
                System.out.println(nombre + " está preparando un bocadillo...");

                // Simular tiempo de trabajo antes de preparar otro bocadillo
                try {
                    Thread.sleep((int) (Math.random() * 721) + 240);  // Entre 240 y 960 minutos (4 a 16 horas)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}