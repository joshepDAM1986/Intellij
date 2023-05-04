

package com.mycompany.calculadora;

import java.util.Scanner;

/**
 *
 * @author damci
 */

public class Calculadora 
{

    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Introduzca el primer numero: ");
        double num1=sc.nextDouble();
        System.out.print("Introduzca el segundo numero: ");
        double num2=sc.nextDouble();
        System.out.print("Introduzca la operación elegida [1-6]: ");
        int operacion=sc.nextInt();
        double resultado=0;
        
        switch (operacion)
            {
            case 1: resultado=num1+num2;
            break;
            case 2: resultado=num1-num2;
            break;
            case 3: resultado=num1*num2;
            break;
            case 4: resultado=num1/num2;
            break;
            case 5: resultado=Math.pow(num1,num2);
            break;
            case 6: resultado=num1%num2;
            break;
            default: System.out.println("Operación no soportada");
            }
            System.out.println("El resuñtado es "+resultado);
    }
}
