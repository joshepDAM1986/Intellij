
package com.mycompany._ejercicio_discord_2;

/**
 *
 * @author garci
 */

public class Iphone8 extends Telefono {
    private int codigo;
    private String huella;
    
    public Iphone8(String marca, Persona persona) {
        super(marca, persona);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getHuella() {
        return huella;
    }

    public void setHuella(String huella) {
        this.huella = huella;
    }

}
