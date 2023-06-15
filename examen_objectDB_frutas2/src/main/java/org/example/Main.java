package org.example;

import javax.persistence.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.DateTimeException;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

            EntityManager em = conectarBaseDatos("Frutas");

            try {
                Scanner scanner = new Scanner(System.in);
                int opcion;

                do {
                    System.out.println("----------- Menú -----------");
                    System.out.println("1. Insertar países");
                    System.out.println("2. Insertar frutas");
                    System.out.println("3. Leer fruta");
                    System.out.println("4. Leer país");
                    System.out.println("5. Consultar fruta por ID");
                    System.out.println("6. Consultar fruta por nombre");
                    System.out.println("7. Modificar fruta por ID");
                    System.out.println("8. Borrar fruta por ID");
                    System.out.println("0. Salir\n");

                    System.out.print("Elige una opción: ");

                    opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1:
                            CRUDFruta.crearPais(em);
                            break;
                        case 2:
                            CRUDFruta.crearFruta(em);
                            break;
                        case 3:
                            CRUDFruta.leerFruta(em);
                            break;
                        case 4:
                            CRUDFruta.leerPais(em);
                            break;
                        case 5:
                            CRUDFruta.consultarFrutaId(em, 2);
                            break;
                        case 6:
                            CRUDFruta.consultarFrutaNombre(em, "Manzana");
                            break;
                        case 7:
                            CRUDFruta.modificarFrutaId(em, 1, "Kiwi", "Una fruta verde y ácida", 0.70f, 3);
                            break;
                        case 8:
                            CRUDFruta.borrarFrutaId(em, 1);
                            break;
                        case 0:
                            System.out.println("Saliendo del programa...");
                            break;
                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }
                }
                while (opcion != 0);
                em.close();
            }

            catch(IllegalArgumentException | NullPointerException | DateTimeException e){
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }

        public static EntityManager conectarBaseDatos(String baseDatos)
        {
            try
            {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/" + baseDatos + ".odb");
                return emf.createEntityManager();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                return null;
            }
        }
    }