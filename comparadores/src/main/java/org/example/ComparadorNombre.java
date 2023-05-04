package org.example;
import java.util.Comparator;
public class ComparadorNombre implements Comparator<Persona> {

    @Override
    public int compare(Persona o1, Persona o2) {
//        if (o1.getNombre() != o2.getNombre())
//            return o1.getNombre().compareTo(o2.getNombre());
//        else
//            return o1.getApellidos().compareTo(o2.getApellidos());
        return o1.getNombre().compareTo(o2.getNombre());
    }
}
