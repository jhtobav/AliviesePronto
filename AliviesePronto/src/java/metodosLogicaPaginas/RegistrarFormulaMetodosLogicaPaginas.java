/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosLogicaPaginas;

import consultasBaseDatos.ProductoConsultaBaseDatos;
import consultasBaseDatos.UsuarioConsultaBaseDatos;
import java.util.List;
import java.util.ArrayList;
import tablas.Producto;
import tablas.Usuario;
import transporteDatos.ProductoTransporteDatos;
import transporteDatos.UsuarioTransporteDatos;

/**
 *
 * @author jhtob
 */
public class RegistrarFormulaMetodosLogicaPaginas {
    
    public List<ProductoTransporteDatos> listarProductos(){
        
        List<Producto> listaProductos = new ProductoConsultaBaseDatos().obtenerProductos();
        
        List<ProductoTransporteDatos> listaProductossTransporteDatos = new ArrayList<>();
        
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
            
            listaProductossTransporteDatos.add(productoTransporteDatos);
            
        }
        
        return listaProductossTransporteDatos;
        
    }
    
    public List<UsuarioTransporteDatos> listarUsuarios(){
        
        List<Usuario> listaUsuarios = new UsuarioConsultaBaseDatos().obtenerUsuarios();
        
        List<UsuarioTransporteDatos> listaUsuariosTransporteDatos = new ArrayList<>();
        
        UsuarioTransporteDatos usuarioTransporteDatos;
        
        for(Usuario usuario : listaUsuarios){
            
            usuarioTransporteDatos = new UsuarioTransporteDatos();
            
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
    
}
