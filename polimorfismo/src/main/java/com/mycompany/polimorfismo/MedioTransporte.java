
package com.mycompany.polimorfismo;

/**
 *
 * @author garci
 */

interface MedioTransporte {
    default public void getInfo()
    {
        System.out.println("MedioTransporte");
    }   
}
    

