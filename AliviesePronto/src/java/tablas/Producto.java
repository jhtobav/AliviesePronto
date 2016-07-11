/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhtob
 */
@Entity
@Table(name = "Producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :id"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByMarca", query = "SELECT p FROM Producto p WHERE p.marca = :marca"),
    @NamedQuery(name = "Producto.findByImagen", query = "SELECT p FROM Producto p WHERE p.imagen = :imagen"),
    @NamedQuery(name = "Producto.findByPresentacion", query = "SELECT p FROM Producto p WHERE p.presentacion = :presentacion"),
    @NamedQuery(name = "Producto.findByPrecioUnitarioCompra", query = "SELECT p FROM Producto p WHERE p.precioUnitarioCompra = :precioUnitarioCompra"),
    @NamedQuery(name = "Producto.findByPrecioUnitarioVenta", query = "SELECT p FROM Producto p WHERE p.precioUnitarioVenta = :precioUnitarioVenta"),
    @NamedQuery(name = "Producto.findByCantidadInventario", query = "SELECT p FROM Producto p WHERE p.cantidadInventario = :cantidadInventario"),
    @NamedQuery(name = "Producto.findByCantidadMinimaInventario", query = "SELECT p FROM Producto p WHERE p.cantidadMinimaInventario = :cantidadMinimaInventario"),
    @NamedQuery(name = "Producto.findByTipo", query = "SELECT p FROM Producto p WHERE p.tipo = :tipo")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "imagen")
    private String imagen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "presentacion")
    private String presentacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioUnitarioCompra")
    private long precioUnitarioCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioUnitarioVenta")
    private long precioUnitarioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadInventario")
    private int cantidadInventario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadMinimaInventario")
    private int cantidadMinimaInventario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "FormulaProducto_Producto_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Formula formulaProductoProductoId;

    public Producto() {
    }

    public Producto(Long id) {
        this.id = id;
    }

    public Producto(Long id, String nombre, String descripcion, String marca, String imagen, String presentacion, long precioUnitarioCompra, long precioUnitarioVenta, int cantidadInventario, int cantidadMinimaInventario, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.imagen = imagen;
        this.presentacion = presentacion;
        this.precioUnitarioCompra = precioUnitarioCompra;
        this.precioUnitarioVenta = precioUnitarioVenta;
        this.cantidadInventario = cantidadInventario;
        this.cantidadMinimaInventario = cantidadMinimaInventario;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public long getPrecioUnitarioCompra() {
        return precioUnitarioCompra;
    }

    public void setPrecioUnitarioCompra(long precioUnitarioCompra) {
        this.precioUnitarioCompra = precioUnitarioCompra;
    }

    public long getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }

    public void setPrecioUnitarioVenta(long precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }

    public int getCantidadInventario() {
        return cantidadInventario;
    }

    public void setCantidadInventario(int cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }

    public int getCantidadMinimaInventario() {
        return cantidadMinimaInventario;
    }

    public void setCantidadMinimaInventario(int cantidadMinimaInventario) {
        this.cantidadMinimaInventario = cantidadMinimaInventario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Formula getFormulaProductoProductoId() {
        return formulaProductoProductoId;
    }

    public void setFormulaProductoProductoId(Formula formulaProductoProductoId) {
        this.formulaProductoProductoId = formulaProductoProductoId;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.Producto[ id=" + id + " ]";
    }
    
}
