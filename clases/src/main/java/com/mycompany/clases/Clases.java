package com.mycompany.clases;


import java.util.Date;

/**
 *
 * @author damci
 */

public class Clases 
{
    
    //Crear Instancias
    
    public static void main(String[] args) 
    {
        System.out.println("Hello World!");
        System.out.println("-----------------------------------------");
        
    Persona p1=new Persona ("123456789A", "Antonio", "Gonzalez", "Sanchez", 45, true);
       
       //p1.setNombre("Pedro");
       //p1.setApellido1("Lopez");
       //p1.setApellido2("Gómez");
       //p1.setNif("123456789A");
       //p1.setEdad(23);
       //p1.setCasado(false);
    
    Persona p2=new Persona ("987654321B", "Carmen", "García", "Rodriguez", 32, false);
       
        //p2.setNombre("Ana");
        //p2.setApellido1("Sánchez");
        //p2.setApellido2("Garcia");
        //p2.setNif("987654321B");
        //p2.setEdad(33);
        //p2.setCasado(true);
        
        //Mostrar en Pantalla
        
        System.out.println("Soy "+p1.getNombre()+" y tengo "+p1.getEdad()+" años"+" y mi DNI es "+p1.getNif());
        if(p1.isCasado()==true)
            System.out.println("Estoy casado");
        else
            System.out.println("No estoy casado");
        
        System.out.println("-----------------------------------------");
        
        System.out.println("Soy "+p2.getNombre()+" y tengo "+p2.getEdad()+" años");
        if(p2.isCasado()==true)
            System.out.println("Estoy casado");
        else
            System.out.println("No estoy casado");
        
        System.out.println("-----------------------------------------");
        
        System.out.println("Nombre: "+p2.getNombre()+" "+p2.getApellido1()+" "+p2.getApellido2());
        System.out.println("Edad: "+p2.getEdad());
        System.out.println("NIF: "+p2.getNif());
        
        System.out.println("-----------------------------------------");
        
        System.out.println(p1.saludar());
    }
}