
package com.mycompany.herencia_ejercicio;

/**
 *
 * @author garci
 */


public class Empresa {

/*
   private Empleado e1 = new Empleado("Ana","Lopez","2483F","Director");
   private Empleado e2 = new Empleado("Jorge","Cruz","8318M","Programador");
   private Empleado e3 = new Empleado("Sergio","Perez","8312K","Administrativo");
   private Persona cl1 = new Persona("Luisa","Sanchez","8124G","Granada");
   private Persona cl2 = new Persona("Carmen","Perez","4298P","Zaragoza");

    public Empleado getE1() {
        return e1;
    }

    public void setE1(Empleado e1) {
        this.e1 = e1;
    }

    public Empleado getE2() {
        return e2;
    }

    public void setE2(Empleado e2) {
        this.e2 = e2;
    }

    public Empleado getE3() {
        return e3;
    }

    public void setE3(Empleado e3) {
        this.e3 = e3;
    }

    public Persona getCl1() {
        return cl1;
    }

    public void setCl1(Persona cl1) {
        this.cl1 = cl1;
    }

    public Persona getCl2() {
        return cl2;
    }

    public void setCl2(Persona cl2) {
        this.cl2 = cl2;
    }
    
    @Override
    public String toString() {
        return "\n"+e1 + "\n\n" + e2 + "\n\n" + e3 + "\n\n" + cl1 + "\n\n" + cl2;
    }
*/

   private Empleado director;
   private Empleado programador;
   private Empleado administrativo;
   private Persona cliente1;
   private Persona cliente2;
   
    public Empleado getDirector() {
        return director;
    }

    public void setDirector(Empleado director) {
        this.director = director;
    }

    public Empleado getProgramador() {
        return programador;
    }

    public void setProgramador(Empleado programador) {
        this.programador = programador;
    }

    public Empleado getAdministrativo() {
        return administrativo;
    }

    public void setAdministrativo(Empleado administrativo) {
        this.administrativo = administrativo;
    }

    public Persona getCliente1() {
        return cliente1;
    }

    public void setCliente1(Persona cliente1) {
        this.cliente1 = cliente1;
    }

    public Persona getCliente2() {
        return cliente2;
    }

    public void setCliente2(Persona cliente2) {
        this.cliente2 = cliente2;
    }

    @Override
    public String toString() {
        return "director=" + director + ", programador=" + programador + ", administrativo=" + administrativo + ", cliente1=" + cliente1 + ", cliente2=" + cliente2;
    }

}
