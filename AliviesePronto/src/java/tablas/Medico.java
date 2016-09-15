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
@Table(name = "Medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m"),
    @NamedQuery(name = "Medico.findById", query = "SELECT m FROM Medico m WHERE m.id = :id"),
    @NamedQuery(name = "Medico.findByNumDocumento", query = "SELECT m FROM Medico m WHERE m.numDocumento = :numDocumento"),
    @NamedQuery(name = "Medico.findByNombreUsuario", query = "SELECT m FROM Medico m WHERE m.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Medico.findByPrimerNombre", query = "SELECT m FROM Medico m WHERE m.primerNombre = :primerNombre"),
    @NamedQuery(name = "Medico.findBySegundoNombre", query = "SELECT m FROM Medico m WHERE m.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "Medico.findByPrimerApellido", query = "SELECT m FROM Medico m WHERE m.primerApellido = :primerApellido"),
    @NamedQuery(name = "Medico.findBySegundoApellido", query = "SELECT m FROM Medico m WHERE m.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Medico.findByFechaNacimiento", query = "SELECT m FROM Medico m WHERE m.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Medico.findByTelefono", query = "SELECT m FROM Medico m WHERE m.telefono = :telefono"),
    @NamedQuery(name = "Medico.findByDireccion", query = "SELECT m FROM Medico m WHERE m.direccion = :direccion"),
    @NamedQuery(name = "Medico.findByCorreo", query = "SELECT m FROM Medico m WHERE m.correo = :correo"),
    @NamedQuery(name = "Medico.findByContrasena", query = "SELECT m FROM Medico m WHERE m.contrasena = :contrasena"),
    @NamedQuery(name = "Medico.findByGenero", query = "SELECT m FROM Medico m WHERE m.genero = :genero"),
    @NamedQuery(name = "Medico.findByEstadoCuenta", query = "SELECT m FROM Medico m WHERE m.estadoCuenta = :estadoCuenta"),
    @NamedQuery(name = "Medico.findByNumTarjetaProfesional", query = "SELECT m FROM Medico m WHERE m.numTarjetaProfesional = :numTarjetaProfesional")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)     
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numDocumento")
    private long numDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "primerNombre")
    private String primerNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "segundoNombre")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "primerApellido")
    private String primerApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "segundoApellido")
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private long telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoCuenta")
    private boolean estadoCuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numTarjetaProfesional")
    private long numTarjetaProfesional;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicoFormulaFormulaId")
    private Collection<Formula> formulaCollection;

    public Medico() {
    }

    public Medico(Long id) {
        this.id = id;
    }

    public Medico(Long id, long numDocumento, String nombreUsuario, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, Date fechaNacimiento, long telefono, String direccion, String correo, String contrasena, String genero, boolean estadoCuenta, long numTarjetaProfesional) {
        this.id = id;
        this.numDocumento = numDocumento;
        this.nombreUsuario = nombreUsuario;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.contrasena = contrasena;
        this.genero = genero;
        this.estadoCuenta = estadoCuenta;
        this.numTarjetaProfesional = numTarjetaProfesional;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(long numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(boolean estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public long getNumTarjetaProfesional() {
        return numTarjetaProfesional;
    }

    public void setNumTarjetaProfesional(long numTarjetaProfesional) {
        this.numTarjetaProfesional = numTarjetaProfesional;
    }

    @XmlTransient
    public Collection<Formula> getFormulaCollection() {
        return formulaCollection;
    }

    public void setFormulaCollection(Collection<Formula> formulaCollection) {
        this.formulaCollection = formulaCollection;
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
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tablas.Medico[ id=" + id + " ]";
    }
    
}
