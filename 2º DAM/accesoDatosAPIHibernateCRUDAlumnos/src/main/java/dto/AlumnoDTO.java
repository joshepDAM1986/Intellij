package dto;

public class AlumnoDTO {
    private String nombre;
    private String apellidos;
    private String categoria;
    private Double nota;

    public AlumnoDTO() {
    }

    public AlumnoDTO(String nombre, String apellidos, String categoria, Double nota) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.categoria = categoria;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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
                ", apellidos='" + apellidos + '\'' +
                ", categoria='" + categoria + '\'' +
                ", nota=" + nota +
                '}';
    }
}
