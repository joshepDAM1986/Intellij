
package com.mycompany.base_datos_alumnado;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author garci
 */

public class Datos {
    public static void fileWriter() {
        try {
            FileWriter fw = new FileWriter("C:\\ficheros\\datos_alumnos.txt", true);
            PrintWriter pw = new PrintWriter(fw);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese el nombre:");
            String nombre = scanner.nextLine();
            pw.write("Nombre: ");
            pw.write(nombre + "\n");

            System.out.println("Ingrese los apellidos:");
            String apellidos = scanner.nextLine();
            pw.write("Apellidos: ");
            pw.write(apellidos + "\n");
            
            System.out.println("Ingrese la edad:");
            byte  edad = scanner.nextByte();
            pw.write("Edad: ");
            pw.write(edad + "\n\n");
            pw.close();
            pw = new PrintWriter(System.out);
            
        } catch (IOException e) {
            System.out.println("Excecpción" + e);
        }
    }
}