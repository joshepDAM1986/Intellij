package org.example;

import javax.persistence.*;
import java.util.List;

/**
 * Clase que proporciona métodos para realizar operaciones CRUD
 * (Crear, Leer, Actualizar, Eliminar) en la base de datos para
 * entidades de tipo Fruta y Pais.
 */

public class CRUDFruta {

    /**
     * Crea varios objetos de tipo Pais..
     * @param em el EntityManager utilizado para interactuar con la base de datos.
     */
    public static void crearPais(EntityManager em){

        Pais pais1 = new Pais("España");
        Pais pais2 = new Pais("Francia");
        Pais pais3 = new Pais("Costa Rica");

        // Verificar si ya existe un país con el mismo nombre antes de insertarlo
        // llamando al metodo buscarPaisPorNombre que comprueba si existe ese nombre en
        // la base de datos
        if (buscarPaisPorNombre(em, pais1.getPais()) == null) {
            CRUDFruta.insertarPais(pais1, em);
        }
        if (buscarPaisPorNombre(em, pais2.getPais()) == null) {
            CRUDFruta.insertarPais(pais2, em);
        }
        if (buscarPaisPorNombre(em, pais3.getPais()) == null) {
            CRUDFruta.insertarPais(pais3, em);
        }
        CRUDFruta.leerPais(em);
    }

    /**
     * Busca un país por su nombre en la base de datos para que no e creen de nuevo.
     * @param em el EntityManager utilizado para interactuar con la base de datos.
     * @param pais el nombre del país a buscar.
     * @return el objeto de tipo Pais encontrado o null si no existe en la base de datos.
     */
    public static Pais buscarPaisPorNombre(EntityManager em, String pais) {
        TypedQuery<Pais> query = em.createQuery("SELECT p FROM Pais p WHERE p.pais = :nombre", Pais.class);
        query.setParameter("nombre", pais);
        List<Pais> resultados = query.getResultList();
        if (!resultados.isEmpty()) {
            return resultados.get(0);
        }
        else {
            return null;
        }
    }

    /**
     * Inserta un objeto de tipo Pais en la base de datos.
     * @param pais el objeto de tipo Pais a insertar.
     * @param em el EntityManager utilizado para interactuar con la base de datos.
     * @return el objeto de tipo Pais insertado en la base de datos.
     */
    public static Pais insertarPais(Pais pais, EntityManager em) {
        em.getTransaction().begin();

        try {
            em.persist(pais);
            em.getTransaction().commit();

        }
        catch (Exception e) {
            return null;
        }
        return pais;
    }

    /**
     * Lee todos los objetos de tipo Pais almacenados en la base de datos y los muestra por consola.
     * @param em el EntityManager utilizado para interactuar con la base de datos.
     */
    public static void leerPais(EntityManager em){

        TypedQuery<Pais> query = em.createQuery("SELECT p " +
                "FROM Pais p", Pais.class);

        List<Pais> results = query.getResultList();

        for (Pais pais : results) {
            System.out.println(pais);
        }
    }

    /**
     * Busca y devuelve un objeto de tipo Pais de la base de datos según su id.
     * @param em el EntityManager utilizado
     * @param id el id del objeto de tipo Pais a buscar.
     * @return el objeto de tipo Pais encontrado o null si no existe en la base de datos.
     */
    public static Pais buscarPaisId(EntityManager em,int id){

        Pais p = null;

        try{
            p = em.find(Pais.class,id);
        }

        catch (Exception e){
            System.out.println(e.getMessage());
        }

        if(p == null){
            System.out.println("El pais no existe en la base de datos");
            return null;
        }

        return p;
    }

    /**
     * Crea varios objetos de tipo Fruta.
     * @param em el EntityManager utilizado para interactuar con la base de datos.
     */
    public static void crearFruta(EntityManager em){

            Pais Pais1 = CRUDFruta.buscarPaisId(em, 1);
            Pais Pais2 = CRUDFruta.buscarPaisId(em, 2);
            Pais Pais3 = CRUDFruta.buscarPaisId(em, 3);

        // Verificar si ya existe una fruta con el mismo nombre antes de insertarlo
        // llamando al metodo buscarFrutaPorNombre que comprueba si existe ese nombre en
        // la base de datos

            if (buscarFrutaPorNombre(em, "Litchi") == null) {
                Fruta fruta1 = new Fruta("Litchi", "Fruta rija por fuera y blanca por dentro", 0.75f, Pais3);
                CRUDFruta.insertarFruta(fruta1, em);
            }

            if (buscarFrutaPorNombre(em, "Fresa") == null) {
                Fruta fruta2 = new Fruta("Fresa", "Pequeñas y dulces", 1.20f, Pais2);
                CRUDFruta.insertarFruta(fruta2, em);
            }

            if (buscarFrutaPorNombre(em, "Uva") == null) {
                Fruta fruta3 = new Fruta("Uva", "Pequeña fruta roja y jugosa", 2.00f, Pais3);
                CRUDFruta.insertarFruta(fruta3, em);
            }

        CRUDFruta.leerFruta(em);
    }

        /**
         * Busca una fruta por su nombre en la base de datos para que no se creen de nuevo.
         * @param em el EntityManager utilizado para interactuar con la base de datos.
         * @param nombre el nombre de la fruta a buscar.
         * @return el objeto de tipo Fruta encontrado o null si no existe en la base de datos.
         */
        public static Fruta buscarFrutaPorNombre(EntityManager em, String nombre) {
            TypedQuery<Fruta> query = em.createQuery("SELECT f FROM Fruta f WHERE f.nombre = :nombre", Fruta.class);
            query.setParameter("nombre", nombre);
            List<Fruta> resultados = query.getResultList();

            if (!resultados.isEmpty()) {
                return resultados.get(0);
            } else
            {
                return null;
            }
        }

