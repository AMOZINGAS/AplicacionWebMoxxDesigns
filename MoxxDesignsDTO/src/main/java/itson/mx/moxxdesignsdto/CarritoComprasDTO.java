package itson.mx.moxxdesignsdto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author olive
 */
public class CarritoComprasDTO {

    private List<ProductoDTO> productos;

    public CarritoComprasDTO() {
        this.productos = new ArrayList<>();
    }

    public CarritoComprasDTO(List<ProductoDTO> productos) {
        this.productos = productos;
    }

    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
    }

}
