package examen;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Escuela {
    private ArrayList<Curso> lista_cursos;

    // Constructor y otros métodos

    public Escuela() {
        this.lista_cursos = new ArrayList<>();
    }

    public void insertarCurso(String nombre, String modalidad, int matriculados, double precio) {
        // Mejorar método
        String buscado = buscarCurso(nombre);
        if (buscado == null) {
            Curso nuevo = new Curso(nombre, modalidad, matriculados, precio);
            this.lista_cursos.add(nuevo);
        } else {
            System.out.println("El curso ya existe");
        }
    }

    public String buscarCurso(String nombre) {
        String resultado = null;
        for (Curso c : this.lista_cursos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                resultado += c.toString();
            }
        }
        return resultado;
    }

    public String visualizarCursos() {
        String res = "";

        if (this.lista_cursos.isEmpty()) {
            res = "No hay cursos";
        } else {
            for (Curso c : this.lista_cursos) {
                res += c.toString();
            }
        }

        return res;
    }


    public void guardarTexto(String ruta) {
        try {
            FileWriter fw = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fw);
            for (Curso p : this.lista_cursos) {
                pw.println(p.getNombre() + ":" +
                        p.getModalidad() + ":" +
                        p.getMatriculados() + ":" +
                        p.getPrecio());
            }
            pw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el fichero");
        } catch (IOException e) {
            System.out.println("Error de escritura");
        }
    }

    public void cargarTexto(String ruta) {
        String linea;
        String partes[];
        String nombre, modalidad;
        Double precio;
        int matriculados;
        this.lista_cursos.clear();
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                partes = linea.split(":");
                nombre = partes[0];
                modalidad = partes[1];
                matriculados = Integer.parseInt(partes[2]);
                precio = Double.parseDouble(partes[3]);
                insertarCurso(nombre, modalidad, matriculados, precio);

            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el fichero");
        } catch (IOException e) {
            System.out.println("Error de lectura");
        }
    }

    public void guardarBinario(String ruta) {
        try {
            FileOutputStream fos = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream((fos));
            for (Curso c : this.lista_cursos) {
                oos.writeObject(c);
            }
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el fichero");
        } catch (IOException e) {
            System.out.println("Error de escritura");
        }
    }

    public void cargarBinario(String ruta) {
        this.lista_cursos.clear();
        try {
            FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Curso c;
            while (fis.available() > 0) {
                c = (Curso) ois.readObject();
                this.lista_cursos.add(c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el fichero");
        } catch (IOException e) {
            System.out.println("Error de lectura");
        } catch (ClassNotFoundException e) {
            System.out.println("Error de casting");
        }
    }

    public String cursosOnline() {
        String resultado = "";
        for (Curso c : this.lista_cursos) {
            if (c.getModalidad().equals("online") && c.getPrecio() >= 100 && c.getPrecio() <= 200) {
                resultado += c.toString();
            }
        }

        if (resultado.isEmpty()) {
            resultado = "No hay cursos de este tipo";
        }

        return resultado;
    }


    public String resumenAlumnos() {
        HashMap<String, Double> mapa = new HashMap<>();
        String res = "";
        for (Curso c : this.lista_cursos) {
            Double contador = mapa.getOrDefault(c.getModalidad(), 0.0);
            mapa.put(c.getModalidad(), contador + c.getPrecio()*c.getMatriculados());
        }
        for (String llave : mapa.keySet()) {
            res += llave + ":" + mapa.get(llave) + "\n";
        }
        return res.toUpperCase();
    }


    public void backupXML(String rutaArchivo) {
        try {
            FileWriter fw = new FileWriter(rutaArchivo);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("<escuela>");
            for (Curso c : this.lista_cursos) {
                if (c.getMatriculados() >= 100 && c.getPrecio() >= 100 && c.getPrecio() <= 200) {
                    pw.println("\t<curso>");
                    pw.println("\t\t<nombre>" + c.getNombre() + "</nombre>");
                    pw.println("\t\t<modalidad>" + c.getModalidad() + "</modalidad>");
                    pw.println("\t\t<matriculados>" + c.getMatriculados() + "</matriculados>");
                    pw.println("\t\t<precio>" + c.getPrecio() + "</precio>");
                    pw.println("\t</curso>");
                }
            }

            pw.println("</escuela>");
            pw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}