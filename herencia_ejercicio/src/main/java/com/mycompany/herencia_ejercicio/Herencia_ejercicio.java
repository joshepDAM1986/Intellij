
package com.mycompany.herencia_ejercicio;

/**
 *
 * @author garci
 */

/*
Clase Persona
    nombre
    apellidos
    nif solo lectura "getter"
    ciudad - por defecto desconodcida
*/

/*
Clase Empleado
    String categoria
    irpf - por defecto 5%
    departamento por defecto N/A
*/

/*metodo to.String      
    Carlos Lopez         Carlos Lopez
    12345678Z            12345678Z
    Granada              Granada
                         Director
                         Ventas
*/

public class Herencia_ejercicio {

    public static void main(String[] args) {
        
        Persona p1=new Persona("Carlos","López","12345678Z","Granada");
        Persona p2=new Persona("Carmen","Pérez","98765432A");
        
        Empleado em1=new Empleado("Carlos","López","12345678Z","Granada","Director","Ventas");
        Empleado em2=new Empleado("Carmen","Pérez","98765432A","Recursos Humanos");
        
        Empresa empresa=new Empresa();
        
        System.out.println(p1.toString()+"\n");
        System.out.println(p2.toString()+"\n");
        System.out.println(em1.toString()+"\n");
        System.out.println(em2.toString()+"\n");
    
        System.out.println("--------------------------------------------------");
     
        System.out.println(empresa);
        empresa.setDirector(new Empleado("Ana","Ruiz","2234W","Director"));

    }
}
