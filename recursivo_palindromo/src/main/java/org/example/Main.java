package org.example;

    public class Main {

        public static void main(String[] args) {
            String texto = "luz azul";
            texto = texto.replaceAll(" ", "");
            texto = texto.replaceAll("á", "a");
            texto = texto.toLowerCase();
            System.out.println(texto.trim());
            System.out.println("resultado:" + Palabra.palindromo(texto));
        }
    }