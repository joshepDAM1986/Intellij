
package com.mycompany.e_bucles_palabrasecreta;

import java.util.Scanner;

/**
 *
 * @author garci
 */

public class E_bucles_palabrasecreta 
{

    public static void main(String[] args) 
    {  
        int intentos=3;
        String clave="secreta";
        String miClave="";
        Scanner sc=new Scanner(System.in);
           
                while (intentos>0)
                {
                    System.out.println("Introduce la contraseña");
                    miClave=sc.nextLine();
                    intentos--;
                    if (clave.equals(miClave))
                    {
                        System.out.println("La clave es correcta");
                        break;
                    }
                    else if (intentos==0)
                    {   
                        System.out.println("La clave no es correcta, intentos agotados");
                        break;
                    } 
                    else
                    {
                        System.out.println("La clave no es correcta, te quedan "+intentos+" intentos");
                    }
                }   
    }   
}
