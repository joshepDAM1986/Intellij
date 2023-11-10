package ejercicio9;

import ejercicio78.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Naciones {

    private ArrayList<Pais> lista_paises;

    public Naciones(){
        this.lista_paises=new ArrayList<>();
    }


    public void cargarPaises(String ruta) {
        Pais p;
        this.lista_paises.clear();
        try {
            FileInputStream fis=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(fis);

            while(fis.available()>0){
                p=(Pais)ois.readObject();
                this.lista_paises.add(p);
            }

            ois.close();
            fis.close();
        }catch(ClassNotFoundException cnf){
            System.out.println("Error con el casting");
        }catch(IOException io){
            System.out.println("Error de fichero");
        }
    }

    public void guardarPaises(String ruta) {
        try {
            FileOutputStream fos=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            for(Pais p:this.lista_paises){
                oos.writeObject(p);
            }

            fos.close();
            oos.close();

        }catch(IOException io){
            System.out.println("error de fichero");
        }
    }

    public String mostrarTodo()
    {

        String res="";

        if(this.lista_paises.isEmpty()){
            res="No hay paises todavia";
        }else{
            for (Pais p:this.lista_paises){
                res+=p.toString();
            }
        }
        return res;
    }

    private Pais encontrarPais(String nombre){
        Pais buscado=null;

        Iterator<Pais> it=this.lista_paises.iterator();

        while(it.hasNext() && buscado==null){
            Pais p=it.next();
            if(p.getNombre().equalsIgnoreCase(nombre)){
                buscado=p;
            }
        }

        return buscado;
    }

    public void añadirPais(String nombre,String capital,int habitantes,int año){
        if(encontrarPais(nombre)==null){
            Pais nuevo=new Pais(nombre,capital,habitantes,año);
            this.lista_paises.add(nuevo);
        }else{
            System.out.println("Ya existe");
        }
    }

    public void backupTexto(String ruta) {
        try {
            FileWriter fw = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fw);

            for (Pais p:this.lista_paises){

                pw.println(p.getNombre() + "," + p.getCapital()+
                        ","+p.getHabitantes()+","+ p.getFundacion());
            }

            pw.close();
            fw.close();
        }catch (IOException io){
            System.out.println("Error de fichero");
        }
    }

    public void backupXML(String ruta) {
        try {
            FileWriter fw = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("<mundo>");
            for (Pais p:this.lista_paises){
                pw.println("<pais>");
                pw.println("<nombre>"+p.getNombre() + "</nombre><precio>" + p.getCapital()+
                        "</capital><habitantes>"+p.getHabitantes()+"</habitantes><fundacion>"+ p.getFundacion()+"</fundacion>");
                pw.println("</matriculas>");
            }
            pw.println("</mundo>");
            pw.close();
            fw.close();
        }catch (IOException io){
            System.out.println("Error de fichero");
        }
    }

    public void backupJSON(String ruta) {
        try {
            FileWriter fw = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("{\"mundo\":[");
            for (Pais p:this.lista_paises){
                pw.println("{\"nombre\":\""+p.getNombre() + "\",\"capital\":\"" + p.getCapital()+
                        "\",\"habitantes\":"+p.getHabitantes()+",\"fundacion\":"+ p.getFundacion()+"},");
            }
            pw.println("]}");
            pw.close();
            fw.close();
        }catch (IOException io){
            System.out.println("Error de fichero");
        }
    }
}
