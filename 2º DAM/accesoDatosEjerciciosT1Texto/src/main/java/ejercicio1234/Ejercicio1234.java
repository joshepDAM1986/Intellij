package ejercicio1234;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Ejercicio1234 {
    final String url_empleados = "src/main/java/ejercicio1234/empleados.txt";
    final static String url = "src/main/java/ejercicio1234/numeros.txt";

    public static void main(String[] args) {
        Ejercicio1234 ejercicios = new Ejercicio1234();
        ejercicios.ejercicio1(url);
    }


    public int ejercicio1(String nombre_fichero) {
        int resultado = 0;
        try {
            FileReader fr = new FileReader(nombre_fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            int numero;

            while ((linea = br.readLine()) != null) {
                numero = Integer.parseInt(linea);
                if (numero > 10) {
                    resultado += numero;
                }
            }
            //System.out.println(resultado);

            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("no existe el fichero");
        } catch (IOException e) {
            System.out.println("Error de lectura");
        }
        return resultado;
    }

    public String ejercicio2(String nombre_fichero) {
        String res = "";
        String empleado;//Por ejemplo Juan,1000,Granada
        String[] partes;
        String nombre_empleado;
        int ventas;
        try {
            FileReader fr = new FileReader(nombre_fichero);
            BufferedReader br = new BufferedReader(fr);
            while ((empleado = br.readLine()) != null) {
                partes = empleado.split(",");
                nombre_empleado = partes[0];
                ventas = Integer.parseInt(partes[1]);
                if (ventas > 1000) {
                    res += nombre_empleado + "\n";
                }
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("Existe el fichero");
            fnf.printStackTrace();
        } catch (IOException io) {
            System.out.println("Error de lectura");
            io.printStackTrace();
        }


        return res;
    }

    public void ejercicio3(String nombre_fichero_entrada, String nombre_fichero_salida) {
        String empleado;
        String[] partes;
        try {
            //modo lectura
            FileReader fr = new FileReader(nombre_fichero_entrada);
            BufferedReader br = new BufferedReader(fr);
            //modo escritura
            FileWriter fw = new FileWriter(nombre_fichero_salida);
            PrintWriter pw = new PrintWriter(fw);

            while ((empleado = br.readLine()) != null) {
                partes = empleado.split(",");
                //pw.println(partes[0]+"="+partes[1]+"="+partes[2]);
                //pw.println(empleado.replace(",","="));
                pw.println(String.join("=", partes));

            }
            pw.close();
            fw.close();
            br.close();
            fr.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("Existe el fichero");
            fnf.printStackTrace();
        } catch (IOException io) {
            System.out.println("Error de lectura");
            io.printStackTrace();
        }
    }

    public void ejercicio4(String nombre_fichero, String nombre_fichero_salida) {
        String empleado;
        String[] partes;
        int ventas;
        String provincia;
        HashMap<String,Integer> totales=new HashMap<>();

        try {
            FileReader fr = new FileReader(nombre_fichero);
            BufferedReader br = new BufferedReader(fr);
            //modo escritura
            FileWriter fw = new FileWriter(nombre_fichero_salida);
            PrintWriter pw = new PrintWriter(fw);

            while ((empleado = br.readLine()) != null) {
                partes = empleado.split(",");
                ventas=Integer.parseInt(partes[1]);
                provincia=partes[2];

                int actual=totales.getOrDefault(provincia,0);
                totales.put(provincia,actual+ventas);

//                if(totales.containsKey(provincia)){
//                    int cantidad=totales.get(provincia);
//                    totales.put(provincia,cantidad+ventas);
//                }else{
//                    totales.put(provincia,ventas);
//                }


            }

            totales.forEach((prov,vent)->
                               pw.println(prov+":"+vent));
            //EQUIVALE A :
            for (Map.Entry<String,Integer> entrada:totales.entrySet()){
                pw.println(entrada.getKey()+":"+entrada.getValue());
            }

            pw.close();
            fw.close();
            br.close();
            fr.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("Existe el fichero");
            fnf.printStackTrace();
        } catch (IOException io) {
            System.out.println("Error de lectura");
            io.printStackTrace();
        }
    }
}


