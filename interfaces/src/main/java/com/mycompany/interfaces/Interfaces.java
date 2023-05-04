
package com.mycompany.interfaces;

/**
 *
 * @author garci
 */

public class Interfaces {

    public static void main(String[] args) {
       Tren t = new Tren("0,13",0);
       Bicicleta b =new Bicicleta("Josele",0);
       
       System.out.println(t.getIdVehicule());
       System.out.println("Velocidad: "+t.getVelocidad());
       
       //Bucle for de incremento de velocidad hasta 20
       for(int i=0;i<20;i++)
            t.acelerar();
       
       //Mostramos por pantalla la velocidad
        System.out.println("Velocidad: "+t.getVelocidad());
        t.imprimirUbicacionGeografica();
        t.resumirMetodosTren();
        
        System.out.println(b.getIdVehicule());
        System.out.println("Velocidad: "+b.getVelocidad());
        
        //Bucle for de incremento de velocidad hasta 20
        for(int i=0;i<20;i++)
        b.acelerar();
        b.getVelocidad();
        
        //Mostramos por pantalla la velocidad
        System.out.println("Velocidad: "+ b.getVelocidad());
        b.imprimirUbicacionGeografica();
        b.resumirMetodosBicicleta();
    }
}
