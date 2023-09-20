package org.example;

import java.io.*;

public class Reader{
    public static void fileReader(){
        try {
            FileReader fr = new FileReader("fichero1.txt");
            /*
            int i = fr.read();
            while(i != -1){
                System.out.println((char) i);
                i = fr.read();
            }
            fr.close();
             */
            int i;
            while((i=fr.read()) != -1){
                System.out.print((char)i);
            }
            fr.close();
        }
        catch(IOException e){
            System.out.println("Excepción: " + e);
        }
    }

    public static void bufferedReader(){
        try{
            FileReader fr = new FileReader("fichero1.txt");
            BufferedReader br = new BufferedReader (fr);
            String linea = "";
            while((linea=br.readLine())!=null){
                System.out.println(linea);
            }
            br.close();
            fr.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public static void lineNumberReader(){
        try {
            FileReader fr = new FileReader("C:\\ficheros\\fichero1.txt");
            LineNumberReader lnr = new LineNumberReader(fr);
            System.out.println(lnr.getLineNumber() + "-" + lnr.readLine());
            lnr.setLineNumber(2);
            System.out.println(lnr.getLineNumber() + "-" + lnr.readLine());
            lnr.close();
            fr.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public static void charArrayReader(){
        try {
            char[] array = "123 JAVA".toCharArray();
            CharArrayReader car = new CharArrayReader(array);
            car.skip(4);
            int k = 0;
            while ((k = car.read()) != -1) {
                System.out.println((char) k);
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public static void stringReader(){
        try {
            StringReader sr = new StringReader("Aprendiendo JAVA\n");
            int c = 0;
            while ((c = sr.read()) != -1) {
                System.out.println((char) c);
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
