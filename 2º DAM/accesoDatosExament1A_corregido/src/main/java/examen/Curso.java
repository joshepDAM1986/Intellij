package examen;

import java.io.Serializable;

public class Curso implements Serializable {
    public final static long serialVersionUID=123456787456545L;
    private String nombre,modalidad;
    private double precio;
    private int matriculados;

    public Curso(String nombre, String modalidad,int matriculados,double precio) {
        this.nombre = nombre;
        this.modalidad = modalidad;
        this.precio = precio;
        this.matriculados = matriculados;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModalidad() {
        return this.modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getMatriculados() {
        return this.matriculados;
    }

    public void setMatriculados(int matriculados) {
        this.matriculados = matriculados;
    }
    
    public String toString(){
        String res="";
        
        res="###########################\n"+
            "Nombre:"+this.nombre+"\n"+
            "Modalidad:"+this.modalidad+"\n"+
            "Matriculados:"+this.matriculados+" alumnos\n"+
            "Precio:"+this.precio+" euros\n";
        
        return res;
    }

}
