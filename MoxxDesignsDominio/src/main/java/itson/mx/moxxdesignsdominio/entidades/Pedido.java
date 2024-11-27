/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignsdominio.entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author olive
 */
@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_hora", nullable = false)
    private Calendar fecha_hora ;
    
    @Column(name = "precio_total", nullable = false)
    private Float precio_total ;
   
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad ;
    
    @ManyToMany
    @JoinTable(
        name = "productos_pedidos",
        joinColumns = @JoinColumn(name = "pedido_id"),
        inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productos;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Pedido() {}

    public Pedido(Long id, Calendar fecha_hora, Float precio_total, Integer cantidad, List<Producto> productos, Usuario usuario) {
        this.id = id;
        this.fecha_hora = fecha_hora;
        this.precio_total = precio_total;
        this.cantidad = cantidad;
        this.productos = productos;
        this.usuario = usuario;
    }
    
    public Pedido(Long id, Calendar fecha_hora, Float precio_total, Integer cantidad, List<Producto> productos) {
        this.id = id;
        this.fecha_hora = fecha_hora;
        this.precio_total = precio_total;
        this.cantidad = cantidad;
        this.productos = productos;
    }

    public Pedido(Calendar fecha_hora, Float precio_total, Integer cantidad, List<Producto> productos) {
        this.fecha_hora = fecha_hora;
        this.precio_total = precio_total;
        this.cantidad = cantidad;
        this.productos = productos;
    }

    public Pedido(Calendar fecha_hora, Float precio_total, Integer cantidad, List<Producto> productos, Usuario usuario) {
        this.fecha_hora = fecha_hora;
        this.precio_total = precio_total;
        this.cantidad = cantidad;
        this.productos = productos;
        this.usuario = usuario;
    }

    public Pedido(Calendar fecha_hora, Float precio_total, Integer cantidad, Usuario usuario) {
        this.fecha_hora = fecha_hora;
        this.precio_total = precio_total;
        this.cantidad = cantidad;
        this.usuario = usuario;
    }

    public Pedido(Calendar fecha_hora, Float precio_total, Integer cantidad) {
        this.fecha_hora = fecha_hora;
        this.precio_total = precio_total;
        this.cantidad = cantidad;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Calendar fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public Float getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(Float precio_total) {
        this.precio_total = precio_total;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "itson.mx.moxxdesignsdominio.Pedido[ id=" + id + " ]";
    }
    
}
