
package com.mycompany.wrapper;

/**
 *
 * @author damci
 */

public class Wrapper 
{
    public static void main(String[] args) 
    {
        Integer i=8;
        Float f=5.5f;
        String s="15";
        Integer convertido=0;
        int n=9;
        
        
        System.out.println("Convertimos una cadena de caracteres a número entero: "+Integer.parseInt("10"));
        //Integer.parseInt combierte una cadena de caracteres ("10") en un número entero (10).
        System.out.println("Cogemos el valor entero de un número decimal ej: 5.5: "+f.intValue());
        //+f.intValue() coje la parte entera de cualquier número decimal mostrándolo en el println.
        System.out.println("Convertimos la variable s (String) a (int) y lo mostramos: "+Integer.valueOf(s));
        //Integer.valueOf(s) combierte una variable tipo string (s) en un número entero int (10).
        
        convertido=n;
        convertido=Integer.valueOf(n);
        System.out.println("Convertido es = "+convertido);
        //Con esto convertimos una variable (int n=9) a clase Wrapper... Ni puta idea de la utilidad de esto.
        
        System.out.println("--------------------------------------------------");
        
        System.out.println((n>10)?"Es mayor de 10":"Es menor de 10");
        //(?) Te compara si una variable, en este caso (n), cumple la condición (>10) y le damos dos opciones a mostrar las cuales delimitamos con (:).
        
        System.out.println("--------------------------------------------------");
        
        int a=8;
        System.out.println(++a); 
        System.out.println("Valor final de a: "+a);
        //(a++) muestra y despues opera mientras que (++a) opera y despues muestra.
        int b=a++;
        System.out.println(b);
        System.out.println("Valor final de b: "+b);
        //Aquí hacemos lo mismo al darle a (b) el valor de (++a) y pedir que la muestre.
    }
}
