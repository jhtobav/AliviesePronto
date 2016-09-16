/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    @NamedQuery(name = "Venta.findByNumDocUsuario", query = "SELECT v FROM Venta v WHERE v.numDocUsuario = :numDocUsuario")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    private long fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorTotal")
    private long valorTotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "numDocUsuario")
    private String numDocUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private long idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventaProductoVendidoProductoVendidoId")
    private Collection<ProductoVendido> productoVendidoCollection;

    public Venta() {
    }

    public Venta(Long id) {
        this.id = id;
    }

    public Venta(Long id, long fecha, long valorTotal, String numDocUsuario) {
        this.id = id;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
        this.numDocUsuario = numDocUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }

    public long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(long valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getNumDocUsuario() {
        return numDocUsuario;
    }

    public void setNumDocUsuario(String numDocUsuario) {
        this.numDocUsuario = numDocUsuario;
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

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
