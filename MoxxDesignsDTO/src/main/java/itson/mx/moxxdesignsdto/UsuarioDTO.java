package itson.mx.moxxdesignsdto;

import java.util.List;

/**
 *
 * @author olive
 */
public class UsuarioDTO {

    private Long id;
    private String email;
    private String password;
    private List<PedidoDTO> pedidos;
    private CarritoComprasDTO carritoComprasDTO;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UsuarioDTO(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public UsuarioDTO(String email, String password, List<PedidoDTO> pedidos, CarritoComprasDTO carritoComprasDTO) {
        this.email = email;
        this.password = password;
        this.pedidos = pedidos;
        this.carritoComprasDTO = carritoComprasDTO;
    }

    public UsuarioDTO(Long id, String email, String password, List<PedidoDTO> pedidos) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.pedidos = pedidos;
    }

    public UsuarioDTO(Long id, String email, String password, List<PedidoDTO> pedidos, CarritoComprasDTO carritoComprasDTO) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.pedidos = pedidos;
        this.carritoComprasDTO = carritoComprasDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PedidoDTO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoDTO> pedidos) {
        this.pedidos = pedidos;
    }

    public CarritoComprasDTO getCarritoComprasDTO() {
        return carritoComprasDTO;
    }

    public void setCarritoComprasDTO(CarritoComprasDTO carritoComprasDTO) {
        this.carritoComprasDTO = carritoComprasDTO;
    }

}
