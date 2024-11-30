/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignsnegocios.bo;

import itson.mx.moxxdesignsdominio.conexion.Conexion;
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
import itson.mx.moxxdesignspersistencia.interfaces.ICarritoComprasDAO;
import itson.mx.moxxdesignspersistencia.interfaces.IProductosDAO;
import itson.mx.moxxdesignspersistencia.interfaces.IUsuariosDAO;

/**
 *
 * @author olive
 */
public class CarritoComprasBO implements ICarritoComprasBO {

    private ICarritoComprasDAO carritoDAO ;
    private IUsuariosDAO usuariosDAO ;
    private IProductosDAO productosDAO ;
    
    public CarritoComprasBO() {
        this.carritoDAO = new CarritoComprasDAO(new Conexion()) ;
        this.usuariosDAO = new UsuariosDAO(new Conexion()) ;
        this.productosDAO = new ProductosDAO(new Conexion()) ;
    }
    
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
            carritoDelUsuario.getProductos().remove(productoDelCarrito) ;
            carritoDAO.eliminarProductoDeCarritoDeCompras(carritoDelUsuario);
        } catch (PersistenciaException e) {
            throw new NegociosException(e.getMessage()) ;
        }
    }

    @Override
    public void eliminarTodosLosProductosDeCarritoDeCompras(UsuarioDTO usuario) throws NegociosException {
        try {
            Usuario usuarioDelCarrito = usuariosDAO.obtenerUsuarioPorEmail(usuario.getEmail()) ;
            CarritoCompras carritoDelUsuario = carritoDAO.obtenerCarritoDeComprasDeUsuario(usuarioDelCarrito) ;
            carritoDAO.eliminarTodosLosProductosDeCarritoDeCompras(carritoDelUsuario);
        } catch (PersistenciaException e) {
            throw new NegociosException(e.getMessage()) ;
        }
    }
}
