package itson.mx.moxxdesignsgestionarcotizaciones;

import itson.mx.moxxdesignsdto.CarritoComprasDTO;
import itson.mx.moxxdesignsdto.PedidoDTO;
import itson.mx.moxxdesignsdto.ProductoDTO;
import itson.mx.moxxdesignsdto.UsuarioDTO;
import itson.mx.moxxdesignsexcepciones.SubsistemaException;
import itson.mx.moxxdesignsgestionarcotizaciones.fachada.FachadaGestionarCotizaciones;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author olive
 */
public class MoxxDesignsGestionarCotizaciones {

    public static void main(String[] args) throws SubsistemaException {
//        Float precio = 2.0f;
//
//        FachadaGestionarCotizaciones fachada = new FachadaGestionarCotizaciones();
//
//        UsuarioDTO usuario = new UsuarioDTO("Olivio@gay.dick", "meLaComo", "MeLano", "Rosa");
//        ProductoDTO producto = new ProductoDTO(
//                "Modelo XXX",
//                "Marca Registrada",
//                "2030",
//                "Color kk",
//                precio,
//                "Imagen");
//
//        try {
//            // Obtener carro
//            CarritoComprasDTO carrito = fachada.obtenerCarritoDeComprasDeUsuario(usuario);
//            System.out.println("Carrito de Compras: " + carrito);
//
//            // Agregar producto
//            fachada.agregarProductoACarritoDeCompras(usuario, producto);
//            System.out.println("Producto agregado al carrito.");
//
////            // Eliminar producto
////            fachada.eliminarProductoDeCarritoDeCompras(usuario, producto);
////            System.out.println("Producto eliminado del carrito.");
////
////            // Eliminar todo
////            fachada.eliminarTodosLosProductosDeCarritoDeCompras(usuario);
////            System.out.println("Todos los productos eliminados del carrito.");
//            // Crear pedido
//            List<ProductoDTO> productos = new ArrayList<>();
//            productos.add(producto);
//
//            PedidoDTO pedido = new PedidoDTO(
//                    Calendar.getInstance(),
//                    productos,
//                    usuario
//            );
//            fachada.crearPedido(pedido);
//            System.out.println("Pedido creado: " + pedido);
//
//        
//
//         
//
//            // Obtener un producto por ID
//            ProductoDTO productoObtenido = fachada.obtenerProductoPorId(1L);
//            System.out.println("Producto obtenido por ID: " + productoObtenido);
//
//        } catch (SubsistemaException e) {
//            System.out.println("Error en el sistema: " + e.getMessage());
//        }

        System.out.println("HACER PEDIDO");
        Float precio = 2.0f;
        Long id1 = 1L;
        Long id2 = 2L;
        Long id3 = 3L;
        FachadaGestionarCotizaciones fachada = new FachadaGestionarCotizaciones();

        UsuarioDTO usuario = new UsuarioDTO("Olivio@gay.dick", "meLaComo", "MeLano", "Rosa");

//        try {
//            // Obtener carro
//            CarritoComprasDTO carrito = fachada.obtenerCarritoDeComprasDeUsuario(usuario);
//
//            // Obtener productos por ID
////            ProductoDTO producto1 = fachada.obtenerProductoPorId(id1);
////            ProductoDTO producto2 = fachada.obtenerProductoPorId(id2);
////            ProductoDTO producto3 = fachada.obtenerProductoPorId(id3);
//            ProductoDTO producto1 = new ProductoDTO(
//                    id1,
//                    "Modelo XXX",
//                    "Marca Registrada",
//                    "2030",
//                    "Color kk",
//                    precio,
//                    "Imagen");
//
//            System.out.println("Carrito de Compras: " + carrito);
//
//            System.out.println("Productos agregados al carrito.");
//
//            // Crear pedido
//            List<ProductoDTO> productos = new ArrayList<>();
//            productos.add(producto1);
//
//            PedidoDTO pedido = new PedidoDTO(
//                    Calendar.getInstance(),
//                    productos,
//                    usuario
//            );
//            fachada.crearPedido(pedido);
//            System.out.println("Pedido creado: " + pedido);
//
//        } catch (SubsistemaException e) {
//            System.out.println("Error en el sistema: " + e.getMessage());
//        }
//        System.out.println("OBTENER PEDIDOS");
//
//        // Obtener los pedidos de un usuario
//        List<PedidoDTO> pedidos = fachada.obtenerPedidosDeUsuario(usuario);
//        System.out.println("Pedidos de usuario: " + pedidos);
//        System.out.println("OBTENER TODOS LOS PRODUCTOS");
//
//        List<ProductoDTO> productosDisponibles = fachada.obtenerTodosLosProductos();
//        System.out.println("Productos disponibles: " + productosDisponibles);
    }

}
