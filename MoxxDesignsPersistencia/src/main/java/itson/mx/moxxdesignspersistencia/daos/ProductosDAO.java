package itson.mx.moxxdesignspersistencia.daos;

import itson.mx.moxxdesignsdominio.conexion.IConexion;
import itson.mx.moxxdesignsdominio.entidades.Producto;
import itson.mx.moxxdesignsexcepciones.PersistenciaException;
import itson.mx.moxxdesignspersistencia.interfaces.IProductosDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author olive
 */
public class ProductosDAO implements IProductosDAO {

    private final IConexion conexion;

    public ProductosDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            return em.createQuery("SELECT p FROM Producto p", Producto.class)
                    .getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todos los productos", e);
        } finally {
            em.close();
        }
    }

}
