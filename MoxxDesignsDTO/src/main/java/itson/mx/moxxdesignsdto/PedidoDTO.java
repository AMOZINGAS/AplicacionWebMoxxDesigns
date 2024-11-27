package itson.mx.moxxdesignsdto;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author olive
 */
public class PedidoDTO {

    private Long id;
    private Calendar fecha_hora;
    private Float precio_total;
    private Integer cantidad;
    private List<ProductoDTO> productosDTO;
    private UsuarioDTO usuarioDTO;

    public PedidoDTO() {
    }

    public PedidoDTO(Long id, Calendar fecha_hora, Float precio_total, Integer cantidad, List<ProductoDTO> productosDTO, UsuarioDTO usuarioDTO) {
        this.id = id;
        this.fecha_hora = fecha_hora;
        this.precio_total = precio_total;
        this.cantidad = cantidad;
        this.productosDTO = productosDTO;
        this.usuarioDTO = usuarioDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Calendar fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public Float getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(Float precio_total) {
        this.precio_total = precio_total;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public List<ProductoDTO> getProductosDTO() {
        return productosDTO;
    }

    public void setProductosDTO(List<ProductoDTO> productosDTO) {
        this.productosDTO = productosDTO;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

}
