
package com.mycompany.cuadradosestrellas;

import java.util.Scanner;

/**
 *
 * @author damci
 */

// 3   5
// *** *****
// * * *   *
// *** *   *
//     *   * 
//     *****

public class Cuadradosestrellas 
{
    public static void main(String[] args)
    {
      int n=obtenerNumero();
      dibujarNumero(n);
    }
    
    
    

    //Obtiene el numero entero
    
    public static int obtenerNumero()
       {
         int n=0;
          
          do
          {
              Scanner sc=new Scanner(System.in);
              System.out.println("Introduzca el número de estrellas");
              if (sc.hasNextInt())
              {
                try
                    {
                        n=sc.nextInt();
                        if(n>0)return n;
                    }
                catch(Exception ex)
                    {
                        System.out.println(ex.getMessage());
                    }

              }
              else 
              {
                    System.out.println("Introduzca un número entero");
                    sc.next();
              }
              
          } 
          while(true);   
       }
    
    public static void dibujarNumero(int n)
    {
    //Arriba
    for(int i=1;i<=n;i++)
        {
            System.out.print("*" ); 
        }
        System.out.println("");
        
    //Centro
    for(int i=1;i<=n-2;i++)
        {
            System.out.print("*");
            for(int j=1;j<=n-2;j++)
                {
                    System.out.print(" ");
                }
            System.out.println("*");
        }
    //Abajo
    for(int i=1;i<=n;i++)
        {
            System.out.print("*" ); 
        }
    }
}
