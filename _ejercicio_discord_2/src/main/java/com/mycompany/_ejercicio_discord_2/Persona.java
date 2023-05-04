
package com.mycompany._ejercicio_discord_2;

/**
 *
 * @author garci
 */

public class Persona implements IValidar {
    private String nombre;
    private int codigo;
    private String patron;
    private String patronRostro;
    private String huella;

    public Persona(String nombre, int codigo, String patron, String patronRostro, String huella) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.patron = patron;
        this.patronRostro = patronRostro;
        this.huella = huella;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
        this.patron = patron;
    }

    public String getPatronRostro() {
        return patronRostro;
    }

    public void setPatronRostro(String patronRostro) {
        this.patronRostro = patronRostro;
    }

    public String getHuella() {
        return huella;
    }

    public void setHuella(String huella) {
        this.huella = huella;
    }

    @Override
    public boolean validar(Persona persona) {
        return persona.getPatron().equals(patron);
    }
}
