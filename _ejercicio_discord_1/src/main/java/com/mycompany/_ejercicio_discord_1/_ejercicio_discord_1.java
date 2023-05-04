
package com.mycompany._ejercicio_discord_1;

import java.util.Scanner;

/**
 *
 * @author garci
 */

public class _ejercicio_discord_1 {

    public static void main(String[] args) {
        String colorCuadrado;
        double ladoCuadrado;
        
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduzca el color del cuadrado: ");
        colorCuadrado=sc.nextLine();
        System.out.println("Introduce el valor del lado del cuadrado");
        ladoCuadrado= sc.nextDouble();
        
        Cuadrado c1= new Cuadrado(colorCuadrado,ladoCuadrado);
        
        System.out.println("El color del cuadrado es "+c1.getColor());
        System.out.println("El valor del cuadrado es "+c1.calcularArea());
    }
}
