/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.mx.moxxdesignspersistencia.interfaces;

import itson.mx.moxxdesignsdominio.entidades.Pedido;
import itson.mx.moxxdesignsdominio.entidades.Usuario;
import itson.mx.moxxdesignsexcepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author olive
 */
public interface IPedidosDAO {
    
    public void crearPedido(Pedido pedido) throws PersistenciaException ;
    
    public List<Pedido> obtenerPedidosDeUsuario(Usuario usuario) throws PersistenciaException ;
    
}
