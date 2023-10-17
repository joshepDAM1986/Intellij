package ejercicio10;

import ejercicio9.Pais;

import java.io.*;
import java.util.ArrayList;

public class Academia {

    private ArrayList<Matricula> academia;
    public Academia(){this.academia=new ArrayList<>();}


    private Matricula encontrarMatricula(String nombre){
        Matricula buscada=null;
        for(Matricula posible:this.academia){
            if(posible.getNombre().equalsIgnoreCase(nombre)){
                buscada=posible;
                break;
            }
        }

    return buscada;
    }
    public void nuevaMatricula(String nombre,double precio,int año,boolean pagada) {
            Matricula buscada = encontrarMatricula(nombre);
            if (buscada == null) {
                Matricula nueva = new Matricula(nombre, precio, año, pagada);
                this.academia.add(nueva);
            } else {
                System.out.println("Ya existe la matricula");
            }
        }

    public String visualizarMatriculas() {
        String resultado;
        if (this.academia.isEmpty()) {
            resultado = "No existe la matricula";
        } else {
            resultado = "";
            for (Matricula matricula : this.academia) {
                resultado += matricula.toString();
            }
        }
        return resultado;
    }

    public void guardarMatriculas(String ruta){
        try {
            FileOutputStream fos = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Matricula matricula : this.academia) {
                oos.writeObject(matricula);
            }
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Error de lectura");
        }
    }

    public void cargarMatriculas(String ruta){
        this.academia.clear();
        try {
            FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Matricula matricula;

            while (fis.available() > 0) {
                // lectura del fichero
                matricula = (Matricula) ois.readObject();
                this.academia.add(matricula);
            }

            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("No existe el fichero");
        } catch (IOException e) {
            System.out.println("Error de lectura");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public double sumaPagadas(){
            double suma = 0;
            for (Matricula matricula :this.academia) {
                if (matricula.isPagado()) {
                    suma += matricula.getPrecio();
                }
            }
            return suma;
        }


    public void matriculasResumen(String ruta){
        try{
            FileWriter fw=new FileWriter(ruta);
            PrintWriter pw=new PrintWriter(fw);

            for(Matricula matricula:this.academia){
                pw.println(matricula.getNombre() + "," +
                        matricula.getPrecio() + "," +
                        matricula.getAño());
            }

            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Fallo de escritura");
        }
    }

    public void matriculasResumenXML(String ruta) {
        try {
            FileWriter fw = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fw);

            pw.println("<Academia>");

            for (Matricula matricula : this.academia){
                pw.println("\t<matricula>");
                pw.println("\t\t<nombre>" + matricula.getNombre() + "</nombre>");
                pw.println("\t\t<año>" + matricula.getAño() + "</año>");
                pw.println("\t\t<precio>" + matricula.getPrecio() + "</precio>");
                pw.println("\t</matricula>");
            }
            pw.println("</Academia>");
            fw.close();
            pw.close();
        } catch(IOException e){
                System.out.println("Fallo de escritura");
                e.printStackTrace();
            }
        }
    public void matriculasResumenJSON (String ruta){
        try{
            FileWriter fw=new FileWriter(ruta);
            PrintWriter pw=new PrintWriter(fw);

            pw.println("{");
            pw.println("\t\"academia\": [");

            int numMatriculas = this.academia.size();
            int contador = 0;

            for (Matricula matricula : this.academia) {
                pw.println("\t\t{");
                pw.println("\t\t\t\"nombre\": \"" + matricula.getNombre() + "\",");
                pw.println("\t\t\t\"año\": \"" + matricula.getAño() + "\",");
                pw.println("\t\t\t\"precio\": " + matricula.getPrecio());

                // Verifica si es el último elemento para evitar imprimir una coma
                if (++contador < numMatriculas) {
                    pw.println("\t\t},");
                } else {
                    pw.println("\t\t}");
                }
            }

            pw.println("\t]");
            pw.println("}");


            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Fallo de escritura");
        }
    }
}