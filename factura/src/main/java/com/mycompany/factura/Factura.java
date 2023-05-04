

package com.mycompany.factura;

import java.util.Scanner;

/**
 *
 * @author damci
 */

public class Factura 
{

    public static void main(String[] args)
    {
    Scanner sc=new Scanner(System.in);
    float bi=0;
    int iva=0;
        System.out.println("Introduzca el valor de la base Imponible: ");
        
        if (sc.hasNextFloat())
            {
            bi=sc.nextFloat();
            System.out.println("Introduzca el valor del IVA: ");
            
                if (sc.hasNextInt())
                    {
                        iva=sc.nextInt();
            
                        float total=bi+(bi*iva/100);
                        System.out.println("BI: "+bi);
                        System.out.println("IVA: "+iva);
                        System.out.println("Total: "+total);
                    }
                else
                    {
                        System.out.println("El valor IVA no es válido");
                    }  
            }   
                     
        else
            {
                System.out.println("El valor BI no es válido");
            }
    }      
}


