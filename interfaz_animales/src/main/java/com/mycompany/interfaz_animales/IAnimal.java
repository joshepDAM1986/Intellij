
package com.mycompany.interfaz_animales;

/**
 *
 * @author garci
 */

//metodo mover(x, y)
//metodo comer(g)

public interface IAnimal {
       
       public void mover(int x, int y);
       public void comer(int cantidad);
       
      default String informe(){
          return "--------------------------------------------";
    }      

}


