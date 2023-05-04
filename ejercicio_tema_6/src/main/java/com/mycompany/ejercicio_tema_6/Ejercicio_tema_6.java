
package com.mycompany.ejercicio_tema_6;

import com.mycompany.ejercicio_tema_6.viajero.Viajero;
import java.util.Random;

/**
 *
 * @author damci
 */

public class Ejercicio_tema_6 {

    public static void main(String[] args) {
        Random r= new Random();
        
        int n1= r.nextInt(0,10)+1;
        int n2= r.nextInt(0,10)+1;
        System.out.println("n1: "+n1);
        System.out.println("n2: "+n2);
        System.out.println("El numero mayor es: "+Math.max(n1, n2));
        
        Viajero v1=new Viajero("75123456A", "Jose", "Garcia", "Española", "C/Jose");
        Viajero v2=new Viajero();
        
        System.out.println("El número de viajeros es: "+Viajero.nViajero);
        System.out.println("");
        System.out.println("Datos del primer viajero: ");
        v1.getInfo("Pausado");
        System.out.println("");
        System.out.println("Datos del segundo viajero:" );
        v2.getInfo("Normal"); 
    }
}
