
package com.mycompany.examen_entornos;

/**
 *
 * @author garci
 */

public class TDDS {
    
    public int suma(int a, int b) {
        return a + b;
    }
    
    public float division(float a, float b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return a / b;
        }

     public String mayorDeEdad(int edad) {
        if (edad < 18) {
            return "Es menor de edad";
        } else {
            return "Es mayor de edad";
        }
    }
     
    public String ofuscar (String cadena) {
        // Lógica de ofuscación
        String resultado = "";
        for (int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i);
            int cAscii= letra;
            cAscii++;
            resultado += (char)cAscii;
        }
        return resultado;
    }
    
    public String conE(String cadena){
        if(cadena.length() > 10){
            throw new IllegalArgumentException("No se puede introducir cadenas 10 o más caracteres.");
        }
        else
        {
            cadena = cadena.replaceAll("[aeiouAEIOU]", "e");
        }
        return cadena;
        }
    
/*
    public String[] invertirParte(String[] cadena) {
        String [] frutas ={"piña","pera","platano","kiwi"};
        String[] frutas2= new String[frutas.length];
        frutas2 [0]= frutas[0];
        int j=1;
        for(int i=frutas.length-1;i>0;i--){
            frutas2[j]=frutas[i];
            j++;
        }
   }
    
*/
    
}

     
    





