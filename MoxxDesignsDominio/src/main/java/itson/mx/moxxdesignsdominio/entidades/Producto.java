package itson.mx.moxxdesignsdominio.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author olive
 */
@Entity
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "modelo", length = 30, nullable = false)
    private String modelo ;
    
    @Column(name = "marca", length = 30, nullable = false)
    private String marca ;
    
    @Column(name = "anio", length = 10, nullable = false)
    private String anio ;
    
    @Column(name = "color", length = 30, nullable = false)
    private String color ;
    
    @Column(name = "imagen", length = 50, nullable = false)
    private String imagen ;

    public Producto() {}

    public Producto(Long id, String modelo, String marca, String anio, String color, String imagen) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.anio = anio;
        this.color = color;
        this.imagen = imagen;
    }

    public Producto(String modelo, String marca, String anio, String color, String imagen) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "itson.mx.moxxdesignsdominio.Producto[ id=" + id + " ]";
    }
    
}
