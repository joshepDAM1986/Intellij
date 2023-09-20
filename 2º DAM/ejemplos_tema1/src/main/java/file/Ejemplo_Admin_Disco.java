package file;

import java.io.File;
import java.io.IOException;

public class Ejemplo_Admin_Disco {

    public static void main(String[] args) {

        File d = new File("src/main/java/SEGUNDODAM"); //directorio que creo a partir del actual
        File f1 = new File(d, "FICHERO1.TXT");
        File f2 = new File(d, "FICHERO2.TXT");

        d.mkdir();//CREAR DIRECTORIO
        System.out.println("Directorio creado");
        try {
            f1.createNewFile();
            System.out.println("FICHERO1 creado correctamente...");
            f2.createNewFile();
            System.out.println("FICHERO2 creado correctamente...");
        } catch (IOException e) {
            System.out.println("Error al crear los ficheros\n"+e.getMessage());
            e.printStackTrace();//Muestra la traza del error
        }

        if (f2.delete()) {
            System.out.println("Fichero borrado con exito");
        } else {
            System.out.println("Imposible borrar el fichero");
        }
    }
}
