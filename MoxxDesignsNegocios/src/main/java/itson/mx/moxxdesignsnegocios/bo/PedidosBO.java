/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignsnegocios.bo;

import itson.mx.moxxdesignsdominio.conexion.Conexion;
import itson.mx.moxxdesignsdominio.entidades.CarritoCompras;
import itson.mx.moxxdesignsdominio.entidades.Pedido;
import itson.mx.moxxdesignsdominio.entidades.Usuario;
import itson.mx.moxxdesignsdto.PedidoDTO;
import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.NegociosException;
import itson.mx.moxxdesignsexcepciones.PersistenciaException;
import itson.mx.moxxdesignsnegocios.utils.Convertor;
import itson.mx.moxxdesignsnegocios.interfaces.IPedidosBO;
import itson.mx.moxxdesignspersistencia.daos.CarritoComprasDAO;
import itson.mx.moxxdesignspersistencia.daos.PedidosDAO;
import itson.mx.moxxdesignspersistencia.daos.ProductosDAO;
import itson.mx.moxxdesignspersistencia.daos.UsuariosDAO;
import itson.mx.moxxdesignspersistencia.interfaces.ICarritoComprasDAO;
import itson.mx.moxxdesignspersistencia.interfaces.IPedidosDAO;
import itson.mx.moxxdesignspersistencia.interfaces.IProductosDAO;
import itson.mx.moxxdesignspersistencia.interfaces.IUsuariosDAO;
import java.util.List;

/**
 *
 * @author olive
 */
public class PedidosBO implements IPedidosBO {

    private IPedidosDAO pedidosDAO ;
    private IProductosDAO productosDAO ;
    private IUsuariosDAO usuariosDAO ;
    private ICarritoComprasDAO carritoDAO ;
    
    public PedidosBO() {
        this.pedidosDAO = new PedidosDAO(new Conexion()) ;
        this.productosDAO = new ProductosDAO(new Conexion()) ;
        this.usuariosDAO = new UsuariosDAO(new Conexion()) ;
        this.carritoDAO = new CarritoComprasDAO(new Conexion()) ;
    }
    
    @Override
    public void crearPedido(PedidoDTO pedido) throws NegociosException {
        try {
            Pedido pedidoACrear = Convertor.pedidoDtoAEntity(pedido) ;
            Usuario usuarioDelPedido = usuariosDAO.obtenerUsuarioPorEmail(pedido.getUsuarioDTO().getEmail()) ;
            CarritoCompras carritoDelUsuario = carritoDAO.obtenerCarritoDeComprasDeUsuario(usuarioDelPedido) ;
            pedidoACrear.setUsuario(usuarioDelPedido);
            pedidosDAO.crearPedido(pedidoACrear);
            carritoDAO.eliminarTodosLosProductosDeCarritoDeCompras(carritoDelUsuario);
        } catch (PersistenciaException e) {
            throw new NegociosException(e.getMessage()) ;
        }
    }

    @Override
    public List<PedidoDTO> obtenerPedidosDeUsuario(UsuarioDTO usuario) throws NegociosException {
        try {
            Usuario usuarioDeLosPedidos = usuariosDAO.obtenerUsuarioPorEmail(usuario.getEmail()) ;
            List<Pedido> pedidosDelUsuario = pedidosDAO.obtenerPedidosDeUsuario(usuarioDeLosPedidos) ;
            
            return Convertor.listaPedidosEntityADto(pedidosDelUsuario) ;
        } catch (PersistenciaException e) {
            throw new NegociosException(e.getMessage());
        }
    }
    
}
