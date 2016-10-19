package intermedioPaginas;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.ProductoMetodosLogicaPaginas;
import transporteDatos.ProductoTransporteDatos;

@ManagedBean(name="eliminarProductoIntermedioPaginas")
@SessionScoped
public class EliminarProductoIntermedioPaginas {
        
    List<ProductoTransporteDatos> productos = null;
    
    public EliminarProductoIntermedioPaginas() {
    }
    
    public String init(){
               
        productos = new ProductoMetodosLogicaPaginas().listarProductos();
        
        for(ProductoTransporteDatos productoTransporteDatos : productos)
            System.out.println(productoTransporteDatos.getId() + " " + productoTransporteDatos.getDescripcion());
        
        return "eliminarProducto.xhtml";
        
    }
    
    public String eliminarProducto(Long id){
        ProductoMetodosLogicaPaginas productoMetodosLogicaPaginas = new ProductoMetodosLogicaPaginas();
        productoMetodosLogicaPaginas.eliminarProducto(id);
        return "carrouselBienvenida.xhtml";
    }

    public List<ProductoTransporteDatos> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoTransporteDatos> productosPublicos) {
        this.productos = productosPublicos;
    }
    
}
