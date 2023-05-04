
package com.mycompany.interfaz_animales;

/**
 *
 * @author garci
 */

public class Mono implements IAnimal, IEvolucion {
    private String nombre;
    private int nBrazos;

    public Mono(String nombre, int nBrazos) {
        this.nombre = nombre;
        this.nBrazos = nBrazos;
    }
    
        public void trepar(int x,int y, int z) {
        mover(x, y);
        System.out.println(" y trepar a " + z);
    }
    
    @Override
    public void mover(int x, int y) {
        System.out.println("El mono se mueve a " + x + " , " + y);
    }

    @Override
    public void comer(int cantidad) {
        System.out.println("El mono come " + cantidad + " gramos de platanos");
    }

    @Override
    public String informe() {
        return IAnimal.super.informe()
        +"\n"
        +"Animal: Mono\n" 
        +"Nombre: " +nombre + "\n"
        +"Número de patas: " + nBrazos;
    }
  
    @Override
    public void pensar() {
        System.out.println("El mono piensa en plátanos"); 
    }
    
    @Override
    public void hablar() {
      System.out.println("El mono hace uh uh");
      
     }
    
}
