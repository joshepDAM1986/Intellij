
package com.mycompany.figuras_geometricas;

import java.util.Scanner;

/**
 *
 * @author garci
 */

public class Figuras_geometricas {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Punto punto = null;
    Recta recta = null;
    Circunferencia circunferencia = null;
    
            while(true){
                System.out.println("Menú de opciones: ");
                System.out.println("1. Crear punto");
                System.out.println("2. Crear recta");
                System.out.println("3. Crear circunferencia");
                System.out.println("4. Mostrar información");
                System.out.println("5. Salir");
                System.out.println("");
                System.out.println("Selecciona una opción: ");
                int opcion = sc.nextInt();
                if(opcion==1){
                System.out.println("Introduzca la coordenada x: ");
                double x = sc.nextDouble();
                System.out.println("Introduzca la coordenada y: ");
                double y = sc.nextDouble();
                punto = new Punto(x,y);
                System.out.println("Punto creado correctamente");
            }

            else if(opcion==2){
                System.out.println("Introduzca la coordenada x del punto inicial: ");
                double x1 = sc.nextDouble();
                System.out.println("Introduzca la coordenada y del punt inicial: ");
                double y1 = sc.nextDouble();
                System.out.println("Introduzca la coordenada x del punto final: ");
                double x2 = sc.nextDouble();
                System.out.println("Introduzca la coordenada y del punto final: ");
                double y2 = sc.nextDouble();
                punto = new Punto(x1, y1);
                punto = new Punto(x2, y2);
                recta = new Recta(punto, punto);
                System.out.println("Recta creada correctamente");
            }
            else if(opcion==3){
                System.out.println("Introduzca la coordenada x del punto central: ");
                double x = sc.nextDouble();
                System.out.println("Introduzca la coordenada y del punto central: ");
                double y = sc.nextDouble();
                System.out.println("Introduzca el radio de la circunferencia: ");
                double radio = sc.nextDouble();
                circunferencia = new Circunferencia(punto, radio);
                System.out.println("Circunferencia creada correctamente");
            }
            else if(opcion==4){
                System.out.println("Información sobre el punto: ");
                punto.mostrarInformacion();
                System.out.println("Información sobre la recta: ");
                recta.mostrarInformacion();
                System.out.println("Información sobre la circunferencia: ");
                circunferencia.mostrarInformacion();
            }
            else if(opcion==5){
                System.out.println("El programa ha terminado, gracias!");
            }
        }
    }
}

