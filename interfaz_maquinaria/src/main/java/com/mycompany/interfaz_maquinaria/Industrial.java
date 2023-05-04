
package com.mycompany.interfaz_maquinaria;

/**
 *
 * @author garci
 */

public class Industrial extends SuperMaquina implements IMaquinaria{
     private int consumo;
     private boolean armado;

    public Industrial(String nSerie, String modelo, int consumo) {
        super(nSerie, modelo);
        this.consumo=consumo;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }
     
    @Override
    public void encender() {
        System.out.println("Armando sistema");
        armado=true;
    }

    @Override
    public void apagar() {
        System.out.println("Apagado seguro del sistema");
        armado=false;
    }

    @Override
    public String caracteristicas() {
        return IMaquinaria.super.caracteristicas() + "\n"
                + this.getModelo() + "\n"
                + this.getnSerie() + "\n"
                +this.getConsumo() + "w" + " \n"
                +this.getHoras();   
    }

}


