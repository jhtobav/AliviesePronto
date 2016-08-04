/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosLogicaPaginas;

import consultasBaseDatos.ProductoConsultaBaseDatos;
import java.util.ArrayList;
import java.util.List;
import tablas.Producto;
import transporteDatos.ProductoTransporteDatos;

/**
 *
 * @author jhtob
 */
public class CarroComprasMetodosLogicaPaginas {

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
