package dto;

public class MuebleDTO {
    private String nombre,url_image;
    private Double precio;

    public MuebleDTO(){}

    public MuebleDTO(String nombre, String url_image, Double precio) {
        this.nombre = nombre;
        this.url_image = url_image;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
