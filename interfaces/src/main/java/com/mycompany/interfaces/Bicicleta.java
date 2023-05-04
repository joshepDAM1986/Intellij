
package com.mycompany.interfaces;

/**
 *
 * @author garci
 */

public class Bicicleta implements Operable {
    private String nombre;
    private double pedaleo;

    public Bicicleta(String nombre, double pedaleo) {
        this.nombre = nombre;
        this.pedaleo = pedaleo;
    }

   

    @Override
    public void acelerar() {
    pedaleo+=0.1; 
    
    }

    @Override
    public void frenar() {
    pedaleo-= 0.1;

    }

    public double getVelocidad() {
        return pedaleo;
    }

    public void resumirMetodosBicicleta(){
        System.out.println("getPedaleo");
        Operable.resumirMetodosInterfaceBicicleta();
    }

    @Override
    public String getIdVehicule() {
        return ("Nombre del ciclista: "+nombre);       }

    
}


