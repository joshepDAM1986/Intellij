
package com.mycompany._examen_herencia;

/**
 *
 * @author garci
 */

public class _examen_herencia {

    public static void main(String[] args) {

        // Crear lavadoraAEG
        Lavadora lavadoraAEG = new Lavadora(400, "Amarillo limón", 'A', 30, 7);

        // Mostrar atributos de lavadoraAEG
        System.out.println("Atributos de lavadoraAEG:");
        System.out.println("Precio base: " + lavadoraAEG.getPrecioBase());
        System.out.println("Color: " + lavadoraAEG.getColor());
        System.out.println("Consumo energético: " + lavadoraAEG.getConsumoEnergetico());
        System.out.println("Peso: " + lavadoraAEG.getPeso());
        System.out.println("Carga: " + lavadoraAEG.getCarga());
        System.out.println("Precio final: " + lavadoraAEG.precioFinal());

        // Crear tvSamsung
       Television tvSamsung = new Television(190, "Negro", 'P', 10, 24, true);

        // Mostrar atributos de tvSamsung
        System.out.println("\nAtributos de tvSamsung:");
        System.out.println("Precio base: " + tvSamsung.getPrecioBase());
        System.out.println("Color: " + tvSamsung.getColor());
        System.out.println("Consumo energético: " + tvSamsung.getConsumoEnergetico());
        System.out.println("Peso: " + tvSamsung.getPeso());
        System.out.println("Resolución: " + tvSamsung.getResolucion());
        System.out.println("Netflix: " + tvSamsung.isNetflix());
        System.out.println("Precio final: " + tvSamsung.precioFinal());

        // Cambiar el consumo energético de tvSamsung a P
        tvSamsung.setConsumoEnergetico('P');

        // Mostrar atributos actualizados de tvSamsung
        System.out.println("\nAtributos actualizados de tvSamsung:");
        System.out.println("Precio base: " + tvSamsung.getPrecioBase());
        System.out.println("Color: " + tvSamsung.getColor());
        System.out.println("Consumo energético: " + tvSamsung.getConsumoEnergetico());
        System.out.println("Peso: " + tvSamsung.getPeso());
        System.out.println("Resolución: " + tvSamsung.getResolucion());
        System.out.println("Netflix: " + tvSamsung.isNetflix());
        System.out.println("Precio final: " + tvSamsung.precioFinal());
    }

}