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
@Table(name = "TarjetaCredito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarjetaCredito.findAll", query = "SELECT t FROM TarjetaCredito t"),
    @NamedQuery(name = "TarjetaCredito.findById", query = "SELECT t FROM TarjetaCredito t WHERE t.id = :id"),
    @NamedQuery(name = "TarjetaCredito.findByNumTarjeta", query = "SELECT t FROM TarjetaCredito t WHERE t.numTarjeta = :numTarjeta"),
    @NamedQuery(name = "TarjetaCredito.findByNombrePersona", query = "SELECT t FROM TarjetaCredito t WHERE t.nombrePersona = :nombrePersona"),
    @NamedQuery(name = "TarjetaCredito.findByFechaVencimiento", query = "SELECT t FROM TarjetaCredito t WHERE t.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "TarjetaCredito.findByCsv", query = "SELECT t FROM TarjetaCredito t WHERE t.csv = :csv")})
public class TarjetaCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)     
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numTarjeta")
    private long numTarjeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombrePersona")
    private String nombrePersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "fechaVencimiento")
    private String fechaVencimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CSV")
    private int csv;

    public TarjetaCredito() {
    }

    public TarjetaCredito(Long id) {
        this.id = id;
    }

    public TarjetaCredito(Long id, long numTarjeta, String nombrePersona, String fechaVencimiento, int csv) {
        this.id = id;
        this.numTarjeta = numTarjeta;
        this.nombrePersona = nombrePersona;
        this.fechaVencimiento = fechaVencimiento;
        this.csv = csv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(long numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCsv() {
        return csv;
    }

    public void setCsv(int csv) {
        this.csv = csv;
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
        if (!(object instanceof TarjetaCredito)) {
            return false;
        }
        TarjetaCredito other = (TarjetaCredito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.TarjetaCredito[ id=" + id + " ]";
    }
    
}
