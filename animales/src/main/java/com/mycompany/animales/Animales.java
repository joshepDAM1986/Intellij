
package com.mycompany.animales;

/**
 *
 * @author garci
 */

public class Animales {

    public static void main(String[] args) {
        Perro Rex=new Perro ("Perro","Rex",3,"Pastor Alemán",4,true,001);
        Gato Garfield=new Gato("Gato","Garfield",2,"Siamés",4,true,002);
        Ave Piolin=new Ave("Ave","Piolín",1,"Canario",2,2);  
        
        System.out.println(Rex.toString());
        System.out.println(Garfield.toString());
        System.out.println(Piolin.toString());
    }

}