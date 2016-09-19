package intermedioPaginas;

import consultasBaseDatos.CuponConsultaBaseDatos;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.ProductoMetodosLogicaPaginas;
import transporteDatos.ProductoTransporteDatos;

@ManagedBean(name="carritoComprasIntermedioPaginas")
@SessionScoped
public class CarritoComprasIntermedioPaginas {
    
    private List<ProductoTransporteDatos> productosCarrito;
    
    private Long numCupon = null;
    private Long valorCupon = null;
    private Long valorTotal = null;
    private Long valorConDescuento = null;

    public void init(){
        
        numCupon = null;
        valorCupon = 0l;
        valorTotal = null;
        valorConDescuento = null;
        
        if(productosCarrito == null){
            productosCarrito = new ArrayList<>();
        }
        
    }
    
    public List<ProductoTransporteDatos> getProductosCarrito() {
        return productosCarrito;
    }

    public void setProductosCarrito(ArrayList<ProductoTransporteDatos> productosCarrito) {
        this.productosCarrito = productosCarrito;
    }

    public Long getNumCupon() {
        return numCupon;
    }

    public void setNumCupon(Long numCupon) {
        this.numCupon = numCupon;
    }

    public Long getValorCupon() {
        return valorCupon;
    }

    public void setValorCupon(Long valorCupon) {
        this.valorCupon = valorCupon;
    }

    public Long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Long getValorConDescuento() {
        return valorConDescuento;
    }

    public void setValorConDescuento(Long valorConDescuento) {
        this.valorConDescuento = valorConDescuento;
    }
    
    public String agregarProductos(ProductoTransporteDatos producto){
    
        System.out.println(producto);
        productosCarrito.add(producto);
        for(int i=0; i<productosCarrito.size(); i++){
            System.out.println(productosCarrito.get(i));
        }
        System.out.println("tamaño de la lista" + productosCarrito.size());
        
        return "inicio.xhtml";
        
    }
    
    public String aplicarDescuento(){
        
        CuponConsultaBaseDatos cuponConsultaBaseDatos = new CuponConsultaBaseDatos();
        
        valorCupon = 0l;
        
        valorCupon = cuponConsultaBaseDatos.encontrarPorIdCupon(numCupon).getValor();
        
        valorConDescuento = valorTotal - valorCupon;
        
        if(valorConDescuento < 0l)
            valorConDescuento = 0l;
        
        return "pagarCarrito.xhtml";
        
    }
    
    public String irAPagar(){
        
        valorTotal = 0l;
        
        for(ProductoTransporteDatos productoTransporteDatos : productosCarrito){
            
            valorTotal = valorTotal + productoTransporteDatos.getPrecioUnitarioVenta();
            
        }
        
        return "pagarCarrito.xhtml";
        
    }
    
    public String pagar(){
        
        ProductoMetodosLogicaPaginas productoMetodosLogicaPaginas = new ProductoMetodosLogicaPaginas();
        
        productoMetodosLogicaPaginas.pagarCompraCarrito(productosCarrito, valorCupon, valorTotal);  
        
        numCupon = null;
        valorCupon = 0l;
        valorTotal = null;
        valorConDescuento = null;
        
        productosCarrito = new ArrayList<>();
        
        return "inicio.xhtml";
        
    }
    
}