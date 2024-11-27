package itson.mx.moxxdesignspersistencia.daos;

import itson.mx.moxxdesignsdominio.conexion.IConexion;
import itson.mx.moxxdesignsdominio.entidades.Usuario;
import itson.mx.moxxdesignsexcepciones.PersistenciaException;
import itson.mx.moxxdesignspersistencia.interfaces.IUsuariosDAO;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author olive
 */
public class UsuariosDAO implements IUsuariosDAO {

    private final IConexion conexion;

    public UsuariosDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();

        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            return usuario;
        } catch (Exception e) {
            throw new PersistenciaException("Error al crear usuario: " + usuario, e);

        } finally {
            em.close();
        }
    }

    @Override
    public boolean login(String email, String password) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            TypedQuery<Usuario> query = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.email = :email AND u.password = :password",
                    Usuario.class);
            query.setParameter("email", email);
            query.setParameter("password", password);

            return !query.getResultList().isEmpty();
        } finally {
            em.close();
        }
    }

    @Override
    public Usuario obtenerUsuarioPorEmail(String email) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            TypedQuery<Usuario> query = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class);
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener el usuario por email UwUr: " + email, e);
        } finally {
            em.close();
        }
    }

}
