package ejercicio78;


import java.io.*;

public class Ejercicio78 {

    public void crearBinario(String entrada,String salida){
        try {
            FileReader fr = new FileReader(entrada);
            BufferedReader br = new BufferedReader(fr);
            FileOutputStream fos=new FileOutputStream(salida);
            ObjectOutputStream oos=new ObjectOutputStream(fos);

            String[] partes;
            String nombre;
            int edad;
            String linea;
            Persona p;

            while((linea=br.readLine())!=null){
                partes=linea.split("\\|");
                nombre=partes[0];
                edad=Integer.parseInt(partes[1]);
                p=new Persona(nombre,edad);
                oos.writeObject(p);
            }

            fos.close();
            oos.close();
            br.close();
            fr.close();
        }catch(IOException io){
            System.out.println("error de fichero");
        }

    }

    public void crearTexto(String entrada,String salida) {
        Persona p;
        try {
            FileInputStream fis=new FileInputStream(entrada);
            ObjectInputStream ois=new ObjectInputStream(fis);
            FileWriter fw=new FileWriter(salida);
            PrintWriter pw=new PrintWriter(fw);

            while(fis.available()>0){
                p=(Persona)ois.readObject();
                pw.println(p.getNombre()+"|"+p.getEdad());
            }

            pw.close();
            fw.close();
            ois.close();
            fis.close();
        }catch(ClassNotFoundException cnf){
            System.out.println("Error con el casting");
        }catch(IOException io){
            System.out.println("Error de fichero");
        }

    }
}
