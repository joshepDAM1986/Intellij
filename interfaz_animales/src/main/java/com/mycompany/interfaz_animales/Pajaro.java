
package com.mycompany.interfaz_animales;

/**
 *
 * @author garci
 */

//-metodos
//metodo piar()
//metodo volar()

//informe()

//-atributos
//String color verde

public class Pajaro implements IAnimal {
    private String nombre;
    private String color;

    public String getColor() {
        return color;
    }

    public Pajaro(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }
 
    public void piar(){
        System.out.println("El pájaro hace pio pio");
    }
    
    public void volar(){
        System.out.println("El pájaro puede volar");
    }

    @Override
    public void mover(int x, int y) {
        System.out.println("El pájaro se mueve a la posición " + x + " , "  + y);
    }

    @Override
    public void comer(int cantidad) {
        System.out.println("El pájaro come " + cantidad + " gramos de alpiste");
    }

    @Override
    public String informe() {
        return IAnimal.super.informe()
        +"\n"
        +"Animal: Perro\n" 
        +"Nombre: " +nombre + "\n"
        + "Color:" + color;
    }
    
}
