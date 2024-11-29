/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.mx.moxxdesignsnegocios.interfaces;

import itson.mx.moxxdesignsdto.CarritoComprasDTO;
import itson.mx.moxxdesignsdto.ProductoDTO;
import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.NegociosException;

/**
 *
 * @author olive
 */
public interface ICarritoComprasBO {
    
    public CarritoComprasDTO obtenerCarritoDeComprasDeUsuario(UsuarioDTO usuario) throws NegociosException ;
    
    public void agregarProductoACarritoDeCompras(UsuarioDTO usuario, ProductoDTO producto) throws NegociosException ;
    
    public void eliminarProductoDeCarritoDeCompras(UsuarioDTO usuario, ProductoDTO producto) throws NegociosException ;
    
    public void eliminarTodosLosProductosDeCarritoDeCompras(UsuarioDTO usuario) throws NegociosException ;
    
}
