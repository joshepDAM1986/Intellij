package salacine;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cine {

    private ArrayList<Pelicula> lista_peliculas;

    public Cine() {
        this.lista_peliculas = new ArrayList<>();
    }

    public void cargarTexto(String ruta_texto) {
        String linea;
        String[] partes;
        String nombre, genero;
        int duracion;
        double recaudacion;
        this.lista_peliculas.clear();
        try {
            FileReader fr = new FileReader(ruta_texto);
            BufferedReader br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
                partes = linea.split(":");
                nombre = partes[0];
                genero = partes[1];
                duracion = Integer.parseInt(partes[2]);
                recaudacion = Double.parseDouble(partes[3]);
                añadirPelicula(nombre, genero, recaudacion, duracion);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String visualizarPeliculas() {
        String resultado = "";
        if (this.lista_peliculas.isEmpty()) {
            resultado = "No existe la pelicula";
        } else {
            resultado = "";
            for (Pelicula p : this.lista_peliculas) {
                resultado += p.toString();
            }
        }
        return resultado;
    }

    public void guardarTexto(String ruta_texto) {
        try {
            FileWriter fw = new FileWriter(ruta_texto);
            PrintWriter pw = new PrintWriter(fw);

            for (Pelicula p : this.lista_peliculas) {
                pw.println(p.getNombre() + ":" +
                        p.getGenero() + ":" +
                        p.getDuracion() + ":" +
                        p.getRecaudacion());
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void guardarBinario(String ruta_bin) {
        try {
            FileOutputStream fos = new FileOutputStream(ruta_bin);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Pelicula p : this.lista_peliculas) {
                oos.writeObject(p);
            }
            oos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cargarBinario(String ruta_bin) {
        this.lista_peliculas.clear();
        try {
            FileInputStream fis = new FileInputStream(ruta_bin);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Pelicula p;
            while (fis.available() > 0) {
                p = (Pelicula) ois.readObject();
                this.lista_peliculas.add(p);
            }
            ois.close();
            fis.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String buscarPelicula(String nombre) {
        String resultado = null;

        for (Pelicula p : this.lista_peliculas) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                resultado = p.toString();
                break;  // Terminamos el bucle una vez que encontramos la película
            }
        }

        return resultado;
    }

    public void añadirPelicula(String nombre, String genero, double recaudacion, int duracion) {
        String buscado = buscarPelicula(nombre);

        if (buscado == null) {
            Pelicula nuevo = new Pelicula(nombre, genero, recaudacion, duracion);
            this.lista_peliculas.add(nuevo);
        } else {
            System.out.println("Ya existe esa pelicula");
        }
    }

    public double dineroSuperheroes() {
        double recaudacionTotal = 0.0;

        for (Pelicula p : this.lista_peliculas) {
            if (p.getGenero().equals("superheroes") && p.getDuracion() > 100) {
                recaudacionTotal += p.getRecaudacion();
            }
        }

        return recaudacionTotal;
    }

    public void exportarmejores(String ruta_xml) {
        try {
            FileWriter fw = new FileWriter(ruta_xml);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("<cine>");
            for (Pelicula p : this.lista_peliculas) {
                if (p.getRecaudacion() >= 200) {
                    pw.println("\t<pelicula>");
                    pw.println(" \t\t<nombre>" + p.getNombre() + "</nombre>");
                    pw.println(" \t\t<genero>" + p.getGenero() + "</genero>");
                    pw.println(" \t\t<duracion>" + p.getDuracion() + "</duracion>");
                    pw.println(" \t\t<recaudacion>" + p.getRecaudacion() + "</recaudacion>");
                    pw.println("\t </pelicula>");
                }
            }
            pw.println("</cine>");

            pw.close();
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

