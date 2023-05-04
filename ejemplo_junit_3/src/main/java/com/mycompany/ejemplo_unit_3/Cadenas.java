
package com.mycompany.ejemplo_unit_3;

/**
 *
 * @author garci
 */

// metodo invertir(hola)
// return aloh

public class Cadenas {

public static String InvertirCadena(String cadena) {
        String cadenaInvertida = "";
        for (int i = cadena.length() - 1; i >= 0; i--)
       cadenaInvertida +=  cadena.charAt(i);
       return cadenaInvertida;  
    }
   
   // metodo cadena H+1A+1L+1 ASCI 
   // return IBM
       
public String sumarLetras(String cadena) {
        String resultado = "";
        for (int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i);
            int cAscii= letra;
            cAscii++;
            resultado += (char)cAscii;
        }
        return resultado;
    }
 }
