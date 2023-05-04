package org.example;

public class Palabra {

    public static boolean palindromo(String texto) {
        if (texto.length() == 1) {
            return true;
        } else {
            return texto.charAt(0) == texto.charAt(texto.length() - 1) ? palindromo(texto.substring(1, texto.length() - 1)) : false;
        }
    }
}

