package org.example;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 * Clase que contiene todos los metodos CRUD para interactuar con la base de datos
 */
public class CRUDPersonaje {

    /* ESPECIE */

    /**
     * Metodo que crea las especies
     * @param em
     */
    public static void crearEspecie(EntityManager em) {

        Especie especie1 = new Especie("Humano");
        Especie especie2 = new Especie("Yoda");

        if (buscarEspeciePorNombre(em, especie1.getEspecie()) == null) {
            CRUDPersonaje.insertarEspecie(especie1, em);
        }
        if (buscarEspeciePorNombre(em, especie2.getEspecie()) == null) {
            CRUDPersonaje.insertarEspecie(especie2, em);
        }
        CRUDPersonaje.leerEspecie(em);
    }

    /**
     * Metodo que inserta las especies
     * @param especie
     * @param em
     * @return
     */
    public static Especie insertarEspecie(Especie especie, EntityManager em) {
        em.getTransaction().begin();

        try {
            em.persist(especie);
            em.getTransaction().commit();
            System.out.println(true);
        } catch (Exception e) {
            System.out.println(false);
        }
        return especie;
    }

    /**
     * Metodo que consulta las especies
     * @param em
     */
    public static void leerEspecie(EntityManager em) {

        TypedQuery<Especie> query = em.createQuery("SELECT e " +
                "FROM Especie e", Especie.class);

        List<Especie> results = query.getResultList();

        for (Especie especie : results) {
            System.out.println(especie);
        }
    }

