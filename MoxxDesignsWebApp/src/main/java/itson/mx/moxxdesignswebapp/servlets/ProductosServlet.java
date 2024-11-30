/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package itson.mx.moxxdesignswebapp.servlets;

import static itson.mx.moxxdesignswebapp.controllers.ProductosController.GETObtenerProductoPorId;
import static itson.mx.moxxdesignswebapp.controllers.ProductosController.GETObtenerTodosLosProductos;
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
@WebServlet(name = "ProductosServlet", urlPatterns = {"/productos"})
public class ProductosServlet extends HttpServlet {

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
        // Obtén el parámetro "id" de la consulta
        String idParam = request.getParameter("id");

        if (idParam != null) {
            // Llama al método para obtener el producto por ID
            GETObtenerProductoPorId(request, response);
        } else {
            // Si no se proporciona un "id", devuelve todos los productos
            GETObtenerTodosLosProductos(request, response);
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
