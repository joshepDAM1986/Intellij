package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca una cadena de texto: ");
        String sc = scanner.nextLine();

        System.out.print("Introduzca la posición de un caracter en la cadena: ");
        int charPosicion = scanner.nextInt();

        try {
            char posicionElegida = sc.charAt(charPosicion);
            System.out.println("El caracter en la posición " + charPosicion + " es: " + posicionElegida);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: la posición " + charPosicion + " es inválida para la cadena de texto.");
        }
    }
}
