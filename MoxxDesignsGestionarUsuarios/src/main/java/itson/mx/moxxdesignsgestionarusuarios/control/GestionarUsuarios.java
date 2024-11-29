/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignsgestionarusuarios.control;

import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.NegociosException;
import itson.mx.moxxdesignsexcepciones.SubsistemaException;
import itson.mx.moxxdesignsnegocios.bo.UsuariosBO;
import itson.mx.moxxdesignsnegocios.interfaces.IUsuariosBO;

/**
 *
 * @author olive
 */
public class GestionarUsuarios {
   
   private IUsuariosBO usuariosBO;
   
   public GestionarUsuarios() {
       this.usuariosBO = new UsuariosBO();
   }
   
   public UsuarioDTO crearUsuario(UsuarioDTO usuario) throws SubsistemaException {
       try {
           return usuariosBO.crearUsuario(usuario);
       } catch (NegociosException e) {
           throw new SubsistemaException(e.getMessage());
       }
   }

   public boolean login(String email, String password) throws SubsistemaException {
       try {
           return usuariosBO.login(email, password);
       } catch (NegociosException e) {
           throw new SubsistemaException(e.getMessage());
       }
   }

   public UsuarioDTO obtenerUsuarioPorEmail(String email) throws SubsistemaException {
       try {
           return usuariosBO.obtenerUsuarioPorEmail(email);
       } catch (NegociosException e) {
           throw new SubsistemaException(e.getMessage());
       }
   }
}
