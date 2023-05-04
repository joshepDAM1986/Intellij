
package com.mycompany._ejercicio_discord_1;

/**
 *
 * @author garci
 */

public abstract class Figura {
    
    //Propiedades
    private String color;

    public Figura(String color) {
        this.color = color;
    }

    //Getter para obtener el color
    public String getColor() {
        return color;
    }

    //Metodos
    public abstract double calcularArea();
 
}





