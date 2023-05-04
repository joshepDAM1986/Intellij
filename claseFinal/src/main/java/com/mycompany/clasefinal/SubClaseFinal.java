
package com.mycompany.clasefinal;

/**
 *
 * @author garci
 */

public class SubClaseFinal extends Clase_Final {
    final double PI=3.14;


    public void metodoEjemplo(){
        // super.metodoEjemplo();
        System.out.println("En subclase final "
        + this.cad);
        super.metodoEjeplo();
    }
    
    public void metodoFinal(String cadena){
        System.out.println("Sobrecargado: "+ cadena);
    }
    
}
