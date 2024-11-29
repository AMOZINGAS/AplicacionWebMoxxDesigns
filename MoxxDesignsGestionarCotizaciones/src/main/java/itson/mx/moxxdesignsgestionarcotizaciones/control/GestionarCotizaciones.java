/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignsgestionarcotizaciones.control;

import itson.mx.moxxdesignsdto.CarritoComprasDTO;
import itson.mx.moxxdesignsdto.PedidoDTO;
import itson.mx.moxxdesignsdto.ProductoDTO;
import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.NegociosException;
import itson.mx.moxxdesignsexcepciones.SubsistemaException;
import itson.mx.moxxdesignsnegocios.bo.CarritoComprasBO;
import itson.mx.moxxdesignsnegocios.bo.PedidosBO;
import itson.mx.moxxdesignsnegocios.bo.ProductosBO;
import itson.mx.moxxdesignsnegocios.interfaces.ICarritoComprasBO;
import itson.mx.moxxdesignsnegocios.interfaces.IPedidosBO;
import itson.mx.moxxdesignsnegocios.interfaces.IProductosBO;
import java.util.List;

/**
 *
 * @author olive
 */
public class GestionarCotizaciones {
    
    private ICarritoComprasBO carritoComprasBO;
    private IPedidosBO pedidosBO;
    private IProductosBO productosBO;
    
    public GestionarCotizaciones() {
        this.carritoComprasBO = new CarritoComprasBO();
        this.pedidosBO = new PedidosBO();
        this.productosBO = new ProductosBO();
    }
    
    public CarritoComprasDTO obtenerCarritoDeComprasDeUsuario(UsuarioDTO usuario) throws SubsistemaException {
        try {
            return carritoComprasBO.obtenerCarritoDeComprasDeUsuario(usuario);
        } catch (NegociosException e) {
            throw new SubsistemaException(e.getMessage());
        }
    }

    public void agregarProductoACarritoDeCompras(UsuarioDTO usuario, ProductoDTO producto) throws SubsistemaException {
        try {
            carritoComprasBO.agregarProductoACarritoDeCompras(usuario, producto);
        } catch (NegociosException e) {
            throw new SubsistemaException(e.getMessage());
        }
    }

    public void eliminarProductoDeCarritoDeCompras(UsuarioDTO usuario, ProductoDTO producto) throws SubsistemaException {
        try {
            carritoComprasBO.eliminarProductoDeCarritoDeCompras(usuario, producto);
        } catch (NegociosException e) {
            throw new SubsistemaException(e.getMessage());
        }
    }

    public void eliminarTodosLosProductosDeCarritoDeCompras(UsuarioDTO usuario) throws SubsistemaException {
        try {
            carritoComprasBO.eliminarTodosLosProductosDeCarritoDeCompras(usuario);
        } catch (NegociosException e) {
            throw new SubsistemaException(e.getMessage());
        }
    }

    public void crearPedido(PedidoDTO pedido) throws SubsistemaException {
        try {
            pedidosBO.crearPedido(pedido);
        } catch (NegociosException e) {
            throw new SubsistemaException(e.getMessage());
        }
    }

    public List<PedidoDTO> obtenerPedidosDeUsuario(UsuarioDTO usuario) throws SubsistemaException {
        try {
            return pedidosBO.obtenerPedidosDeUsuario(usuario);
        } catch (NegociosException e) {
            throw new SubsistemaException(e.getMessage());
        }
    }

    public List<ProductoDTO> obtenerTodosLosProductos() throws SubsistemaException {
        try {
            return productosBO.obtenerTodosLosProductos();
        } catch (NegociosException e) {
            throw new SubsistemaException(e.getMessage());
        }
    }

    public ProductoDTO obtenerProductoPorId(Long id) throws SubsistemaException {
        try {
            return productosBO.obtenerProductoPorId(id);
        } catch (NegociosException e) {
            throw new SubsistemaException(e.getMessage());
        }
    }
}