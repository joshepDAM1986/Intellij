
package com.mycompany.depurado;
/**
 *
 * @author damci
 */
public class Depurado
{
    public static void main(String[] args) 
    {
     int resultado=0;
     for(int i=0;i<100;i=i+2)  // se ejecuta 50 veces
     {
         for(int j=50;j>1;j=j-3) //se ejecuta 16
         {
            int k=1;
            while (k<=40)
            {
                k++;  
                resultado=i*j*k;   
            }
         }
        }
    }
}
