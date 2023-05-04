
package com.mycompany.cine;

/**
 *
 * @author damci
 */

/*Películas
 * Titulo,director,año,genero
 * 3 instancias de peliculas
 * Starwars, george lucas, 1977,CF
 * Insterestelar, cristopher Nola, 2017,CF
 * Ciudadano Keane, Orson Wells, 1941,DR
 */

public class Pelicula 

{
   private String titulo;
   private String director;
   private int año;
   private String genero;
   
   //getter y setter


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenereo(String genero) {
        this.genero = genero;
    }

    //Constructores

    public Pelicula(String titulo, String director, int año, String genero) 
    {
        this.titulo = titulo;
        this.director = director;
        this.año = año;
        this.genero = genero;
    }
}
    
    

