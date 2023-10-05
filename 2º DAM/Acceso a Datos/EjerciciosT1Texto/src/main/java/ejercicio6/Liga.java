package ejercicio6;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Liga {

    private ArrayList<Futbolista> jugadores;

    public Liga() {
        this.jugadores = new ArrayList<>();
    }

    public void cargarFutbolistas(String nombre) {
        String linea, nombreJugador, club, posicion;
        String[] partes;
        int goles;
        this.jugadores.clear();
        try {
            FileReader fr = new FileReader(nombre);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                partes = linea.split(":");
                nombreJugador = partes[0];
                club = partes[1];
                posicion = partes[2];
                goles = Integer.parseInt(partes[3]);
                añadirFutbolista(nombreJugador, club, posicion, goles);
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException fnf) {
            System.out.println("no existe el futbolista");
            fnf.printStackTrace();
        } catch (IOException io) {
            System.out.println("error de lectura");
            io.printStackTrace();
        }
    }

    public String visualizarFutbolistas() {
        String resVisualizar;
        if (this.jugadores.isEmpty()) {
            resVisualizar = "Plantilla Vacía";
        } else {
            resVisualizar = "";
            for (Futbolista f : this.jugadores) {
                resVisualizar += f.toString();
            }
        }
        return resVisualizar;
    }

    public String buscarFutbolista(String nombre) {
        String resBuscar;
        Futbolista jugadorBuscado = encontrarFutbolista(nombre);
        if (jugadorBuscado==null) {
            resBuscar = "No se encuentra el jugador";
        } else {
            resBuscar = jugadorBuscado.toString();
            }
        return resBuscar;
    }

    private Futbolista encontrarFutbolista(String nombre) {
        Futbolista buscado = null;
        Iterator<Futbolista> it = this.jugadores.iterator();
        while (it.hasNext() && buscado == null) {
            Futbolista f = it.next();
            if (f.getNombre().equalsIgnoreCase(nombre)) {
                buscado = f;
            }
        }
        for (Futbolista f : this.jugadores) {
            if (f.getNombre().equals(nombre)) {
                return f;
            }
        }
        return buscado;
    }

    public String defensasGoleadores() {
        return null;
    }

    public void añadirFutbolista(String nombre, String club, String posicion, int goles) {
        Futbolista buscado = encontrarFutbolista(nombre);
        if (buscado == null) {
            Futbolista nuevo = new Futbolista(nombre, club, posicion, goles);
            this.jugadores.add(nuevo);
        }else{
            System.out.println("Ya existe");
        }
    }

    public void modificarNombre(String nombre_ant, String nombre_nuevo) {

    }

    public void guardarFutbolistas(String nombre)  {
        try{
            FileWriter fw = new FileWriter(nombre);
            PrintWriter pw = new PrintWriter(fw);
        for(Futbolista f:this.jugadores){
            pw.println(f.getNombre()+":"+f.getClub()+":"+f.getPosicion()+":"+f.getGoles());
        }
        fw.close();
        pw.close();

        }catch (FileNotFoundException fnf) {
            System.out.println("no existe el libro");
            fnf.printStackTrace();
        } catch (IOException io) {
            System.out.println("error de lectura");
            io.printStackTrace();
        }
    }

    public void backupFutbolistas(String nombre)  {
    }

    public void backupFutbolistasXML(String nombre)  {
    }

    public void backupFutbolistasJSON(String nombre) {
    }

    public String resumenEquipos(){
        return "nada";
    }
}
