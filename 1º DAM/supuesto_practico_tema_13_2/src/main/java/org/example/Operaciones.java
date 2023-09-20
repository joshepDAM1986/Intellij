package org.example;

import javax.persistence.*;
import java.util.*;


public class Operaciones {
        public static void ingresarDatosInstancias(EntityManager em) {

            try {
                em.getTransaction().begin();

                // Crear productos
                Productos producto1 = new Productos("Manzana", "Fruta Roja", 0.2f, "Asia");
                Productos producto2 = new Productos("Limón", "Fruta Amarilla", 0.25f, "Sicilia");
                Productos producto3 = new Productos("Naranja", "Fruta Naranja", 0.15f, "Brasil");
                Productos producto4 = new Productos("Kiwi", "Fruta verde", 0.35f, "China");
                Productos producto5 = new Productos("Ciruela", "Fruta morada", 0.30f, "Turquía");

                List<Productos> productos = new ArrayList<>();
                productos.add(producto1);
                productos.add(producto2);
                productos.add(producto3);
                productos.add(producto4);
                productos.add(producto5);

                // Verificar si los nombres de los productos ya existen en la base de datos
                List<String> nombresProductos = new ArrayList<>();
                for (Productos producto : productos) {
                    nombresProductos.add(producto.getNombre());
                }

                TypedQuery<Productos> nombreProductosQuery = em.createQuery("SELECT p FROM Productos p WHERE p.nombre IN :nombres", Productos.class);
                nombreProductosQuery.setParameter("nombres", nombresProductos);
                List<Productos> productosExistentes = nombreProductosQuery.getResultList();

                if (!productosExistentes.isEmpty()) {
                    System.out.println("Ya existe al menos un producto con el mismo nombre.");
                    em.getTransaction().rollback();
                    return;
                }

                // Guardar en la base de datos
                for (Productos producto : productos) {
                    em.persist(producto);
                }

                em.getTransaction().commit();
                System.out.println("\nDatos de instancias insertados\n");
            } catch (Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
            }
        }

    public static void consultarProductos(EntityManager em) {
        System.out.println("Datos de todos los vehículos de la base de datos:");
        System.out.println("-------------------------------------------------");
        TypedQuery<Productos> query
                = em.createQuery("SELECT id FROM Productos id",
                Productos.class);
        List<Productos> results = query.getResultList();
        for (Productos producto : results) {
            System.out.println(producto);
        }
    }

     public static void consultarProductosId(EntityManager em) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la id del producto:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Datos del producto buscado:");
        System.out.println("---------------------------");
        Productos producto = em.find(Productos.class, id);
        System.out.println(producto);
    }

    public static void consultarProductosQuery(EntityManager em) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la id del producto:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Datos del producto buscado:");
        System.out.println("---------------------------");
        TypedQuery consulta = em.createQuery("SELECT b FROM Productos b " +
                "WHERE b.id = " + id + "", Productos.class);
        List<Productos> resultado = consulta.getResultList();
        for (Productos producto : resultado) {
            System.out.println(producto);
        }
    }

    public static void modificarDatosPorId(EntityManager em) {
        em.getTransaction().begin();

        Scanner sc = new Scanner(System.in);
        System.out.println("Para modificar los datos de un producto, introduce su ID:");
        int id = sc.nextInt();
        sc.nextLine();

        Productos producto = em.find(Productos.class, id);
        System.out.println(producto);
        if (producto != null) {
            System.out.println("¿Qué dato desea modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Descripción");
            System.out.println("3. Precio");
            System.out.println("4. País");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduce el nuevo nombre:");
                    String nuevoNombre = sc.nextLine();
                    producto.setNombre(nuevoNombre);
                }
                case 2 -> {
                    System.out.println("Introduce la nueva descripción:");
                    String nuevaDescripcion = sc.nextLine();
                    producto.setDescripcion(nuevaDescripcion);
                }
                case 3 -> {
                    System.out.println("Introduce el nuevo precio:");
                    float nuevoPrecio = sc.nextFloat();
                    producto.setPrecio(nuevoPrecio);
                }
                case 4 -> {
                    System.out.println("Introduce el nuevo país:");
                    String nuevoPais = sc.nextLine();
                    producto.setPais(nuevoPais);
                }
                default -> System.out.println("Opción incorrecta.");
            }
            em.getTransaction().commit();
            System.out.println("Los datos han sido modificados correctamente.");
        } else {
            em.getTransaction().commit();
            System.out.println("No se ha encontrado un producto con esa ID en la base de datos.");
        }
    }

    public static void modificarDatosPorQuery(EntityManager em) {
        em.getTransaction().begin();

        Scanner sc = new Scanner(System.in);
        System.out.println("Para modificar los datos de un producto, introduce su ID:");
        int id = sc.nextInt();
        sc.nextLine();

        TypedQuery consulta = em.createQuery("SELECT b FROM Productos b " +
                "WHERE b.id = " + id + "", Productos.class);
        List<Productos> resultado = consulta.getResultList();
        for (Productos producto : resultado) {
            System.out.println(producto);

            if (producto != null) {
                System.out.println("¿Qué dato desea modificar?");
                System.out.println("1. Nombre");
                System.out.println("2. Descripción");
                System.out.println("3. Precio");
                System.out.println("4. País");
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1 -> {
                        System.out.println("Introduce el nuevo nombre:");
                        String nuevoNombre = sc.nextLine();
                        producto.setNombre(nuevoNombre);
                    }
                    case 2 -> {
                        System.out.println("Introduce la nueva descripción:");
                        String nuevaDescripcion = sc.nextLine();
                        producto.setDescripcion(nuevaDescripcion);
                    }
                    case 3 -> {
                        System.out.println("Introduce el nuevo precio:");
                        float nuevoPrecio = sc.nextFloat();
                        producto.setPrecio(nuevoPrecio);
                    }
                    case 4 -> {
                        System.out.println("Introduce el nuevo país:");
                        String nuevoPais = sc.nextLine();
                        producto.setPais(nuevoPais);
                    }
                    default -> System.out.println("Opción incorrecta.");
                }
                em.getTransaction().commit();
                System.out.println("Los datos han sido modificados correctamente.");
            }
            else {
                em.getTransaction().commit();
                System.out.println("No se ha encontrado un producto con esa ID en la base de datos.");

            }

        }

    }
    public static void borrarProductosPorId(EntityManager em){
        Query query = em.createQuery("SELECT p FROM Productos p ORDER BY p.id ASC");
        query.setMaxResults(1);
        Productos producto = (Productos) query.getSingleResult();
        if (producto != null) {
            em.getTransaction().begin();
            em.remove(producto);
            em.getTransaction().commit();
            System.out.println("Producto eliminado con éxito.");
        } else {
            System.out.println("No se encontró ningún producto para eliminar.");
        }
    }

    public static void borrarProductosPorQuery(EntityManager em) {
        em.getTransaction().begin();

        int idMasBajo = em.createQuery("SELECT MIN(p.id) " +
                "FROM Productos p", int.class).getSingleResult();

        int numBorrados = em.createQuery("DELETE FROM Productos p WHERE p.id = :id")
                .setParameter("id", idMasBajo).executeUpdate();

        em.getTransaction().commit();
        System.out.println("Vehículos borrados: " + numBorrados);
    }
}
