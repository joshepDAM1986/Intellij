package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int anio;

        try {
            anio = pedirAnio(scanner);
            System.out.println("Su año de nacimiento es: " + anio);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }

    public static int pedirAnio(Scanner scanner) throws Exception {
        System.out.print("Introduzca su año de nacimiento: ");
        int anioNacimiento = scanner.nextInt();

        if (anioNacimiento < 0) {
            throw new Exception("El año de nacimiento no puede ser negativo");
        }
        else {
            return anioNacimiento;
        }
    }
}