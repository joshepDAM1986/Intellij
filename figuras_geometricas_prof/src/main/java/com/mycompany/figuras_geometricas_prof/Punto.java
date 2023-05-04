
package com.mycompany.figuras_geometricas_prof;

/**
 *
 * @author garci
 */

public class Punto {
    private double x;
    private double y;
    
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Punto() {
        x = 0;
        y = 0;
    }
    public double getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
    @Override
    public String toString() {
        return "Punto (" + "x=" + x + ", y=" + y +')';
    }
}