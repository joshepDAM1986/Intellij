package org.example;

import java.io.*;

public class Writer {

    public static void fileWriter() {
        try {
            FileWriter fw = new FileWriter("fichero1.txt");
            fw.write("Texto\r\n");
            fw.write("Más texto");
            fw.close();
        } catch (IOException e) {
            System.out.println("Excepción: " + e);
        }
    }

    public static void bufferedWriter() {
        try {
            FileWriter fw = new FileWriter("C:\\ficheros\\fichero1.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Texto\r\n");
            bw.newLine();
            bw.write("Más texto");
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Excepción: " + e);
        }
    }

    public static void charArrayWriter() {
        try {
            CharArrayWriter caw = new CharArrayWriter();
            caw.write("JAVA");
            FileWriter fw = new FileWriter("C:\\ficheros\\fichero2.txt");
            caw.writeTo(fw);
            fw.close();
        } catch (IOException e) {
            System.out.println("Excepción: " + e);
        }
    }

    public static void printWriter() {
        try {
            PrintWriter pw;
            FileWriter fw = new FileWriter("C:\\ficheros\\fichero3.txt");
            // Escribiendo en fichero
            pw = new PrintWriter(fw);
            pw.println("Escribiendo en fichero ...");
            pw.printf("Escribiendo en fichero por %dª vez ...\n", 2);
            pw.flush();
            pw.close();
            fw.close();
            // Escribiendo en consola
            pw = new PrintWriter(System.out);
            pw.println("Esccribiendo en consola ...");
            pw.printf("Escribiendo en consola por %dª vez ...\n", 2);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            System.out.println("Excepción: " + e);
        }
    }

    public static void stringWriter() {
        StringWriter sw = new StringWriter();
        sw.write("Aprendiendo ");
        sw.write("JAVA\n");
        System.out.println(sw.toString());
        System.out.println(sw.getBuffer());
    }
}