package intermedioPaginas;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.ListarFormulaMetodosLogicaPaginas;
import transporteDatos.FormulaTransporteDatos;
import transporteDatos.ProductoTransporteDatos;

@ManagedBean(name="listarFormulasClienteIntermedioPaginas")
@SessionScoped
public class ListarFormulasClienteIntermedioPaginas {
        
    List<FormulaTransporteDatos> formulasDelCliente = null;
    List<ProductoTransporteDatos> productosDeFormula = null;

    Long numDocumentoUsuarioFormula;
    String descripcionFormula;

    public ListarFormulasClienteIntermedioPaginas() {
    }

    public String init(){
                
        formulasDelCliente = new ListarFormulaMetodosLogicaPaginas().listarFormulasCliente();
        
        return "listaFormulasCliente.xhtml";
        
    }

    public List<FormulaTransporteDatos> getFormulasDelCliente() {
        return formulasDelCliente;
    }

    public void setFormulasDelCliente(List<FormulaTransporteDatos> formulasDelCliente) {
        this.formulasDelCliente = formulasDelCliente;
    }

    public List<ProductoTransporteDatos> getProductosDeFormula() {
        return productosDeFormula;
    }

    public void setProductosDeFormula(List<ProductoTransporteDatos> productosDeFormula) {
        this.productosDeFormula = productosDeFormula;
    }  

    public Long getNumDocumentoUsuarioFormula() {
        return numDocumentoUsuarioFormula;
    }

    public void setNumDocumentoUsuarioFormula(Long numDocumentoUsuarioFormula) {
        this.numDocumentoUsuarioFormula = numDocumentoUsuarioFormula;
    }

    public String getDescripcionFormula() {
        return descripcionFormula;
    }

    public void setDescripcionFormula(String descripcionFormula) {
        this.descripcionFormula = descripcionFormula;
    }
    
    public String verFormula(FormulaTransporteDatos formula){
        
        productosDeFormula = new ArrayList<>();
        
        productosDeFormula = formula.getProductos();
        numDocumentoUsuarioFormula = formula.getNumDocumentoUsuario();
        descripcionFormula = formula.getDescripcion();
        
        return "listaFormulasClienteDetalle.xhtml";
        
    }
    
}
