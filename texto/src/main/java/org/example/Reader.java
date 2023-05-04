
package org.example;

import java.io.BufferedReader;
import java.io.LineNumberReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author garci
 *
 */

public class Reader {
    static void fileReader(){
        try {
            FileReader fr = new FileReader("C:\\ficheros\\fichero1.txt");
            int i=fr.read();
            while(i != -1 ){
                System.out.print((char) i );
                    i=fr.read();
        }
            
         fr.close();
    }
         catch (IOException e){
            System.out.println("Excecpción" +e);
        }
    }
    
     static void bufferedReader(){
        try {
            FileReader fr = new FileReader("C:\\ficheros\\fichero2.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea="";
            while((linea=br.readLine()) != null ){
                System.out.println(linea);                   
        }
           
         br.close();
         fr.close();
    }
         catch (IOException e){
            System.out.println("Excecpción" +e);
        }
    }
     
     static void lineNumberReader(){
        try {
            FileReader fr = new FileReader("C:\\ficheros\\fichero1.txt");
            LineNumberReader lnr = new LineNumberReader(fr);
            System.out.println(lnr.getLineNumber()+lnr.readLine());
            System.out.println(lnr.getLineNumber()+lnr.readLine());
            
         lnr.close();
         fr.close();
    }
         catch (IOException e){
            System.out.println("Excecpción" +e);
        }
    }
}

