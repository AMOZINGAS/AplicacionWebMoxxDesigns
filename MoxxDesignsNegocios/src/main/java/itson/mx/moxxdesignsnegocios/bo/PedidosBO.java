/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignsnegocios.bo;

import itson.mx.moxxdesignsdominio.entidades.Pedido;
import itson.mx.moxxdesignsdominio.entidades.Usuario;
import itson.mx.moxxdesignsdto.PedidoDTO;
import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.NegociosException;
import itson.mx.moxxdesignsexcepciones.PersistenciaException;
import itson.mx.moxxdesignsnegocios.convertor.Convertor;
import itson.mx.moxxdesignsnegocios.interfaces.IPedidosBO;
import itson.mx.moxxdesignspersistencia.daos.PedidosDAO;
import itson.mx.moxxdesignspersistencia.daos.ProductosDAO;
import itson.mx.moxxdesignspersistencia.daos.UsuariosDAO;
import java.util.List;

/**
 *
 * @author olive
 */
public class PedidosBO implements IPedidosBO {

    private PedidosDAO pedidosDAO ;
    private ProductosDAO productosDAO ;
    private UsuariosDAO usuariosDAO ;
    
    @Override
    public void crearPedido(PedidoDTO pedido) throws NegociosException {
        try {
            Pedido pedidoACrear = Convertor.pedidoDtoAEntity(pedido) ;
            Usuario usuarioDelPedido = usuariosDAO.obtenerUsuarioPorEmail(pedido.getUsuarioDTO().getEmail()) ;
            pedidoACrear.setUsuario(usuarioDelPedido);
            pedidosDAO.crearPedido(pedidoACrear);
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
