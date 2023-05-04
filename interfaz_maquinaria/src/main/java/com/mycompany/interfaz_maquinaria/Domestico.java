
package com.mycompany.interfaz_maquinaria;

/**
 *
 * @author garci
 */

public class Domestico extends SuperMaquina implements IMaquinaria {
    
    private boolean encendido;

    public Domestico(String nSerie, String modelo) {
        super(nSerie, modelo);
    }

    @Override
    public void encender() {
        System.out.println("Se enciende la máquina");
        encendido=true;
    }

    @Override
    public void apagar() {
        System.out.println("Se apaga la máquina");
        encendido=false;
    }

    @Override
    public String caracteristicas() {
        return IMaquinaria.super.caracteristicas() + "\n"         
        + this.getModelo() + "\n"
        + this.getnSerie() + "\n"      
        + "Maquina de uso doméstico";
                    
    }
   
}
    