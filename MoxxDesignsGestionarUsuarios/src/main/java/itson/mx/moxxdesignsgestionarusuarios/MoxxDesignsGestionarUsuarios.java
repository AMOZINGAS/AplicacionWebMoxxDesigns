package itson.mx.moxxdesignsgestionarusuarios;

import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.SubsistemaException;
import itson.mx.moxxdesignsgestionarusuarios.fachada.FachadaGestionarUsuarios;

/**
 *
 * @author olive
 */
public class MoxxDesignsGestionarUsuarios {

    public static void main(String[] args) throws SubsistemaException {
        System.out.println("PRUEBAS EN EL GESTIONAR USUARIO");
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Olivio@gay.dick",
                "meLaComo",
                "MeLano",
                "Rosa"
        );

        FachadaGestionarUsuarios fachada = new FachadaGestionarUsuarios();

        fachada.crearUsuario(usuarioDTO);

    }
}
