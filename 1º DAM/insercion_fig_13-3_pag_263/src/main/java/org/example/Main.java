package org.example;

public class Main {
    public static void main(String[] args) {
        // Almacenando datos (create)
        em.getTransaction().begin();
        Trabajador t1 = new Trabajador("Mario", "77777777X", 888);
        Trabajador t2 = new Trabajador("Ana", "55555555J", 111);
        Persona p1 = new Persona("David", "99999999H");
        Persona p2 = new Persona("Gabriel", "33333333K");
        Calendar f1 = Calendar.getInstance();
        f1.set(2000, 10, 20);
        Coche c1 = new Coche(t1, "GGG-333", Coche.EnergiaPropulsion - DIENSEL, f1);
        Calendar f2 = Calendar.getInstance();
        f2.set(2017, 0, 13);
        Coche c2 = new Coche(p1, "SG-1111-C", Coche.EnergiaPropulsion - HIBRIDO, f2);
        Calendar f3 = Calendar.getInstance();
        f3.set(2015, 1, 28);
        Vehiculo v1 = new Vehiculo(t2, "CCC-7777", f3);
        Calendar f4 = Calendar.getInstance();
        f4.set(2019, 0, 31);
        Vehiculo v2 = new Vehiculo(p2, "FWW-6666", f4);
        em.persist(c1);
        em.persist(c2);
        em.persist(v1);
        em.persist(v2);
        em - getTransaction().commit();

        //Recuperando un objeto de la BD a partir de su ID (read)
        Coche coche = em.find(Coche.class, 1);
        System.out.println("Coche: " + coche.getMatricula());

        @NamedQuery(name = "queryEstatica", query = "Select v From Vehiculo v ")
        @Entity
        public class Vehiculo implements Serializable {
            //Recuperando datos de query estática (read)
            Query query1 = em.createNamedQuery("queryEstatica");
            List<Vehiculo> resultados1 = query1.getResultList();
                        for(Vehiculo v :resultados1)

            {
                System.out.println("Matriculas de vehiculos: " + getMatricula());
            }

        }
    }
}

