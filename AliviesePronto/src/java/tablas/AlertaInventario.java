/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhtob
 */
@Entity
@Table(name = "AlertaInventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlertaInventario.findAll", query = "SELECT a FROM AlertaInventario a"),
    @NamedQuery(name = "AlertaInventario.findById", query = "SELECT a FROM AlertaInventario a WHERE a.id = :id"),
    @NamedQuery(name = "AlertaInventario.findByFechaApertura", query = "SELECT a FROM AlertaInventario a WHERE a.fechaApertura = :fechaApertura"),
    @NamedQuery(name = "AlertaInventario.findByFechaCierre", query = "SELECT a FROM AlertaInventario a WHERE a.fechaCierre = :fechaCierre"),
    @NamedQuery(name = "AlertaInventario.findByDescripcion", query = "SELECT a FROM AlertaInventario a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "AlertaInventario.findByIdProducto", query = "SELECT a FROM AlertaInventario a WHERE a.idProducto = :idProducto"),
    @NamedQuery(name = "AlertaInventario.findByEstado", query = "SELECT a FROM AlertaInventario a WHERE a.estado = :estado")})
public class AlertaInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaApertura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaApertura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProducto")
    private long idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;

    public AlertaInventario() {
    }

    public AlertaInventario(Long id) {
        this.id = id;
    }

    public AlertaInventario(Long id, Date fechaApertura, Date fechaCierre, String descripcion, long idProducto, boolean estado) {
        this.id = id;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.descripcion = descripcion;
        this.idProducto = idProducto;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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
        if (!(object instanceof AlertaInventario)) {
            return false;
        }
        AlertaInventario other = (AlertaInventario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.AlertaInventario[ id=" + id + " ]";
    }
    
}
