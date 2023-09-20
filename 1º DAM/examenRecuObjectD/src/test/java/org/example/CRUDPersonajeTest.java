package org.example;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class CRUDPersonajeTest {
    private EntityManager em;

    public void Manager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/Personajes.odb");
        em = emf.createEntityManager();
    }
    @Test
    void insertarPersonaje() {
        Manager(); // Inicializar el EntityManager

        Especie especie = em.find(Especie.class, 1);
        Arma arma = em.find(Arma.class, 1);
        Afiliacion afiliacion = em.find(Afiliacion.class, 1);
        Personaje esperado = new Personaje("Jose Miguel", especie, "Un chaval to apañao.", 37, 1.67f, arma, afiliacion);
        Personaje personaje = esperado;

        //given
        Personaje buscado = CRUDPersonaje.insertarPersonaje(personaje, em);
        //then
        try {
            assertSame(esperado, buscado); //Comparacion exacta
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void borrarFrutaId() {
        Manager(); // Inicializar el EntityManager antes de la prueba

        //When
        int id = 6;
        Personaje esperado = em.find(Personaje.class,id);

        //Given
        Personaje buscado = CRUDPersonaje.eliminarPersonaje(em,6);

        //Then
        try{
            assertSame(esperado,buscado);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}