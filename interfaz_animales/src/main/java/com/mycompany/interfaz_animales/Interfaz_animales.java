
package com.mycompany.interfaz_animales;

/**
 *
 * @author garci
 */

public class Interfaz_animales {

    public static void main(String[] args) {
      Perro pe = new Perro("Rex",10);
      
      System.out.println(pe.informe());
      pe.mover(100,200);
      pe.comer(100);
      pe.ladrar();
      
      for(int i=0;i>=50;i++){
            pe.engordar();
       }

      Pajaro pa = new Pajaro("Piolin","Verde");
      
      System.out.println(pa.informe());
      pa.mover(10,20);
      pa.comer(10);
      pa.volar();
      pa.piar();
      
      EstrellaMar es = new EstrellaMar("Patricio",5);
      
      System.out.println(es.informe());
      es.mover(1,2);
      es.comer(1);
      es.nadar();
      es.regenerar();
      
      Mono mo = new Mono("Amelio",4);
        System.out.println(mo.informe());
        mo.mover(10, 20);
        mo.comer(5);
        mo.hablar();
        mo.pensar();
        mo.crearHerramientas();
        
      Humano hu = new Humano("Josele");
        System.out.println(hu.informe());
        hu.mover(100, 200);
        hu.comer(300);
        hu.hablar();
        hu.pensar();
        hu.crearHerramientas();
    }
    
}
