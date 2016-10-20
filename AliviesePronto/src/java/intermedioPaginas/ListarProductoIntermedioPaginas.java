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
    String ordenarAlfabeticamente;
    String ordenarPorFabricante;
    String nombre;
    
    public ListarProductoIntermedioPaginas() {
    }
    
    public String init(){
               
        productosPublicos = new ProductoMetodosLogicaPaginas().listarProductosPublicos();
        
        for(ProductoTransporteDatos productoTransporteDatos : productosPublicos)
            System.out.println(productoTransporteDatos.getId() + " " + productoTransporteDatos.getDescripcion());
        
        return "listarProducto.xhtml";
        
    }
    
    public String ordenarAlfabeticamente(){
        ordenarAlfabeticamente="success";
        ordenarPorFabricante="default";
        
        productosPublicos = new ProductoMetodosLogicaPaginas().listarProductosAlfabeticamente();
        
        return "listarProducto.xhtml";
    }
            
    public String ordenarPorFabricante(){
        ordenarAlfabeticamente="default";
        ordenarPorFabricante="success";
        
        productosPublicos = new ProductoMetodosLogicaPaginas().listarProductosPorMarca();
        
        return "listarProducto.xhtml";
    }
    
    public String buscarPorNombre(){
        productosPublicos = new ProductoMetodosLogicaPaginas().buscarProductosPorNombre(nombre);
        
        return "listarProducto.xhtml";
    }
    
    public List<ProductoTransporteDatos> getProductosPublicos() {
        return productosPublicos;
    }

    public void setProductosPublicos(List<ProductoTransporteDatos> productosPublicos) {
        this.productosPublicos = productosPublicos;
    }

    public String getOrdenarAlfabeticamente() {
        return ordenarAlfabeticamente;
    }

    public void setOrdenarAlfabeticamente(String ordenarAlfabeticamente) {
        this.ordenarAlfabeticamente = ordenarAlfabeticamente;
    }

    public String getOrdenarPorFabricante() {
        return ordenarPorFabricante;
    }

    public void setOrdenarPorFabricante(String ordenarPorFabricante) {
        this.ordenarPorFabricante = ordenarPorFabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 
    
}
