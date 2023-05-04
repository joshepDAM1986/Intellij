
//Mostrar el cuadrado de los 20 primeros números excepto el 3 y 7.
//Mostrar ejemplo: 1x1=1, 2x2=4, 4x4=16...
//Utilizar break o continue

package com.mycompany.e_bucles;

/**
 *
 * @author damci
 */

public class E_bucles 
{

    public static void main(String[] args) 
    {
        
        int i=0;
        
        for (i=1;i<=20;i++)
        {
            if (i==3 || i==7)
            continue;
            else
            System.out.println(i+"x"+i+"="+i*i);
        }
        
        System.out.println("==============================================");
        
        i=0;
        
        while (i<20)
            {
                i++;        
                if (i==3 || i==7)
                {
                    continue;
                }
                else
                {
                        System.out.println(i+"x"+i+"="+i*i);
                }
            }
        
        System.out.println("==============================================");
        
        i=0;
        
        do
        {
           i++;        
           if (i==3 || i==7)
           {
               continue;
           }
           else
           {
               System.out.println(i+"x"+i+"="+i*i);
           }
        }  
        while (i<20);
    }
}
