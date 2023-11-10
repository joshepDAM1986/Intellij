package ejercicio6;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Liga {
    private ArrayList<Futbolista> liga;

    public Liga() {
        this.liga = new ArrayList<>();
    }

    public void guardarFutbolistas(String nombre) {
        try {
            FileWriter fw = new FileWriter(nombre);
            PrintWriter pw = new PrintWriter(fw);

            for (Futbolista fut : this.liga) {
                pw.println(fut.getNombre() + ":" +
                        fut.getClub() + ":" +
                        fut.getPosicion() + ":" +
                        fut.getGoles());
            }

            pw.close();
            fw.close();
        } catch (IOException io) {
            System.out.println("fallo de escritura");
        }
    }

    public void cargarFutbolistas(String ruta) {
        String linea;
        String[] partes;
        int goles;
        String nombre, posicion, club;
        this.liga.clear();
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
                partes = linea.split(":");
                nombre = partes[0];
                club = partes[1];
                posicion = partes[2];
                goles = Integer.parseInt(partes[3]);
                añadirFutbolista(nombre, club, posicion, goles);
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException fne) {
            System.out.println("No existe el fichero");
        } catch (IOException io) {
            System.out.println("fallo de lectura");
        }
    }

    public String visualizarFutbolistas() {
        String res;
        if (this.liga.isEmpty()) {
            res = "No hay futbolistas";
        } else {
            res = "";
            for (Futbolista f : this.liga) {
                res += f.toString();
            }
        }

        return res;
    }

    private Futbolista encontrarFutbolista(String nombre) {
        Futbolista buscado = null;
        Iterator<Futbolista> it = this.liga.iterator();

        while (it.hasNext() && buscado == null) {
            Futbolista posible = it.next();
            if (posible.getNombre().equalsIgnoreCase(nombre)) {
                buscado = posible;
            }
        }

        return buscado;
    }

    public void añadirFutbolista(String nombre, String club, String posicion, int goles) {
        Futbolista buscado = encontrarFutbolista(nombre);

        if (buscado == null) {
            Futbolista nuevo = new Futbolista(nombre, club, posicion, goles);
            this.liga.add(nuevo);
        } else {
            System.out.println("Ya existe ese nombre de futbolista");
        }
    }

    public String buscarFutbolista(String nombre) {
        String res;
        Futbolista buscado = encontrarFutbolista(nombre);

        if (buscado == null) {
            res = "No existe el futbolista buscado";
        } else {
            res = buscado.toString();
        }

        return res;
    }

    public void borrarFutbolista(String nombre) {
        Futbolista buscado = encontrarFutbolista(nombre);

        if (buscado == null) {
            System.out.println("No existe el futbolista");
        } else {
            this.liga.remove(buscado);
        }
    }


    public String defensasGoleadores() {
        String res=null;
        for (Futbolista f : this.liga) {
            if (f.getPosicion().equals("defensa") &&
                    f.getGoles() >= 5) {
                res += f.toString();
            }
        }

        if (res.equals("")) {
            res = "No hay defensas goleadores";
        }

        return res;
    }

    public void modificarNombre(String nombre_ant, String nombre_nuevo) {
        if (!nombre_ant.equalsIgnoreCase(nombre_nuevo)) {
            Futbolista ant = encontrarFutbolista(nombre_ant);
            if (ant != null) {
                Futbolista nuevo = encontrarFutbolista(nombre_nuevo);
                if (nuevo == null) {
                    ant.setNombre(nombre_nuevo);
                } else {
                    System.out.println("Ese jugador ya existe");
                }
            } else {
                System.out.println("Ese jugador no existe");
            }
        } else {
            System.out.println("El nombre nuevo tiene que ser diferente al anterior");
        }

    }


    public void backupFutbolistas(String nombre) {
        this.liga.sort((a, b) -> Integer.compare(b.getGoles(), a.getGoles()));
        Iterator<Futbolista> it = this.liga.iterator();
        int contador = 0;
        try {
            FileWriter fw = new FileWriter(nombre);
            PrintWriter pw = new PrintWriter(fw);

            while (contador < 5 && it.hasNext()) {
                Futbolista fut = it.next();
                pw.println(fut.getNombre() + ":" +
                        fut.getClub() + ":" +
                        fut.getPosicion() + ":" +
                        fut.getGoles());
                contador++;
            }

            pw.close();
            fw.close();
        } catch (IOException io) {
            System.out.println("fallo de escritura");
        }
    }

    public void backupFutbolistasXML(String nombre) {
        this.liga.sort((a, b) ->
                Integer.compare(b.getGoles(), a.getGoles()));
        int contador = 0;
        try {
            FileWriter fw = new FileWriter(nombre);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("<liga>");

            for (int i = 0; i < this.liga.size() && i < 5; i++) {
                Futbolista fut = this.liga.get(i);
                pw.println("<futbolista>");
                pw.println("<nombre>" + fut.getNombre() + "</nombre>" +
                        "<club>" + fut.getClub() + "</club>" +
                        "<posicion>" + fut.getPosicion() + "</posicion>" +
                        "<goles>" + fut.getGoles() + "</goles>");
                pw.println("</futbolista>");
            }
            pw.println("</liga>");

            //===========con un iterador=========================
            //que es mas eficiente
            Iterator<Futbolista> it = this.liga.iterator();
            while (contador < 5 && it.hasNext()) {
                Futbolista fut = it.next();
                pw.println("<futbolista>");
                pw.println("<nombre>" + fut.getNombre() + "</nombre>" +
                        "<club>" + fut.getClub() + "</club>" +
                        "<posicion>" + fut.getPosicion() + "</posicion>" +
                        "<goles>" + fut.getGoles() + "</goles>");
                contador++;
                pw.println("</futbolista>");
            }
            pw.println("</liga>");
            pw.close();
            fw.close();
        } catch (IOException io) {
            System.out.println("fallo de escritura");
        }
    }

    public void backupFutbolistasJSON(String nombre) {
        this.liga.sort((a, b) -> Integer.compare(b.getGoles(), a.getGoles()));
        Iterator<Futbolista> it = this.liga.iterator();
        int contador = 0;
        try {
            FileWriter fw = new FileWriter(nombre);
            PrintWriter pw = new PrintWriter(fw);

            pw.println("{\n'liga':\n[");
            while (contador < 5 && it.hasNext()) {
                Futbolista fut = it.next();
                pw.println("{");
                pw.println("'nombre':'" + fut.getNombre() + "',\n" +
                        "'club':'" + fut.getClub() + "',\n" +
                        "'posicion':'" + fut.getPosicion() + "',\n" +
                        "'goles':'" + fut.getGoles() + "'\n");
                contador++;
                pw.println("}");
                if (contador < 5) {
                    pw.println(",");
                }

            }
            pw.println("\n]}");

            pw.close();
            fw.close();
        } catch (IOException io) {
            System.out.println("fallo de escritura");
        }
    }

//    public String resumenEquipos() {
//
//        HashMap<String,Integer> resumen=new HashMap<>();
//        String res="";
//        int goles_actuales;
//        if(this.liga.isEmpty()){
//            res="No hay futbolistas";
//        }else{
//            for(Futbolista fut:this.liga){
//                goles_actuales=resumen.getOrDefault(fut.getClub(),0);
//                resumen.put(fut.getClub(),goles_actuales+fut.getGoles());
//            }
//
//            for(Map.Entry<String,Integer> entrada:resumen.entrySet()){
//                res+=entrada.getKey()+":"+entrada.getValue()+"\n";
//            }
//        }
//        return res;
//    }
//
//}

    public String resumenEquipos() {
        HashMap<String, Integer> mapa = new HashMap<>();
        String res = "";
        for (Futbolista futbolista : this.liga) {
            int contador = mapa.getOrDefault(futbolista.getClub(), 0);
            mapa.put(futbolista.getClub(), contador + futbolista.getGoles());
        }
        for (String llave : mapa.keySet()) {
            res += llave +":"+ mapa.get(llave) +"\n";
        }
        return res;
    }
}
