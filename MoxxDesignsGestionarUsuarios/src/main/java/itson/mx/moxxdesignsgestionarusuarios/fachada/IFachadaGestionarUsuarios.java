/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.mx.moxxdesignsgestionarusuarios.fachada;

import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.NegociosException;
import itson.mx.moxxdesignsexcepciones.SubsistemaException;

/**
 *
 * @author olive
 */
public interface IFachadaGestionarUsuarios {
    
    public UsuarioDTO crearUsuario(UsuarioDTO usuario) throws SubsistemaException ;
    
    public boolean login(String email, String password) throws SubsistemaException ;
    
    public UsuarioDTO obtenerUsuarioPorEmail(String email) throws SubsistemaException ;
    
}
