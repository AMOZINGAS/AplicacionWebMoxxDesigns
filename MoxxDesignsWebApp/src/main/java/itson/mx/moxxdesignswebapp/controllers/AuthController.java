/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignswebapp.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import itson.mx.moxxdesignsautenticacion.jwt.JwtUtil;
import itson.mx.moxxdesignsdto.LoginDTO;
import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.SubsistemaException;
import itson.mx.moxxdesignsgestionarusuarios.fachada.FachadaGestionarUsuarios;
import itson.mx.moxxdesignsgestionarusuarios.fachada.IFachadaGestionarUsuarios;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author olive
 */
public class AuthController {
    
    private static Gson gson = new Gson();
    private static IFachadaGestionarUsuarios fachadaUsuarios = new FachadaGestionarUsuarios() ;
    
    public static void POSTLogin(HttpServletRequest req, HttpServletResponse res) {
        try {
            LoginDTO loginRequest;

            // Leer el cuerpo de la solicitud
            StringBuilder jsonBody = new StringBuilder();
            try (BufferedReader reader = req.getReader()) {
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonBody.append(line);
                }
            }

            // Parsear el JSON a un objeto Java
            try {
                loginRequest = gson.fromJson(jsonBody.toString(), LoginDTO.class);
            } catch (JsonSyntaxException e) {
                // Respuesta para JSON mal formado
                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                res.getWriter().write("{\"error\": \"JSON mal formado\"}");
                return;
            }

            String email = loginRequest.getEmail();
            String password = loginRequest.getPassword();

            try {
                // Validar las credenciales (este ejemplo usa credenciales ficticias)
                if (fachadaUsuarios.login(email, password)) {
                    // Generar un token JWT
                    String token = JwtUtil.generateToken(email);

                    //Agregar Token a las Cookies
                    Cookie jwtCookie = new Cookie("auth_token", token) ;
                    jwtCookie.setMaxAge(10800);
                    jwtCookie.setHttpOnly(true);
                    jwtCookie.setSecure(false);
                    jwtCookie.setPath("/");
                    res.addCookie(jwtCookie);
                    
                    // Responder con el token
                    res.setStatus(HttpServletResponse.SC_OK);
                    res.setContentType("application/json");
                    res.getWriter().write("Inicio de Sesion exitoso");
                } else {
                    // Credenciales inválidas
                    res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    res.getWriter().write("{\"error\": \"Credenciales inválidas\"}");
                }
            } catch (SubsistemaException e) {
                // Credenciales inválidas
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                res.getWriter().write("{\"error\": \"Credenciales inválidas\"}");
            }
        } catch (IOException e) {
            System.out.println("Error al manejar la solicitud");
        }
    }
    
    public static void POSTCrearUsuario(HttpServletRequest req, HttpServletResponse res) {
        try {
            UsuarioDTO crearUsuarioRequest;

            // Leer el cuerpo de la solicitud
            StringBuilder jsonBody = new StringBuilder();
            try (BufferedReader reader = req.getReader()) {
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonBody.append(line);
                }
            }

            // Parsear el JSON a un objeto Java
            try {
                crearUsuarioRequest = gson.fromJson(jsonBody.toString(), UsuarioDTO.class);
            } catch (JsonSyntaxException e) {
                // Respuesta para JSON mal formado
                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                res.getWriter().write("{\"error\": \"JSON mal formado\"}");
                return;
            }

            try {
                fachadaUsuarios.crearUsuario(crearUsuarioRequest);
                res.setStatus(HttpServletResponse.SC_OK);
                res.setContentType("application/json");
                res.getWriter().write("Se ha creado la cuenta con exito");
            } catch (SubsistemaException e) {
                // Credenciales inválidas
                res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                res.getWriter().write("{\"error\": \"Error del Sistema\"}");
            }
        } catch (IOException e) {
            System.out.println("Error al manejar la solicitud");
        }
    }
}
