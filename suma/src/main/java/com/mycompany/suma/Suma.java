

package com.mycompany.suma;

/**
 *
 * @author damci
 */

//suma 8 7 6 
//dice la suma es 21
//suma 1 2 3 4 5 14
//la suma es 20

public class Suma 

{

    public static void main(String[] args) 
    {       
          int suma=0;
          ///Recorre array de argumentos independientemente de la cantidad de los mismos.
          for(int i=0;i<args.length;i++)
            {
               suma+=Integer.parseInt(args[i]);
            }
          System.out.println("La suma total de los argumentos es "+suma);
    }
}
