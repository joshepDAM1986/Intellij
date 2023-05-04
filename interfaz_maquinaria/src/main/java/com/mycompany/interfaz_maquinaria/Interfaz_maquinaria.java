
package com.mycompany.interfaz_maquinaria;

/**
 *
 * @author garci
 */

public class Interfaz_maquinaria {

    public static void main(String[] args) {
        Domestico d=new Domestico("1234","Bosch 9000");
        System.out.println(d.caracteristicas() + "\n");

        Industrial i=new Industrial("456AWMP90","Siemens M5",100);
        System.out.println(i.caracteristicas());
        
        SuperMaquina s=new SuperMaquina("111","Bosh");
    }
}
