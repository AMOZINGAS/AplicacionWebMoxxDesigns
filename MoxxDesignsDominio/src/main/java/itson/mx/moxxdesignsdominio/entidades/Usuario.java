/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignsdominio.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author olive
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Pedido> pedidos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carrito_id", referencedColumnName = "id")
    private CarritoCompras carritoCompras;

    public Usuario() {
    }

    public Usuario(Long id, String email, String password, List<Pedido> pedidos, CarritoCompras carritoCompras) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.pedidos = pedidos;
        this.carritoCompras = carritoCompras;
    }

    public Usuario(Long id, String email, String password, List<Pedido> pedidos) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.pedidos = pedidos;
        this.carritoCompras = new CarritoCompras();
    }

    public Usuario(String email, String password, List<Pedido> pedidos, CarritoCompras carritoCompras) {
        this.email = email;
        this.password = password;
        this.pedidos = pedidos;
        this.carritoCompras = carritoCompras;
    }

    public Usuario(String email, String password, List<Pedido> pedidos) {
        this.email = email;
        this.password = password;
        this.pedidos = pedidos;
        this.carritoCompras = new CarritoCompras();
    }

    public Usuario(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.carritoCompras = new CarritoCompras();
    }

    public Usuario(String email, String password, CarritoCompras carritoCompras) {
        this.email = email;
        this.password = password;
        this.carritoCompras = carritoCompras;
    }

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
        this.carritoCompras = new CarritoCompras();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "itson.mx.moxxdesignsdominio.Usuario[ id=" + id + " ]";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public CarritoCompras getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(CarritoCompras carritoCompras) {
        this.carritoCompras = carritoCompras;
    }

}
