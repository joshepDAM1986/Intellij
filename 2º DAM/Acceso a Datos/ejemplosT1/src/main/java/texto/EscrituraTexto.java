package texto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscrituraTexto {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("src/main/java/texto/fila.txt"); //vacia el fichero si existe
            PrintWriter fichero = new PrintWriter(fw);
            for (int i = 1; i <= 10; i++) {
                fichero.println("Fila numero: " + i); //escribe en la posicion actual
            }
            fichero.close();
            fw.close();
            System.out.println("Fichero escrito con exito");

        } catch (IOException io) {
            System.out.println("Error de E/S\n" + io.getMessage());
            io.printStackTrace();
        }
    }
}