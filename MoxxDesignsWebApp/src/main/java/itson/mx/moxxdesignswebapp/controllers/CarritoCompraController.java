/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignswebapp.controllers;

import itson.mx.moxxdesignsgestionarcotizaciones.fachada.FachadaGestionarCotizaciones;
import itson.mx.moxxdesignsgestionarcotizaciones.fachada.IFachadaGestionarCotizaciones;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author olive
 */
public class CarritoCompraController {
    
    private static IFachadaGestionarCotizaciones fachadaCotizaciones = new FachadaGestionarCotizaciones() ;
    
    public static void GETObtenerCarritoDeComprasUsuario(HttpServletRequest req, HttpServletResponse res) {
        
    }
    
    public static void POSTAgregarProductoACarritoDeCompras(HttpServletRequest req, HttpServletResponse res) {
        
    }
    
    public static void DELETEEliminarProductoDeCarritoDeCompras(HttpServletRequest req, HttpServletResponse res) {
        
    }
    
    public static void DELETEEliminarTodosLosProductosDeCarritoDeCompras(HttpServletRequest req, HttpServletResponse res) {
        
    }
    
}
