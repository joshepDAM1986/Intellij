
package com.mycompany.colecciones;

import java.util.*;

/**
 *
 * @author garci
 */

public class Map {
    static void crearHashMap() {
            HashMap<Integer, String> hashMap = new HashMap<>();
            hashMap.put(1,"1");
            hashMap.put(3,"3");
            hashMap.put(4,"4");
            hashMap.put(2,"2");
            hashMap.put(5,"5");
            //Mostramos todos los elementos
            System.out.println(hashMap.values());
            //Mostramos el elemento con la key 3
            System.out.println(hashMap.get(3));
    }
    
    static void crearLinkedHashMap() {
            LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(1,"1");
            linkedHashMap.put(3,"3");
            linkedHashMap.put(4,"4");
            linkedHashMap.put(2,"2");
            linkedHashMap.put(5,"5");
            System.out.println(linkedHashMap.values());
    }
    static void crearTreeMap(){
        TreeMap<Integer, String> puntuaciones = new TreeMap<>();
        puntuaciones.put(8, "Notable alto");
        puntuaciones.put(5, "Aprobado");
        puntuaciones.put(10, "Matricula honor.");
        puntuaciones.put(6, "Bien");
        puntuaciones.put(9, "Sobresaliente");
        puntuaciones.put(7, "Notable");
        puntuaciones.entrySet().forEach((m) ->{
        System.out.println(m.getKey()+" "+m.getValue());
    });
        puntuaciones.replace(7,"Notable", "Notable bajo");
        System.out.println(puntuaciones.values());
        System.out.println("Por debajo de "+ puntuaciones.firstKey()+ " es suspenso");
    }
    
}
