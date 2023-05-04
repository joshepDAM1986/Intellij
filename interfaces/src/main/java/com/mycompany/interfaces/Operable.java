
package com.mycompany.interfaces;

/**
 *
 * @author garci
 */

public interface Operable {
    public String getIdVehicule();
    public void acelerar();
    public void frenar();
    
    
    // Metodo immplementado por defecto por la interface
    default public void imprimirUbicacionGeografica(){
        System.out.println("Implementación por defecto en interface");
    }
    public static void resumirMetodosInterface(){
        System.out.println("getIdVehiculo, acelerar, frenar" + ", imprimirUbicacionGeografica, resumirMetodosInterfaces");
    }
    public static void resumirMetodosInterfaceBicicleta(){
        System.out.println("getNombre, acelerar, frenar" + " imprimirUbicacionGeografica, resumirMetodosInterfacesBicicleta");
    }
}
