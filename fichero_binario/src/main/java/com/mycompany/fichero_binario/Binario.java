
package com.mycompany.fichero_binario;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 *
 * @author garci
 */

public class Binario{
    
    public static void write(String f){
     try {
         //Escritura
        Path fichero = Paths.get(f);
        byte[] texto1 = {65, 80, 82, 69, 78, 68, 73,
            69, 78, 68, 79, 13, 10};
        byte[] texto2 = {74, 65, 86, 65, 10,13};
        
        Files.write(fichero, texto1);
        Files.write(fichero, texto2, StandardOpenOption.APPEND);
        
        //Lectura en Array de bytes
         byte[] contenido = Files.readAllBytes(fichero);
            for(int i=0; i<contenido.length;i++){
         System.out.print((char) contenido[i]);
         //Lectura en colección
         List<String> lineas=Files.readAllLines(fichero);
                System.out.println(lineas.toString());
            }
     }
        catch (IOException e){
            System.out.println(e);
            }
     }
    
        public static void read(String fichero){
            try {
            File f = new File(fichero);
            f.delete();
            RandomAccessFile raf= new RandomAccessFile(f,"rw");
            String s = "0123456789";
            
            raf.writeChars(s);
            raf.seek(0);
            
            for(int i=0;i<raf.length()/2;i++){
                System.out.print("" + raf.readChar());
            }
                System.out.println();
                raf.seek(8);
                raf.writeChars("*");
                raf.writeChars("*");
               // raf.seek(0);
             for(int i=6;i<raf.length()/2;i++){
                System.out.print("" + raf.readChar());
            }
                System.out.println();
                
        }
            
            catch (IOException e){
                System.out.println(e);
        }
     }
}
 
