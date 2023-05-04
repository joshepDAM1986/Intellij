
package com.mycompany.interfaces;

/**
 *
 * @author garci
 */

public class Tren implements Operable{
    private String id;
    private int velocidad;

     //Constructor
    public Tren(String id, int velocidad) {
        this.id = id;
        this.velocidad = velocidad;
    }

    @Override
    public String getIdVehicule() {
    return ("Tren con ID"+id);    }

    @Override
    public void acelerar() {
    velocidad++;    }

    @Override
    public void frenar() {
    velocidad--;    }

    //Getter velocidad
    public int getVelocidad() {
        return velocidad;
    }
    
    public void resumirMetodosTren() {
        System.out.println("getVelocidad");
        Operable.resumirMetodosInterface();
    }

}
       
        