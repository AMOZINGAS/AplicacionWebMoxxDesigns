/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.mx.moxxdesignsnegocios.interfaces;

import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.NegociosException;

/**
 *
 * @author olive
 */
public interface IUsuariosBO {
    
    public UsuarioDTO crearUsuario(UsuarioDTO usuario) throws NegociosException ;
    
    public boolean login(String email, String password) throws NegociosException ;
    
    public UsuarioDTO obtenerUsuarioPorEmail(String email) throws NegociosException ;
    
}
