
package com.mycompany.interfaz_maquinaria;

/**
 *
 * @author garci
 */

public interface IMaquinaria {
    public void encender();
    public void apagar();
    
    default  public String caracteristicas (){
        return  ("Ficha de la máquina");
    }
}
