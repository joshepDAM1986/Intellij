
package com.mycompany.marca;

/**
 *
 * @author garci
 */

import java.io.Reader;
import java.io.StringReader;

public class Marker {
    static public void marca() {
        try {
            String cadenaEntrada = "Ejemplo de uso de#reset() y mark().";
            Reader reader = new StringReader(cadenaEntrada);
            char ch;
            int marca = 0;
            int i = 0;

            while (i < cadenaEntrada.length()) {
                ch = (char) reader.read();
                if (ch == '#') {
                    marca = i;
                    break;
                } 
                else {
                    System.out.print(ch);
                }

                i++;
                }

        reader.mark(marca);
        reader.reset();
        System.out.println();

            while (i < cadenaEntrada.length()) {
                ch = (char) reader.read();
                if (ch == '#') {
                    marca = i;
                    break;
                } 
                else {
                    System.out.print(ch);
                }
            i++;
            }
        }
        catch(Exception e){
        System.out.println(e);
        }
    }
}