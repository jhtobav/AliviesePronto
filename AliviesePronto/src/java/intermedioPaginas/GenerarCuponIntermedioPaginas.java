package intermedioPaginas;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.GenerarCuponMetodosLogicaPaginas;
import transporteDatos.CuponTransporteDatos;

@ManagedBean(name="generarCuponIntermedioPaginas")
@SessionScoped
public class GenerarCuponIntermedioPaginas {
        
    List<CuponTransporteDatos> cupones = null;
   
    private Long id;
    private Long valor;
    private Date fechaVencimiento;
    private String estado;

    public GenerarCuponIntermedioPaginas() {
    }

    public String init(){
        
        cupones = new GenerarCuponMetodosLogicaPaginas().listarCupones();
        
        id = null;
        valor = null;
        fechaVencimiento = null;
        estado = null;
        
        return "generarCuponLista.xhtml";
        
    }

    public List<CuponTransporteDatos> getCupones() {
        return cupones;
    }

    public void setCupones(List<CuponTransporteDatos> cupones) {
        this.cupones = cupones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String generarCupon(){
        
        
        if (valor != null && fechaVencimiento != null ){
            
            CuponTransporteDatos cuponTransporteDatos = new CuponTransporteDatos();
            
            cuponTransporteDatos.setValor(valor);
            cuponTransporteDatos.setFechaVencimiento(fechaVencimiento);
            
            GenerarCuponMetodosLogicaPaginas generarCuponMetodosLogicaPaginas = new GenerarCuponMetodosLogicaPaginas();
            
            cuponTransporteDatos = generarCuponMetodosLogicaPaginas.generarCupon(cuponTransporteDatos);
            
            id = cuponTransporteDatos.getId();
            estado = cuponTransporteDatos.getEstado();
                
            return "generarCupon.xhtml";
            
        } else {
            
            return "Por favor ingrese los datos completos";
            
        }
        
    }

}
