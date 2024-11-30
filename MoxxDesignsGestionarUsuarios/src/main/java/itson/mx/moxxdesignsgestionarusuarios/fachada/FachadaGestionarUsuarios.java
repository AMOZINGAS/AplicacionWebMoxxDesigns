/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignsgestionarusuarios.fachada;

import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.SubsistemaException;
import itson.mx.moxxdesignsgestionarusuarios.control.GestionarUsuarios;

/**
 *
 * @author olive
 */
public class FachadaGestionarUsuarios implements IFachadaGestionarUsuarios {

    private GestionarUsuarios control;

    public FachadaGestionarUsuarios() {
        this.control = new GestionarUsuarios();
    }

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuario) throws SubsistemaException {
        try {
            return control.crearUsuario(usuario);
        } catch (SubsistemaException e) {
            throw new SubsistemaException(e.getMessage());
        }
    }

    @Override
    public boolean login(String email, String password) throws SubsistemaException {
        try {
            return control.login(email, password);
        } catch (SubsistemaException e) {
            throw new SubsistemaException(e.getMessage());
        }
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorEmail(String email) throws SubsistemaException {
        try {
            return control.obtenerUsuarioPorEmail(email);
        } catch (SubsistemaException e) {
            throw new SubsistemaException(e.getMessage());
        }
    }

}
