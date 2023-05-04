
package com.mycompany._ejercicio_discord_3;

/**
 *
 * @author garci
 */

public abstract class Producto {
     String nombre;
     double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcularPrecio(int cantidad);

    @Override
    public String toString() {
        return "Libro: "+nombre + "\n" + 
                   "Precio: " + precio + "€\n";
    }
}