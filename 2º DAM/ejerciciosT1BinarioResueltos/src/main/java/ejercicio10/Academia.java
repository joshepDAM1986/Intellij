package ejercicio10;

import ejercicio9.Pais;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Academia {

    private ArrayList<Matricula> lista_matriculas;

    public Academia(){
        this.lista_matriculas=new ArrayList<>();
    }
    private Matricula encontrarPais(String nombre){
        Matricula buscado=null;

        Iterator<Matricula> it=this.lista_matriculas.iterator();

        while(it.hasNext() && buscado==null){
            Matricula m=it.next();
            if(m.getNombre().equalsIgnoreCase(nombre)){
                buscado=m;
            }
        }

        return buscado;
    }
    public void nuevaMatricula(String nombre,double precio,int año,boolean pagada){
        if(encontrarPais(nombre)==null){
            Matricula nuevo=new Matricula(nombre,precio,año,pagada);
            this.lista_matriculas.add(nuevo);
        }else{
            System.out.println("Ya existe");
        }
    }

    public String visualizarMatriculas(){
        String res="";

        if(this.lista_matriculas.isEmpty()){
            res="No hay matriculsa todavia";
        }else{
            for (Matricula m:this.lista_matriculas){
                res+=m.toString();
            }
        }
        return res;
    }

    public void guardarMatriculas(String ruta){
        try {
            FileOutputStream fos=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            for(Matricula m:this.lista_matriculas){
                oos.writeObject(m);
            }

            fos.close();
            oos.close();

        }catch(IOException io){
            System.out.println("error de fichero");
        }
    }

    public void cargarMatriculas(String ruta){
        Matricula m;
        this.lista_matriculas.clear();
        try {
            FileInputStream fis=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(fis);

            while(fis.available()>0){
                m=(Matricula)ois.readObject();
                this.lista_matriculas.add(m);
            }

            ois.close();
            fis.close();
        }catch(ClassNotFoundException cnf){
            System.out.println("Error con el casting");
        }catch(IOException io){
            System.out.println("Error de fichero");
        }
    }

    public double sumaPagadas(){
        double res=0.0;

        for (Matricula m:this.lista_matriculas){
            if(m.isPagado()){
                res+=m.getPrecio();
            }
        }

        return res;
    }

    public void matriculasResumen(String ruta){
        try {
            FileWriter fw = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fw);

            for (Matricula m:this.lista_matriculas){
                if(m.isPagado()){
                    pw.println(m.getNombre() + "," + m.getPrecio()+
                            ","+m.getAño());
                }
            }

            pw.close();
            fw.close();
        }catch (IOException io){
            System.out.println("Error de fichero");
        }
    }

    public void matriculasResumenXML(String ruta){
        try {
            FileWriter fw = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("<academia>");

            for (Matricula m:this.lista_matriculas){
                if(m.isPagado()){
                    pw.println("<matriculas>");
                    pw.println("<nombre>"+m.getNombre() + "</nombre><precio>" + m.getPrecio()+
                            "</precio><año>"+m.getAño()+"</año>");
                    pw.println("</matriculas>");
                }

            }
            pw.println("</academia>");
            pw.close();
            fw.close();
        }catch (IOException io){
            System.out.println("Error de fichero");
        }
    }

    public void matriculasResumenJSON(String ruta){
        try {
            FileWriter fw = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("{\"academia\":[");
            for (Matricula m:this.lista_matriculas){
                if(m.isPagado()){
                    pw.println("{\"nombre\":\""+m.getNombre() + "\",\"precio\":\"" + m.getPrecio()+
                            ",\"año\":"+ m.getAño()+"},");
                }
            }
            pw.println("]}");
            pw.close();
            fw.close();
        }catch (IOException io){
            System.out.println("Error de fichero");
        }
    }
}
