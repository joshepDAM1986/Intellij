package texto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaTexto {
    public static void main(String[] args) {
        try{
            FileReader fr = new FileReader("src/main/java/texto/LecturaTexto.java");
            BufferedReader fichero = new BufferedReader(fr);
            String linea,resultado="CONTENIDO DEL FICHERO:\n";

            while((linea = fichero.readLine())!=null){
                resultado+=linea+"\n";
            }
            System.out.println(resultado);
            fichero.close();

        }catch (FileNotFoundException fn ){
            System.out.println("No se encuentra el fichero\n"+fn.getMessage());
            fn.printStackTrace();

        }catch (IOException io) {
            System.out.println("Error de E/S\n"+io.getMessage());
            io.printStackTrace();

        }
    }

}
