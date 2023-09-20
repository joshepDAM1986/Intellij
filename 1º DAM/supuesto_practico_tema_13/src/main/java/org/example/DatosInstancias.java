package org.example;

import java.time.LocalDate;
import javax.persistence.EntityManager;

public class DatosInstancias {
    public static void ingresarDatosInstancias(EntityManager em) {

        em.getTransaction().begin();

        // Crear personas
        Persona persona1 = new Persona("11111111A", "Juan");
        Persona persona2 = new Persona("22222222B", "María");
        Persona persona3 = new Persona("33333333C", "Pedro", 1234);
        Persona persona4 = new Persona("44444444D", "Ana", 5678);

        // Crear vehículos
        Vehiculo vehiculo1 = new Vehiculo("123ABC", LocalDate.of(1990, 1, 9), persona1);
        Vehiculo vehiculo2 = new Vehiculo("123ABC", LocalDate.of(1995, 2, 10), persona2);
        Vehiculo vehiculo3 = new Vehiculo("XYZ123", LocalDate.of(2000, 3, 11), TipoEnergia.GASOLINA, persona3);
        Vehiculo vehiculo4 = new Vehiculo("DEF456", LocalDate.of(2005, 4, 12), TipoEnergia.DIESEL, persona4);

        try {
            // Verificar si los datos ya existen en la base de datos
            Persona existingPersona1 = em.find(Persona.class, persona1.getDni());
            Persona existingPersona2 = em.find(Persona.class, persona2.getDni());
            Persona existingPersona3 = em.find(Persona.class, persona3.getDni());
            Persona existingPersona4 = em.find(Persona.class, persona4.getDni());

            Vehiculo existingVehiculo1 = em.find(Vehiculo.class, vehiculo1.getId());
            Vehiculo existingVehiculo2 = em.find(Vehiculo.class, vehiculo2.getId());
            Vehiculo existingVehiculo3 = em.find(Vehiculo.class, vehiculo3.getId());
            Vehiculo existingVehiculo4 = em.find(Vehiculo.class, vehiculo4.getId());

            // Si los datos existen, mostrar un mensaje y regresar
            if (existingPersona1 != null || existingPersona2 != null || existingPersona3 != null || existingPersona4 != null ||
                    existingVehiculo1 != null || existingVehiculo2 != null || existingVehiculo3 != null || existingVehiculo4 != null) {
                System.out.println("Los datos ya existen en la base de datos.");
                em.getTransaction().commit();
                return;
            }

            // Guardar en la base de datos
            em.persist(persona1);
            em.persist(persona2);
            em.persist(persona3);
            em.persist(persona4);
            em.persist(vehiculo1);
            em.persist(vehiculo2);
            em.persist(vehiculo3);
            em.persist(vehiculo4);

            em.getTransaction().commit();

            System.out.println("\nDatos de instancias insertados\n");



        }
        catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error al insertar los datos: los datos ya existen.");
        }

    }
}
