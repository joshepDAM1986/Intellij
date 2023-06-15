package org.example;


import java.sql.Statement;
/**
 * El metodo main donde son llamados todos los metodos de la clase CRUDFrutas
 * 
 */
public class Main {

    public static void main(String[] args) {

            try {
                Statement stmt = CRUDFrutas.conectar();
                if (stmt != null) {

//                    /* Insertar Frutas */
//                      CRUDFrutas.insertarFrutas(stmt, "Uva", "Pequeñas y dulces uvas disponibles en racimos de diferentes colores", 1.20f, 1);
//                      CRUDFrutas.insertarFrutas(stmt, "Fresa","Pequeña fruta roja y jugosa, ideal para postres y ensaladas", 2.00f, 2);
//                      CRUDFrutas.insertarFrutas(stmt, "Peras","Fruta jugosa con una textura suave y dulce sabor", 0.80f, 3);
//                      CRUDFrutas.insertarFrutas(stmt, "Plátano","Una fruta alargada y dulce, rica en potasio y energía", 0.70f, 4);
//                      CRUDFrutas.insertarFrutas(stmt, "Piña","Una fruta tropical dulce y jugosa, conocida por su sabor refrescante", 2.50f, 5);
//                      CRUDFrutas.insertarFrutas(stmt, "Melocotón","Fruta de pulpa suave y jugosa, con un sabor dulce y aromático", 1.00f, 6);

//                    /* Modificar Frutas */
//                      CRUDFrutas.modificarFrutas(stmt, 57, "UVA","Pequeñas y dulces uvas disponibles en racimos de diferentes colores", 2.00f, 1);
//
//                    /* Borrar Frutas */
//                      CRUDFrutas.borrarFrutas(stmt, 62);

//
//                    /* Lista Inglés */
//                      CRUDFrutas.datosFrutaIngles(stmt);
//
//                    /* Media Precio */
//                      CRUDFrutas.mediaPrecioFrutas(stmt);
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }