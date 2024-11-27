package itson.mx.moxxdesignsdto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author olive
 */
public class CarritoComprasDTO {

    private Long id;
    private List<ProductoDTO> productos;

    public CarritoComprasDTO() {
        this.productos = new ArrayList<>();
    }

    public CarritoComprasDTO(List<ProductoDTO> productos) {
        this.productos = productos;
    }

    public CarritoComprasDTO(Long id, List<ProductoDTO> productos) {
        this.id = id;
        this.productos = productos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
    }

}
