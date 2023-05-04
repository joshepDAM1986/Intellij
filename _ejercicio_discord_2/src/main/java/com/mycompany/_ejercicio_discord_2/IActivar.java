
package com.mycompany._ejercicio_discord_2;

/**
 *
 * @author garci
 */
public interface IActivar {
   public void on();
   public void off();
   
   default  public String fichaTelefono (){
        return  ("Ficha del telefono");
    }
   
}
