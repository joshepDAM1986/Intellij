
package com.mycompany.clasefinal;

/**
 *
 * @author garci
 */

public class ClaseFinal {

    public static void main(String[] args) {
       Clase_Final cf=new Clase_Final();
       
       cf.cad ="Hola";
       cf.metodoEjeplo();
       cf.metodoFinal();
       
       SubClaseFinal scf = new SubClaseFinal();
       scf.cad ="Hola";
       scf.metodoEjemplo();
       scf.metodoFinal();
    }
}
