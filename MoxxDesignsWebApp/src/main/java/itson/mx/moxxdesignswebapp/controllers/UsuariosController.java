package itson.mx.moxxdesignswebapp.controllers;

import com.google.gson.Gson;
import itson.mx.moxxdesignsautenticacion.jwt.JwtUtil;
import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.AutenticacionException;
import itson.mx.moxxdesignsexcepciones.SubsistemaException;
import itson.mx.moxxdesignsgestionarusuarios.fachada.FachadaGestionarUsuarios;
import itson.mx.moxxdesignsgestionarusuarios.fachada.IFachadaGestionarUsuarios;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olive
 */
public class UsuariosController {

    private static IFachadaGestionarUsuarios fachadaUsuarios = new FachadaGestionarUsuarios();
    private static Gson gson = new Gson();

    public static void GETObtenerUsuario(HttpServletRequest req, HttpServletResponse res) {
        try {

            try {
                String token = JwtUtil.getTokenFromCookies(req.getCookies());

                UsuarioDTO usuarioDTO = null;

                String email = JwtUtil.getTokenData(token);

                usuarioDTO = fachadaUsuarios.obtenerUsuarioPorEmail(email);

                if (usuarioDTO == null) {

                    res.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    res.getWriter().write("{\"error\": \"Null my lil fam\"}");
                } else {

                    String usuarioJson = gson.toJson(usuarioDTO);
                    res.setStatus(HttpServletResponse.SC_OK);
                    res.setContentType("application/json");
                    res.getWriter().write(usuarioJson);
                }
            } catch (SubsistemaException e) {
                res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                res.getWriter().write("{\"error\": \"Not found bruh\"}");
            } catch (AutenticacionException e) {
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                res.getWriter().write("{\"error\": \"Necesitas iniciar sesion\"}");
            }

        } catch (IOException e) {

            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
