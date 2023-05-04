
package com.mycompany.interfaz_animales;

/**
 *
 * @author garci
 */

public interface IEvolucion {
    public void hablar();
    public void pensar();
    
    default public void crearHerramientas(){
        System.out.println ("El mono es capaz de hacer rama");
    }
    
}
 

