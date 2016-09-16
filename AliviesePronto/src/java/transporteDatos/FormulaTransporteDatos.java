/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporteDatos;

import java.util.Date;
import java.util.List;

/**
 *
 * @author jhtob
 */
public class FormulaTransporteDatos {
    
    private long idFormula;
    private long idUsuario;
    private long numDocumentoUsuario;
    List<ProductoTransporteDatos> productos = null;
    private long idMedico;
    private long numDocumentoMedico;
    private Date fechaEmision;
    private String estadoFormula;
    private String descripcion;

    public long getIdFormula() {
        return idFormula;
    }

    public void setIdFormula(long idFormula) {
        this.idFormula = idFormula;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getNumDocumentoUsuario() {
        return numDocumentoUsuario;
    }

    public void setNumDocumentoUsuario(long numDocumentoUsuario) {
        this.numDocumentoUsuario = numDocumentoUsuario;
    }

    public List<ProductoTransporteDatos> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoTransporteDatos> productos) {
        this.productos = productos;
    }

    public long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(long idMedico) {
        this.idMedico = idMedico;
    }

    public long getNumDocumentoMedico() {
        return numDocumentoMedico;
    }

    public void setNumDocumentoMedico(long numDocumentoMedico) {
        this.numDocumentoMedico = numDocumentoMedico;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getEstadoFormula() {
        return estadoFormula;
    }

    public void setEstadoFormula(String estadoFormula) {
        this.estadoFormula = estadoFormula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
