package binario;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscrituraBinario {
    public static void main(String[] args) {
        Persona persona;//para contener los datos de la persona

        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/binario/Ejemplo_binario.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            String nombres[] = {"Ana","Luis Miguel","Alicia","Pedro",
                    "Manuel","Andrés","Julio","Antonio","María Jesús"};
            int edades[] = {14,15,13,15,16,12,16,14,13};

            System.out.println("GRABANDO DATOS...");
            for (int i=0;i<edades.length; i++){ //recorro los arrays
                persona= new Persona(nombres[i],edades[i]);
                oos.writeObject(persona);
            }
            System.out.println("FIN DE GRABACION...");

            oos.close();
            fos.close();

        }  catch (IOException io) {
            System.out.println("Error de E/S\n" + io.getMessage());
            io.printStackTrace();
        }



    }
}
