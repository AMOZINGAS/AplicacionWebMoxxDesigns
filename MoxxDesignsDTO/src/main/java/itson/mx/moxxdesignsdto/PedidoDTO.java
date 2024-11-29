package itson.mx.moxxdesignsdto;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author olive
 */
public class PedidoDTO {

    private Calendar fecha_hora;
    private List<ProductoDTO> productosDTO;
    private UsuarioDTO usuarioDTO;

    public PedidoDTO() {
    }

    public PedidoDTO(Calendar fecha_hora, List<ProductoDTO> productosDTO, UsuarioDTO usuarioDTO) {
        this.fecha_hora = fecha_hora;
        this.productosDTO = productosDTO;
        this.usuarioDTO = usuarioDTO;
    }

    public Calendar getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Calendar fecha_hora) {
        this.fecha_hora = fecha_hora;
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
