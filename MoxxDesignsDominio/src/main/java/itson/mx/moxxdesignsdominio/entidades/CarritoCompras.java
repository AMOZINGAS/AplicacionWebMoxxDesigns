package itson.mx.moxxdesignsdominio.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author olive
 */
@Entity
public class CarritoCompras implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_carrito")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToMany
    @JoinTable(
        name = "carrito_productos",
        joinColumns = @JoinColumn(name = "carrito_id"),
        inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productos ;

    public CarritoCompras() {
        this.productos = new ArrayList() ;
    }

    public CarritoCompras(Long id, List<Producto> productos) {
        this.id = id;
        this.productos = productos;
    }

    public CarritoCompras(List<Producto> productos) {
        this.productos = productos;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
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
        if (!(object instanceof CarritoCompras)) {
            return false;
        }
        CarritoCompras other = (CarritoCompras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "itson.mx.moxxdesignsdominio.entidades.CarritoCompras[ id=" + id + " ]";
    }
    
}