    /**
     * metodo que busca las especies por nombre para evitar repeticiones
     * @param em
     * @param especie
     * @return
     */
    public static Especie buscarEspeciePorNombre(EntityManager em, String especie) {
        TypedQuery<Especie> query = em.createQuery("SELECT e FROM Especie e WHERE e.especie = :nombre", Especie.class);
        query.setParameter("nombre", especie);
        List<Especie> resultados = query.getResultList();
        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null;
        }
    }

    /**
     * busca especies por id para insertarlos en el personaje
     * @param em
     * @param idEspecie
     * @return
     */
    public static Especie buscarEspecieId(EntityManager em, int idEspecie) {

        Especie especie = null;

        try {
            especie = em.find(Especie.class, idEspecie);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (especie == null) {
            System.out.println("La especie no existe en la base de datos");
            return null;
        }

        return especie;
    }

    /* ARMA */

    /**
     * metodo que crea las armas
     * @param em
     */
    public static void crearArma(EntityManager em) {

        Arma arma1 = new Arma("Sable de luz");
        Arma arma2 = new Arma("Pistola bláster");

        if (buscarArmaPorNombre(em, arma1.getArma()) == null) {
            CRUDPersonaje.insertarArma(arma1, em);
        }
        if (buscarArmaPorNombre(em, arma2.getArma()) == null) {
            CRUDPersonaje.insertarArma(arma2, em);
        }
        CRUDPersonaje.leerArma(em);
    }

    /**
     * metodoque inserta las armas
     * @param arma
     * @param em
     * @return
     */
    public static Arma insertarArma(Arma arma, EntityManager em) {
        em.getTransaction().begin();

        try {
            em.persist(arma);
            em.getTransaction().commit();
            System.out.println(true);
        } catch (Exception e) {
            System.out.println(false);
        }
        return arma;
    }

    /**
     * metodo que consulta las armas
     * @param em
     */
    public static void leerArma(EntityManager em) {

        TypedQuery<Arma> query = em.createQuery("SELECT a " +
                "FROM Arma a", Arma.class);

        List<Arma> results = query.getResultList();

        for (Arma arma : results) {
            System.out.println(arma);
        }
    }

    /**
     * metodo que busca las armas por nombre para evitar repeticiones
     * @param em
     * @param arma
     * @return
     */
    public static Arma buscarArmaPorNombre(EntityManager em, String arma) {
        TypedQuery<Arma> query = em.createQuery("SELECT a FROM Arma a WHERE a.arma = :nombre", Arma.class);
        query.setParameter("nombre", arma);
        List<Arma> resultados = query.getResultList();
        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null;
        }
    }

    /**
     * busca las armas por id para insertarlas en los personajes
     * @param em
     * @param idArma
     * @return
     */
    public static Arma buscarArmaId(EntityManager em, int idArma) {

        Arma arma = null;

        try {
            arma = em.find(Arma.class, idArma);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (arma == null) {
            System.out.println("El arma no existe en la base de datos");
            return null;
        }

        return arma;
    }

    /* AFILIACION */

    /**
     * Crea las afiliaciones
     * @param em
     */
    public static void crearAfiliacion(EntityManager em) {

        Afiliacion afiliacion1 = new Afiliacion("Jedi");
        Afiliacion afiliacion2 = new Afiliacion("Sith");
        Afiliacion afiliacion3 = new Afiliacion("Rebelde");

        if (buscarAfiliacionPorNombre(em, afiliacion1.getAfiliacion()) == null) {
            CRUDPersonaje.insertarAfiliacion(afiliacion1, em);
        }
        if (buscarAfiliacionPorNombre(em, afiliacion2.getAfiliacion()) == null) {
            CRUDPersonaje.insertarAfiliacion(afiliacion2, em);
        }
        if (buscarAfiliacionPorNombre(em, afiliacion3.getAfiliacion()) == null) {
            CRUDPersonaje.insertarAfiliacion(afiliacion3, em);
        }
        CRUDPersonaje.leerAfiliacion(em);
    }

    /**
     * inserta las afiliaciones
     * @param afiliacion
     * @param em
     * @return
     */
    public static Afiliacion insertarAfiliacion(Afiliacion afiliacion, EntityManager em) {
        em.getTransaction().begin();

        try {
            em.persist(afiliacion);
            em.getTransaction().commit();
            System.out.println(true);
        } catch (Exception e) {
            System.out.println(false);
        }
        return afiliacion;
    }

    /**
     * consulta las afiliaciones
     * @param em
     */
    public static void leerAfiliacion(EntityManager em) {

        TypedQuery<Afiliacion> query = em.createQuery("SELECT af " +
                "FROM Afiliacion af", Afiliacion.class);

        List<Afiliacion> results = query.getResultList();

        for (Afiliacion afiliacion : results) {
            System.out.println(afiliacion);
        }
    }

    /**
     * buscar las afiliaciones por nombre para evitar repeticiones
     * @param em
     * @param afiliacion
     * @return
     */
    public static Afiliacion buscarAfiliacionPorNombre(EntityManager em, String afiliacion) {
        TypedQuery<Afiliacion> query = em.createQuery("SELECT af FROM Afiliacion af WHERE af.afiliacion = :nombre", Afiliacion.class);
        query.setParameter("nombre", afiliacion);
        List<Afiliacion> resultados = query.getResultList();
        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null;
        }
    }

    /**
     * busca las afiliaciones por id para insertarlas en los personajes
     * @param em
     * @param idAfiliacion
     * @return
     */
    public static Afiliacion buscarAfiliacionId(EntityManager em, int idAfiliacion) {

        Afiliacion afiliacion = null;

        try {
            afiliacion = em.find(Afiliacion.class, idAfiliacion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (afiliacion == null) {
            System.out.println("La afiliacion no existe en la base de datos");
            return null;
        }
        return afiliacion;
    }

    /* PERSONAJE */

    /**
     * crea los personajes
     * @param em
     */
    public static void crearPersonaje(EntityManager em) {

        Especie especie1 = CRUDPersonaje.buscarEspecieId(em, 1);
        Especie especie2 = CRUDPersonaje.buscarEspecieId(em, 2);
        Arma arma1 = CRUDPersonaje.buscarArmaId(em, 1);
        Arma arma2 = CRUDPersonaje.buscarArmaId(em, 2);
        Afiliacion afiliacion1 = CRUDPersonaje.buscarAfiliacionId(em, 1);
        Afiliacion afiliacion2 = CRUDPersonaje.buscarAfiliacionId(em, 2);
        Afiliacion afiliacion3 = CRUDPersonaje.buscarAfiliacionId(em, 3);

        // Verificar si ya existe una fruta con el mismo nombre antes de insertarlo
        // llamando al metodo buscarFrutaPorNombre que comprueba si existe ese nombre en
        // la base de datos

        if (buscarPersonajePorNombre(em, "Luke Skywalker") == null) {
            Personaje personaje1 = new Personaje("Luke Skywalker", especie1, "Jedi y héroe de la Alianza Rebelde.", 23, 1.72f, arma1, afiliacion1);
            CRUDPersonaje.insertarPersonaje(personaje1, em);
        }

        if (buscarPersonajePorNombre(em, "Darth Vader") == null) {
            Personaje personaje2 = new Personaje("Darth Vader", especie1, "Anakin Skywalker, un poderoso Sith y antiguo Caballero Jedi.", 45, 2.03f, arma1, afiliacion2);
            CRUDPersonaje.insertarPersonaje(personaje2, em);
        }

        if (buscarPersonajePorNombre(em, "Princesa Leia") == null) {
            Personaje personaje3 = new Personaje("Princesa Leia", especie1, "Líder de la Alianza Rebelde y hermana de Luke Skywalker.", 19, 1.50f, arma2, afiliacion3);
            CRUDPersonaje.insertarPersonaje(personaje3, em);
        }

        if (buscarPersonajePorNombre(em, "Han Solo") == null) {
            Personaje personaje4 = new Personaje("Han Solo", especie1, "Cazarrecompensas y contrabandista convertido en héroe de la Alianza Rebelde.", 32, 1.80f, arma2, afiliacion3);
            CRUDPersonaje.insertarPersonaje(personaje4, em);
        }

        if (buscarPersonajePorNombre(em, "Yoda") == null) {
            Personaje personaje5 = new Personaje("Yoda", especie2, "Maestro Jedi anciano y sabio.", 900, 0.66f, arma1, afiliacion1);
            CRUDPersonaje.insertarPersonaje(personaje5, em);
        }
        CRUDPersonaje.leerPersonaje(em);
    }

    /**
     * inserta los personajes
     * @param personaje
     * @param em
     * @return
     */
    public static Personaje insertarPersonaje(Personaje personaje, EntityManager em) {

        em.getTransaction().begin();

        try {
            em.persist(personaje);
            em.getTransaction().commit();
            System.out.println(true);
        } catch (Exception e) {
            System.out.println(false);
        }
        return personaje;
    }

    /**
     * consulta los personajes
     * @param em
     */
    public static void leerPersonaje(EntityManager em) {

        TypedQuery<Personaje> query = em.createQuery("SELECT p " +
                "FROM Personaje p", Personaje.class);

        List<Personaje> results = query.getResultList();

        for (Personaje personaje : results) {
            System.out.println(personaje);
        }
    }

    /**
     * busca los personajes por nombre para evitar repeticiones
     * @param em
     * @param nombre
     * @return
     */
    public static Personaje buscarPersonajePorNombre(EntityManager em, String nombre) {
        TypedQuery<Personaje> query
                = em.createQuery("SELECT  p FROM Personaje p " +
                "WHERE p.nombre ='" + nombre + "'", Personaje.class);

        if (query.getResultList().size() == 0) {
            System.out.println("No existe ese personaje");
            return null;
        } else {
            return query.getResultList().get(0);
        }
    }

    /**
     * consulta los personajes por id
     * @param em
     * @param idPersonaje
     * @return
     */
    public static Personaje consultarPersonajeIdQuery(EntityManager em, int idPersonaje) {
        TypedQuery<Personaje> query = em.createQuery("SELECT p FROM Personaje p WHERE p.idPersonaje = :id", Personaje.class);
        query.setParameter("id", idPersonaje);

        List<Personaje> results = query.getResultList();

        for (Personaje personaje : results) {
            System.out.println(personaje);
            if (personaje == null) {
                return personaje;
            }
        }
        return null;
    }

    /**
     * modifica la afiliacion de personajes
     * @param em
     * @param idPersonaje
     * @param nuevaAfiliacion
     * @return
     */
    /* MODIFICAR AFILIACION PERSONAJE */
    public static Personaje modificarAfiliacion(EntityManager em, int idPersonaje, String nuevaAfiliacion) {
        // Busca el personaje por su ID
        Personaje personaje = em.find(Personaje.class, idPersonaje);

        if (personaje != null) {
            // Modifica la afiliación del personaje
            Afiliacion afiliacion = personaje.getAfiliacion();
            afiliacion.setAfiliacion(nuevaAfiliacion);

            // Guarda los cambios en la base de datos
            em.getTransaction().begin();
            em.getTransaction().commit();
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        return personaje;
    }

    /**
     * elimina un personaje
     * @param em
     * @param idPersonaje
     * @return
     */
    public static Personaje eliminarPersonaje(EntityManager em, int idPersonaje) {
        // Busca el personaje por su ID
        Personaje personaje = em.find(Personaje.class, idPersonaje);

        if (personaje != null) {
            // Elimina el personaje de la base de datos
            em.getTransaction().begin();
            em.remove(personaje);
            em.getTransaction().commit();

            System.out.println(true);
        } else {
            System.out.println(false);
        }
        return personaje;
    }

    /**
     * muestra todos los personajes que no usan pistola bláster como arma y los ordena por la altura.
     * @param em
     */
    public static void listarPersonajeOrdenados(EntityManager em) {
        TypedQuery<Personaje> query = em.createQuery("SELECT p FROM Personaje p " +
                "WHERE p.arma.arma <> 'Pistola bláster' ORDER BY p.altura", Personaje.class);

        List<Personaje> results = query.getResultList();

        for (Personaje personaje : results) {
            System.out.println(personaje);
        }
    }
}






