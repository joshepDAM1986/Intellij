package org.example;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Esta clase contiene métodos para realizar operaciones relacionadas con frutas y componentes.
 */

public class Operaciones {

    /**
     * Inserta datos de un componente en la base de datos.
     *
     * @param em El EntityManager utilizado para la operación.
     */

    public static void insertarDatosComponente(EntityManager em) {
        em.getTransaction().begin();

        String pais = "España";
        FutasComponente frutaC = new FutasComponente();
        frutaC.setPais(pais);
        em.persist(frutaC);
        em.getTransaction().commit();
    }

    /**
     * Inserta datos de varias frutas en la base de datos.
     *
     * @param em El EntityManager utilizado para la operación.
     */

    public static void insertarDatosFruta(EntityManager em) {
        em.getTransaction().begin();
        String nombre = "Manzana";
        String descripcion = "Una fruta crujiente y jugosa, con diferentes variedades disponibles.";
        float precio = 0.5f;

        Fruta fruta1 = new Fruta("Manzana", "Una fruta crujiente y jugosa, con diferentes variedades disponibles.", 0.5f);
        Fruta fruta2 = new Fruta("Fresa", "Pequeña fruta roja y jugosa, ideal para postres y ensaladas.", 2f);
        Fruta fruta3 = new Fruta("Peras", "Fruta jugosa con una textura suave y dulce sabor.", 0.80f);
        Fruta fruta4 = new Fruta("Plátano", "Una fruta alargada y dulce, rica en potasio y energía.", 0.7f);
        Fruta fruta5 = new Fruta("Piña", "Una fruta tropical dulce y jugosa, conocida por su sabor refrescante", 2.50f);
        Fruta fruta6 = new Fruta("Melocotón", "Fruta de pulpa suave y jugosa, con un sabor dulce y aromático", 1f);
        em.persist(fruta1);
        em.persist(fruta2);
        em.persist(fruta3);
        em.persist(fruta4);
        em.persist(fruta5);
        em.persist(fruta6);
        em.getTransaction().commit();
    }

    /**
     * Consulta una fruta por su ID y la muestra en la consola.
     *
     * @param em El EntityManager utilizado para la operación.
     */

    static public void consultarFruta(EntityManager em) {
        em.getTransaction().begin();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la id de la fruta:");
        int id = sc.nextInt();
        sc.nextLine();
        Fruta agenteExistente = em.find(Fruta.class, id);
        if (agenteExistente == null) {
            System.out.println("La fruta con ID " + id + " no existe en la base de datos.");
            em.getTransaction().rollback();
            return;
        }
        System.out.println("-------------------------------------------------");

        Fruta vehiculo = em.find(Fruta.class, id);
        System.out.println(vehiculo);
        em.getTransaction().commit();
    }

    /**
     * Consulta todas las frutas en la base de datos y las muestra en la consola.
     *
     * @param em El EntityManager utilizado para la operación.
     * @return Una lista de objetos Fruta consultados.
     */

    public static List<Fruta> consultarFrutas(EntityManager em) {
        System.out.println("-------------------------------------------------");
        TypedQuery<Fruta> query = em.createQuery("SELECT id FROM Fruta id", Fruta.class);
        List<Fruta> resultados = query.getResultList();
        List<Fruta> frutasConsultadas = new ArrayList<>();

        for (Fruta fruta : resultados) {
            System.out.println(fruta);
            frutasConsultadas.add(fruta);
        }

        if (frutasConsultadas.isEmpty()) {
            return null;
        } else {
            return frutasConsultadas;
        }
    }

    /**
     * Modifica el nombre de una fruta en la base de datos.
     *
     * @param em El EntityManager utilizado para la operación.
     * @return La fruta modificada.
     */

    public static Fruta modificarFruta(EntityManager em) {
        em.getTransaction().begin();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID de la fruta que quieres modificar: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce el nuevo nombre de la fruta: ");
        String nombre = sc.nextLine();

        Query consulta = em.createQuery("UPDATE Fruta " +
                "SET nombre = :nombre " +
                "WHERE id = :id");
        consulta.setParameter("nombre", nombre);
        consulta.setParameter("id", id);

        int numModificados = consulta.executeUpdate();
        em.getTransaction().commit();
        System.out.println("Modificaciones realizadas: " + numModificados);

        // Consulta para obtener la fruta modificada

        Query consultaFruta = em.createQuery("SELECT f FROM Fruta f WHERE f.id = :id");
        consultaFruta.setParameter("id", id);
        Fruta frutaModificada = null;
        try {
            frutaModificada = (Fruta) consultaFruta.getSingleResult();
        } catch (Exception e) {
            // No se encontró la fruta en la base de datos
            System.out.println("La fruta no existe en la base de datos.");
        }
        return frutaModificada;
    }

    /**
     * Borra una fruta de la base de datos.
     *
     * @param em El EntityManager utilizado para la operación.
     */

    static public void borrarFruta(EntityManager em) {
        em.getTransaction().begin();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la id de la fruta a borrar ");
        int id = sc.nextInt();
        Query query
                = em.createQuery("DELETE FROM Fruta " +
                "WHERE id = " + id + "");
        int numBorrados = query.executeUpdate();
        em.getTransaction().commit();
        System.out.println("Frutas borradas: " + numBorrados);
    }
}

