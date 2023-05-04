
package com.mycompany.examen_tienda;

/**
 *
 * @author garci
 */

public class Examen_tienda 
{

    public static void main(String[] args) 
    { 
        Tienda p1=new Tienda("Impresora HP",100,5,21);
        Tienda p2=new Tienda("Ratón Logitech");
        Tienda p3=new Tienda("Libro Java",20,15,4);
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());

        System.out.println("Cantidad de productos total a la venta: "+ Tienda.getnProductos());
        
        p2.setPrecio(12);
        Tienda.setBlackFriday(10);
        Tienda.setnProductosCont(1);
        
        System.out.println("-------------------------------------------");
        System.out.println("Comienzo del Black Friday");
        System.out.println("-------------------------------------------");
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());

        System.out.println("Cantidad de productos total a la venta: "+Tienda.getnProductos());
    }
}
