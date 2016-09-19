/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosLogicaPaginas;

import consultasBaseDatos.VentaConsultaBaseDatos;
import java.util.List;
import java.util.ArrayList;
import tablas.ProductoVendido;
import tablas.Venta;
import transporteDatos.ProductoTransporteDatos;
import transporteDatos.VentaTransporteDatos;

/**
 *
 * @author jhtob
 */
public class ReportesMetodosLogicaPaginas {

    public List<VentaTransporteDatos> listarVentas() {

        List<Venta> listaVentas;
        List<ProductoTransporteDatos> listaProductoTransporteDatos;
        List<VentaTransporteDatos> listaVentaTransporteDatos = new ArrayList<>();

        listaVentas = (List<Venta>) new VentaConsultaBaseDatos().obtenerVentas();

        VentaTransporteDatos ventaTransporteDatos;
        ProductoTransporteDatos productoTransporteDatos;

        for (Venta venta : listaVentas) {

            ventaTransporteDatos = new VentaTransporteDatos();

            ventaTransporteDatos.setIdVenta(venta.getId());
            ventaTransporteDatos.setIdUsuario(venta.getIdUsuario());
            ventaTransporteDatos.setFechaVenta(venta.getFecha());
            ventaTransporteDatos.setTipoVenta(venta.getTipoVenta());
            ventaTransporteDatos.setValorDescuento(venta.getValorDescuento());
            ventaTransporteDatos.setValorSinDescuento(venta.getValorSinDescuento());
            ventaTransporteDatos.setValorTotal(venta.getValorTotal());

            listaProductoTransporteDatos = new ArrayList<>();
            
            for (ProductoVendido productoVendido : venta.getProductoVendidoCollection()) {

                productoTransporteDatos = new ProductoTransporteDatos();

                productoTransporteDatos.setId(productoVendido.getId());
                productoTransporteDatos.setIdProductoInventario(productoVendido.getIdProductoInventario());
                productoTransporteDatos.setDescripcion(productoVendido.getDescripcion());
                productoTransporteDatos.setNombre(productoVendido.getNombre());
                productoTransporteDatos.setMarca(productoVendido.getMarca());
                productoTransporteDatos.setTipo(productoVendido.getTipo());
                productoTransporteDatos.setImagen(productoVendido.getImagen());
                productoTransporteDatos.setPrecioUnitarioCompra(productoVendido.getPrecioUnitarioCompra());
                productoTransporteDatos.setPrecioUnitarioVenta(productoVendido.getPrecioUnitarioVenta());
                productoTransporteDatos.setPresentacion(productoVendido.getPresentacion());

                listaProductoTransporteDatos.add(productoTransporteDatos);

            }

            ventaTransporteDatos.setProductos(listaProductoTransporteDatos);
            
            listaVentaTransporteDatos.add(ventaTransporteDatos);

        }
        
        return listaVentaTransporteDatos;
        
    }
   
}
