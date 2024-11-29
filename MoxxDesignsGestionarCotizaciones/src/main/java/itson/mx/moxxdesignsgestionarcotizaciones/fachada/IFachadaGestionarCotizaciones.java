/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.mx.moxxdesignsgestionarcotizaciones.fachada;

import itson.mx.moxxdesignsdto.CarritoComprasDTO;
import itson.mx.moxxdesignsdto.PedidoDTO;
import itson.mx.moxxdesignsdto.ProductoDTO;
import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.NegociosException;
import itson.mx.moxxdesignsexcepciones.SubsistemaException;
import java.util.List;

/**
 *
 * @author olive
 */
public interface IFachadaGestionarCotizaciones {
   
   public CarritoComprasDTO obtenerCarritoDeComprasDeUsuario(UsuarioDTO usuario) throws SubsistemaException;
   
   public void agregarProductoACarritoDeCompras(UsuarioDTO usuario, ProductoDTO producto) throws SubsistemaException;
   
   public void eliminarProductoDeCarritoDeCompras(UsuarioDTO usuario, ProductoDTO producto) throws SubsistemaException;
   
   public void eliminarTodosLosProductosDeCarritoDeCompras(UsuarioDTO usuario) throws SubsistemaException;
   
   public void crearPedido(PedidoDTO pedido) throws SubsistemaException;
   
   public List<PedidoDTO> obtenerPedidosDeUsuario(UsuarioDTO usuario) throws SubsistemaException;
   
   public List<ProductoDTO> obtenerTodosLosProductos() throws SubsistemaException;
   
   public ProductoDTO obtenerProductoPorId(Long id) throws SubsistemaException;
   
}
