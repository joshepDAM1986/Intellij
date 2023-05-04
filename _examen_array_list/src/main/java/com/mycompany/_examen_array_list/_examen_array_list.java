
package com.mycompany._examen_array_list;
import java.util.*;

/**
 *
 * @author garci
 */

public class _examen_array_list {

    public static void main(String[] args) {
        ListaPersonas lista = new ListaPersonas();

        Persona p1 = new Persona("Carmen", "López", "11111A");
        Persona p2 = new Persona("Pedro", "Ruiz", "22222B");
        Persona p3 = new Persona("Luisa", "Pérez", "33333C");
        Persona p4 = new Persona("Pablo", "Sánchez", "44444D");

        lista.añadirPersona(p1);
        lista.añadirPersona(p2);
        lista.añadirPersona(p3);
        lista.añadirPersona(p4);

        System.out.println("Listado de personas:");
        lista.listar();

        System.out.println("\nBuscando persona con NIF 33333C:");
        Persona p = lista.buscarPersona("33333C");
        if (p != null) {
            System.out.println(p.getNombre() + " " + p.getApellidos() + " " + p.getNif());
        } else {
            System.out.println("Persona no encontrada");
        }

        System.out.println("\nBuscando persona con NIF 55555E:");
        p = lista.buscarPersona("55555E");
        if (p != null) {
            System.out.println(p.getNombre() + " " + p.getApellidos() + " " + p.getNif());
        } else {
            System.out.println("Persona no encontrada");
        }
    }
}