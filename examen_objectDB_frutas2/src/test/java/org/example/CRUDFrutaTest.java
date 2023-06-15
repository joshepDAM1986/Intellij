package org.example;

import org.junit.jupiter.api.*;
import javax.persistence.*;
import static org.junit.jupiter.api.Assertions.*;

class CRUDFrutaTest {

    private EntityManager em;

    public void Manager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/Frutas.odb");
        em = emf.createEntityManager();
    }

    @Test
    void insertarPais() {

        Manager(); // Inicializar el EntityManager

        Pais esperado = new Pais("Costa Rica");
        Pais pais = esperado;

        //given
        Pais buscado = CRUDFruta.insertarPais(pais, em);

        //then
        try{
            assertSame(esperado,buscado);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void insertarFruta() {

        Manager(); // Inicializar el EntityManager

        Pais pais = em.find(Pais.class,1);
        Fruta esperado = new Fruta("Manzana","Fruta harinosa",0.25f,pais);
        Fruta fruta = esperado;

        //given
        Fruta buscado = CRUDFruta.insertarFruta(fruta, em);

        //then
        try{
            assertSame(esperado,buscado); //Comparacion exacta
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void consultarFrutaId() {

        Manager(); // Inicializar el EntityManager antes de la prueba

        int id =2;

        Fruta esperado = em.find(Fruta.class,id);

        //Given
        Fruta buscado = CRUDFruta.consultarFrutaId(em,2);

        //then
        try{
            assertEquals(esperado, buscado);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void modificarFrutaId() {
        Manager(); // Inicializar el EntityManager antes de la prueba

        //When
        int id = 1;
        Fruta esperada = em.find(Fruta.class,id);
        //Given
        Fruta modificada = CRUDFruta.modificarFruta(em,esperada,"Pera","Fruta verde",0.50f,2);

        //Then
        try{
            assertSame(esperada,modificada);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    void borrarFrutaId() {
        Manager(); // Inicializar el EntityManager antes de la prueba

        //When
        int id = 1;
        Fruta esperado = em.find(Fruta.class,id);

        //Given
        Fruta buscado = CRUDFruta.borrarFruta(esperado,em);

        //Then
        try{
            assertSame(esperado,buscado);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}