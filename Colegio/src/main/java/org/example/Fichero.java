package org.example;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Fichero {
    static final int TAM_REGISTRO_CHARS = 60;
    static final int TAM_REGISTRO_BYTES = 121;

    public static void escribir(Alumno a, String fichero)
    {
        try {
            File f = new File(fichero);

            RandomAccessFile raf =
                    new RandomAccessFile(f, "rw");

            //Posicionar al final del archivo
            if (f.length()>0)
                raf.seek(f.length());
            raf.writeChars(a.toString());
            raf.writeByte(a.getEdad());

            raf.close();

        }
        catch (IOException e) {
            System.out.println(e);
        }

    }

    /**
     * Actualiza el alumno index con el objeto a en fichero
     * @param a
     * @param fichero
     * @param index
     */
    public static void actualizar(Alumno a, String fichero, int index)
    {
        try {
            File f = new File(fichero);

            RandomAccessFile raf =
                    new RandomAccessFile(f, "rw");

            //Posicionar el archivo en index
            if (f.length()>0)
                raf.seek((index-1) * TAM_REGISTRO_BYTES);
            raf.writeChars(a.toString());
            raf.writeByte(a.getEdad());

            raf.close();

        }
        catch (IOException e) {
            System.out.println(e);
        }

    }

    public static Alumno leer(String fichero, int index)
    {
        try {
            Alumno a;
            File f = new File(fichero);
            String datosChar="";
            byte edad = 0;
            RandomAccessFile raf =
                    new RandomAccessFile(f, "rw");

            //Posicionar el archivo en index
            if (f.length()>0)
                raf.seek((index-1) * TAM_REGISTRO_BYTES);

            for(int i=0;i<TAM_REGISTRO_CHARS; i++) {
                datosChar = datosChar + raf.readChar();
                //System.out.println(datosChar);
            }

            edad = raf.readByte();

            //Cargar alumno
            a = new Alumno(datosChar.substring(0,29).trim(),
                    datosChar.substring(30, 59).trim(),
                    edad);

            return a;
        }
        catch (IOException e) {
            System.out.println(e);
            return null;
        }

    }

    public static void listar(String fichero)
    {
        int index = 1;
        Alumno a = new Alumno("", "",(byte)0);
        try {
            File f = new File(fichero);

            RandomAccessFile raf =
                    new RandomAccessFile(f, "r");

            while(index<=f.length()/TAM_REGISTRO_BYTES)
            {
                raf.seek(index);
                a = leer(fichero, index);
                System.out.println(a.getNombre()
                        + " " + a.getApellidos()
                        + " " + a.getEdad());
                index++;
            }


            raf.close();

        }
        catch (IOException e) {
            System.out.println(e);
        }

    }
}
