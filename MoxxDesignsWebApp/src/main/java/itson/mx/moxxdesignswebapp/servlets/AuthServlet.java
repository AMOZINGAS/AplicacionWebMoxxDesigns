/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package itson.mx.moxxdesignswebapp.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static itson.mx.moxxdesignswebapp.controllers.AuthController.POSTCrearUsuario;
import static itson.mx.moxxdesignswebapp.controllers.AuthController.POSTLogin;
import static itson.mx.moxxdesignswebapp.controllers.AuthController.POSTLogout;

/**
 *
 * @author olive
 */
@WebServlet(name = "AuthServlet", urlPatterns = {"/auth"})
public class AuthServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        
        if(path.endsWith("/login")) {
           POSTLogin(request, response);
        } else if(path.endsWith("/signup")) {
            POSTCrearUsuario(request, response);
        } else if(path.endsWith("logout")) {
            POSTLogout(request, response) ;
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
