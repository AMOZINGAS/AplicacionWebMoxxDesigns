/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package itson.mx.moxxdesignswebapp.filters;

import itson.mx.moxxdesignsautenticacion.jwt.JwtUtil;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author olive
 */
@WebFilter(filterName = "LoggedFilter", urlPatterns = {"/auth/login", "/auth/user"})
public class LoggedFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialización opcional
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String token = JwtUtil.getTokenFromCookies(req.getCookies());

        if (token == null || !JwtUtil.isTokenValid(token)) {

            if (token != null) {
                for (Cookie cookie : req.getCookies()) {
                    if ("auth_token".equals(cookie.getName())) {
                        cookie.setValue("");
                        cookie.setMaxAge(0);
                        res.addCookie(cookie);
                    }
                }
            }

            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("Necesitas cerrar sesión primero");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Limpieza opcional
    }
    
}
