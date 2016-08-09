package intermedioPaginas;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.ProductoMetodosLogicaPaginas;
import transporteDatos.ProductoTransporteDatos;

@ManagedBean(name="listarProductoIntermedioPaginas")
@SessionScoped
public class ListarProductoIntermedioPaginas {
        
    List<ProductoTransporteDatos> productosPublicos = null;
    
    public ListarProductoIntermedioPaginas() {
    }
    
    public String init(){
               
        productosPublicos = new ProductoMetodosLogicaPaginas().listarProductosPublicos();
        
        for(ProductoTransporteDatos productoTransporteDatos : productosPublicos)
            System.out.println(productoTransporteDatos.getId() + " " + productoTransporteDatos.getDescripcion());
        
        return "listarProductos.xhtml";
        
    }

    public List<ProductoTransporteDatos> getProductosPublicos() {
        return productosPublicos;
    }

    public void setProductosPublicos(List<ProductoTransporteDatos> productosPublicos) {
        this.productosPublicos = productosPublicos;
    }
    
}
