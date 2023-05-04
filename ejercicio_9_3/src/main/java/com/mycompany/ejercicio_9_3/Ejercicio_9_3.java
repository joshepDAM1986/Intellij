
package com.mycompany.ejercicio_9_3;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

/**
 *
 * @author garci
 */

public class Ejercicio_9_3 {

    public static void main(String[] args) {
        
        // Creamos una instancia Scanner
        Scanner sc = new Scanner(System.in);

        // Creamos un ArrayList de caracteres
        ArrayList<Character> caracteres = new ArrayList<Character>();

        while(true) {
            System.out.println("Introduzca un caracter: ");

            String todosCaracteres = sc.nextLine();

            // Cuando el carácter introducido sea Enter, parar el programa
            if(todosCaracteres.equals("")) {
                break;
            }

            // Si no se ha introducido la tecla Enter, añadimos el carácter
            caracteres.add(todosCaracteres.charAt(0));
        }

        System.out.println("Los caracteres introducidos son: " + caracteres);



        // Solución con ITERATOR
        ListIterator<Character> iterador = caracteres.listIterator(caracteres.size());

        while(iterador.hasPrevious()) {
            System.out.print(iterador.previous());
        }


        System.out.println("");
        System.out.println("--------");


        // Solución con bucle FOR
        for(int i=caracteres.size() - 1; i>=0; i--){
            System.out.print(caracteres.get(i));
        }
        
        
        //Revertimos la Collecion
        Collections.reverse(caracteres);
        System.out.println(caracteres);
        
        //Colección ordenada alfabeticamente o de menor mayor
        Collections.sort(caracteres);
        
        //9.4_Creamos un HahSet de caracteres sin repetir
        HashSet<Character>caracteresSinRepetir = new HashSet<Character>(caracteres);
        System.out.println(caracteresSinRepetir);
        
        List<Character> list= new ArrayList<Character>(caracteresSinRepetir);
        Collections.sort(list);
        System.out.println(list);
        
    }   
}