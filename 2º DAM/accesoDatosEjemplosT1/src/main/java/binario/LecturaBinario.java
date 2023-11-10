package binario;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LecturaBinario {
    public static void main(String[] args) {

        Persona persona;//para contener los datos de la persona
        String resultado="";
        try {
            FileInputStream fis= new FileInputStream("src/main/java/binario/Ejemplo_binario.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (fis.available()>0){
                // lectura del fichero
                persona = (Persona)ois.readObject();
                resultado+="Nombre: "+persona.getNombre()+"\n"+
                        "Edad: "+persona.getEdad()+"\n"+
                        "------------------------------\n";

            }
            System.out.println(resultado);
            ois.close();
            fis.close();

        } catch (IOException io) {
            System.out.println("Error de E/S\n" + io.getMessage());
            io.printStackTrace();
        } catch (ClassNotFoundException cnf) {
            System.out.println("Error de casting\n" + cnf.getMessage());
            cnf.printStackTrace();
        }

    }
}
