
package com.mycompany.formatcadena;

import java.util.Date;

/**
 *
 * @author damci
 */

public class Formatcadena 
{

    public static void main(String[] args) 
    {
        String cadena="hola";
        String nombre="Luis";
        System.out.printf("%nCadena vale %s y el nombre es %S%n",cadena,nombre);
        
        boolean booleano= false;
        System.out.printf("Mostrando booleanos %b %b",booleano,null);//null=false, !null=true.
        
        Date fecha=new Date();
        System.out.printf("%nHoy es %1$td/%1$tm/%1$tY %1$tH:%1$tM:%1$tS",fecha);
    }
}
