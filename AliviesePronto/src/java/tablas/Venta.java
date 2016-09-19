/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jhtob
 */
@Entity
@Cacheable(false)
@Table(name = "Venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findById", query = "SELECT v FROM Venta v WHERE v.id = :id"),
    @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Venta.findByValorTotal", query = "SELECT v FROM Venta v WHERE v.valorTotal = :valorTotal"),
    @NamedQuery(name = "Venta.findByIdUsuario", query = "SELECT v FROM Venta v WHERE v.idUsuario = :idUsuario"),
    @NamedQuery(name = "Venta.findByTipoVenta", query = "SELECT v FROM Venta v WHERE v.tipoVenta = :tipoVenta"),
    @NamedQuery(name = "Venta.findByValorDescuento", query = "SELECT v FROM Venta v WHERE v.valorDescuento = :valorDescuento"),
    @NamedQuery(name = "Venta.findByValorSinDescuento", query = "SELECT v FROM Venta v WHERE v.valorSinDescuento = :valorSinDescuento")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorTotal")
    private long valorTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private long idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipoVenta")
    private String tipoVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorDescuento")
    private long valorDescuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorSinDescuento")
    private long valorSinDescuento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventaProductoVendidoProductoVendidoId")
    private Collection<ProductoVendido> productoVendidoCollection;

    public Venta() {
    }

    public Venta(Long id) {
        this.id = id;
    }

    public Venta(Long id, Date fecha, long valorTotal, long idUsuario, String tipoVenta, long valorDescuento, long valorSinDescuento) {
        this.id = id;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
        this.idUsuario = idUsuario;
        this.tipoVenta = tipoVenta;
        this.valorDescuento = valorDescuento;
        this.valorSinDescuento = valorSinDescuento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(long valorTotal) {
        this.valorTotal = valorTotal;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public long getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(long valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public long getValorSinDescuento() {
        return valorSinDescuento;
    }

    public void setValorSinDescuento(long valorSinDescuento) {
        this.valorSinDescuento = valorSinDescuento;
    }

    @XmlTransient
    public Collection<ProductoVendido> getProductoVendidoCollection() {
        return productoVendidoCollection;
    }

    public void setProductoVendidoCollection(Collection<ProductoVendido> productoVendidoCollection) {
        this.productoVendidoCollection = productoVendidoCollection;
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
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.Venta[ id=" + id + " ]";
    }
    
}
