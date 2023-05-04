
package com.mycompany.curso;

/**
 *
 * @author damci
 */

public class Curso {

    public static void main(String[] args) 
    {
        Alumno a1=new Alumno("Juan","Lopez",8);
        Alumno a2=new Alumno("Maria","Sanchez",9);
        Alumno a3=new Alumno("Juana","Ruiz",8.5);
        
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a3.toString());
        
        System.out.println("");
        System.out.println("El númro total de alumnos es "+Alumno.getnAlumnos());
        System.out.println("La media total de la clase es "+Alumno.getmTotal());
    }
}
