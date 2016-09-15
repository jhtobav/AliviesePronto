package intermedioPaginas;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.RegistrarFormulaMetodosLogicaPaginas;
import transporteDatos.ProductoTransporteDatos;
import transporteDatos.UsuarioTransporteDatos;

@ManagedBean(name="registrarFormulaIntermedioPaginas")
@SessionScoped
public class RegistrarFormulaIntermedioPaginas {
        
    List<ProductoTransporteDatos> todosLosProductos = null;
    List<ProductoTransporteDatos> productosAgregados = null;
    List<UsuarioTransporteDatos> listaUsuarios = null;
    
    private Long idUsuario;
    private Long numDocumento;
    private String descripcion;

    public RegistrarFormulaIntermedioPaginas() {
    }

    public String init(){
                
        listaUsuarios = new RegistrarFormulaMetodosLogicaPaginas().listarUsuarios();
        
        idUsuario = null;
        numDocumento = null;
        descripcion = null;
        
        return "registrarFormulaListaUsuarios.xhtml";
        
    }

    public List<ProductoTransporteDatos> getTodosLosProductos() {
        return todosLosProductos;
    }

    public void setTodosLosProductos(List<ProductoTransporteDatos> todosLosProductos) {
        this.todosLosProductos = todosLosProductos;
    }

    public List<ProductoTransporteDatos> getProductosAgregados() {
        return productosAgregados;
    }

    public void setProductosAgregados(List<ProductoTransporteDatos> productosAgregados) {
        this.productosAgregados = productosAgregados;
    }

    public List<UsuarioTransporteDatos> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<UsuarioTransporteDatos> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(Long numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String irRegistrarFormula(Long idUsuarioSeleccionado, Long numDocumentoSeleccionado){

        todosLosProductos = new RegistrarFormulaMetodosLogicaPaginas().listarProductos();
        productosAgregados = new ArrayList<>();
        
        idUsuario = idUsuarioSeleccionado;
        numDocumento = numDocumentoSeleccionado;
        
        return "registrarFormula.xhtml";
        
    }
    
    public String agregarProducto(Long idProducto){
        
        for(ProductoTransporteDatos productoTransporteDatos : todosLosProductos){
            
            if(productoTransporteDatos.getId() == idProducto){
                
                productosAgregados.add(productoTransporteDatos);
                break;
                
            }
            
        }
        
        return "registrarFormula.xhtml";
        
    }
    
    public String quitarProducto(Long idProducto){
        
        for(ProductoTransporteDatos productoTransporteDatos : productosAgregados){
            
            if(productoTransporteDatos.getId() == idProducto){
                
                productosAgregados.remove(productoTransporteDatos);
                break;
                
            }
            
        }
        
        return "registrarFormula.xhtml";
        
    }
    
}
