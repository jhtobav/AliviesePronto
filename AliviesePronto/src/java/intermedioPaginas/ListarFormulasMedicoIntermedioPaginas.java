package intermedioPaginas;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.ListarFormulaMetodosLogicaPaginas;
import transporteDatos.FormulaTransporteDatos;
import transporteDatos.ProductoTransporteDatos;

@ManagedBean(name="listarFormulasMedicoIntermedioPaginas")
@SessionScoped
public class ListarFormulasMedicoIntermedioPaginas {
        
    List<FormulaTransporteDatos> formulasDelMedico = null;
    List<ProductoTransporteDatos> productosDeFormula = null;

    Long numDocumentoUsuarioFormula;
    String descripcionFormula;

    public ListarFormulasMedicoIntermedioPaginas() {
    }

    public String init(){
                
        formulasDelMedico = new ListarFormulaMetodosLogicaPaginas().listarFormulasMedico();
        
        return "listaFormulasMedico.xhtml";
        
    }

    public List<FormulaTransporteDatos> getFormulasDelMedico() {
        return formulasDelMedico;
    }

    public void setFormulasDelMedico(List<FormulaTransporteDatos> formulasDelMedico) {
        this.formulasDelMedico = formulasDelMedico;
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
        
        return "listaFormulasMedicoDetalle.xhtml";
        
    }
    
}
