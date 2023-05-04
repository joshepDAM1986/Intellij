
//MAIN

package com.mycompany.examen_clase;

/**
 *
 * @author garci
 */

public class Examen_clase {

    public static void main(String[] args) 
    {
        Alumno a1=new Alumno("Pedro","DAW");
        Alumno a2=new Alumno("Ana","DAW");
        Alumno a3=new Alumno("Carmen","DAM",8.5f);
        
        a1.setCiclo("DAM");
        a1.setMedia(7.3f);
        
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a3.toString());
    }      
}
