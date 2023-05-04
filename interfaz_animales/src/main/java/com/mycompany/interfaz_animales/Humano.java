
package com.mycompany.interfaz_animales;

/**
 *
 * @author garci
 */

public class Humano implements IAnimal, IEvolucion {
    private String nombre;

    public Humano(String nombre) {
        this.nombre = nombre;
    }
    
    public void hacerFuego(){
        System.out.println("Hacer fuego");
    }
    
    @Override
    public void mover(int x, int y) {
        System.out.println("El humano se mueve a " + x + " , " + y);
    }

    @Override
    public void comer(int cantidad) {
                System.out.println("El humano come " + cantidad + " gramos de comida");
    }

    @Override
    public String informe() {
        return IAnimal.super.informe()
                +"\n"
                +"Animal: Humano\n" 
                +"Nombre: " +nombre;
    }
    
    @Override
    public void crearHerramientas(){
        IEvolucion.super.crearHerramientas();
        System.out.println("Utiliza herramientas complejas");
    }
    
    @Override
    public void pensar() {
        System.out.println("El humano piensa mucho en todo");
    }

    @Override
    public void hablar() {
        System.out.println("El humano utiliza lenguaje complejo");
    }
    
}
