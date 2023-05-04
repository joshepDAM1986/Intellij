
package com.mycompany.polimorfismo;

/**
 *
 * @author garci
 */

public class Mascota extends Perro {
    private String nombre;

    public Mascota(String raza, String nombre) {
        super(raza);
        this.nombre = nombre;
    }



    @Override
    public void alimentar() {
        System.out.println("La mascota " + nombre + " está comiendo pienso" );
    }
}
