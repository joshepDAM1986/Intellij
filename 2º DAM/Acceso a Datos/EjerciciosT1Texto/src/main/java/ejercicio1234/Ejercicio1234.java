package ejercicio1234;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1234 {
    final String url_empleados = "src/main/java/ejercicio1234/empleados.txt";
    static final String url = "src/main/java/ejercicio1234/numeros.txt";

    public static void main(String[] args) {
        Ejercicio1234 ejercicios=new Ejercicio1234();
        ejercicios.ejercicio1(url);
    }
    public int ejercicio1(String nombre_fichero) {
        int resultado=0;
        try {
            FileReader fr = new FileReader(nombre_fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            int numero;
            while ((linea=br.readLine())!=null){
               numero=Integer.parseInt(linea);
               resultado+=numero;
            }
            System.out.println(resultado);
            fr.close();
            br.close();

        }
        catch (FileNotFoundException e){
            System.out.println("no existe el fichero");
        }
        catch (IOException e){
            System.out.println("error de lectura");
        }
                return 0;
    }

    public String ejercicio2(String nombre_fichero){
        return "";
    }

    public void ejercicio3(String nombre_fichero_entrada,String nombre_fichero_salida){

    }

    public void ejercicio4(String nombre_fichero,String nombre_fichero_salida){

    }
}


