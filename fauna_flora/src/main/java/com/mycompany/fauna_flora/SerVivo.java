
package com.mycompany.fauna_flora;

/**
 *
 * @author garci
 */

abstract public class SerVivo {
    protected String nombre_cientifico;
    protected String nombre_comun;
    public String getNombre_cientifico() {
        return nombre_cientifico;
    }
    public void setNombre_cientifico(String nombre_cientifico) {
        this.nombre_cientifico = nombre_cientifico;
    }
    public String getNombre_comun() {
        return nombre_comun;
    }
    public void setNombre_comun(String nombre_comun) {
        this.nombre_comun = nombre_comun;
    }
    
    public abstract void alimentarse();
    
}