package org.example;

import javax.persistence.*;
import java.util.*;

public class CRUDHabilidad {
    public static void altaHabilidad(EntityManager em) {
        em.getTransaction().begin();
        Scanner sc=new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la descripcion: ");
        String descripcion = sc.nextLine();
        System.out.print("Ingrese el precio: ");
        int precio = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese los usos: ");
        int usos = sc.nextInt();
        sc.nextLine();

        Habilidad habilidad = new Habilidad();
        habilidad.setNombre(nombre);
        habilidad.setDescripcion(descripcion);
        habilidad.setPrecio(precio);
        habilidad.setUsos(usos);
        em.persist(habilidad);
        em.getTransaction().commit();
    }
}
