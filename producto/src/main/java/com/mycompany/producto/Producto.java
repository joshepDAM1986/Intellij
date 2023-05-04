
package com.mycompany.producto;

/**
 *
 * @author damci
 */
public class Producto {

    public static int rebajaActual;
    private double precioInicial;

    public Producto(double precio) {
        this.precioInicial = precio;
    }

    public static void infoRebajaActual() {
        System.out.println("La rebaja actual es del " + rebajaActual + "%.");
    }

    public double getPrecioFinal() {
        return precioInicial - (precioInicial * rebajaActual / 100);
    }

    public static void main(String[] args) {
        //Creando 2 productos
        Producto p1 = new Producto(10);
        Producto p2 = new Producto(30);
        infoRebajaActual();
        System.out.println("Precio p1: " + p1.getPrecioFinal());
        System.out.println("Precio p2: " + p2.getPrecioFinal());
        //Primeras rebajas y se decide bajar todos los precios un 25%
        p2.rebajaActual = 25;
        infoRebajaActual();
        System.out.println("Precio p1 primeras rebajas: " + p1.getPrecioFinal());
        System.out.println("Precio p2 primeras rebajas: " + p2.getPrecioFinal());
        //segundas rebajas y se decide bajar todos los precios a la mitad (50%)
        Producto.rebajaActual = 50;
        infoRebajaActual();
        System.out.println("Precio p1 segundas rebajas: " + p1.getPrecioFinal());
        System.out.println("Precio p2 segundas rebajas: " + p2.getPrecioFinal());
    }
}