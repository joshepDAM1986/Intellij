
package com.mycompany._examen_herencia;

/**
 *
 * @author garci
 */

public class Television extends Electrodomestico {

    private int resolucion;
    private boolean netflix;

    public Television(char cosumoEnergetico) {
        super();
        this.resolucion = 20;
        this.netflix = false;
    }

   public Television(double precioBase, String color, char consumoEnergetico, double peso, int resolucion, boolean netflix) {
    super(precioBase, color, consumoEnergetico, peso);
    this.resolucion = resolucion;
    this.netflix = netflix;
    }

    public int getResolucion() {
        return resolucion;
    }

    public boolean isNetflix() {
        return netflix;
    }

    @Override
    public String toString() {
        return "Television{" +
                "precioBase=" + getPrecioBase() +"\n" +
                ", color='" + getColor() + 
                ", consumoEnergetico=" + getConsumoEnergetico()+
                ", peso=" + getPeso() +
                ", resolucion=" + resolucion +
                ", netflix=" + netflix +
                '}';
    }

    @Override
    public double precioFinal() {
        double precio = super.precioFinal();
        if (resolucion > 20) {
            precio += precio * 0.3;
        }
        if (netflix) {
            precio += 50;
        }
        return precio;
    }
}