/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignspersistencia.daos;

import itson.mx.moxxdesignsdominio.conexion.Conexion;
import itson.mx.moxxdesignsdominio.conexion.IConexion;
import itson.mx.moxxdesignsdominio.entidades.Usuario;
import itson.mx.moxxdesignsexcepciones.PersistenciaException;
import itson.mx.moxxdesignspersistencia.interfaces.IUsuariosDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author olive
 */
public class UsuariosDAO implements IUsuariosDAO {

    private IConexion conexion ;
    
    public UsuariosDAO(IConexion conexion) {
        this.conexion = conexion ;
    }
    
    @Override
    public Usuario crearUsuario(Usuario usuario) throws PersistenciaException {
        EntityManager em = conexion.crearConexion() ;
        
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
        
        return usuario ;
    }

    @Override
    public boolean login(String email, String password) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario obtenerUsuarioPorEmail(String email) throws PersistenciaException {
        EntityManager em = conexion.crearConexion() ;
        TypedQuery<Usuario> query = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.email = " + email + ";", Usuario.class);
        Usuario usuario = query.getResultList().getFirst();
        
        return usuario ;
    }
    
}
