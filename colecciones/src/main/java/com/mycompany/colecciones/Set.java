
package com.mycompany.colecciones;

import java.util.*;

/**
 *
 * @author garci
 */

public class Set {
    static void crearHashSet(){
        HashSet<String> setNombres = new HashSet<>();
        setNombres.add("Juan");
        setNombres.add("Micaela");
        setNombres.add(null);
        if (!setNombres.add("Micaela"));
        System.out.println("Elemento no insertado");
        setNombres.add("David");
        
        //Recorrer elemetos
        Iterator<String> itr=setNombres.iterator();
            while(itr.hasNext()){
                
                //Imprime cada elemento por separado
                System.out.println(itr.next());
            }
                //Imprime todo el conjunto de elementos
                System.out.println(setNombres);
      }
    
    static void crearLinkedHashSet(){
        LinkedHashSet<String> setNombres = new LinkedHashSet<>();
        setNombres.add("Juan");
        setNombres.add("Micaela");
        setNombres.add(null);
        if (!setNombres.add("Micaela"));
        System.out.println("Elemento no insertado");
        setNombres.add("David");
        
        Iterator<String> itr=setNombres.iterator();
            while(itr.hasNext()){
                
                //Imprime cada elemento por separado
                System.out.println(itr.next());
            }
                //Imprime todo el conjunto de elementos
                System.out.println(setNombres);
      }
    static void crearTreeSet(){
        TreeSet<Integer> setNombres=new TreeSet<>();
            setNombres.add(3);
            setNombres.add(1);
            //setNombres.add(null);
            setNombres.add(1);
            setNombres.add(2);
            
            //recorriendo elementos
            Iterator<Integer> itr=setNombres.iterator();
                while(itr.hasNext()){
                
                //Imprime cada elemento por separado
                System.out.println(itr.next());
            }
                //Imprime todo el conjunto de elementos
                System.out.println(setNombres);
      }

    static void crearTreeSet2(){
        TreeSet<Persona> setPersona=new TreeSet<>(Comparator.comparing(Persona::getNombre));
        setPersona.add(new Persona("Maria"));
        setPersona.add(new Persona("Ricardo"));
        setPersona.add(new Persona("Ricardo"));
        
        setPersona.add(new Persona("Estefanía"));
        setPersona.add(new Persona("Javier"));
        
        //Recorriendo elemetos en orden creciente
        System.out.println("Recorriendo en orden creciente");
        Iterator<Persona> itr=setPersona.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next().getNombre());
        }
        
        //Recorriendo elemetos en orden creciente
        System.out.println("Recorriendo en orden creciente");
        Iterator<Persona> ditr=setPersona.descendingIterator();
        while(ditr.hasNext()){
         System.out.println(ditr.next().getNombre());
         
        }
    }
}