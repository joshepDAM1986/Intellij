
package com.mycompany.figuras_geometricas;

/**
 *
 * @author garci
 */
public class Recta {
    // Campos
    Punto p1;
    Punto p2;
    
    // Constructor de la clase Recta
    public Recta(Punto p1, Punto p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    
    // Getter & Setter
    public Punto getP1() {
        return p1;
    } 
    public void setP1(Punto p1) {
    }
    public Punto getP2() {
        return p2;
    }
    public void setP2(Punto p2) {
        this.p2 = p2;
    }
    
    // Método para mostrar la información
    public void mostrarInformacion(){
        System.out.println("Recta con los puntos inicial y final: ");
        System.out.println("Punto inicial: (" + p1.x + ", " + p1.y + ")");
        System.out.println("Punto final: (" + p2.x + ", " + p2.y + ")");
    }
}

