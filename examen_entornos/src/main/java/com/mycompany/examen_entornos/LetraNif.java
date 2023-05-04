
package com.mycompany.examen_entornos;

/**
 *
 * @author garci
 */

public class LetraNif {

 public static char calcularLetraDNI(int dni){
    if (dni < 0 || dni > 99999999) {
        throw new IllegalArgumentException();
    }
    String letraDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
    int resto = dni % 23;
    return letraDNI.charAt(resto); 
    }
}
