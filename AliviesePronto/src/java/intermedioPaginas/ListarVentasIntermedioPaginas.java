package intermedioPaginas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.ReportesMetodosLogicaPaginas;
import transporteDatos.ProductoTransporteDatos;
import transporteDatos.VentaTransporteDatos;

@ManagedBean(name="listarVentasIntermedioPaginas")
@SessionScoped
public class ListarVentasIntermedioPaginas {
        
    private List<VentaTransporteDatos> ventas = null;
    private List<ProductoTransporteDatos> productosDeVenta = null;

    private Date fechaVenta;
    private Long valorTotal;
    private Long valorTotalVentas;
    private Long valorTotalDescuentos;

    public ListarVentasIntermedioPaginas() {
    }

    public String init(){
                
        ventas = new ReportesMetodosLogicaPaginas().listarVentas();

        valorTotalVentas = 0l;
        valorTotalDescuentos = 0l;
        
        for(VentaTransporteDatos ventaTransporteDatos : ventas){
         
            valorTotalVentas = valorTotalVentas + ventaTransporteDatos.getValorSinDescuento();
            valorTotalDescuentos = valorTotalDescuentos + ventaTransporteDatos.getValorDescuento();
            
        }
        
        return "listaVentas.xhtml";
        
    }

    public List<VentaTransporteDatos> getVentas() {
        return ventas;
    }

    public void setVentas(List<VentaTransporteDatos> ventas) {
        this.ventas = ventas;
    }

    public List<ProductoTransporteDatos> getProductosDeVenta() {
        return productosDeVenta;
    }

    public void setProductosDeVenta(List<ProductoTransporteDatos> productosDeVenta) {
        this.productosDeVenta = productosDeVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Long getValorTotalVentas() {
        return valorTotalVentas;
    }

    public void setValorTotalVentas(Long valorTotalVentas) {
        this.valorTotalVentas = valorTotalVentas;
    }

    public Long getValorTotalDescuentos() {
        return valorTotalDescuentos;
    }

    public void setValorTotalDescuentos(Long valorTotalDescuentos) {
        this.valorTotalDescuentos = valorTotalDescuentos;
    }
    
    public String verVenta(VentaTransporteDatos venta){
        
        productosDeVenta = new ArrayList<>();
        
        productosDeVenta = venta.getProductos();
        fechaVenta = venta.getFechaVenta();
        valorTotal = venta.getValorTotal();
        
        return "listaVentasDetalle.xhtml";
        
    }
    
}
