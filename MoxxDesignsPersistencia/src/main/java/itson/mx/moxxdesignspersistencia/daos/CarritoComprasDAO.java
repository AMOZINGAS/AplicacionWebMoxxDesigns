/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignspersistencia.daos;

import itson.mx.moxxdesignsdominio.entidades.CarritoCompras;
import itson.mx.moxxdesignsdominio.entidades.Producto;
import itson.mx.moxxdesignsdominio.entidades.Usuario;
import itson.mx.moxxdesignsexcepciones.PersistenciaException;
import itson.mx.moxxdesignspersistencia.interfaces.ICarritoComprasDAO;

/**
 *
 * @author olive
 */
public class CarritoComprasDAO implements ICarritoComprasDAO {

    @Override
    public CarritoCompras obtenerCarritoDeComprasDeUsuario(Usuario usuario) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarProductoACarritoDeCompras(CarritoCompras carritoCompras) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarProductoDeCarritoDeCompras(CarritoCompras carritoCompras, Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarTodosLosProductosDeCarritoDeCompras(CarritoCompras carritoCompras) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
