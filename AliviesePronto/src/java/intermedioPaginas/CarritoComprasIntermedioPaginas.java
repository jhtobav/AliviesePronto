package intermedioPaginas;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import transporteDatos.ProductoTransporteDatos;

@ManagedBean(name="carritoComprasIntermedioPaginas")
@SessionScoped
public class CarritoComprasIntermedioPaginas {
    List<ProductoTransporteDatos> productosCarrito;

    public void init(){
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
    
    public String agregarProductos(ProductoTransporteDatos producto){
        System.out.println(producto);
        productosCarrito.add(producto);
        for(int i=0; i<productosCarrito.size(); i++){
            System.out.println(productosCarrito.get(i));
        }
        System.out.println("tamaño de la lista" + productosCarrito.size());
        
        return "inicio.xhtml";
    }
    
}