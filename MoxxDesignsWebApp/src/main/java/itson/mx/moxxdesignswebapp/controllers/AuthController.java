/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignswebapp.controllers;

import itson.mx.moxxdesignsgestionarusuarios.fachada.FachadaGestionarUsuarios;
import itson.mx.moxxdesignsgestionarusuarios.fachada.IFachadaGestionarUsuarios;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author olive
 */
public class AuthController {
    
    private static IFachadaGestionarUsuarios fachadaUsuarios = new FachadaGestionarUsuarios() ;
    
    public static void POSTLogin(HttpServletRequest req, HttpServletResponse res) {
        
    }
    
    public static void POSTCrearUsuario(HttpServletRequest req, HttpServletResponse res) {
        
    }
}
