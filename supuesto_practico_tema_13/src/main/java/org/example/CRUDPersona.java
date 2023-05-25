package org.example;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class CRUDPersona {
    public static void altaPersona(EntityManager em) {
        em.getTransaction().begin();
        Scanner sc=new Scanner(System.in);
        System.out.println("------ Alta Persona ------");
        System.out.print("Ingrese el DNI de la persona: ");
        String dni = sc.nextLine();

        Persona personaExistente = em.find(Persona.class, dni);
        if (personaExistente != null) {
            System.out.println("La persona con DNI " + dni + " ya existe en la base de datos.");
            em.getTransaction().rollback();
            return;
        }

        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();

        System.out.print("¿Es trabajador? (s/n): ");
        String esTrabajador = sc.nextLine();

        try {
            if (esTrabajador.equals("s")) {

                System.out.print("Ingrese el número de registro: ");
                int numRegistro = sc.nextInt();

                Persona persona = new Persona();
                persona.setDni(dni);
                persona.setNombre(nombre);
                persona.setNumRegistro(numRegistro);
                em.persist(persona);
            }
            else {

                Persona persona = new Persona();
                persona.setDni(dni);
                persona.setNombre(nombre);
                em.persist(persona);
            }

            em.getTransaction().commit();
        }
        catch (Exception e) {
            System.out.println("Error al dar de alta la persona: " + e.getMessage());
            em.getTransaction().rollback();
        }
    }
    static public void consultarPersonas(EntityManager em) {
        System.out.println("Datos de todas las personas de la base de datos:");
        System.out.println("-------------------------------------------------");
        TypedQuery<Persona> query
                = em.createQuery("SELECT dni FROM Persona dni",
                Persona.class);
        List<Persona> results = query.getResultList();
        for (Persona persona : results) {
            System.out.println(persona);
        }
    }
}