//CLASS

package com.mycompany.examen_clase;

/**
 *
 * @author garci
 * 
 */

public class Alumno 
{
    private String nombre;
    private String ciclo;
    private float media=1;
    
    //Getter and Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }
    
    //Constructores

    public Alumno(String nombre, String ciclo) {
        this.nombre = nombre;
        this.ciclo = ciclo;
    }

    public Alumno(String nombre, String ciclo, float media) {
        this.nombre = nombre;
        this.ciclo = ciclo;
        this.media = media;
        
        
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", ciclo=" + ciclo + ", media=" + media + '}';
    }
    
}
