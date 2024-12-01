/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignswebapp.controllers;

import static com.mysql.cj.conf.PropertyKey.logger;
import itson.mx.moxxdesignsautenticacion.jwt.JwtUtil;
import itson.mx.moxxdesignsdto.PedidoDTO;
import itson.mx.moxxdesignsdto.ProductoDTO;
import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.AutenticacionException;
import itson.mx.moxxdesignsexcepciones.SubsistemaException;
import itson.mx.moxxdesignsgestionarcotizaciones.fachada.FachadaGestionarCotizaciones;
import itson.mx.moxxdesignsgestionarcotizaciones.fachada.IFachadaGestionarCotizaciones;
import itson.mx.moxxdesignsgestionarusuarios.fachada.FachadaGestionarUsuarios;
import itson.mx.moxxdesignsgestionarusuarios.fachada.IFachadaGestionarUsuarios;
import itson.mx.moxxdesignswebutils.bodyparser.BodyParser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author olive
 */
public class PedidosController {

    private static IFachadaGestionarCotizaciones fachadaCotizaciones = new FachadaGestionarCotizaciones();
    private static IFachadaGestionarUsuarios fachadaUsuarios = new FachadaGestionarUsuarios();
    private static final Logger logger = Logger.getLogger(PedidosController.class.getName());

    public static void POSTCrearPedido(HttpServletRequest req, HttpServletResponse res) {
        try {

            String token = JwtUtil.getTokenFromCookies(req.getCookies());
            String emailUsuario = JwtUtil.getTokenData(token);
            UsuarioDTO usuario = fachadaUsuarios.obtenerUsuarioPorEmail(emailUsuario);
            PedidoDTO pedidoDTO = BodyParser.parseRequestBody(req, res, PedidoDTO.class);

            System.out.println("AQUI PUTAAAAAAAAAAAAAAAAAA");
            System.out.println(pedidoDTO.getProductosDTO());

            List<ProductoDTO> productos = pedidoDTO.getProductosDTO();
            if (productos == null || productos.isEmpty()) {
                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                res.getWriter().write("{\"error\": \"El pedido debe contener al menos un producto\"}");
                return;
            }

            pedidoDTO.setUsuarioDTO(usuario);
            pedidoDTO.setFecha_hora(Calendar.getInstance());

            fachadaCotizaciones.crearPedido(pedidoDTO);

            res.setStatus(HttpServletResponse.SC_CREATED);
            res.setContentType("application/json");
            res.getWriter().write("{\"message\": \"Pedido creado exitosamente\"}");

        } catch (AutenticacionException e) {
            logger.warning("No se hace" + e.getMessage());
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            try {
                res.getWriter().write("{\"error\": \"Logeate krnal\"}");
            } catch (IOException ioEx) {
                logger.severe(ioEx.getMessage());
            }
        } catch (SubsistemaException e) {
            logger.severe(e.getMessage());
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                res.getWriter().write("{\"error\": \"No se pudo procesar el pedido. Intente nuevamente\"}");
            } catch (IOException ioEx) {
                logger.severe(ioEx.getMessage());
            }
        } catch (IOException e) {
            logger.severe(e.getMessage());
            try {
                res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                res.getWriter().write("{\"error\": \"Error al procesar la solicitud\"}");
            } catch (IOException ioEx) {
                logger.severe(ioEx.getMessage());
            }

        }
    }

    public static void GETObtenerPedidosDeUsuario(HttpServletRequest req, HttpServletResponse res) {
        try {
            String token = JwtUtil.getTokenFromCookies(req.getCookies());

            try {

                String emailUsuario = JwtUtil.getTokenData(token);

                UsuarioDTO usuario = fachadaUsuarios.obtenerUsuarioPorEmail(emailUsuario);

                List<PedidoDTO> pedidos = fachadaCotizaciones.obtenerPedidosDeUsuario(usuario);

                String pedidosJson = new com.google.gson.Gson().toJson(pedidos);

                res.setStatus(HttpServletResponse.SC_OK);
                res.setContentType("application/json");
                res.getWriter().write(pedidosJson);

            } catch (AutenticacionException e) {

                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                res.getWriter().write("{\"error\": \"Necesitas iniciar sesión\"}");
                logger.warning("Unauthorized access attempt: " + e.getMessage());

            } catch (SubsistemaException e) {

                res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                res.getWriter().write("{\"error\": \"Error al obtener los pedidos\"}");
                logger.severe("Error retrieving user orders: " + e.getMessage());
            }
        } catch (IOException e) {

            logger.severe("Error al manejar la solicitud: " + e.getMessage());
            try {
                res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                res.getWriter().write("{\"error\": \"Error al procesar la solicitud\"}");
            } catch (IOException ex) {
                logger.severe("Error al escribir la respuesta: " + ex.getMessage());
            }

        }

    }

}
