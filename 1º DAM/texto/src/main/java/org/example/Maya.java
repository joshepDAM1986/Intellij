package org.example;

import java.io.*;
import java.util.ArrayList;

public class Maya {
    public static void crearArchivo1() {
        try {
            // Creamos el "archivo1.txt" para almacenar la letra
            FileWriter archivo1 = new FileWriter("archivo1.txt");

            // Instanciamos la clase PrintWriter para escribir en el archivo1.txt
            PrintWriter pw = new PrintWriter(archivo1);
            pw.println("En un pais multicolor");
            pw.println("Vivia una abeja bajo el sol");
            pw.println("Y fue famosa en el lugar");
            pw.println("Por su alegria y su bondad");
            archivo1.close();
        } catch (IOException e) {
            System.out.println("Excepcion: " + e);
        }
    }

    public static void crearArchivo2() {
        try {
            // Creamos el "archivo2.txt" para almacenar la letra de forma inversa
            FileWriter archivo2 = new FileWriter("archivo2.txt");

            // Instanciamos la clase FileReader para leer el archivo1.txt
            FileReader archivo1 = new FileReader("archivo1.txt");


            BufferedReader br = new BufferedReader(archivo1);
            ArrayList<String> contenido = new ArrayList<>();
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.add(linea);
            }
            for (int i = contenido.size() - 1; i >= 0; i--) {
                System.out.println(contenido.get(i));
                archivo2.write(contenido.get(i) + "\n");
            }
            archivo2.close();
        } catch (IOException e) {
            System.out.println("Excepcion: " + e);
        }
    }
}

/*
    SOLUCIÓN MATIAS

    public static void escribirInvertido(String documento) {
     try {
     FileReader fr = new FileReader(documento);
    BufferedReader br = new BufferedReader(fr);

    StringBuilder documentoInvertido = new StringBuilder();
    String leido;
    while ((leido = br.readLine()) != null) {
     documentoInvertido.insert(0, leido + "\n");
    }

     FileWriter fw = new FileWriter(documento.substring(0, documento.indexOf(".")) + "Invert.txt");
    PrintWriter pw = new PrintWriter(fw);

    pw.printf(documentoInvertido.toString());
    pw.flush();
    pw.close();

    br.close();
    } catch (IOException e) {
     throw new RuntimeException(e);
    }
    }
 */