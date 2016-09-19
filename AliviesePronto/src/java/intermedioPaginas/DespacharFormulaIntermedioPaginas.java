package intermedioPaginas;

import consultasBaseDatos.CuponConsultaBaseDatos;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.FormulaMetodosLogicaPaginas;
import metodosLogicaPaginas.ListarFormulaMetodosLogicaPaginas;
import transporteDatos.FormulaTransporteDatos;
import transporteDatos.ProductoTransporteDatos;

@ManagedBean(name="despacharFormulaIntermedioPaginas")
@SessionScoped
public class DespacharFormulaIntermedioPaginas {
        
    private List<FormulaTransporteDatos> formulas = null;
    private List<ProductoTransporteDatos> productosDeFormula = null;

    private FormulaTransporteDatos formulaSeleccionada = null;
    private Long numDocumentoUsuarioFormula;
    private String descripcionFormula;
    
    private Long numCupon = null;
    private Long valorCupon = null;
    private Long valorTotal = null;
    private Long valorConDescuento = null;

    public DespacharFormulaIntermedioPaginas() {
    }

    public String init(){
                
        formulas = new ListarFormulaMetodosLogicaPaginas().listarFormulas();
        
        numCupon = null;
        valorTotal = null;
        valorCupon = 0l;
        valorConDescuento = null;
        
        return "despacharFormulaLista.xhtml";
        
    }

    public List<FormulaTransporteDatos> getFormulas() {
        return formulas;
    }

    public void setFormulas(List<FormulaTransporteDatos> formulas) {
        this.formulas = formulas;
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

    public FormulaTransporteDatos getFormulaSeleccionada() {
        return formulaSeleccionada;
    }

    public void setFormulaSeleccionada(FormulaTransporteDatos formulaSeleccionada) {
        this.formulaSeleccionada = formulaSeleccionada;
    }

    public Long getNumCupon() {
        return numCupon;
    }

    public void setNumCupon(Long numCupon) {
        this.numCupon = numCupon;
    }

    public Long getValorCupon() {
        return valorCupon;
    }

    public void setValorCupon(Long valorCupon) {
        this.valorCupon = valorCupon;
    }

    public Long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Long getValorConDescuento() {
        return valorConDescuento;
    }

    public void setValorConDescuento(Long valorConDescuento) {
        this.valorConDescuento = valorConDescuento;
    }
    
    public String verFormula(FormulaTransporteDatos formula){
        
        productosDeFormula = new ArrayList<>();
        
        formulaSeleccionada = formula;
        productosDeFormula = formulaSeleccionada.getProductos();
        numDocumentoUsuarioFormula = formulaSeleccionada.getNumDocumentoUsuario();
        descripcionFormula = formulaSeleccionada.getDescripcion();
        
        valorTotal = 0l;
        
        for(ProductoTransporteDatos productoTransporteDatos : productosDeFormula){
            
            valorTotal = valorTotal + productoTransporteDatos.getPrecioUnitarioVenta();
            
        }
        
        return "despacharFormulaListaDetalle.xhtml";
        
    }
    
    public String aplicarDescuento(){
        
        CuponConsultaBaseDatos cuponConsultaBaseDatos = new CuponConsultaBaseDatos();
        
        valorCupon = 0l;
        
        valorCupon = cuponConsultaBaseDatos.encontrarPorIdCupon(numCupon).getValor();
        
        valorConDescuento = valorTotal - valorCupon;
        
        if(valorConDescuento < 0l)
            valorConDescuento = 0l;
        
        return "despacharFormulaListaDetalle.xhtml";
        
    }
    
    public String despachar(){
                
        FormulaMetodosLogicaPaginas formulaMetodosLogicaPaginas = new FormulaMetodosLogicaPaginas();
        
        formulaMetodosLogicaPaginas.despacharFormula(formulaSeleccionada, valorCupon, valorTotal);
        
        return init();
        
    }
    
}
