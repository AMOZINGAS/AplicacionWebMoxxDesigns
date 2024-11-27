package itson.mx.moxxdesignsdto;

/**
 *
 * @author olive
 */
public class ProductoDTO {

    private Long id;
    private String modelo;
    private String marca;
    private String anio;
    private String color;
    private String imagen;

    public ProductoDTO() {
    }

    public ProductoDTO(String modelo, String marca, String anio, String color, String imagen) {
        this.modelo = modelo;
        this.marca = marca;
        this.anio = anio;
        this.color = color;
        this.imagen = imagen;
    }

    public ProductoDTO(Long id, String modelo, String marca, String anio, String color, String imagen) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.anio = anio;
        this.color = color;
        this.imagen = imagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
