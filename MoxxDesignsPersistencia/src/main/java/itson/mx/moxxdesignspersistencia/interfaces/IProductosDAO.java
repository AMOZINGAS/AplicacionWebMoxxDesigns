package itson.mx.moxxdesignspersistencia.interfaces;

import itson.mx.moxxdesignsdominio.entidades.Producto;
import itson.mx.moxxdesignsexcepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author olive
 */
public interface IProductosDAO {

    public List<Producto> obtenerTodosLosProductos() throws PersistenciaException;

}
