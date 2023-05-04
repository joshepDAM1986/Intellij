
package com.mycompany;

/**
 *
 * @author Profesor
 */
public class Trabajador extends Persona{
    private String puesto;

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    void prueba()
    {
        Persona p = new Persona();
        p.nombre = "Yo";
        p.nif = "123";
        
        this.nombre = "yo";
        this.nif = "123";
    }
}
