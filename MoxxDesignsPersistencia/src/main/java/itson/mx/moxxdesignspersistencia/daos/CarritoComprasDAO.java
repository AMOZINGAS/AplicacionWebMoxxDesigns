/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignspersistencia.daos;

import itson.mx.moxxdesignsdominio.conexion.IConexion;
import itson.mx.moxxdesignsdominio.entidades.CarritoCompras;
import itson.mx.moxxdesignsdominio.entidades.Producto;
import itson.mx.moxxdesignsdominio.entidades.Usuario;
import itson.mx.moxxdesignsexcepciones.PersistenciaException;
import itson.mx.moxxdesignspersistencia.interfaces.ICarritoComprasDAO;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author olive
 */
public class CarritoComprasDAO implements ICarritoComprasDAO {

    private final IConexion conexion;

    public CarritoComprasDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     *
     * @param usuario
     * @return
     * @throws PersistenciaException
     */
    @Override
    public CarritoCompras obtenerCarritoDeComprasDeUsuario(Usuario usuario) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            TypedQuery<CarritoCompras> query = em.createQuery(
                    "SELECT c FROM CarritoCompras c WHERE c.usuario = :usuario", CarritoCompras.class);
            query.setParameter("usuario", usuario);
            return query.getResultList().stream().findFirst().orElse(null);
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener el carrito de compras del usuario: " + usuario.getEmail(), e);
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param carritoCompras
     * @throws PersistenciaException
     */
    @Override
    public void agregarProductoACarritoDeCompras(CarritoCompras carritoCompras) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.merge(carritoCompras); // Usamos merge para actualizar la entidad
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al agregar producto al carrito de compras", e);
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param carritoCompras
     * @param producto
     * @throws PersistenciaException
     */
    @Override
    public void eliminarProductoDeCarritoDeCompras(CarritoCompras carritoCompras, Producto producto) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            carritoCompras.getProductos().remove(producto);
            em.merge(carritoCompras); // Actualizamos el carrito después de remover el producto
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al eliminar producto del carrito de compras", e);
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param carritoCompras
     * @throws PersistenciaException
     */
    @Override
    public void eliminarTodosLosProductosDeCarritoDeCompras(CarritoCompras carritoCompras) throws PersistenciaException {
        EntityManager em = conexion.crearConexion();
        try {
            em.getTransaction().begin();
            carritoCompras.getProductos().clear(); // Limpiamos la lista de productos
            em.merge(carritoCompras); // Persistimos los cambios
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al eliminar todos los productos del carrito de compras", e);
        } finally {
            em.close();
        }
    }

}
