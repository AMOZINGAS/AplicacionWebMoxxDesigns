/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignsgestionarcotizaciones.fachada;

import itson.mx.moxxdesignsdto.CarritoComprasDTO;
import itson.mx.moxxdesignsdto.PedidoDTO;
import itson.mx.moxxdesignsdto.ProductoDTO;
import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.SubsistemaException;
import itson.mx.moxxdesignsgestionarcotizaciones.control.GestionarCotizaciones;
import java.util.List;

/**
 *
 * @author olive
 */
public class FachadaGestionarCotizaciones implements IFachadaGestionarCotizaciones {
   private GestionarCotizaciones control;
   
   public FachadaGestionarCotizaciones() {
       this.control = new GestionarCotizaciones();
   }
   
   @Override
   public CarritoComprasDTO obtenerCarritoDeComprasDeUsuario(UsuarioDTO usuario) throws SubsistemaException {
       try {
           return control.obtenerCarritoDeComprasDeUsuario(usuario);
       } catch (SubsistemaException e) {
           throw new SubsistemaException(e.getMessage());
       }
   }
   
   @Override
   public void agregarProductoACarritoDeCompras(UsuarioDTO usuario, ProductoDTO producto) throws SubsistemaException {
       try {
           control.agregarProductoACarritoDeCompras(usuario, producto);
       } catch (SubsistemaException e) {
           throw new SubsistemaException(e.getMessage());
       }
   }
   
   @Override
   public void eliminarProductoDeCarritoDeCompras(UsuarioDTO usuario, ProductoDTO producto) throws SubsistemaException {
       try {
           control.eliminarProductoDeCarritoDeCompras(usuario, producto);
       } catch (SubsistemaException e) {
           throw new SubsistemaException(e.getMessage());
       }
   }
   
   @Override
   public void eliminarTodosLosProductosDeCarritoDeCompras(UsuarioDTO usuario) throws SubsistemaException {
       try {
           control.eliminarTodosLosProductosDeCarritoDeCompras(usuario);
       } catch (SubsistemaException e) {
           throw new SubsistemaException(e.getMessage());
       }
   }
   
   @Override
   public void crearPedido(PedidoDTO pedido) throws SubsistemaException {
       try {
           control.crearPedido(pedido);
       } catch (SubsistemaException e) {
           throw new SubsistemaException(e.getMessage());
       }
   }
   
   @Override
   public List<PedidoDTO> obtenerPedidosDeUsuario(UsuarioDTO usuario) throws SubsistemaException {
       try {
           return control.obtenerPedidosDeUsuario(usuario);
       } catch (SubsistemaException e) {
           throw new SubsistemaException(e.getMessage());
       }
   }
   
   @Override
   public List<ProductoDTO> obtenerTodosLosProductos() throws SubsistemaException {
       try {
           return control.obtenerTodosLosProductos();
       } catch (SubsistemaException e) {
           throw new SubsistemaException(e.getMessage());
       }
   }
   
   @Override
   public ProductoDTO obtenerProductoPorId(Long id) throws SubsistemaException {
       try {
           return control.obtenerProductoPorId(id);
       } catch (SubsistemaException e) {
           throw new SubsistemaException(e.getMessage());
       }
   }
}