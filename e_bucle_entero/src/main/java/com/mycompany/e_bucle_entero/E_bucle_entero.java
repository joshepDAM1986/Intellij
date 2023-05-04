
package com.mycompany.e_bucle_entero;

import java.util.Scanner;

/**
 *
 * @author damci
 */

//Pide un entero por pantalla entre 1 - 10 
//Si no lo metemos vuelve a empezar y dice
//"introduzca un numero entero"
//si lo mete, mostrar tabla de multiplicar del número

public class E_bucle_entero 
{
    public static void main(String[] args) 
    {  
        int n=obtenerNumero();
        dibujarTabla(n);
        
    }
       /** 
        * Obtiene un numero entero entre [1-10]
        * @return  entero entre 1 - 10
        */

       public static int obtenerNumero()
       {
         int n=0;
          
          do
          {
              Scanner sc=new Scanner(System.in);
              System.out.println("Introduzca un numero entre 1 y 10");
              if (sc.hasNextInt())
              {
                try
                    {
                        n=sc.nextInt();
                        if(n>=1 && n<=10)return n;
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

       
       /** 
        * Dibuja la tabla multiplicar de n
        * @return  
        */
       
       public static void dibujarTabla(int n)
       {  
          
           System.out.println("Dibujando la tabla del "+n); 
           for (int multi=0;multi<=10;multi++)
           {
               System.out.println(n+" x "+multi+" = "+n*multi);
           }

       }
}
    

