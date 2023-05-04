
package com.mycompany.agregacion;

/**
 *
 * @author garci
 */
public class Agregacion {

    public static void main(String[] args) {
        Persona p1=new Persona("Carlos","Alonso");
        Persona p2=new Persona("Julia","Alonso",p1);
        Persona p3=new Persona("Carmen","Lopez",new Persona("Pepe","Lopez"));
        p3.getPadre().setNombre("Jose");
        
        String resultado=p3.getPadre().getNombre().substring(2).toUpperCase();
        System.out.println(resultado);

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
    }
}
