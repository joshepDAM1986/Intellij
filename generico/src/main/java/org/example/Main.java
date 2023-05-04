package org.example;

public class Main {
    public static void main(String[] args) {
        ClaseGenerica <Integer> cg1 = new ClaseGenerica(23);
        System.out.println("cg: "+ cg1.getElemento());

        ClaseGenerica totopo=new ClaseGenerica("guacamole");
        System.out.println(totopo.getElemento());

        ClaseGenerica<String> cg2=new ClaseGenerica("hola");

        ClaseGenerica<Persona> cg3=new ClaseGenerica<>(new Persona("Josele",37));
        System.out.println(cg3.getElemento().getNombre()+cg3.getElemento().getEdad());
    }
}

