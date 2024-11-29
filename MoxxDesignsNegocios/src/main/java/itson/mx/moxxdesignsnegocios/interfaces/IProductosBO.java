/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.mx.moxxdesignsnegocios.interfaces;

import itson.mx.moxxdesignsdto.ProductoDTO;
import itson.mx.moxxdesignsexcepciones.NegociosException;
import java.util.List;

/**
 *
 * @author olive
 */
public interface IProductosBO {
    
    public List<ProductoDTO> obtenerTodosLosProductos() throws NegociosException;

    public ProductoDTO obtenerProductoPorId(Long id) throws NegociosException ;
    
}
