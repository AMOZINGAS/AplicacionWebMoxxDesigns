/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignswebapp.controllers;

import com.google.gson.Gson;
import itson.mx.moxxdesignsautenticacion.jwt.JwtUtil;
import itson.mx.moxxdesignsdto.CarritoComprasDTO;
import itson.mx.moxxdesignsdto.ProductoDTO;
import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.AutenticacionException;
import itson.mx.moxxdesignsexcepciones.SubsistemaException;
import itson.mx.moxxdesignsgestionarcotizaciones.fachada.FachadaGestionarCotizaciones;
import itson.mx.moxxdesignsgestionarcotizaciones.fachada.IFachadaGestionarCotizaciones;
import itson.mx.moxxdesignsgestionarusuarios.fachada.FachadaGestionarUsuarios;
import itson.mx.moxxdesignsgestionarusuarios.fachada.IFachadaGestionarUsuarios;
import itson.mx.moxxdesignswebutils.bodyparser.BodyParser;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author olive
 */
public class CarritoCompraController {
    
    private static IFachadaGestionarCotizaciones fachadaCotizaciones = new FachadaGestionarCotizaciones() ;
    private static IFachadaGestionarUsuarios fachadaUsuarios = new FachadaGestionarUsuarios() ;
    private static Gson gson = new Gson();
    
    public static void GETObtenerCarritoDeComprasUsuario(HttpServletRequest req, HttpServletResponse res) {
        try {
           String token = JwtUtil.getTokenFromCookies(req.getCookies()) ;
            
            try {
                String emailUsuario = JwtUtil.getTokenData(token) ;
                UsuarioDTO usuario = fachadaUsuarios.obtenerUsuarioPorEmail(emailUsuario) ;
                CarritoComprasDTO carritoDeUsuario = fachadaCotizaciones.obtenerCarritoDeComprasDeUsuario(usuario) ;
                
                String carritoJson = gson.toJson(carritoDeUsuario) ;
                
                res.setStatus(HttpServletResponse.SC_OK);
                res.setContentType("application/json");
                res.getWriter().write(carritoJson);
                
            } catch (SubsistemaException e) {
                res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                res.getWriter().write("{\"error\": \"Error al obtener los productos\"}");
            } catch (AutenticacionException e) {
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                res.getWriter().write("{\"error\": \"Necesitas iniciar sesion\"}");
            }
        } catch (IOException e) {
            System.out.println("Error al manejar la solicitud");
        }
    }
    
    public static void POSTAgregarProductoACarritoDeCompras(HttpServletRequest req, HttpServletResponse res) {
        try {
           String token = JwtUtil.getTokenFromCookies(req.getCookies()) ;
            
           ProductoDTO productoAgregar ;
            try {
                productoAgregar = BodyParser.parseRequestBody(req, res, ProductoDTO.class) ;
                
                String emailUsuario = JwtUtil.getTokenData(token) ;
                UsuarioDTO usuario = fachadaUsuarios.obtenerUsuarioPorEmail(emailUsuario) ;
                fachadaCotizaciones.agregarProductoACarritoDeCompras(usuario, productoAgregar);
                
                res.setStatus(HttpServletResponse.SC_OK);
                res.setContentType("application/json");
                res.getWriter().write("Se ha agregado el producto al carrito exitosamente");
                
            } catch (SubsistemaException e) {
                res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                res.getWriter().write("{\"error\": \"Hubo un error al agregar el producto al carrito\"}");
            } catch (AutenticacionException e) {
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                res.getWriter().write("{\"error\": \"Necesitas iniciar sesion\"}");
            }
        } catch (IOException e) {
            System.out.println("Error al manejar la solicitud");
        }
    }
    
    public static void DELETEEliminarProductoDeCarritoDeCompras(HttpServletRequest req, HttpServletResponse res) {
        try {
           String token = JwtUtil.getTokenFromCookies(req.getCookies()) ;
            
           ProductoDTO productoEliminar ;
            try {
                productoEliminar = BodyParser.parseRequestBody(req, res, ProductoDTO.class) ;
                
                String emailUsuario = JwtUtil.getTokenData(token) ;
                UsuarioDTO usuario = fachadaUsuarios.obtenerUsuarioPorEmail(emailUsuario) ;
                fachadaCotizaciones.eliminarProductoDeCarritoDeCompras(usuario, productoEliminar);
                
                res.setStatus(HttpServletResponse.SC_OK);
                res.setContentType("application/json");
                res.getWriter().write("Se ha eliminado el producto al carrito exitosamente");
                
            } catch (SubsistemaException e) {
                res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                res.getWriter().write("{\"error\": \"Hubo un error al eliminar el producto al carrito\"}");
            } catch (AutenticacionException e) {
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                res.getWriter().write("{\"error\": \"Necesitas iniciar sesion\"}");
            }
        } catch (IOException e) {
            System.out.println("Error al manejar la solicitud");
        }
    }
    
    public static void DELETEEliminarTodosLosProductosDeCarritoDeCompras(HttpServletRequest req, HttpServletResponse res) {
        try {
            
        } catch (IOException e) {
            
        }
    }
    
}
