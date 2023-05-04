

package com.mycompany.fauna_flora;

/**
 *
 * @author garci
 */
public class Fauna_flora {

    public static void main(String[] args) {
    Animal foca = new Animal();
    foca.setNombre_cientifico("Phocidae");
    foca.setNombre_comun("Foca");
    foca.setAltura(1.50f);
    foca.setPeso(60);
    
    System.out.println(foca.toString());
    foca.alimentarse();
    
    System.out.println("");
    
    Vegetal limonero = new Vegetal();
    limonero.setNombre_comun("Limonero");
    limonero.setNombre_cientifico("Citrus limon");
    limonero.setAltura(1.80f);
    
    System.out.println(limonero.toString());
    limonero.alimentarse();   
    
  
  
    }
}