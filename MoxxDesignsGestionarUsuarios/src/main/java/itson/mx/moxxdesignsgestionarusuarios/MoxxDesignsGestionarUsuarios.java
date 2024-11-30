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
//        System.out.println("PRUEBAS EN EL GESTIONAR USUARIO");
//        UsuarioDTO usuarioDTO = new UsuarioDTO(
//                "Olivio@gay.dick",
//                "meLaComo",
//                "MeLano",
//                "Rosa"
//        );
//
//        FachadaGestionarUsuarios fachada = new FachadaGestionarUsuarios();
//        fachada.crearUsuario(usuarioDTO);

        FachadaGestionarUsuarios fachada = new FachadaGestionarUsuarios();

//        try {
//            String email = "Olivio@gay.dick";
//            // Intentamos obtener el usuario por el correo
//            UsuarioDTO usuarioDTO = fachada.obtenerUsuarioPorEmail(email);
//
//            if (usuarioDTO != null) {
//                // Si el usuario es encontrado, mostramos su información
//                System.out.println("Usuario encontrado:");
//                System.out.println("Nombre: " + usuarioDTO.getNombre());
//                System.out.println("Correo: " + usuarioDTO.getEmail());
//            } else {
//
//                System.out.println("SE ENCONTRO" + email);
//            }
//        } catch (SubsistemaException e) {
//
//            System.err.println("Error al obtener el usuario: " + e.getMessage());
//        }
        System.out.println("PRUEBAS EN EL LOGIN DE USUARIO");

        try {
            String email = "Olivio@gay.dick";
            String password = "meLaComo";

            boolean loginExitoso = fachada.login(email, password);

            if (loginExitoso) {
                System.out.println("Se metio perra");
            } else {
                System.out.println("No se hizo");
            }
        } catch (SubsistemaException e) {
            System.err.println("NO SE METIO ERROR" + e.getMessage());
        }
    }

}
