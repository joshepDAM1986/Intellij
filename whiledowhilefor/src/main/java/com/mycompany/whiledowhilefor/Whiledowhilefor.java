

package com.mycompany.whiledowhilefor;

/**
 *
 * @author damci
 */

public class Whiledowhilefor 
{

    public static void main(String[] args) 
    {
            
        int k=0; 
         
           do 
            {
               k=k+1;
               System.out.println(k);
            }
                
       while(k<=10);
        
        System.out.println("===============================================");
        
        int j=10;
        
        for (j=10;j>0;j=j-3)
            {
                System.out.println(j);
            }
        
        System.out.println("===============================================");
        
        int i=0;
        
        for(i=0;i<=10;i=i+2)
            {
                System.out.println(i);   
            }
        
        System.out.println("===============================================");
        
        int g=10;
        
        while(g>0)
            {
                System.out.println(g);
                g=g-3;
            }

        System.out.println("===============================================");
        
        int h=10;
        
        while(h>0)
            {
                h=h-3;
                System.out.println(h);
                
            }
        
        System.out.println("===============================================");
        
        A: while(true)
            {
                System.out.println("Dentro de A");
                    while(true)
                    {
                        System.out.println("Dentro de B");
                        break A;
                    }
            }    
        
        C: while(true)
            {
                System.out.println("Dentro de C");
                D: while(true)
                {
                System.out.println("Dentro de D");
                continue C;
                }
            }
        //Bucle CD infinito
    }
}
