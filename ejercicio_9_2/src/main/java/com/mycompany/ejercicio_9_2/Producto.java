
package com.mycompany.ejercicio_9_2;

/**
 *
 * @author garci
 */

public class Producto {
    private String nombre;
    private String tipo;
    private String nSerie;
    private double precio;

    public Producto(String nombre, String tipo, String nSerie, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nSerie = nSerie;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getnSerie() {
        return nSerie;
    }

    public void setnSerie(String nSerie) {
        this.nSerie = nSerie;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

   
}
