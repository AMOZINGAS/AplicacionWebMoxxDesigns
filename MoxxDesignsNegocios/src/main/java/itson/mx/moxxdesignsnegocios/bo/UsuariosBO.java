/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignsnegocios.bo;

import itson.mx.moxxdesignsdominio.conexion.Conexion;
import itson.mx.moxxdesignsdominio.entidades.Usuario;
import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.NegociosException;
import itson.mx.moxxdesignsexcepciones.PersistenciaException;
import itson.mx.moxxdesignsnegocios.utils.Convertor;
import itson.mx.moxxdesignsnegocios.interfaces.IUsuariosBO;
import itson.mx.moxxdesignspersistencia.daos.UsuariosDAO;

/**
 *
 * @author olive
 */
public class UsuariosBO implements IUsuariosBO {
    
    private UsuariosDAO usuariosDAO ;
    
    public UsuariosBO() {
        this.usuariosDAO = new UsuariosDAO(new Conexion()) ;
    }

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuario) throws NegociosException {
        try {
            Usuario usuarioCreado = usuariosDAO.crearUsuario(Convertor.usuarioDtoAEntity(usuario)) ;
            return Convertor.usuarioEntityADto(usuarioCreado) ;
        } catch (PersistenciaException e) {
            throw new NegociosException(e.getMessage()) ;
        }
    }

    @Override
    public boolean login(String email, String password) throws NegociosException {
        try {
            return usuariosDAO.login(email, password) ;
        } catch (PersistenciaException e) {
            throw new NegociosException(e.getMessage()) ;
        }
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorEmail(String email) throws NegociosException {
        try {
            Usuario usuarioObtenido = usuariosDAO.obtenerUsuarioPorEmail(email) ;
            return Convertor.usuarioEntityADto(usuarioObtenido) ;
        } catch (PersistenciaException e) {
            throw new NegociosException(e.getMessage()) ;
        }
    }
    
}
