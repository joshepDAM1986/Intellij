
package com.mycompany;

/**
 *
 * @author Profesor
 */
public class Visibilidad {

    public static void main(String[] args) {
       Persona p = new Persona();
       p.nombre = "Jose";
       p.nif = "1234";
       
       Integer valor = 9;
       String c ="Hola";
       
       prueba(valor);
       prueba(c);
       prueba(p);
       
       System.out.println(valor);
       System.out.println(c);
       System.out.println(p.nombre);
       
    }
    static void prueba (Integer num)
    {
        num = 14;
    }
    
    static void prueba (String cad)
    {
        cad = "adios";
    }
    
    static void prueba (Persona par)
    {
        par.nombre = "Enrique";
        par.nif = "4321";
    }
    
    
}
