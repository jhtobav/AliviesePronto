package metodosLogicaPaginas;

import consultasBaseDatos.ProductoConsultaBaseDatos;
import java.util.ArrayList;
import java.util.List;
import tablas.Producto;
import transporteDatos.ProductoTransporteDatos;

public class ProductoMetodosLogicaPaginas {

    public boolean RegistrarProducto(ProductoTransporteDatos productoTransporteDatos){
    
        Producto producto = new Producto();
        
        producto.setNombre(productoTransporteDatos.getNombre());
        producto.setDescripcion(productoTransporteDatos.getDescripcion());
        producto.setMarca(productoTransporteDatos.getMarca());
        producto.setImagen(productoTransporteDatos.getImagen());
        producto.setPresentacion(productoTransporteDatos.getPresentacion());
        producto.setPrecioUnitarioCompra(productoTransporteDatos.getPrecioUnitarioCompra());
        producto.setPrecioUnitarioVenta(productoTransporteDatos.getPrecioUnitarioVenta());
        producto.setCantidadInventario(productoTransporteDatos.getCantidadInventario());
        producto.setCantidadMinimaInventario(productoTransporteDatos.getCantidadMinimaInventario());
        producto.setTipo(productoTransporteDatos.getTipo());
        producto.setFormulaProductoProductoId(null);
        
        ProductoConsultaBaseDatos productoConsultaBaseDatos = new ProductoConsultaBaseDatos();
        productoConsultaBaseDatos.crearProducto(producto);
        
        return true;
        
    }
    
    public List<ProductoTransporteDatos> listarProductosPublicos(){
        
        List<Producto> listaProductosPublicos = new ProductoConsultaBaseDatos().obtenerProductosPublicos();
        
        List<ProductoTransporteDatos> listaProductosPublicosTransporteDatos = new ArrayList<>();
        
        ProductoTransporteDatos productoTransporteDatos;
        
        for(Producto producto : listaProductosPublicos){
            
            productoTransporteDatos = new ProductoTransporteDatos();
            
            productoTransporteDatos.setId(producto.getId());
            productoTransporteDatos.setNombre(producto.getNombre());
            productoTransporteDatos.setDescripcion(producto.getDescripcion());
            productoTransporteDatos.setMarca(producto.getMarca());
            productoTransporteDatos.setImagen(producto.getImagen());
            productoTransporteDatos.setPresentacion(producto.getPresentacion());
            productoTransporteDatos.setPrecioUnitarioCompra(producto.getPrecioUnitarioCompra());
            productoTransporteDatos.setPrecioUnitarioVenta(producto.getPrecioUnitarioVenta());
            productoTransporteDatos.setCantidadInventario(producto.getCantidadInventario());
            productoTransporteDatos.setCantidadMinimaInventario(producto.getCantidadMinimaInventario());
            productoTransporteDatos.setTipo(producto.getTipo());
            
            listaProductosPublicosTransporteDatos.add(productoTransporteDatos);
            
        }
        
        return listaProductosPublicosTransporteDatos;
        
    }

    
}
