package intermedioPaginas;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.ProductoMetodosLogicaPaginas;
import transporteDatos.ProductoTransporteDatos;

@ManagedBean(name="inventarioListarProductosIntermedioPaginas")
@SessionScoped
public class InventarioListarProductosIntermedioPaginas {
        
    List<ProductoTransporteDatos> productos = null;
    
    public InventarioListarProductosIntermedioPaginas() {
    }
    
    public String init(){
               
        productos = new ProductoMetodosLogicaPaginas().listarProductos();
        
        return "inventarioListaProductos.xhtml";
        
    }

    public List<ProductoTransporteDatos> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoTransporteDatos> productos) {
        this.productos = productos;
    }
    
    public String actualizarInventario(){
        
        ProductoMetodosLogicaPaginas productoMetodosLogicaPaginas = new ProductoMetodosLogicaPaginas();
        
        productoMetodosLogicaPaginas.actualizarInventarioProductos(productos);
        
        return init();
        
    }
    
}
