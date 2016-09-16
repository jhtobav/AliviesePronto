/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Cacheable(false)
@Table(name = "ProductoVendido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoVendido.findAll", query = "SELECT p FROM ProductoVendido p"),
    @NamedQuery(name = "ProductoVendido.findById", query = "SELECT p FROM ProductoVendido p WHERE p.id = :id"),
    @NamedQuery(name = "ProductoVendido.findByNombre", query = "SELECT p FROM ProductoVendido p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ProductoVendido.findByDescripcion", query = "SELECT p FROM ProductoVendido p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "ProductoVendido.findByMarca", query = "SELECT p FROM ProductoVendido p WHERE p.marca = :marca"),
    @NamedQuery(name = "ProductoVendido.findByImagen", query = "SELECT p FROM ProductoVendido p WHERE p.imagen = :imagen"),
    @NamedQuery(name = "ProductoVendido.findByPresentacion", query = "SELECT p FROM ProductoVendido p WHERE p.presentacion = :presentacion"),
    @NamedQuery(name = "ProductoVendido.findByPrecioUnitarioCompra", query = "SELECT p FROM ProductoVendido p WHERE p.precioUnitarioCompra = :precioUnitarioCompra"),
    @NamedQuery(name = "ProductoVendido.findByPrecioUnitarioVenta", query = "SELECT p FROM ProductoVendido p WHERE p.precioUnitarioVenta = :precioUnitarioVenta"),
    @NamedQuery(name = "ProductoVendido.findByCantidadVendida", query = "SELECT p FROM ProductoVendido p WHERE p.cantidadVendida = :cantidadVendida"),
    @NamedQuery(name = "ProductoVendido.findByTipo", query = "SELECT p FROM ProductoVendido p WHERE p.tipo = :tipo")})
public class ProductoVendido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "cantidadVendida")
    private int cantidadVendida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "FormulaProductoVendido_ProductoVendido_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Formula formulaProductoVendidoProductoVendidoId;
    @JoinColumn(name = "VentaProductoVendido_ProductoVendido_Id", referencedColumnName = "Id")
    @ManyToOne
    private Venta ventaProductoVendidoProductoVendidoId;

    public ProductoVendido() {
    }

    public ProductoVendido(Long id) {
        this.id = id;
    }

    public ProductoVendido(Long id, String nombre, String descripcion, String marca, String imagen, String presentacion, long precioUnitarioCompra, long precioUnitarioVenta, int cantidadVendida, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.imagen = imagen;
        this.presentacion = presentacion;
        this.precioUnitarioCompra = precioUnitarioCompra;
        this.precioUnitarioVenta = precioUnitarioVenta;
        this.cantidadVendida = cantidadVendida;
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

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Formula getFormulaProductoVendidoProductoVendidoId() {
        return formulaProductoVendidoProductoVendidoId;
    }

    public void setFormulaProductoVendidoProductoVendidoId(Formula formulaProductoVendidoProductoVendidoId) {
        this.formulaProductoVendidoProductoVendidoId = formulaProductoVendidoProductoVendidoId;
    }

    public Venta getVentaProductoVendidoProductoVendidoId() {
        return ventaProductoVendidoProductoVendidoId;
    }

    public void setVentaProductoVendidoProductoVendidoId(Venta ventaProductoVendidoProductoVendidoId) {
        this.ventaProductoVendidoProductoVendidoId = ventaProductoVendidoProductoVendidoId;
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
        if (!(object instanceof ProductoVendido)) {
            return false;
        }
        ProductoVendido other = (ProductoVendido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.ProductoVendido[ id=" + id + " ]";
    }
    
}
