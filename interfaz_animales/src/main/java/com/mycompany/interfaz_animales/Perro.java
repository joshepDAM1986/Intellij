

package com.mycompany.interfaz_animales;

/**
 *
 * @author garci
 */

// -metodos
// metodo ladrar()

//informe() (perro engorda) for peso++? hasta 10kg

//-atributos

//int peso

public class Perro implements IAnimal {
    private String nombre;
    private int peso;

    public Perro(String nombre, int peso) {
        this.nombre = nombre;
        this.peso = peso;
    }
   
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    public void ladrar(){
        System.out.println("El perro hace guau guau");
    }
    
    public void engordar(){
        peso++;
        }

    @Override
    public void mover(int x, int y) {
        System.out.println("El perro se mueve a la posición " + x + " , "  + y);
    }
    @Override
    public void comer(int cantidad) {
    System.out.println("El perro come " + cantidad + " gramos de pienso");
    }

    @Override
    public String informe() {
        return IAnimal.super.informe()
        +"\n"
        +"Animal: Perro\n" 
        +"Nombre: " +nombre + "\n"
        + "Peso: " + peso;
    }
  
}
