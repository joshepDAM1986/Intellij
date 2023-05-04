
package com.mycompany.curso;

/**
 *
 * @author damci
 */
         
public class Alumno 
{
    private String nombre;
    private String apellidos;
    private double notaMedia;
    
    private static int nAlumnos=0;
    private static double mTotal=0;
    
    
    public Alumno(String nombre, String apellidos, double notaMedia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.notaMedia = notaMedia;
        nAlumnos++;
        mTotal=(notaMedia +mTotal);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {  
        this.notaMedia = notaMedia;
    }

    public static int getnAlumnos() {
        return nAlumnos;
    }

    public static void setnAlumnos(int nAlumnos) {
        Alumno.nAlumnos = nAlumnos;
    }

    public static double getmTotal() {
        return mTotal/nAlumnos;
    }

    public static void setmTotal(double mTotal) {
        Alumno.mTotal = mTotal;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", notaMedia=" + notaMedia + '}';
    }

}