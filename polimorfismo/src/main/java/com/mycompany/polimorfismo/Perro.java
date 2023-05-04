
package com.mycompany.polimorfismo;

/**
 *
 * @author garci
 */

public class Perro {
    private String raza;

    public Perro(String raza) {
        this.raza = raza;
    }
    
    public void alimentar(){
        System.out.println("Un perro de raza " + raza + " está comiendo pienso");
    }
}
