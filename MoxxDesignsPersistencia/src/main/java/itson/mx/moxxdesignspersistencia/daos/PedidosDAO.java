package itson.mx.moxxdesignspersistencia.daos;

import itson.mx.moxxdesignsdominio.conexion.IConexion;
import itson.mx.moxxdesignsdominio.entidades.Pedido;
import itson.mx.moxxdesignsdominio.entidades.Usuario;
import itson.mx.moxxdesignsexcepciones.PersistenciaException;
import itson.mx.moxxdesignspersistencia.interfaces.IPedidosDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author olive
 */
public class PedidosDAO implements IPedidosDAO {

    private final IConexion conexion;

    /**
     *
     * @param conexion
     */
    public PedidosDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     *
     * @param pedido
     * @throws PersistenciaException
     */
    @Override
    public void crearPedido(Pedido pedido) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al crear el pedido", e);
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param usuario
     * @return
     * @throws PersistenciaException
     */
    @Override
    public List<Pedido> obtenerPedidosDeUsuario(Usuario usuario) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            TypedQuery<Pedido> query = em.createQuery(
                    "SELECT p FROM Pedido p WHERE p.usuario = :usuario", Pedido.class);
            query.setParameter("usuario", usuario);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener los pedidos del usuario: " + usuario.getEmail(), e);
        } finally {
            em.close();
        }
    }

}
