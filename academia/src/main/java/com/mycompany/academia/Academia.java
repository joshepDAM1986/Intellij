package com.mycompany.academia;

/**
 *
 * @author damci
 */

public class Academia {

    public static void main(String[] args) 
    {
    Alumno a1=new Alumno ("Carlos", "Lopez", 5, 8, 7);
    Alumno a2=new Alumno ("Marta", "Ruiz", 7, 7, 7);
  
    System.out.println("La nota media de  " +a1.getNombre()+ " es " +a1.notaMedia());
    System.out.println("La nota media de " +a2.getNombre()+ " es " +a2.notaMedia());
    }
}