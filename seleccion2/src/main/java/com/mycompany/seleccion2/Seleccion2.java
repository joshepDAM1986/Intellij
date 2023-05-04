
package com.mycompany.seleccion2;

import java.util.Scanner;

/**
 *
 * @author damci
 */

//Descuentos
//Pedimos precio (IVA incluido)
//Pedimos la edad
//Con 65+ 20% off
//Con 60-64 10% off
//Hasta 30 15% off
//hasta 20 25% off

public class Seleccion2 
{
    public static void main(String[] args) 
    {
/*
       Scanner sc= new Scanner(System.in) ;
       System.out.println("Introduce precio:");
       float precio=sc.nextFloat();
       System.out.println("Introduce edad:");
       int edad=sc.nextInt();
       float descuento=0;
       
       if (edad>=60 && edad<=64)
        {
            float precioFinal=precio*0.9f;
            System.out.println("Su edad es de " +edad +" años");
            System.out.println("El precio inicial es " +precio +" €");
            System.out.println("El descuento es del 10%");
            System.out.println("El precio final es " +precioFinal +" €");
        }    
       else if (edad>=21 && edad<=30)
        {
            float precioFinal=precio*0.85f;
            System.out.println("Su edad es de " +edad +" años");
            System.out.println("El precio inicial es " +precio +" €");
            System.out.println("El descuento es del 15%");
            System.out.println("El precio final es " +precioFinal +" €");
        }
       else if (edad>=65)
        {
            float precioFinal=precio*0.8f;
            System.out.println("Su edad es de " +edad +" años");
            System.out.println("El precio inicial es " +precio +" €");
            System.out.println("El descuento es del 20%");
            System.out.println("El precio final es " +precioFinal +" €");
        }
       else if (edad<=20)
        {
            float precioFinal=precio*0.75f;
            System.out.println("Su edad es de " +edad +" años");
            System.out.println("El precio inicial es " +precio +" €");
            System.out.println("El descuento es del 25%");
            System.out.println("El precio final es " +precioFinal +" €");
        }
       else
        {
            System.out.println("Su edad es de " +edad +" años");
            System.out.println("El precio inicial es " +precio +" €");
            System.out.println("No tiene descuento");
            System.out.println("El precio final es " +precio +" €");
        }
       
    }
    
}

*/
        
    Scanner sc= new Scanner(System.in);
    
    int edad=0;
    float precio=0;
    float descuento=0;
    
    System.out.println("Introduzca su edad");
        if (sc.hasNextInt())
        {
            edad=sc.nextInt();
        
            System.out.println("Introduzca precio");
            if (sc.hasNextFloat())
            {
                precio=sc.nextFloat();
                if (edad>=60 && edad<=64)
                {
                descuento=10;
                System.out.println("Su edad es de " +edad +" años");
                System.out.println("El descuento es del 10%");
                }
            else if (edad>=21 && edad<=30)
                {
                descuento=15;
                System.out.println("Su edad es de " +edad +" años");
                System.out.println("El descuento es del 15%");
                }
            else if (edad>=65)
                {
                descuento=20;
                System.out.println("Su edad es de " +edad +" años");
                System.out.println("El descuento es del 20%");    
                }
            else if (edad<=20)
                {
                descuento=25;
                System.out.println("Su edad es de " +edad +" años");
                System.out.println("El descuento es del 25%");
                }
            else
                {
                System.out.println("Su edad es de " +edad +" años");
                System.out.println("No le corresponde descuento");
                }
                
            float total=precio-(precio*descuento/100);
            System.out.print("El precio final es: "+total);
            }
            else
            System.out.println("El precio introducido no es válido");
        }
        else 
        {
            System.out.println("La edad introducida no es válida");
        }

    }           
    
}
