
package com.mycompany.examen_tienda;

/**
 *
 * @author garci
 */

public class Tienda {

    private String producto;
    private double precio;
    private double descuento;
    private double iva;
    
    static double blackFriday=0;
    static int nProductos;
    static int nProductosCont=1;

    public Tienda(String producto, double precio, double descuento, double iva) {
        this.producto = producto;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        nProductos++;
    }

    public Tienda(String producto) {
        this.producto=producto;
        this.precio = 10;
        this.descuento = 0;
        this.iva = 21;
        nProductos++;
    }

    public static int getnProductos() {
        return nProductos;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public static void setBlackFriday(double blackFriday) {
        Tienda.blackFriday = blackFriday;
    }

    public static void setnProductosCont(int nProductosCont) {
        Tienda.nProductosCont = nProductosCont;
    }

    public double getPrecioFinal(){
        double descuentoElegido = Math.max(descuento, blackFriday);
        double precioDescuento = precio - (precio*(descuentoElegido/100));
        return precioDescuento + (precioDescuento*(iva/100));
    }
    
    @Override
    public String toString() {
        return "Producto " + nProductosCont++ + ": " + producto + ", Precio: " + String.format("%.2f",getPrecioFinal()) + " €";
    }
}
