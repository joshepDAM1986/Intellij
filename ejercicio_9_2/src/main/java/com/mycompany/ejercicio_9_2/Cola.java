
package com.mycompany.ejercicio_9_2;
import java.util.*;

/**
 *
 * @author garci
 */

public class Cola {
    private final LinkedList<Pedido> cola;
    
    public Cola(){
        this.cola=new LinkedList();
    }
    
    public void encolar(Pedido pedido){
        cola.add(pedido);
    }
    public Pedido desencolar(){
         return cola.remove();
    }
}
