package salacine;


import java.io.Serializable;

public class Pelicula implements Serializable {

    private static final long serialVersionUID=48658446588645464L;
    private String nombre,genero;
    private double recaudacion;
    private int duracion;

    public Pelicula(String nombre, String genero,int duracion, double recaudacion) {
        this.nombre = nombre;
        this.genero = genero;
        this.recaudacion = recaudacion;
        this.duracion = duracion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getRecaudacion() {
        return this.recaudacion;
    }

    public void setRecaudacion(double recaudacion) {
        this.recaudacion = recaudacion;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    public String toString(){
        String res="";
        
        res="-----------------------------\n"+
            "Nombre: "+this.nombre+"\n"+
            "Genero: "+this.genero+"\n"+
            "Duracion: "+this.duracion+" minutos\n"+
            "Recaudacion: "+this.recaudacion+" millones de dolares\n";
        
        return res;
    }
}