    /**
     * Inserta un objeto de tipo Fruta en la base de datos.
     * @param fruta el objeto de tipo Fruta a insertar.
     * @param em el EntityManager utilizado para interactuar con la base de datos.
     * @return el objeto de tipo Fruta insertado en la base de datos.
     */
    public static Fruta insertarFruta(Fruta fruta, EntityManager em){

        em.getTransaction().begin();

        try {

            em.persist(fruta);
            em.getTransaction().commit();

        }
        catch (Exception e){
            return null;
        }
        System.out.println("Frutas insertadas");
        return fruta;
    }

    /**
     * Lee todos los objetos de tipo Fruta almacenados en la base de datos y los muestra por consola.
     * @param em el EntityManager utilizado para interactuar con la base de datos.
     */
    public static void leerFruta(EntityManager em){

        TypedQuery<Fruta> query = em.createQuery("SELECT f " +
                "FROM Fruta f", Fruta.class);

        List<Fruta> results = query.getResultList();

        for (Fruta fruta : results) {
            System.out.println(fruta);
        }
    }

    /**
     * Consulta y devuelve un objeto de tipo Fruta de la base de datos según su id.
     * @param em el EntityManager utilizado para interactuar con la base de datos.
     * @param id el id del objeto de tipo Fruta a buscar.
     * @return el objeto de tipo Fruta encontrado o null si no existe en la base de datos.
     */
    public static Fruta consultarFrutaId(EntityManager em, int id){

        Fruta fruta= em.find(Fruta.class,id);

        if (fruta == null ){
            return null;
        }
        else {
            return fruta;
        }
    }

    /**
     * Consulta y devuelve un objeto de tipo Fruta de la base de datos según su nombre.
     * @param em el EntityManager utilizado para interactuar con la base de datos.
     * @param nombre el nombre de la fruta a buscar.
     * @return el objeto de tipo Fruta encontrado o null si no existe en la base de datos.
     */
    public static Fruta consultarFrutaNombre(EntityManager em, String nombre){

        TypedQuery<Fruta> alimento
                = em.createQuery("SELECT  f FROM Fruta f " +
                        "WHERE f.nombre ='"+nombre+"'", Fruta.class);

        if (alimento.getResultList().size() == 0 ){
            System.out.println("No existe fruta");
            return null;
        }

        else {
            return alimento.getResultList().get(0);
        }
    }

    /**
     * Modifica los atributos de un objeto de tipo Fruta y actualiza los cambios en la base de datos según su id.
     * @param em el EntityManager utilizado para interactuar con la base de datos.
     * @param id el id del objeto de tipo Fruta a modificar.
     * @param nombre el nuevo nombre de la fruta.
     * @param descripcion la nueva descripción de la fruta.
     * @param precio el nuevo precio de la fruta.
     * @param pais el id del nuevo país de origen de la fruta.
     * @return el objeto de tipo Fruta modificado o null si no se pudo realizar la modificación.
     */
    public static Fruta modificarFrutaId(EntityManager em, int id,String nombre,String descripcion, float precio,int pais){

        Fruta fruta = em.find(Fruta.class,id);

        if (fruta == null ){
            System.out.println("No existe esa id");
            return null;
        }

        else {

            CRUDFruta.modificarFruta(em, fruta, nombre, descripcion,  precio, pais);

            System.out.println("Fruta modificada:");
            return fruta;
        }
    }

    /**
     * Modifica los atributos de un objeto de tipo Fruta y actualiza los cambios en la base de datos.
     * @param em el EntityManager utilizado para interactuar con la base de datos.
     * @param fruta el objeto de tipo Fruta a modificar.
     * @param nombre el nuevo nombre de la fruta.
     * @param descripcion la nueva descripción de la fruta.
     * @param precio el nuevo precio de la fruta.
     * @param pais el id del nuevo país de origen de la fruta.
     * @return el objeto de tipo Fruta modificado o null si no se pudo realizar la modificación.
     */
    public static Fruta modificarFruta(EntityManager em, Fruta fruta, String nombre,String descripcion, float precio,int pais){

        Pais pais1 = CRUDFruta.buscarPaisId(em,pais);
        em.getTransaction().begin();

        try{
            fruta.setNombre(nombre);
            fruta.setDescripcion(descripcion);
            fruta.setPrecio(precio);

            fruta.setPais(pais1);
            em.getTransaction().commit();
        }

        catch (Exception e){
            return null;
        }

        System.out.println("Datos de la fruta modificados");
        return fruta;
    }

    /**
     * Elimina un objeto de tipo Fruta de la base de datos según su id.
     * @param em el EntityManager utilizado para interactuar con la base de datos.
     * @param id el id del objeto de tipo Fruta a eliminar.
     * @return el objeto de tipo Fruta eliminado de la base de datos.
     */
    public static Fruta borrarFrutaId(EntityManager em ,int id){

        Fruta fruta = em.find(Fruta.class,id);

        if (fruta== null ){
            System.out.println("No existe esa id");
            return null;
        }
        CRUDFruta.borrarFruta(fruta,em);

        return fruta;
    }

    /**
     * Elimina un objeto de tipo Fruta de la base de datos.
     * @param fruta el objeto de tipo Fruta a eliminar.
     * @param em el EntityManager utilizado para interactuar con la base de datos.
     * @return el objeto de tipo Fruta eliminado de la base de datos.
     */
    public static Fruta borrarFruta(Fruta fruta, EntityManager em){

        em.getTransaction().begin();

        try {
            em.remove(fruta);
            em.getTransaction().commit();
        }

        catch (Exception e){
            return null;
        }
        System.out.println("Fruta eliminada de la base de datos");

        System.out.println("Fruta eliminada");
        return fruta;
    }
}
