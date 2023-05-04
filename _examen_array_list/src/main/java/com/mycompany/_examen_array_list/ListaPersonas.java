
package com.mycompany._examen_array_list;

/**
 *
 * @author garci
 */

import java.util.ArrayList;

public class ListaPersonas {
    private ArrayList<Persona> personas;

    public ListaPersonas() {
        personas = new ArrayList<Persona>();
    }

    public void añadirPersona(Persona p) {
        personas.add(p);
    }

    public void listar() {
        for (Persona p : personas) {
            System.out.println(p.getNombre() + " " + p.getApellidos() + " " + p.getNif());
        }
    }

    public Persona buscarPersona(String nif) {
        for (Persona p : personas) {
            if (p.getNif().equals(nif)) {
                return p;
            }
        }
        return null;
    }
}
