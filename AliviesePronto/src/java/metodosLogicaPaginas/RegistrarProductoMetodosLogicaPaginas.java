package metodosLogicaPaginas;

import consultasBaseDatos.ProductoConsultaBaseDatos;
import tablas.Producto;
import transporteDatos.ProductoTransporteDatos;

public class RegistrarProductoMetodosLogicaPaginas {

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
    
}
