

package com.mycompany.diassemana;

import java.util.Scanner;

/**
 *
 * @author damci
 */

public class Diassemana 
{

    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Introduzca el dia: ");
        int dia=sc.nextInt();
        switch (dia)
        {
            case 1: System.out.println("Lunes");
            case 2: System.out.println("Martes");
            case 3: System.out.println("Miércoles");
            case 4: System.out.println("Jueves");
            case 5: System.out.println("Viernes");
            case 6,7: System.out.println("Fin de semana");
            break;
            default: System.out.println("La semana no tiene más de 7 dias, imbecil!!!");
            break;
        }
    }
}
