/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignsnegocios.bo;

import itson.mx.moxxdesignsdominio.entidades.CarritoCompras;
import itson.mx.moxxdesignsdominio.entidades.Producto;
import itson.mx.moxxdesignsdominio.entidades.Usuario;
import itson.mx.moxxdesignsdto.CarritoComprasDTO;
import itson.mx.moxxdesignsdto.ProductoDTO;
import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.NegociosException;
import itson.mx.moxxdesignsexcepciones.PersistenciaException;
import itson.mx.moxxdesignsnegocios.utils.Convertor;
import itson.mx.moxxdesignsnegocios.interfaces.ICarritoComprasBO;
import itson.mx.moxxdesignspersistencia.daos.CarritoComprasDAO;
import itson.mx.moxxdesignspersistencia.daos.ProductosDAO;
import itson.mx.moxxdesignspersistencia.daos.UsuariosDAO;

/**
 *
 * @author olive
 */
public class CarritoComprasBO implements ICarritoComprasBO {

    private CarritoComprasDAO carritoDAO ;
    private UsuariosDAO usuariosDAO ;
    private ProductosDAO productosDAO ;
    
    @Override
    public CarritoComprasDTO obtenerCarritoDeComprasDeUsuario(UsuarioDTO usuario) throws NegociosException {
        try {
            Usuario usuarioDelCarrito = usuariosDAO.obtenerUsuarioPorEmail(usuario.getEmail()) ;
            CarritoCompras carritoDelUsuario = carritoDAO.obtenerCarritoDeComprasDeUsuario(usuarioDelCarrito) ;
            return Convertor.carritoComprasEntityADto(carritoDelUsuario) ;
        } catch (PersistenciaException e) {
            throw new NegociosException(e.getMessage()) ;
        }
    }

    @Override
    public void agregarProductoACarritoDeCompras(UsuarioDTO usuario, ProductoDTO producto) throws NegociosException {
        try {
            Producto productoDelCarrito = Convertor.productoDtoAEntity(producto) ;
            Usuario usuarioDelCarrito = usuariosDAO.obtenerUsuarioPorEmail(usuario.getEmail()) ;
            CarritoCompras carritoDelUsuario = carritoDAO.obtenerCarritoDeComprasDeUsuario(usuarioDelCarrito) ;
            carritoDelUsuario.getProductos().add(productoDelCarrito) ;
            carritoDAO.agregarProductoACarritoDeCompras(carritoDelUsuario);
        } catch (PersistenciaException e) {
            throw new NegociosException(e.getMessage()) ;
        }
    }

    @Override
    public void eliminarProductoDeCarritoDeCompras(UsuarioDTO usuario, ProductoDTO producto) throws NegociosException {
        try {
            Producto productoDelCarrito = Convertor.productoDtoAEntity(producto) ;
            Usuario usuarioDelCarrito = usuariosDAO.obtenerUsuarioPorEmail(usuario.getEmail()) ;
            CarritoCompras carritoDelUsuario = carritoDAO.obtenerCarritoDeComprasDeUsuario(usuarioDelCarrito) ;
            carritoDelUsuario.getProductos().add(productoDelCarrito) ;
            carritoDAO.agregarProductoACarritoDeCompras(carritoDelUsuario);
        } catch (PersistenciaException e) {
            throw new NegociosException(e.getMessage()) ;
        }
    }

    @Override
    public void eliminarTodosLosProductosDeCarritoDeCompras(UsuarioDTO usuario) throws NegociosException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
