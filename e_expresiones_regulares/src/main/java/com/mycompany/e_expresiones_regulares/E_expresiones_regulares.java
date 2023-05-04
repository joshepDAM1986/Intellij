
package com.mycompany.e_expresiones_regulares;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author damci
 */

public class E_expresiones_regulares 
{
    public static void main(String[] args) 
    {
        
        String regExNIF = "[0-9]{7,8}-?[A-HJ-NP-TV-Z]";
        String regExTelefono = "[6|7|9][0-9]{8}";
        String regExCorreo = "[a-zA-Z0-9 +&*-]+(?:\\.[a-zA-Z0-9 +&*-]+)*@"
                             + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}";
        

        String cadena="611111111 Lorem fistrum atlantidaformacion@gmail.com condemor 645254789 torpedo diodenoo ese que llega. "
                     + "Sexuarl mamaar ese 754856958 que llega al ataquerl benemeritaar va usté muy cargadoo se calle "
                     + "usté amatomaa la caidita 11778767G te voy a borrar el cerito. No puedor ese hombree de la "
                     + "pradera atlantida@hotmail.es apetecan caballo blanco caballo 3459877-B negroorl al ataquerl caballo blanco caballo "
                     + "negroorl. Por la gloria 12345678m de mi madre no te digo trigo por no llamarte Rodrigor apetecan "
                     + "llevame 958745862 al sircoo. Amatomaa fistro a 98765234Wpeich caballo blanco caballo negroorl llevame al sircoo.";
        
       Scanner sc = new Scanner(cadena);
       
       // Resto de cadena por escanear
       
       String resto =" ";
       
       // Extraer datos de una cadena
       // hasNext va preguntando y next consume
       
       while(sc.hasNext())
       {
            if(sc.hasNext(Pattern.compile(regExNIF)))
            {
                 System.out.println("Encontrado NIF: " 
                          + sc.next(Pattern.compile(regExNIF)));
            }
            else if(sc.hasNext(Pattern.compile(regExTelefono)))
            {
                 System.out.println("Encontrado Teléfono: " 
                          + sc.next(Pattern.compile(regExTelefono)));   
            }
            else if(sc.hasNext(Pattern.compile(regExCorreo)))
            {
                 System.out.println("Encontrado email: " 
                          + sc.next(Pattern.compile(regExCorreo)));   
            }
            else
            {
                //Muestra lo que descarta
                /*
                resto = sc.next();
                System.out.println("Descartando: " + resto);
                */
            }
       }
    }
}
