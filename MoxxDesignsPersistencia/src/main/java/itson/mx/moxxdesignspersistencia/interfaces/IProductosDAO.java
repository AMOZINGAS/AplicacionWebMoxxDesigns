/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.mx.moxxdesignspersistencia.interfaces;

import itson.mx.moxxdesignsdominio.entidades.Producto;
import java.util.List;

/**
 *
 * @author olive
 */
public interface IProductosDAO {
    
    public List<Producto> obtenerTodosLosProductos() ;
    
}