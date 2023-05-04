
package com.mycompany._ejercicio_discord_3;

/**
 *
 * @author garci
 */

public class Libro extends Producto implements IProductoDescuento {
     private String autor;

    public Libro(String nombre, double precio, String autor) {
        super(nombre, precio);
        this.autor = autor;
    }

    @Override
    public double calcularPrecio(int cantidad) {
        return precio * cantidad;
    }

    @Override
    public void aplicarDescuento(double descuento) {
        precio -= (precio * descuento)/100;
    }

    @Override
    public String toString() {
        return super.toString() + "Autor:  " + autor +"\n";
    }
}