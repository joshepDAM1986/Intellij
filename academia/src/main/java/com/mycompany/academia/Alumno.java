package com.mycompany.academia;

public class Alumno 
    {
    private String nombre;
    private String apellidos;
    private float programacion;
    private float lenguajeMarcas;
    private float sistemasInformaticos;
    private float notaMedia;
    
//getter y setter
    


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellidos;
    }

    public void setApellido1(String apellido1) {
        this.apellidos = apellidos;
    }
    
    public float getProgramacion() {
        return programacion;
    }

    public void setProgramacion(float programacion) {
        this.programacion = programacion;
    }

    public float getLenguajeMarcas() {
        return lenguajeMarcas;
    }

    public void setLenguajeMarcas(float lenguajeMarcas) {
        this.lenguajeMarcas = lenguajeMarcas;
    }

    public float getSistemasInformaticos() {
        return sistemasInformaticos;
    }

    public void setSistemasInformaticos(float sistemasInformaticos) {
        this.sistemasInformaticos = sistemasInformaticos;
    }

    public float getNotaMedia() {
        return notaMedia;
    }

    private void setNotaMedia(float NotaMedia) {
        this.notaMedia = NotaMedia;
    }

//Constructores

    public Alumno(String nombre, String apellidos)
        {
        this.nombre=nombre;
        this.apellidos=apellidos;
        }
    
/**
 * @param nombre
 * @param apellidos
 * @param programacion
 * @param lenguajeMarcas
 * @param sistemasInformaticos 
 */

    public Alumno(String nombre, String apellidos, float programacion, float lenguajeMarcas, float sistemasInformaticos)
        {
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.programacion=programacion;
        this.lenguajeMarcas=lenguajeMarcas;
        this.sistemasInformaticos=sistemasInformaticos;
        }
    
   public float notaMedia()
       {
       float resultado=((programacion+lenguajeMarcas+sistemasInformaticos)/3);
       return resultado;
       }
   
}




