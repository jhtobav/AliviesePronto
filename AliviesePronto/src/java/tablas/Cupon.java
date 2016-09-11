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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhtob
 */
@Entity
@Table(name = "Cupon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cupon.findAll", query = "SELECT c FROM Cupon c"),
    @NamedQuery(name = "Cupon.findById", query = "SELECT c FROM Cupon c WHERE c.id = :id"),
    @NamedQuery(name = "Cupon.findByValor", query = "SELECT c FROM Cupon c WHERE c.valor = :valor"),
    @NamedQuery(name = "Cupon.findByFechaVencimiento", query = "SELECT c FROM Cupon c WHERE c.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "Cupon.findByEstado", query = "SELECT c FROM Cupon c WHERE c.estado = :estado")})
public class Cupon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)     
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private long valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaVencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;

    public Cupon() {
    }

    public Cupon(Long id) {
        this.id = id;
    }

    public Cupon(Long id, long valor, Date fechaVencimiento, boolean estado) {
        this.id = id;
        this.valor = valor;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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
        if (!(object instanceof Cupon)) {
            return false;
        }
        Cupon other = (Cupon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.Cupon[ id=" + id + " ]";
    }
    
}
