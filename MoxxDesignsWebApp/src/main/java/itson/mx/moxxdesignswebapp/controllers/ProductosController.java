package itson.mx.moxxdesignswebapp.controllers;

import com.google.gson.Gson;
import itson.mx.moxxdesignsdto.ProductoDTO;
import itson.mx.moxxdesignsexcepciones.SubsistemaException;
import itson.mx.moxxdesignsgestionarcotizaciones.fachada.FachadaGestionarCotizaciones;
import itson.mx.moxxdesignsgestionarcotizaciones.fachada.IFachadaGestionarCotizaciones;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olive
 */
public class ProductosController {

    private static IFachadaGestionarCotizaciones fachadaCotizaciones = new FachadaGestionarCotizaciones();
    private static Gson gson = new Gson();

    public static void GETObtenerTodosLosProductos(HttpServletRequest req, HttpServletResponse res) {
        try {

            List<ProductoDTO> productosDTO = fachadaCotizaciones.obtenerTodosLosProductos();

            if (productosDTO.isEmpty()) {
                res.setStatus(HttpServletResponse.SC_NOT_FOUND);
                res.getWriter().write("{\"error\": \"No product found nigga\"}");
            } else {

                String productosJson = gson.toJson(productosDTO);

                res.setStatus(HttpServletResponse.SC_OK);
                res.setContentType("application/json");
                res.getWriter().write(productosJson);
            }
        } catch (SubsistemaException e) {

            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                res.getWriter().write("{\"error\": \"Error al obtener productos uwu\"}");
            } catch (IOException ex) {
                Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void GETObtenerProductoPorId(HttpServletRequest req, HttpServletResponse res) {
        try {

            String idParam = req.getParameter("id");

            if (idParam == null || idParam.isEmpty()) {
                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                res.getWriter().write("{\"error\": \"PON ALGO VERGA\"}");
                return;
            }

            Long id = 0L;
            try {
                id = Long.parseLong(idParam);

            } catch (NumberFormatException e) {
                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                res.getWriter().write("{\"error\": \"ID Invalido\"}");
                return;
            }

            ProductoDTO productoDTO = fachadaCotizaciones.obtenerProductoPorId(id);

            if (productoDTO == null) {
                res.setStatus(HttpServletResponse.SC_NOT_FOUND);
                res.getWriter().write("{\"error\": \"Producto no encontrado\"}");
            } else {

                String productoJson = gson.toJson(productoDTO);
                res.setStatus(HttpServletResponse.SC_OK);
                res.setContentType("application/json");
                res.getWriter().write(productoJson);
            }
        } catch (IOException e) {

            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                res.getWriter().write("{\"error\": \"Don't know\"}");
            } catch (IOException ex) {
                Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SubsistemaException ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
