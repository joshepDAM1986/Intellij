package utilidades;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
    public static String leerFichero(String url) {
        try {
            FileReader fr = new FileReader(url);
            BufferedReader br = new BufferedReader(fr);
            String linea, resultado = "";

            while ((linea = br.readLine()) != null) {
                resultado += linea + "\n";
            }
            br.close();
            fr.close();

            return resultado;

        } catch (FileNotFoundException fn) {
            System.out.println("No se encuentra el fichero\n" + fn.getMessage());
            fn.printStackTrace();
            return "";

        } catch (IOException io) {
            System.out.println("Error de E/S\n" + io.getMessage());
            io.printStackTrace();
            return "";
        }


    }
}
