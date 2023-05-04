package org.example;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.IOException;

public class Writer {
    public static void fileWriter(){
        try{
            FileWriter fw = new FileWriter("C:\\ficheros\\fichero1.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.write("texto\n");
            pw.write("mas textoooo\n");
            pw.close();
            pw = new PrintWriter(System.out);
           //pw.println("Escribiendo en la consola");
           // pw.flush();
           // pw.close();
            
        }
        catch(IOException e){
            System.out.println("Excecpción" +e);
        }
    }

    public static void stringWriter() {
        try {
            FileWriter fw = new FileWriter("C:\\ficheros\\fichero2.txt");
            PrintWriter pw = new PrintWriter(fw);
            StringWriter sw = new StringWriter();
            sw.write("texto\n");
            sw.write("mas texto\n");
            sw.write("aun mas texto\n");
            sw.close();
            pw.println(sw.getBuffer());
            pw.close();

        } catch (IOException e) {
            System.out.println("Excecpción" + e);
        }

    }
}
