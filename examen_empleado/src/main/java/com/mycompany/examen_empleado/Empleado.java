
package com.mycompany.examen_empleado;

/**
 *
 * @author garci
 */

class Empleado {
    
private String nombre;
  private String apellidos;
  private double sueldo;
  private double retenciones;
  char categoria;
  private static int nEmpleados;
  private static double prima;

  public Empleado(String nombre){
    this.nombre = nombre;
    this.apellidos = "Díez";
    this.sueldo = 1500;
    this.retenciones = 0.05;
    this.categoria = 'A';
    nEmpleados++;
  }

  public Empleado(String nombre, String apellidos, double sueldoBase, double retenciones, char categoria) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.sueldo = sueldoBase;
    this.retenciones = retenciones;
    this.categoria = categoria;
    nEmpleados++;
  }

  public double calcularSueldo(){
    double sueldo = this.sueldo;
    switch (this.categoria) {
      case 'A':
        sueldo += 100;
        break;
      case 'B':
        sueldo += 200;
        break;
      case 'C':
        sueldo += 300;
        break;
      case 'D':
        sueldo += 500;
        break;
    }
    sueldo *= (1 + prima);
    sueldo *= (1 - retenciones);
    return sueldo;
  }
  
  public static int getNEmpleados() {
    return nEmpleados;
  }
  
  public static void setPrimaGlobal(double primaGlobal) {
    Empleado.prima = primaGlobal;
  }
  
  @Override
  public String toString(){
    return this.nombre + " " + this.apellidos + ": " + String.format("%.2f",this.calcularSueldo()) + " €";
  }
}
