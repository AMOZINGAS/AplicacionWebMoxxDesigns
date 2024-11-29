/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.mx.moxxdesignsnegocios.interfaces;

import itson.mx.moxxdesignsdto.PedidoDTO;
import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.NegociosException;
import java.util.List;

/**
 *
 * @author olive
 */
public interface IPedidosBO {
    
    public void crearPedido(PedidoDTO pedido) throws NegociosException ;
    
    public List<PedidoDTO> obtenerPedidosDeUsuario(UsuarioDTO usuario) throws NegociosException ;
}
