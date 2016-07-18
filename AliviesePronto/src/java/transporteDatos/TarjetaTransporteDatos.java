/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporteDatos;

/**
 *
 * @author jhtob
 */
public class TarjetaTransporteDatos {
    
    private Long numTarjeta;
    private String nombrePersona;
    private String fechaVencimiento;
    private short csv;

    public TarjetaTransporteDatos() {
    }

    public Long getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(Long numTarjeta) {
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

    public short getCsv() {
        return csv;
    }

    public void setCsv(short csv) {
        this.csv = csv;
    }
    
}
