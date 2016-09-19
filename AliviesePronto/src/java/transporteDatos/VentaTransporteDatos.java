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
public class VentaTransporteDatos {
    
    private long idVenta;
    private Date fechaVenta;
    private long idUsuario;
    private String tipoVenta;
    private long valorTotal;
    private long valorDescuento;
    private long valorSinDescuento;
    private List<ProductoTransporteDatos> productos = null;

    public long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(long idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
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

    public long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(long valorTotal) {
        this.valorTotal = valorTotal;
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

    public List<ProductoTransporteDatos> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoTransporteDatos> productos) {
        this.productos = productos;
    }
    
}
