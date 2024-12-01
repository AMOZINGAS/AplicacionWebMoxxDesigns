/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/AdvancedFilter.java to edit this template
 */
package itson.mx.moxxdesignswebapp.filters;

import itson.mx.moxxdesignsautenticacion.jwt.JwtUtil;
import itson.mx.moxxdesignsexcepciones.AutenticacionException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

/**
 *
 * @author olive
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"/pedido/*", "/usuario/*", "/carrito/*"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialización opcional
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String token = JwtUtil.getTokenFromCookies(req.getCookies()) ;

        if (token == null) {
            // Si no se encuentra la cookie, retornar 401
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("Necesitas iniciar sesion primero");
            return;
        }

        // Validar el token usando isTokenValid
        if (!JwtUtil.isTokenValid(token)) {
            // Si el token no es válido, retornar 401
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("Tu sesion es inválida o ya expiró...");
            return;
        }

        // Continuar con la cadena de filtros
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Limpieza opcional
    }
}