package ejercicio5;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Libreria {

    private ArrayList<Libro> biblioteca;

    public Libreria(){
        this.biblioteca=new ArrayList<>();
    }

    public void cargarLibros(String nombre) {
        String linea;
        String[] partes;
        double precio;
        int copias;
        String titulo,autor;
        this.biblioteca.clear();
        try{
            FileReader fr=new FileReader(nombre);
            BufferedReader br=new BufferedReader(fr);

            while((linea=br.readLine())!=null){
                partes=linea.split(":");
                titulo=partes[0];
                autor=partes[1];
                precio=Double.parseDouble(partes[2]);
                copias=Integer.parseInt(partes[3]);
                añadirLibro(titulo,autor,precio,copias);
            }

            br.close();
            fr.close();
        }catch(FileNotFoundException fne){
            System.out.println("No existe el fichero");
        }catch(IOException io){
            System.out.println("fallo de lectura");
        }
    }

    public void guardarLibros(String nombre){
        try{
            FileWriter fw=new FileWriter(nombre);
            PrintWriter pw=new PrintWriter(fw);

            for(Libro l:this.biblioteca){
                pw.println(l.getTitulo()+":"+
                           l.getAutor()+":"+
                           l.getPrecio()+":"+
                           l.getNumero_ejemplares());
            }

            pw.close();
            fw.close();
        }catch(IOException io){
            System.out.println("fallo de escritura");
        }
    }

    public String visualizarLibros(){
        String res;

        if(this.biblioteca.isEmpty()){
            res="Librería vacía";
        }else{
            res="";
            for(Libro l:this.biblioteca){
                res+=l.toString();
            }
        }

        return res;
    }

    private Libro buscarLibro(String titulo){
        Libro buscado=null;

        Iterator<Libro> it=this.biblioteca.iterator();
        while(it.hasNext() && buscado==null){
            Libro l=it.next();
            if(l.getTitulo().equalsIgnoreCase(titulo)){
                buscado=l;
            }
        }

//        for(Libro l:this.biblioteca){
//            if(l.getTitulo().equalsIgnoreCase(titulo)){
//                return l;
//            }
//        }

        return buscado;
    }

    public void añadirLibro(String titulo, String autor, double precio, int copias) {
        Libro buscado=buscarLibro(titulo);
        if(buscado==null){
            Libro nuevo=new Libro(titulo,autor,precio,copias);
            this.biblioteca.add(nuevo);
        }else{
            System.out.println("ya existe");
        }
    }

    public String buscarTitulo(String titulo) {
        return null;
    }

    public String buscarLibrosAutor(String autor) {
        return null;
    }


    public void modificarTitulo(String ant_titulo, String nuevo_titulo) {

    }

    public void borrarLibro(String titulo) {

    }

}
