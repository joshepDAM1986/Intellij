
package com.mycompany.persona_alumno_trabajador;

/**
 *
 * @author garci
 */

import java.util.Date;
public class Trabajador extends Persona {
    protected int nrp;
    public Trabajador(String dni, String nombre, String apellido1, String apellido2, Date fechaNacimiento, int nrp) {
        super(dni, nombre, apellido1, apellido2, fechaNacimiento);
        this.nrp = nrp;
    }
    public int getNrp() {
        return nrp;
    }
    public void setNrp(int nrp) {
        this.nrp = nrp;
    }
}