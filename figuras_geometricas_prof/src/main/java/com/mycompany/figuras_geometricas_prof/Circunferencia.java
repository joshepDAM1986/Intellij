
package com.mycompany.figuras_geometricas_prof;

/**
 *
 * @author garci
 */

public class Circunferencia {
    private Recta radio;
    private Punto centro;
    public Circunferencia(Recta radio) {
        this.radio = radio;
        this.centro = radio.getP1();
    }
    public Circunferencia() {
        radio = new Recta();
        this.centro = radio.getP1();
    }
    public Recta getRadio() {
        return radio;
    }
    public void setRadio(Recta radio) {
        this.radio = radio;
    }
    public double calcularArea(){
        return Math.PI * Math.pow(radio.calcularLongitud(), 2);
    }
    @Override
    public String toString() {
        return "Circunferencia (" + "radio=" + radio + ')';
    }
}