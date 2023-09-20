package org.example;

import java.sql.Connection;
import java.sql.Date;

public class Main {
    public static void main(String[] args) {

       //CRUD.probarConexion();

        try {
            Connection cn = CRUD.conectar();
            if(cn!=null) {
                CRUDPersona.insertarPersona();
                //CRUDPersona.insertarTrabajador();
                //CRUDPersona.lecturaPersona(cn);
                //CRUDPersona.eliminarPersona(cn, "22222222B");
                //CRUDVehiculo.insertarVehiculo();
                //CRUDVehiculo.insertarCoche();
                //CRUDVehiculo.lecturaVehiculo(cn);
                //CRUDVehiculo.lecturaVehículoID(cn, 1);
                //CRUDVehiculo.modificarVehiculo(cn, 7, "321CBA", Date.valueOf("2051-03-01"), "75957482B");
                //CRUDVehiculo.eliminarVehiculo(cn, 2);
                cn.close();
            } else {
                System.out.println("No se ha podido establecer la conexión.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}