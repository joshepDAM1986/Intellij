package ejercicio9;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Naciones {

    private ArrayList<Pais> naciones;

    public Naciones() {
        this.naciones = new ArrayList<>();
    }

    public void cargarPaises(String ruta) {
        this.naciones.clear();
        try {
            FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Pais pa;

            while (fis.available() > 0) {
                // lectura del fichero
                pa = (Pais) ois.readObject();
                this.naciones.add(pa);
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

    public void guardarPaises(String ruta) {
        try {
            FileOutputStream fos = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Pais pa : this.naciones) {
                oos.writeObject(pa);
            }
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Error de lectura");
        }
    }

    public String mostrarTodo() {
        String resultado;
        if (this.naciones.isEmpty()) {
            resultado = "No hay paises";
        } else {
            resultado = "";
            for (Pais pa : this.naciones) {
                resultado += pa.toString();
            }
        }
        return resultado;
    }

    private Pais encontrarPais(String nombre) {
        Pais buscado = null;
        Iterator<Pais> it = this.naciones.iterator();
        while (it.hasNext() && buscado == null) {
            Pais posible = it.next();
            if (posible.getNombre().equalsIgnoreCase(nombre)) {
                ;
                buscado = posible;
            }
        }
        return buscado;
    }

    public void añadirPais(String nombre, String capital, int habitantes, int año) {
        Pais buscado = encontrarPais(nombre);

        if (buscado == null) {
            Pais nuevo = new Pais(nombre, capital, habitantes, año);
            this.naciones.add(nuevo);
        } else {
            System.out.println("Ya existe ese pais");
        }
    }

//    public void backupTexto(String ruta) {
//        Iterator<Pais> it = this.naciones.iterator();
//        int contador = 0;
//        try {
//            FileWriter fw = new FileWriter(ruta);
//            PrintWriter pw = new PrintWriter(fw);
//
//            while (contador < 5 && it.hasNext()) {
//                Pais p = it.next();
//                pw.println(p.getNombre() + ":" +
//                        p.getCapital() + ":" +
//                        p.getHabitantes() + ":" +
//                        p.getFundacion());
//                contador++;
//            }
//
//            pw.close();
//            fw.close();
//        } catch (IOException io) {
//            System.out.println("fallo de escritura");
//        }
//    }

//    public void backupTexto(String ruta) {
//        try {
//            FileWriter fw = new FileWriter(ruta);
//            PrintWriter pw = new PrintWriter(fw);
//
//           for(Pais p:this.naciones){
//                pw.println(p.getNombre() + "," +
//                        p.getCapital() + "," +
//                        p.getHabitantes() + "," +
//                        p.getFundacion());
//            }
//            pw.close();
//            fw.close();
//        } catch (IOException io) {
//            System.out.println("fallo de escritura");
//        }
//    }

    public void backupTexto(String ruta) {
        try {
            FileWriter fw = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fw);

            for(Pais p:this.naciones){
                pw.println(p.getNombre().concat(",")
                        .concat(p.getCapital()).concat(",")
                        .concat(String.valueOf(p.getCapital()).concat(",")
                        .concat(String.valueOf(p.getFundacion()))));
            }
            pw.close();
            fw.close();
        } catch (IOException io) {
            System.out.println("fallo de escritura");
        }
    }

//    public void backupXML(String ruta) {
//        this.naciones.sort((a, b) ->
//                Integer.compare(b.getHabitantes(), a.getHabitantes()));
//        this.naciones.sort((a, b) ->
//                Integer.compare(b.getFundacion(), a.getFundacion()));
//
//        int contador = 0;
//        try {
//            FileWriter fw = new FileWriter(ruta);
//            PrintWriter pw = new PrintWriter(fw);
//            pw.println("<liga>");
//
//            for (int i = 0; i < this.naciones.size() && i < 5; i++) {
//                Pais p = this.naciones.get(i);
//                pw.println("<pais>");
//                pw.println("<nombre>" + p.getNombre() + "</nombre>" +
//                        "<capital>" + p.getCapital() + "</capital>" +
//                        "<habitantes>" + p.getHabitantes() + "</habitantes>" +
//                        "<año>" + p.getFundacion() + "</año>");
//                pw.println("</pais>");
//            }
//            pw.println("</pais>");
//
//            //===========con un iterador=========================
//            //que es mas eficiente
//
//            Iterator<Pais> it = this.naciones.iterator();
//            while (contador < 5 && it.hasNext()) {
//                Pais p = it.next();
//                pw.println("<pais>");
//                pw.println("<nombre>" + p.getNombre() + "</nombre>" +
//                        "<capital>" + p.getCapital() + "</capital>" +
//                        "<habitantes>" + p.getHabitantes() + "</habitantes>" +
//                        "<año>" + p.getFundacion() + "<año/>");
//                contador++;
//                pw.println("</pais>");
//            }
//            pw.close();
//            fw.close();
//        } catch (IOException io) {
//            System.out.println("fallo de escritura");
//        }
//    }

    public void backupXML(String ruta) {
        try {
            FileWriter fw = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fw);

            for (Pais p : this.naciones) {
                pw.println("<pais>");
                pw.println("<nombre=" + p.getNombre() + "<nombre>");
                pw.println("<Capital>" + p.getCapital() + "</Capital>");
                pw.println("<habitantes>" + p.getHabitantes() + "</habitantes>");
                pw.println("<año>" + p.getFundacion() + "</año>");
                pw.println("  </pais>");
            }

            pw.println("</pais>");

            pw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Fallo al escribir en formato XML");
            e.printStackTrace();
        }
    }

//    public void backupJSON(String ruta) {
//        this.naciones.sort((a, b) -> Integer.compare(b.getHabitantes(), a.getHabitantes()));
//        Iterator<Pais> it = this.naciones.iterator();
//        int contador = 0;
//        try {
//            FileWriter fw = new FileWriter(ruta);
//            PrintWriter pw = new PrintWriter(fw);
//
//            pw.println("{\n'liga':\n[");
//            while (contador < 5 && it.hasNext()) {
//                Pais p = it.next();
//                pw.println("{");
//                pw.println("'nombre':'" + p.getNombre() + "',\n" +
//                        "'capital':'" + p.getCapital() + "',\n" +
//                        "'habitantes':'" + p.getHabitantes() + "',\n" +
//                        "'año':'" + p.getFundacion() + "'\n");
//                contador++;
//                pw.println("}");
//                if (contador < 5) {
//                    pw.println(",");
//                }
//            }
//            pw.println("\n]}");
//
//            pw.close();
//            fw.close();
//        } catch (IOException io) {
//            System.out.println("fallo de escritura");
//        }
//    }

    public void backupJSON(String ruta) {
        try {
            FileWriter fw = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fw);

            pw.println("{\n\"pais\":\n[");

            for (Pais p : this.naciones) {
                pw.println("{");
                pw.println("\"nombre\": \"" + p.getNombre() + "\",");
                pw.println("\"capital\": \"" + p.getCapital() + "\",");
                pw.println("\"habitantes\": " + p.getHabitantes() + ",");
                pw.println("\"año\": " + p.getFundacion());
                pw.println("\n]}");
            }
            pw.close();
            fw.close();
        } catch (IOException io) {
            System.out.println("fallo de escritura");
        }
    }
}