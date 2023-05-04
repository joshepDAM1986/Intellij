
package com.mycompany.asociacion;

/**
 *
 * @author garci
 */
class Asociacion {

    public static void main(String[] args) {
       Universidad u;
       u=new Universidad("Universidad de Oxford");
       Alumno a;
       a=new Alumno ("Flora");
       System.out.println(a.getNombreAlumno()+" estudió en la "+ u.getNombreUniversidad());
       
        System.out.println("------------------------------------------------------------------------");
       
       Ciudad ciu;
       ciu=new Ciudad("Granada");
       Ciudadano c;
       c=new Ciudadano("Josele");
       System.out.println(c.getNombreCiudadano() +" es granadino porque nació en "+ ciu.getNombreCiudad());
    }
}
