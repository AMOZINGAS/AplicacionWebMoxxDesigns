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
public class ProductosController {
    
    private static IFachadaGestionarCotizaciones fachadaCotizaciones = new FachadaGestionarCotizaciones() ;
    
    public static void GETObtenerTodosLosProductos(HttpServletRequest req, HttpServletResponse res) {
        
    }
    
    public static void GETObtenerProductoPorId(HttpServletRequest req, HttpServletResponse res) {
        
    }
    
}
