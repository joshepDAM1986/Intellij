package org.example;

import java.io.Serial;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AddressBook implements Serializable {

    //1.Atributos
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long id;
    private String name;
    private String address;

    public AddressBook() {
    }

    public AddressBook(String n, String a) {
        this.name = n;
        this.address = a;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)",
                this.name, this.address);
    }
}