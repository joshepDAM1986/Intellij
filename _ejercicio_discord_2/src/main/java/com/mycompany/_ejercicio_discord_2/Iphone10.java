
package com.mycompany._ejercicio_discord_2;

/**
 *
 * @author garci
 */

public class Iphone10 extends Iphone8 implements IValidar {
    private String patronRastro;

    public Iphone10(String marca,Persona persona,String patronRostro) {
        super(marca, persona);
        this.patronRastro = patronRastro;
    }

    public String getPatronRastro() {
        return patronRastro;
    }

    public void setPatronRastro(String patronRastro) {
        this.patronRastro = patronRastro;
    }

    @Override
    public boolean validar(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}


