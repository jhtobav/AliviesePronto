package intermedioPaginas;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.ListarFormulaMetodosLogicaPaginas;
import transporteDatos.FormulaTransporteDatos;
import transporteDatos.ProductoTransporteDatos;

@ManagedBean(name="despacharFormulaListaDespachadasIntermedioPaginas")
@SessionScoped
public class DespacharFormulaListaDespachadasIntermedioPaginas {
        
    List<FormulaTransporteDatos> formulasDespachadas = null;
    List<ProductoTransporteDatos> productosDeFormula = null;

    FormulaTransporteDatos formulaSeleccionada = null;
    Long numDocumentoUsuarioFormula;
    String descripcionFormula;

    public DespacharFormulaListaDespachadasIntermedioPaginas() {
    }

    public String init(){
                
        formulasDespachadas = new ListarFormulaMetodosLogicaPaginas().listarFormulasDespachadas();
        
        return "despacharFormulaListaDespachadas.xhtml";
        
    }

    public List<FormulaTransporteDatos> getFormulasDespachadas() {
        return formulasDespachadas;
    }

    public void setFormulasDespachadas(List<FormulaTransporteDatos> formulasDespachadas) {
        this.formulasDespachadas = formulasDespachadas;
    }

    public FormulaTransporteDatos getFormulaSeleccionada() {
        return formulaSeleccionada;
    }

    public void setFormulaSeleccionada(FormulaTransporteDatos formulaSeleccionada) {
        this.formulaSeleccionada = formulaSeleccionada;
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
        
        formulaSeleccionada = formula;
        productosDeFormula = formulaSeleccionada.getProductos();
        numDocumentoUsuarioFormula = formulaSeleccionada.getNumDocumentoUsuario();
        descripcionFormula = formulaSeleccionada.getDescripcion();
        
        return "despacharFormulaListaDespachadasDetalle.xhtml";
        
    }

    
}
