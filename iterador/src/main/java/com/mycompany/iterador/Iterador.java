
package com.mycompany.iterador;
import java.util.*;

/**
 *
 * @author garci
 */

/*
Crear un array list de frutas

manzana
kiwi
pera
platano
coco
Listar las frutas
*/

public class Iterador {
    
    
    public static void main(String[] args) {
     
   ArrayList<String>frutas= new ArrayList<>();
    frutas.add("manzana");
    frutas.add("kiwi");
    frutas.add("pera");
    frutas.add("platano");
    frutas.add("coco");
    
    
    for(int i=0;i<frutas.size();i++){
        System.out.println(frutas.get(i));
    }
    
        System.out.println(" =========");
    
    for(String fruta:frutas){
        System.out.println(fruta);
    }
    
    System.out.println(" =========");
    
    frutas.forEach((fruta) -> {
        System.out.println(fruta);
    });
    
     System.out.println(" =========");
     
     frutas.forEach(System.out::println);
     
     System.out.println(" =========");
    
    Iterator<String> it = frutas.iterator();
        while(it.hasNext())
            System.out.println(it.next());
        
     System.out.println(" =========");
     
     ListIterator iteradorInverso = frutas.listIterator(frutas.size());   
        while(iteradorInverso.hasNext()){
            System.out.println("frutas");
        }
            
         Collections.reverse(frutas);
         
         Iterator<String> it2 = frutas.iterator();
        while(it.hasNext())
            System.out.println(it2.next());  
        }
    }
