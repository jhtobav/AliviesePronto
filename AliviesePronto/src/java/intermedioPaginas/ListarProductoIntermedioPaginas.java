package intermedioPaginas;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.ProductoMetodosLogicaPaginas;
import transporteDatos.ProductoTransporteDatos;

@ManagedBean(name="listarProductoIntermedioPaginas")
@SessionScoped
public class ListarProductoIntermedioPaginas {
        
    List<ProductoTransporteDatos> productosPublicos;
    
    public ListarProductoIntermedioPaginas() {
    }
    
    @PostConstruct
    public void init(){
        
        productosPublicos = new ProductoMetodosLogicaPaginas().listarProductosPublicos();
        
        for(ProductoTransporteDatos productoTransporteDatos : productosPublicos)
            
            System.out.println(productoTransporteDatos.getId() + productoTransporteDatos.getDescripcion());
        
    }

    public List<ProductoTransporteDatos> getProductosPublicos() {
        return productosPublicos;
    }

    public void setProductosPublicos(List<ProductoTransporteDatos> productosPublicos) {
        this.productosPublicos = productosPublicos;
    }
    
}
