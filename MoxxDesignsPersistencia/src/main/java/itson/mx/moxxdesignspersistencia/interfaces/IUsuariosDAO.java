/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.mx.moxxdesignspersistencia.interfaces;

import itson.mx.moxxdesignsdominio.entidades.Usuario;
import itson.mx.moxxdesignsexcepciones.PersistenciaException;

/**
 *
 * @author olive
 */
public interface IUsuariosDAO {
    
    public void crearUsuario(Usuario usuario) throws PersistenciaException ;
    
    public void autenticarUsuario(String email, String password) throws PersistenciaException ;
    
    public void obtenerUsuarioPorEmail(String email) throws PersistenciaException ;
}
