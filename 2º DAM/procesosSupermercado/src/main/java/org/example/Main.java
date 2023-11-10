package org.example;

public class Main {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2,2,1,5,2,3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1,3,5,1,1});

        Caja caj1=new Caja("Pedro");
        Caja caj2=new Caja("Ana");

        //Tiempo referencia
        long tiempoInicial= System.currentTimeMillis();

        caj1.procesarCompra(cliente1, tiempoInicial);
        caj2.procesarCompra(cliente2, tiempoInicial);

        //Hilos
        Thread cajH1=new Thread(new Caja2("Pedro",
                cliente1, tiempoInicial));
        Thread cajH2=new Thread(new Caja2("Ana",
                cliente2, tiempoInicial));

        cajH1.start();
        cajH2.start();
    }
}