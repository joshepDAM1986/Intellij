
package com.mycompany.base_datos_alumnado;

/**
 *
 * @author garci
 */

import com.mycompany.base_datos_alumnado.Alumno;
import java.io.*;
import java.util.*;

public class ArchivoAlumnos {
    private String nombreArchivo;
    
    public ArchivoAlumnos(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    public void guardarAlumno(Alumno alumno) {
        try (FileWriter writer = new FileWriter(nombreArchivo, true)) {
            writer.write(alumno.getNombre() + "," + alumno.getApellidos() + "," + alumno.getEdad() + "\n");
        } catch (IOException e) {
            System.err.println("Error al guardar el alumno en el archivo");
            e.printStackTrace();
        }
    }
    
    public List<Alumno> leerAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            while (scanner.hasNextLine()) {
                String[] datosAlumno = scanner.nextLine().split(",");
                String nombre = datosAlumno[0];
                String apellidos = datosAlumno[1];
                byte edad = Byte.parseByte(datosAlumno[2]);
                Alumno alumno = new Alumno(nombre, apellidos, edad);
                alumnos.add(alumno);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo de alumnos no encontrado");
            e.printStackTrace();
        }
        return alumnos;
    }
    
    public void eliminarAlumno(Alumno alumno) {
        List<Alumno> alumnos = leerAlumnos();
        alumnos.remove(alumno);
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            for (Alumno a : alumnos) {
                writer.write(a.getNombre() + "," + a.getApellidos() + "," + a.getEdad() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al eliminar el alumno del archivo");
            e.printStackTrace();
        }
    }
    
    public void modificarAlumno(Alumno alumnoAntiguo, Alumno alumnoNuevo) {
        List<Alumno> alumnos = leerAlumnos();
        int index = alumnos.indexOf(alumnoAntiguo);
        if (index >= 0) {
            alumnos.set(index, alumnoNuevo);
            try (FileWriter writer = new FileWriter(nombreArchivo)) {
                for (Alumno a : alumnos) {
                    writer.write(a.getNombre() + "," + a.getApellidos() + "," + a.getEdad() + "\n");
                }
            } catch (IOException e) {
                System.err.println("Error al modificar el alumno en el archivo");
                e.printStackTrace();
            }
        }
    }
    
    public List<Alumno> ordenarPorNombre() {
        List<Alumno> alumnos = leerAlumnos();
        Collections.sort(alumnos, new Comparator<Alumno>() {
            @Override
            public int compare(Alumno a1, Alumno a2) {
                return a1.getNombre().compareToIgnoreCase(a2.getNombre());
            }
        });
        return alumnos;
    }
    
    public List<Alumno> ordenarPorEdad() {
        List<Alumno> alumnos = leerAlumnos();
        Collections.sort(alumnos, new Comparator<Alumno>() {
            @Override
            public int compare(Alumno a1, Alumno a2) {
                return a1.getEdad() - a2.getEdad();
            }
        });
        return alumnos;
    }
}