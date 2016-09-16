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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Formula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formula.findAll", query = "SELECT f FROM Formula f"),
    @NamedQuery(name = "Formula.findById", query = "SELECT f FROM Formula f WHERE f.id = :id"),
    @NamedQuery(name = "Formula.findByFechaEmision", query = "SELECT f FROM Formula f WHERE f.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "Formula.findByEstado", query = "SELECT f FROM Formula f WHERE f.estado = :estado"),
    @NamedQuery(name = "Formula.findByDescripcion", query = "SELECT f FROM Formula f WHERE f.descripcion = :descripcion")})
public class Formula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEmision")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "MedicoFormula_Formula_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Medico medicoFormulaFormulaId;
    @JoinColumn(name = "UsuarioFormula_Formula_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Usuario usuarioFormulaFormulaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formulaProductoVendidoProductoVendidoId")
    private Collection<ProductoVendido> productoVendidoCollection;

    public Formula() {
    }

    public Formula(Long id) {
        this.id = id;
    }

    public Formula(Long id, Date fechaEmision, boolean estado, String descripcion) {
        this.id = id;
        this.fechaEmision = fechaEmision;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Medico getMedicoFormulaFormulaId() {
        return medicoFormulaFormulaId;
    }

    public void setMedicoFormulaFormulaId(Medico medicoFormulaFormulaId) {
        this.medicoFormulaFormulaId = medicoFormulaFormulaId;
    }

    public Usuario getUsuarioFormulaFormulaId() {
        return usuarioFormulaFormulaId;
    }

    public void setUsuarioFormulaFormulaId(Usuario usuarioFormulaFormulaId) {
        this.usuarioFormulaFormulaId = usuarioFormulaFormulaId;
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
        if (!(object instanceof Formula)) {
            return false;
        }
        Formula other = (Formula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.Formula[ id=" + id + " ]";
    }
    
}
