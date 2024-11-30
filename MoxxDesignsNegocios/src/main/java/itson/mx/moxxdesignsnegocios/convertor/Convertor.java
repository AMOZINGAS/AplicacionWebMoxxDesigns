/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignsnegocios.convertor;

import itson.mx.moxxdesignsdominio.entidades.Pedido;
import itson.mx.moxxdesignsdominio.entidades.Producto;
import itson.mx.moxxdesignsdominio.entidades.Usuario;
import itson.mx.moxxdesignsdto.PedidoDTO;
import itson.mx.moxxdesignsdto.ProductoDTO;
import itson.mx.moxxdesignsdto.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author olive
 */
public class Convertor {
    
    public Convertor() {
        
    }
    
    public static Producto productoDtoAEntity(ProductoDTO dto) {
        return new Producto(
                dto.getCodigo(),
                dto.getModelo(),
                dto.getMarca(), 
                dto.getAnio(), 
                dto.getColor(), 
                dto.getPrecio(),
                dto.getImagen()) ;
    }
    
    public static ProductoDTO productoEntityADto(Producto entity) {
        return new ProductoDTO(
                entity.getId(),
                entity.getModelo(),
                entity.getMarca(),
                entity.getAnio(),
                entity.getColor(),
                entity.getPrecio(),
                entity.getImagen()
        ) ;
    }
    
    public static Pedido pedidoDtoAEntity(PedidoDTO dto) {
        Float precioTotal = dto.getProductosDTO().stream()
            .map(producto -> producto.getPrecio())
            .reduce(0F, Float::sum);
        
        return new Pedido(
                dto.getFecha_hora(),
                precioTotal,
                dto.getProductosDTO().size(),
                listaProductosDtoAEntity(dto.getProductosDTO())
        );
    }
    
    public static PedidoDTO pedidoEntityADto(Pedido entity) {
        return new PedidoDTO(
                entity.getFecha_hora(),
                listaProductosEntityADto(entity.getProductos()),
                usuarioEntityADto(entity.getUsuario())
        ) ;
    }
    
    public static Usuario usuarioDtoAEntity(UsuarioDTO dto) {
        return new Usuario(
                dto.getEmail(),
                dto.getPassword(),
                dto.getApellido(),
                dto.getNombre()
        ) ;
    }
    
    public static UsuarioDTO usuarioEntityADto(Usuario entity) {
        return new UsuarioDTO(
                entity.getEmail(),
                entity.getPassword(),
                entity.getApellido(),
                entity.getNombre()
        ) ;
    }
    
    public static List<Producto> listaProductosDtoAEntity(List<ProductoDTO> dtos) {
        List<Producto> entitys = new ArrayList() ;
        
        dtos.forEach(dto -> {
            entitys.add(productoDtoAEntity(dto)) ;
        });
        
        return entitys ;
    }
    
    public static List<ProductoDTO> listaProductosEntityADto(List<Producto> entitys) {
        List<ProductoDTO> dtos = new ArrayList() ;
        
        entitys.forEach(entity -> {
            dtos.add(productoEntityADto(entity)) ;
        });
        
        return dtos ;
    }
    
    public static List<Pedido> listaPedidosDtoAEntity(List<PedidoDTO> dtos) {
        List<Pedido> entitys = new ArrayList() ;
        
        dtos.forEach(dto ->{
            entitys.add(pedidoDtoAEntity(dto)) ;
        });
        
        return entitys ;
    }
    
    public static List<PedidoDTO> listaPedidosEntityADto(List<Pedido> entitys) {
        List<PedidoDTO> dtos = new ArrayList() ;
        
        entitys.forEach(entity -> {
            dtos.add(pedidoEntityADto(entity)) ;
        });
        
        return dtos ;
    }
}
