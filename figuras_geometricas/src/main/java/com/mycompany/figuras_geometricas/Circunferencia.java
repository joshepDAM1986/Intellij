
package com.mycompany.figuras_geometricas;

/**
 *
 * @author garci
 */

public class Circunferencia {
    
    // Campos
    Punto punto;
    double radio;
    
    // Constructor de la clase Circunferencia
    public Circunferencia(Punto centro, double radio){
        this.punto = centro;
        this.radio = radio;
    }
     
    // Getter & Setter
    public Punto getCentro() {
        return punto;
    }
    public void setCentro(Punto centro) {
        this.punto = centro;
    }
    public double getRadio() {
        return radio;
    }
    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    // Método para mostrar la información
    void mostrarInformacion(){
        System.out.println("Circunferencia con centro en: ");
        System.out.println(punto.x + ", " + punto.y);
        System.out.println("Radio: " + radio);
    }
}
