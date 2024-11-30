package itson.mx.moxxdesignsnegocios.bo;

import itson.mx.moxxdesignsdominio.conexion.Conexion;
import itson.mx.moxxdesignsdominio.entidades.Producto;
import itson.mx.moxxdesignsdto.ProductoDTO;
import itson.mx.moxxdesignsexcepciones.NegociosException;
import itson.mx.moxxdesignsexcepciones.PersistenciaException;
import itson.mx.moxxdesignsnegocios.convertor.Convertor;
import itson.mx.moxxdesignsnegocios.interfaces.IProductosBO;
import itson.mx.moxxdesignspersistencia.daos.ProductosDAO;
import java.util.List;

/**
 *
 * @author olive
 */
public class ProductosBO implements IProductosBO {

    private final ProductosDAO productosDAO;

    public ProductosBO() {
        this.productosDAO = new ProductosDAO(new Conexion());
    }

    @Override
    public List<ProductoDTO> obtenerTodosLosProductos() throws NegociosException {
        try {
            return Convertor.listaProductosEntityADto(productosDAO.obtenerTodosLosProductos());
        } catch (PersistenciaException e) {
            throw new NegociosException(e.getMessage());
        }
    }

    @Override
    public ProductoDTO obtenerProductoPorId(Long id) throws NegociosException {
        try {
            return Convertor.productoEntityADto(productosDAO.obtenerProductoPorId(id));
        } catch (PersistenciaException e) {
            throw new NegociosException(e.getMessage());
        }
    }

}
