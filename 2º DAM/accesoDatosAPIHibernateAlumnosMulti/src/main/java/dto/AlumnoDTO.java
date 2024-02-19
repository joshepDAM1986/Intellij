package dto;

import com.google.gson.annotations.Expose;

public class AlumnoDTO {
    @Expose
    private String nombre;
    @Expose
    private String email;
    @Expose
    private String categoria;
    @Expose
    private Double nota;

    public AlumnoDTO() {
    }

    public AlumnoDTO(String nombre, String email, String categoria, Double nota) {
        this.nombre = nombre;
        this.email = email;
        this.categoria = categoria;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "AlumnoDTO{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", categoria='" + categoria + '\'' +
                ", nota=" + nota +
                '}';
    }
}
