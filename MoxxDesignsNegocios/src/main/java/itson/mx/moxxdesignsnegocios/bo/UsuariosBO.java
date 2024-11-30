package itson.mx.moxxdesignsnegocios.bo;

import itson.mx.moxxdesignsdominio.conexion.Conexion;
import itson.mx.moxxdesignsdominio.entidades.CarritoCompras;
import itson.mx.moxxdesignsdominio.entidades.Usuario;
import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.NegociosException;
import itson.mx.moxxdesignsexcepciones.PersistenciaException;
import itson.mx.moxxdesignsnegocios.utils.Convertor;
import itson.mx.moxxdesignsnegocios.interfaces.IUsuariosBO;
import itson.mx.moxxdesignsnegocios.utils.Encrypt;
import itson.mx.moxxdesignspersistencia.daos.CarritoComprasDAO;
import itson.mx.moxxdesignspersistencia.daos.UsuariosDAO;
import itson.mx.moxxdesignspersistencia.interfaces.ICarritoComprasDAO;
import itson.mx.moxxdesignspersistencia.interfaces.IUsuariosDAO;

/**
 *
 * @author olive
 */
public class UsuariosBO implements IUsuariosBO {

    private IUsuariosDAO usuariosDAO;
    private ICarritoComprasDAO carritoDAO;

    public UsuariosBO() {
        this.usuariosDAO = new UsuariosDAO(new Conexion());
        this.carritoDAO = new CarritoComprasDAO(new Conexion());
    }

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuario) throws NegociosException {
        try {

            String contrasenaEncriptada = Encrypt.encrypt(usuario.getPassword());
            usuario.setPassword(contrasenaEncriptada);

            Usuario usuarioCreado = usuariosDAO.crearUsuario(Convertor.usuarioDtoAEntity(usuario));
            carritoDAO.crearCarritoDeCompras(new CarritoCompras(usuarioCreado));
            return Convertor.usuarioEntityADto(usuarioCreado);
        } catch (PersistenciaException e) {
            throw new NegociosException(e.getMessage());
        }
    }

    @Override
    public boolean login(String email, String password) throws NegociosException {
        try {
            return usuariosDAO.login(email, password);
        } catch (PersistenciaException e) {
            throw new NegociosException(e.getMessage());
        }
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorEmail(String email) throws NegociosException {
        try {
            Usuario usuarioObtenido = usuariosDAO.obtenerUsuarioPorEmail(email);
            return Convertor.usuarioEntityADto(usuarioObtenido);
        } catch (PersistenciaException e) {
            throw new NegociosException(e.getMessage());
        }
    }

}
