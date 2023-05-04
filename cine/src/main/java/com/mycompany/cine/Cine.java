

package com.mycompany.cine;

/**
 *
 * @author damci
 */

public class Cine 
{
    public static void main(String[] args) 
    {
        Pelicula p1=new Pelicula ("Starwars","George Lucas",1977,"Ciencia Ficción");
        Pelicula p2=new Pelicula ("Interstellar","Cristopher Nola",2017,"Ciencia Ficción");
        Pelicula p3=new Pelicula ("Ciudadano Keane","Orson Wells",1941,"Drama");
        
        System.out.println("Pelicula 1 es: "+p1.getTitulo()+" "+p1.getDirector()+" "+p1.getAño()+" "+p1.getGenero());
        System.out.println("Pelicula 2 es: "+p2.getTitulo()+" "+p2.getDirector()+" "+p2.getAño()+" "+p2.getGenero());
        System.out.println("Pelicula 3 es: "+p3.getTitulo()+" "+p3.getDirector()+" "+p3.getAño()+" "+p3.getGenero());
    }
}
