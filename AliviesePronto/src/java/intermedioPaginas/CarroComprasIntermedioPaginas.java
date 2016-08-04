package intermedioPaginas;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.CarroComprasMetodosLogicaPaginas;
import transporteDatos.ProductoTransporteDatos;

@ManagedBean(name="carroComprasIntermedioPaginas")
@SessionScoped
public class CarroComprasIntermedioPaginas {
        
    List<ProductoTransporteDatos> productosPublicos;
    
    public CarroComprasIntermedioPaginas() {
    }
    
    @PostConstruct
    public void init(){
        
        productosPublicos = new CarroComprasMetodosLogicaPaginas().listarProductosPublicos();
        
        for(ProductoTransporteDatos productoTransporteDatos : productosPublicos)
            
            System.out.println(productoTransporteDatos.getId() + productoTransporteDatos.getDescripcion());
        
    }
    
    public void comprar(){
        
        
        
    }
}
