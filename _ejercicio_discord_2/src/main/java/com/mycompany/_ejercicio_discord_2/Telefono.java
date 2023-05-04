
package com.mycompany._ejercicio_discord_2;

/**
 *
 * @author garci
 */
public class Telefono implements IActivar{
    private String marca;
    private Persona persona;

    public Telefono(String marca, Persona persona) {
        this.marca = marca;
        this.persona = persona;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public void on() {
        System.out.println("Telefono encendido");   
    }

    @Override
    public void off() {
        System.out.println("Telefono apagado");    
    }
}
