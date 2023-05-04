
package com.mycompany.ambitos;

/**
 *
 * @author damci
 */

public class Ambitos 
{
    static int a=99;
    static final int MAXIMO_VALOR=100;
    static final boolean CTE_OCULTA=false;
    // ejemplo ambitos
    public static void main(String[] args)
    {
        System.out.println("Valor cte: "+MAXIMO_VALOR);
        {
            {
             int a=2;
             System.out.println("a="+(a+MAXIMO_VALOR));
            }    
            //la linea siguiente provocaría un error
            //System.out.println("a= "+a);
            int a=1;
            int b=1000;
            System.out.println("a="+a);
        }
        //La linea siguiente provocaría un error
        //System.out.println("b="+b);
        int a=0;
        System.out.println("a="+ ++a);
        {
            System.out.println("a="+ ++a);
                {
                    System.out.println("a="+ ++a);
                }
        }
        System.out.println("a="+ ++a);
    }
 
        public void prueba()
        {
            int a=10;
            this.a=111;
            System.out.println("a="+a);
            System.out.println("a="+this.a);
        }
}

