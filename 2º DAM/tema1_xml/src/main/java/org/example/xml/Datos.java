package org.example.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Datos {
    private List<Persona> personas;

    public Datos() {
        this.personas = new ArrayList<>();
    }

    @XmlElement(name = "persona")
    public List<Persona> getPersonas() {
        return personas;
    }

}
