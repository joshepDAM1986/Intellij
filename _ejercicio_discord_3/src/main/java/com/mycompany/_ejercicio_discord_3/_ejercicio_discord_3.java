
package com.mycompany._ejercicio_discord_3;
import java.util.*;

/**
 *
 * @author garci
 */

public class _ejercicio_discord_3 {

    public static void main(String[] args) {
        List<Producto>productos=new ArrayList();
        
        Libro libro1= new Libro("El principito",15.99,"Antoine de Saint");
        Libro libro2= new Libro("El principito2",20.99,"Antoine de Saint2");
        productos.add(libro1);
        productos.add(libro2);
        
        System.out.println(productos);
        
        libro1.aplicarDescuento(50);
        libro2.aplicarDescuento(10);
        
         System.out.println(productos);
         
    }
}
