
package com.mycompany.colecciones;

import java.util.ArrayList;

/**
 *
 * @author garci
 */

public class List {
    static void crearArrayList(){
        ArrayList<Integer> arrayEnteros = new ArrayList();
        
            arrayEnteros.add(22);
            arrayEnteros.add(77);
            arrayEnteros.add(11);
            System.out.println("Primer elemento" + arrayEnteros.get(0));
            System.out.println("Segundo elemento" + arrayEnteros.get(1));
            Integer enteroReemplazado = arrayEnteros.set(1,33);
            System.out.println("Elemento Reemplazado" + enteroReemplazado);
            System.out.println("Ahora segundo elemento" + arrayEnteros.get(1));
            System.out.println("Tercer elemento" + arrayEnteros.get(2));
            arrayEnteros.add(22);
            
            System.out.println(arrayEnteros);
            
            
            System.out.println("Elemento ["+ arrayEnteros.indexOf(22)+"] del Array");
            
            //Sustituir todas las ocurrencias de 22 por 55
            while (arrayEnteros.indexOf(22) != -1)
                arrayEnteros.set(arrayEnteros.indexOf(22),55);
            
            //mostrar arrayList
            for(int elemento:arrayEnteros){
                System.out.println(elemento);
            }
            
            System.out.println("------------------------");
            
            arrayEnteros.forEach((elemento)->{
                System.out.println(elemento);
            }
            );
      }
}
