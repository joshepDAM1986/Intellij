
package com.mycompany.arreglocreciente;

/**
 *
 * @author garci
 */
import java.util.Scanner;

public class ArregloCreciente {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] arreglo = new int[10];

    // Pedimos al usuario que ingrese los primeros 5 números en orden creciente
    System.out.println("Ingresa los primeros 5 números en orden creciente:");
    for (int i = 0; i < 5; i++) {
      arreglo[i] = sc.nextInt();
    }

    // Pedimos al usuario que ingrese un número adicional que debemos insertar de manera que el arreglo siga siendo creciente
    System.out.println("Ingresa un número adicional:");
    int nuevoNumero = sc.nextInt();

    // Encontramos la posición en la que debemos insertar el nuevo número
    int posicionInsercion = 0;
    while (posicionInsercion < 5 && nuevoNumero > arreglo[posicionInsercion]) {
      posicionInsercion++;
    }

    // Hacemos espacio para el nuevo número moviendo todos los elementos hacia la derecha
    for (int i = 4; i >= posicionInsercion; i--) {
      arreglo[i + 1] = arreglo[i];
    }

    // Insertamos el nuevo número en la posición correcta
    arreglo[posicionInsercion] = nuevoNumero;

    // Imprimimos el arreglo completo
    System.out.println("El arreglo resultante es:");
    for (int i = 0; i < 6; i++) {
      System.out.print(arreglo[i] + " ");
    }
  }
}