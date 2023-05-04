
//Crear un programa que gestione la info de alumnos de un colegio
//Datos a almacenar:
//- nombre String hasta 30 caracteres
//- apellidos String hasta 30 caracteres
//- edad byte
//El programa debe:
//- Añadir, eliminar alumnos
//- Modificar datos ya añadidosç
//- informacion debe ser persistente
//- crear listado ordenado por alta.

package com.mycompany.base_datos_alumnado;

/**
 *
 * @author garci
 */

public class Base_datos_alumnado {

    public static void main(String[] args) {
        //Datos.fileWriter();
        Alumno a1= new Alumno("Josele", "Garcia", (byte) 37);
        a1.toString();
    }
}
