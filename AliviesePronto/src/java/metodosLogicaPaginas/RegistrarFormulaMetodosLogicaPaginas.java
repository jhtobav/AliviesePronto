/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosLogicaPaginas;

import consultasBaseDatos.FormulaConsultaBaseDatos;
import consultasBaseDatos.MedicoConsultaBaseDatos;
import consultasBaseDatos.ProductoConsultaBaseDatos;
import consultasBaseDatos.ProductoVendidoConsultaBaseDatos;
import consultasBaseDatos.UsuarioConsultaBaseDatos;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import tablas.Formula;
import tablas.Producto;
import tablas.ProductoVendido;
import tablas.Usuario;
import tablas.Venta;
import transporteDatos.FormulaTransporteDatos;
import transporteDatos.ProductoTransporteDatos;
import transporteDatos.UsuarioTransporteDatos;

/**
 *
 * @author jhtob
 */
public class RegistrarFormulaMetodosLogicaPaginas {
    
    public List<ProductoTransporteDatos> listarProductos(){
        
        List<Producto> listaProductos = new ProductoConsultaBaseDatos().obtenerProductos();
        
        List<ProductoTransporteDatos> listaProductosTransporteDatos = new ArrayList<>();
        
        ProductoTransporteDatos productoTransporteDatos;
        
        for(Producto producto : listaProductos){
            
            productoTransporteDatos = new ProductoTransporteDatos();
            
            productoTransporteDatos.setId(producto.getId());
            productoTransporteDatos.setDescripcion(producto.getDescripcion());
            productoTransporteDatos.setNombre(producto.getNombre());
            productoTransporteDatos.setMarca(producto.getMarca());
            productoTransporteDatos.setTipo(producto.getTipo());
            productoTransporteDatos.setCantidadInventario(producto.getCantidadInventario());
            productoTransporteDatos.setCantidadMinimaInventario(producto.getCantidadMinimaInventario());
            productoTransporteDatos.setImagen(producto.getImagen());
            productoTransporteDatos.setPrecioUnitarioCompra(producto.getPrecioUnitarioCompra());
            productoTransporteDatos.setPrecioUnitarioVenta(producto.getPrecioUnitarioVenta());
            productoTransporteDatos.setPresentacion(producto.getPresentacion());
            
            listaProductosTransporteDatos.add(productoTransporteDatos);
            
        }
        
        return listaProductosTransporteDatos;
        
    }
    
    public List<UsuarioTransporteDatos> listarUsuarios(){
        
        List<Usuario> listaUsuarios = new UsuarioConsultaBaseDatos().obtenerUsuarios();
        
        List<UsuarioTransporteDatos> listaUsuariosTransporteDatos = new ArrayList<>();
        
        UsuarioTransporteDatos usuarioTransporteDatos;
        
        for(Usuario usuario : listaUsuarios){
            
            usuarioTransporteDatos = new UsuarioTransporteDatos();
            
            usuarioTransporteDatos.setId(usuario.getId());
            usuarioTransporteDatos.setNumDocumento(usuario.getNumDocumento());
            usuarioTransporteDatos.setNombreUsuario(usuario.getNombreUsuario());
            usuarioTransporteDatos.setPrimerNombre(usuario.getPrimerNombre());
            usuarioTransporteDatos.setSegundoNombre(usuario.getSegundoNombre());
            usuarioTransporteDatos.setPrimerApellido(usuario.getPrimerApellido());
            usuarioTransporteDatos.setSegundoApellido(usuario.getSegundoApellido());
            usuarioTransporteDatos.setFechaNacimiento(usuario.getFechaNacimiento());
            usuarioTransporteDatos.setTelefono(usuario.getTelefono());
            usuarioTransporteDatos.setDireccion(usuario.getDireccion());
            usuarioTransporteDatos.setCorreo(usuario.getCorreo());
            usuarioTransporteDatos.setContrasena(usuario.getContrasena());
            usuarioTransporteDatos.setGenero(usuario.getGenero());
            usuarioTransporteDatos.setEstadoCuenta(usuario.getEstadoCuenta());
            
            listaUsuariosTransporteDatos.add(usuarioTransporteDatos);
            
        }
        
        return listaUsuariosTransporteDatos;
        
    }
    
    public String registrarFormula(FormulaTransporteDatos formulaTransporteDatos){
        
        Formula formula = new Formula();
        
        UsuarioConsultaBaseDatos usuarioConsultaBaseDatos = new UsuarioConsultaBaseDatos();
        ProductoVendidoConsultaBaseDatos productoVendidoConsultaBaseDatos = new ProductoVendidoConsultaBaseDatos();
        FormulaConsultaBaseDatos formulaConsultaBaseDatos = new FormulaConsultaBaseDatos();
        
        formula.setUsuarioFormulaFormulaId(usuarioConsultaBaseDatos
                .encontrarPorIdUsuario(formulaTransporteDatos.getIdUsuario()));       
        formula.setMedicoFormulaFormulaId(new MedicoConsultaBaseDatos()
                .encontrarPorIdMedico(formulaTransporteDatos.getIdMedico()));
        formula.setFechaEmision(new Date());
        formula.setDescripcion(formulaTransporteDatos.getDescripcion());
        formula.setEstado(true);
        
        formula = formulaConsultaBaseDatos.crearFormula(formula);
        
        ProductoVendido productoVendido;
        
        for(ProductoTransporteDatos productoTransporteDatos : formulaTransporteDatos.getProductos()){
            
            productoVendido = new ProductoVendido();
            
            productoVendido.setNombre(productoTransporteDatos.getNombre());
            productoVendido.setDescripcion(productoTransporteDatos.getDescripcion());
            productoVendido.setMarca(productoTransporteDatos.getMarca());
            productoVendido.setImagen(productoTransporteDatos.getImagen());
            productoVendido.setPresentacion(productoTransporteDatos.getPresentacion());
            productoVendido.setPrecioUnitarioCompra(productoTransporteDatos.getPrecioUnitarioCompra());
            productoVendido.setPrecioUnitarioVenta(productoTransporteDatos.getPrecioUnitarioVenta());
            productoVendido.setTipo(productoTransporteDatos.getTipo());
            productoVendido.setCantidadVendida(1);
            productoVendido.setFormulaProductoVendidoProductoVendidoId(formula);
            productoVendido.setVentaProductoVendidoProductoVendidoId(null);
            
            productoVendidoConsultaBaseDatos.crearProductoVendido(productoVendido);
            
        }
        
        return "exito";
        
    }
    
}
