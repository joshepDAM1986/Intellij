package org.example;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        //instancias del objeto Persona

        Persona p1 = new Persona("Josele", "Garcia", 37);
        Persona p2 = new Persona("Enrique", "Palma", 31);
        Persona p3 = new Persona("Jaime", "Molina", 21);
        Persona p4 = new Persona("Natalia", "Chica", 19);
        Persona p5 = new Persona("Rubencio", "Canario", 87);

        //creamos la lista añadiéndole las instancias

        ArrayList<Persona> lista =
                new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));

        //ordenamos e imprimimos las instancias por nombre

        System.out.println("");
        System.out.println("Ordenado por nombre");
        System.out.println("===============================");

        lista.sort(new ComparadorNombre());
        lista.forEach(System.out::println);

        System.out.println("");
        System.out.println("Ordenado por Apellidos");
        System.out.println("===============================");

        //ordenamos e imprimimos las instancias por apellidos
        lista.sort(new ComparadorApellidos());
        lista.forEach(System.out::println);

        System.out.println("");
        System.out.println("Ordenado por Edad");
        System.out.println("===============================");

        //ordenamos e imprimimos las instancias por apellidos
        lista.sort((o1, o2) -> o1.getEdad() > o2.getEdad() ? 1 : -1);
        lista.forEach(System.out::println);

        System.out.println("");
        System.out.println("Comparador completo");
        System.out.println("===============================");

        Comparator<Persona> comparadorA = (pa, pb)
            -> pa.getApellidos().compareTo(pb.getApellidos());
        Comparator<Persona> comparadorB = comparadorA.thenComparing((pa, pb) ->
                pa.getNombre().compareTo(pb.getNombre()));
        Comparator<Persona> comparadorC = comparadorB.thenComparing((pa, pb) ->
                pa.getEdad() > pb.getEdad() ? 1 : -1);

        lista.sort(comparadorC);
        lista.forEach(System.out::println);
        }
    }