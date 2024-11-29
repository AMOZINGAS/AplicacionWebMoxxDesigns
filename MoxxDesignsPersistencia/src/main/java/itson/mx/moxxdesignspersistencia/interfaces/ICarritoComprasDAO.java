/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.mx.moxxdesignspersistencia.interfaces;

import itson.mx.moxxdesignsdominio.entidades.CarritoCompras;
import itson.mx.moxxdesignsdominio.entidades.Producto;
import itson.mx.moxxdesignsdominio.entidades.Usuario;
import itson.mx.moxxdesignsexcepciones.PersistenciaException;

/**
 *
 * @author olive
 */
public interface ICarritoComprasDAO {
    
    public CarritoCompras obtenerCarritoDeComprasDeUsuario(Usuario usuario) throws PersistenciaException ;
    
    public void agregarProductoACarritoDeCompras(CarritoCompras carritoCompras) throws PersistenciaException ;
    
    public void eliminarProductoDeCarritoDeCompras(CarritoCompras carritoCompras) throws PersistenciaException ;
    
    public void eliminarTodosLosProductosDeCarritoDeCompras(CarritoCompras carritoCompras) throws PersistenciaException ;
    
    public void crearCarritoDeCompras(CarritoCompras carritoCompras) throws PersistenciaException ;
    
}
