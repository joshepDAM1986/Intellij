
package com.mycompany.interfaz_animales;

/**
 *
 * @author garci
 */

//-metodos
//metodo nada()
//metodo regenerar()

//informe()

//-atributos
//int brazos 5

public class EstrellaMar implements IAnimal {
    private String nombre;
    private int nBrazos;

    public EstrellaMar(String nombre, int nBrazos) {
        this.nombre = nombre;
        this.nBrazos = nBrazos;
    }

    public int getnBrazos() {
        return nBrazos;
    }

    public void setnBrazos(int nBrazos) {
        this.nBrazos = nBrazos;
    }

    public void nadar(){
        System.out.println("La estrella de mas puede nadar");
    }
    
    public void regenerar(){
        System.out.println("La estrella de mar puede regenerar sus extremidades");
    }

    @Override
    public void mover(int x, int y) {
        System.out.println("La estrella se mueve a la posición " + x + " , "  + y);
    }

    @Override
    public void comer(int cantidad) {
        System.out.println("La estrella come " + cantidad + " gramos de placton");
    }

    @Override
    public String informe() {
        return IAnimal.super.informe()
        +"\n"
        +"Animal: Estrella de mar\n" 
        +"Nombre: " +nombre + "\n"
        + "Número de brazos:" + nBrazos;
    }
    
}
