/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package itson.mx.moxxdesignswebapp.servlets;

import static itson.mx.moxxdesignswebapp.controllers.CarritoCompraController.GETObtenerCarritoDeComprasUsuario;
import static itson.mx.moxxdesignswebapp.controllers.CarritoCompraController.DELETEEliminarProductoDeCarritoDeCompras;
import static itson.mx.moxxdesignswebapp.controllers.CarritoCompraController.DELETEEliminarTodosLosProductosDeCarritoDeCompras;
import static itson.mx.moxxdesignswebapp.controllers.CarritoCompraController.POSTAgregarProductoACarritoDeCompras;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author olive
 */
@WebServlet(name = "CarritoCompraServlet", urlPatterns = {"/carrito"})
public class CarritoCompraServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GETObtenerCarritoDeComprasUsuario(request, response);
    }

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
        
        if(path.endsWith("/producto")) {
            POSTAgregarProductoACarritoDeCompras(request, response);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        
        if(path.endsWith("/producto")) {
            DELETEEliminarProductoDeCarritoDeCompras(request, response);
        } else if(path.endsWith("/productos")) {
            DELETEEliminarTodosLosProductosDeCarritoDeCompras(request, response);
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
