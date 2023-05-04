
package com.mycompany._examen_herencia;

/**
 *
 * @author garci
 */

public class Electrodomestico {
    private double precioBase;
    private String color;
    private char consumoEnergetico;
    private double peso;
    private static final String[] coloresDisponibles = {"blanco", "negro", "rojo", "azul", "gris"};
   
    public Electrodomestico() {
        this.precioBase = 100;
        this.color = "blanco";
        this.consumoEnergetico = 'A';
        this.peso = 5;
    }
    
    public Electrodomestico(double precioBase, double peso) {
        this.precioBase = precioBase;
        this.color = "blanco";
        this.consumoEnergetico = 'A';
        this.peso = peso;
    }
    
    public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        setColor(color);
        comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }
    
    public double getPrecioBase() {
        return precioBase;
    }
    
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        String colorLowerCase = color.toLowerCase();
        for (String colorDisponible : coloresDisponibles) {
            if (colorLowerCase.equals(colorDisponible)) {
                this.color = colorLowerCase;
                return;
            }
        }
    }
    
    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }
    
    public void setConsumoEnergetico(char consumoEnergetico) {
        comprobarConsumoEnergetico(consumoEnergetico);
    }
    
    private void comprobarConsumoEnergetico(char letra) {
        if (letra >= 'A' && letra <= 'F') {
            this.consumoEnergetico = letra;
        } 
        else {
            
        this.consumoEnergetico ='A';
    }
}

public double getPeso() {
    return peso;
}

public void setPeso(double peso) {
    this.peso = peso;
}

@Override
public String toString() {
    return "Precio base: " + precioBase + " €\n"
            + "Consumo energético: " + consumoEnergetico + "\n"
            + "Peso: " + peso + " kg\n";
}

public double precioFinal() {
    double precioFinal = precioBase;
    switch (consumoEnergetico) {
        case 'A':
            precioFinal += 100;
            break;
        case 'B':
            precioFinal += 80;
            break;
        case 'C':
            precioFinal += 60;
            break;
        case 'D':
            precioFinal += 50;
            break;
        case 'E':
            precioFinal += 30;
            break;
        case 'F':
            precioFinal += 10;
            break;
    }
    if (peso >= 0 && peso < 20) {
        precioFinal += 10;
    } else if (peso >= 20 && peso < 50) {
        precioFinal += 50;
    } else if (peso >= 50 && peso < 80) {
        precioFinal += 80;
    } else if (peso >= 80) {
        precioFinal += 100;
    }
    return precioFinal;
    }
}