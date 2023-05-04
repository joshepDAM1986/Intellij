
package com.mycompany.figuras_geometricas;

/**
 *
 * @author garci
 */

public class Punto {
    
    // Campos
    public double x;
    public double y;
    
    // Constructor de la clase Punto
    public Punto(double x, double y){
    this.x = x;
    this.y = y;
    }
    
    // Getter & Setter
    public double getX() {
    return x;
    } 
    public void setX(double x) {
    this.x = x;
    } 
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    
    // Método para mostrar la información
    public void mostrarInformacion(){
    System.out.println("Punto: (" + x + ", " + y + ")");
    }
}

