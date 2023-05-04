
package com.mycompany.persona_alumno_trabajador;

/**
 *
 * @author garci
 */

import java.util.Date;

public class Profesor extends Trabajador{
    private String departamento;
    public Profesor(String dni, String nombre, String apellido1, String apellido2, Date fechaNacimiento, int nrp, String departamento) {
        super(dni, nombre, apellido1, apellido2, fechaNacimiento, nrp);
        this.departamento = departamento;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}