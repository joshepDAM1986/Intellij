
package com.mycompany.ejercicio_tema_6.viajero;

import java.util.Scanner;


/**
 *
 * @author damci
 */

public class Viajero {
    private String dni;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private String direccion;
    public static int nViajero=0;
    
    public Viajero(String dni, String nombre, String apellidos, String nacionalidad, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        nViajero++;
    }

    public Viajero() {
        this.dni ="N/A " ;
        this.nombre = "N/A ";
        this.apellidos = "N/A " ;
        this.nacionalidad = "N/A ";
        this.direccion = "N/A ";
        nViajero++;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDirección() {
        return direccion;
    }

    public void setDirección(String direccion) {
        this.direccion = direccion;
    }

  
    public void mostrarLinea(String valor,String formato,Scanner sc){
        System.out.print(valor);
        if (formato.equals("Pausado"))
        sc.nextLine();
    }
    
    public void getInfo(String formato){
        Scanner sc=new Scanner(System.in);
        mostrarLinea(this.dni,formato,sc);
        mostrarLinea(this.nombre,formato,sc);
        mostrarLinea(this.apellidos,formato,sc);
        mostrarLinea(this.nacionalidad,formato,sc);
        mostrarLinea(this.direccion,formato,sc);
        
        //return "DNI: "+dni+" Nombre: "+nombre+" Apellidos: "+apellidos+" Nacionalidad: "+nacionalidad+" Dirección: "+direccion;
    } 
}
