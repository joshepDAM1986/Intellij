
package com.mycompany.cochepersistente;

import java.io.Serializable;

/**
 *
 * @author Profesor
 */

public class Coche implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String modelo;
    private String matricula;
    private String motor;

    public Coche(String modelo, String matricula, String motor) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.motor = motor;
    }
}
