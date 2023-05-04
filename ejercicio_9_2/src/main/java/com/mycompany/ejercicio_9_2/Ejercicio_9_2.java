

package com.mycompany.ejercicio_9_2;

/**
 *
 * @author garci
 */

import java.util.HashMap;

public class Ejercicio_9_2 {

    public static void main(String[] args) {
        Clientes c1= new Clientes("Jose","Garcia","12345678A");
        Clientes c2= new Clientes("Enrique","Lapalma","87654321B");
        
        Producto p1= new Producto("Tornillo 11", "Estrella", "3123",.1);
        Producto p2= new Producto("Tornillo 31", "Plano", "2332",.1);
        Producto p3= new Producto("Destornillador Lujo", "Mixto", "2346",.4);
        
       Pedido pd1=new Pedido("1",c1);
        pd1.addArticulos(p1,100);
        pd1.addArticulos(p2,100);
        pd1.addArticulos(p3,2);
       
       Pedido pd2=new Pedido("2",c2);
        pd2.addArticulos(p3,10);
        pd2.addArticulos(p1,100);
        pd2.addArticulos(p3,2);
       
       Cola c = new Cola();
        c.encolar(pd2);
        c.encolar(pd1);
       
       Pedido atendido = c.desencolar();
        System.out.println("Próximo cliente");
       System.out.println(atendido.getClientes().getNombre()+atendido.getClientes().getApellidos());
       
        System.out.println("Lista Productos");
        HashMap<Producto, Integer> lista = atendido.getArticulos();
        
        for(Producto p:lista.keySet()){
            System.out.println(p.getnSerie());
        }
        
        lista.keySet().forEach((prod) ->{
            System.out.println(prod.getnSerie());
            });
        }
    }
    