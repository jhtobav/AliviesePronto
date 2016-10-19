package metodosLogicaPaginas;

import consultasBaseDatos.ProductoConsultaBaseDatos;
import consultasBaseDatos.ProductoVendidoConsultaBaseDatos;
import consultasBaseDatos.VentaConsultaBaseDatos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tablas.Producto;
import tablas.ProductoVendido;
import tablas.Venta;
import transporteDatos.ProductoTransporteDatos;

public class ProductoMetodosLogicaPaginas {

    public boolean RegistrarProducto(ProductoTransporteDatos productoTransporteDatos) {

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

        ProductoConsultaBaseDatos productoConsultaBaseDatos = new ProductoConsultaBaseDatos();
        productoConsultaBaseDatos.crearProducto(producto);

        return true;

    }

    public List<ProductoTransporteDatos> listarProductosPublicos() {

        List<Producto> listaProductosPublicos = new ProductoConsultaBaseDatos().obtenerProductosPublicos();

        List<ProductoTransporteDatos> listaProductosPublicosTransporteDatos = new ArrayList<>();

        ProductoTransporteDatos productoTransporteDatos;

        for (Producto producto : listaProductosPublicos) {

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

    public List<ProductoTransporteDatos> listarProductos() {

        List<Producto> listaProductos = new ProductoConsultaBaseDatos().obtenerProductos();

        List<ProductoTransporteDatos> listaProductosTransporteDatos = new ArrayList<>();

        ProductoTransporteDatos productoTransporteDatos;

        for (Producto producto : listaProductos) {

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

            listaProductosTransporteDatos.add(productoTransporteDatos);

        }

        return listaProductosTransporteDatos;

    }

    public String actualizarInventarioProductos(List<ProductoTransporteDatos> productos) {

        ProductoConsultaBaseDatos productoConsultaBaseDatos = new ProductoConsultaBaseDatos();

        for (ProductoTransporteDatos productoTransporteDatos : productos) {

            productoConsultaBaseDatos.actualizarCantidadInventario(productoTransporteDatos);

        }

        return "exito";

    }

    public boolean actualizarProducto(ProductoTransporteDatos productoTransporteDatos) {
        System.out.println(productoTransporteDatos);
        System.out.println(productoTransporteDatos.getId());
        Producto producto = new Producto(productoTransporteDatos.getId(), 
                productoTransporteDatos.getNombre(), 
                productoTransporteDatos.getDescripcion(), 
                productoTransporteDatos.getMarca(), 
                productoTransporteDatos.getImagen(), 
                productoTransporteDatos.getPresentacion(), 
                productoTransporteDatos.getPrecioUnitarioCompra(), 
                productoTransporteDatos.getPrecioUnitarioVenta(), 
                productoTransporteDatos.getCantidadInventario(), 
                productoTransporteDatos.getCantidadMinimaInventario(), 
                productoTransporteDatos.getTipo());
        ProductoConsultaBaseDatos productoConsultaBaseDatos = new ProductoConsultaBaseDatos();
        productoConsultaBaseDatos.actualizarProducto(producto);
        return true;
    }
    
    public void eliminarProducto(Long id){
        ProductoConsultaBaseDatos productoConsultaBaseDatos = new ProductoConsultaBaseDatos();
        productoConsultaBaseDatos.eliminarProducto(id);
    }

    public String pagarCompraCarrito(List<ProductoTransporteDatos> productosVendidos,
            Long valorCupon, Long valorVenta) {

        VentaConsultaBaseDatos ventaConsultaBaseDatos = new VentaConsultaBaseDatos();
        ProductoVendidoConsultaBaseDatos productoVendidoConsultaBaseDatos = new ProductoVendidoConsultaBaseDatos();
        ProductoConsultaBaseDatos productoConsultaBaseDatos = new ProductoConsultaBaseDatos();

        ProductoVendido productoVendido;

        Venta venta = new Venta();
        venta.setFecha(new Date());
        venta.setIdUsuario(0);
        venta.setTipoVenta("Venta al Público");
        venta.setValorDescuento(valorCupon);
        venta.setValorSinDescuento(valorVenta);
        venta.setValorTotal(valorVenta - valorCupon);

        venta = ventaConsultaBaseDatos.crearVenta(venta);

        for (ProductoTransporteDatos productoTransporteDatos : productosVendidos) {

            productoVendido = new ProductoVendido();

            productoVendido.setIdProductoInventario(productoTransporteDatos.getId());
            productoVendido.setNombre(productoTransporteDatos.getNombre());
            productoVendido.setDescripcion(productoTransporteDatos.getDescripcion());
            productoVendido.setMarca(productoTransporteDatos.getMarca());
            productoVendido.setImagen(productoTransporteDatos.getImagen());
            productoVendido.setPresentacion(productoTransporteDatos.getPresentacion());
            productoVendido.setPrecioUnitarioCompra(productoTransporteDatos.getPrecioUnitarioCompra());
            productoVendido.setPrecioUnitarioVenta(productoTransporteDatos.getPrecioUnitarioVenta());
            productoVendido.setTipo(productoTransporteDatos.getTipo());
            productoVendido.setCantidadVendida(1);
            productoVendido.setFormulaProductoVendidoProductoVendidoId(null);
            productoVendido.setVentaProductoVendidoProductoVendidoId(venta);

            productoVendidoConsultaBaseDatos.crearProductoVendido(productoVendido);

            productoConsultaBaseDatos.registrarCompra(productoTransporteDatos.getId());

        }

        return "exito";

    }

}
