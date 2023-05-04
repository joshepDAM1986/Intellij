
package com.mycompany._examen_herencia;

/**
 *
 * @author garci
 */

public class Lavadora extends Electrodomestico {
    private double carga;

    public Lavadora() {
        super();
        this.carga = 5;
    }

    public Lavadora(double precioBase, String color, char consumoEnergetico, double peso, int carga) {
    super(precioBase,color ,consumoEnergetico, peso);
    this.carga = (double) carga;
    }

    public double getCarga() {
        return this.carga;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (this.carga > 6) {
            precioFinal += 50;
    }

        return precioFinal;
    }

    @Override
    public String toString() {
        return super.toString() + ", Carga: " + this.carga + " kg";
    }
}
