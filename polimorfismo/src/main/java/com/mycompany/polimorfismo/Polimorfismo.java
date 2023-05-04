
package com.mycompany.polimorfismo;

/**
 *
 * @author garci
 */

public class Polimorfismo {

    public static void main(String[] args) {
        Perro p1 = new Perro("Labrador");
        Perro p2 = new Mascota ("Rottweiler","Princeso");
        
        p1.alimentar();
        p2.alimentar();
        
        System.out.println("");
        
        MedioTransporte objMedioTransporte;
        
        objMedioTransporte = new Avion(4);
        objMedioTransporte.getInfo();
        
        System.out.println(objMedioTransporte.getClass().toString());
                ((Avion) objMedioTransporte).getNumMotores();
                
    }
}
