/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosLogicaPaginas;

import consultasBaseDatos.MedicoConsultaBaseDatos;
import intermedioPaginas.InicioSesionIntermedioPaginas;
import java.util.List;
import java.util.ArrayList;
import tablas.Formula;
import tablas.Producto;
import tablas.ProductoVendido;
import transporteDatos.FormulaTransporteDatos;
import transporteDatos.ProductoTransporteDatos;

/**
 *
 * @author jhtob
 */
public class ListarFormulaMetodosLogicaPaginas {

    public List<FormulaTransporteDatos> listarFormulasMedico() {

        List<Formula> listaFormulas;
        List<ProductoTransporteDatos> listaProductoTransporteDatos;
        List<FormulaTransporteDatos> listaFormulasTransporteDatos = new ArrayList<>();

        listaFormulas = (List<Formula>) new MedicoConsultaBaseDatos()
                .encontrarPorIdMedico(InicioSesionIntermedioPaginas.idPersonaLogueada).getFormulaCollection();

        FormulaTransporteDatos formulaTransporteDatos;
        ProductoTransporteDatos productoTransporteDatos;

        for (Formula formula : listaFormulas) {

            formulaTransporteDatos = new FormulaTransporteDatos();

            formulaTransporteDatos.setIdFormula(formula.getId());
            formulaTransporteDatos.setIdUsuario(formula.getUsuarioFormulaFormulaId().getId());
            formulaTransporteDatos.setNumDocumentoUsuario(formula.getUsuarioFormulaFormulaId().getNumDocumento());
            formulaTransporteDatos.setIdMedico(formula.getMedicoFormulaFormulaId().getId());
            formulaTransporteDatos.setNumDocumentoMedico(formula.getMedicoFormulaFormulaId().getNumDocumento());
            formulaTransporteDatos.setFechaEmision(formula.getFechaEmision());

            if (formula.getEstado()) {
                formulaTransporteDatos.setEstadoFormula("Sin Despachar");
            } else {
                formulaTransporteDatos.setEstadoFormula("Despachada");
            }

            listaProductoTransporteDatos = new ArrayList<>();
            
            for (ProductoVendido productoVendido : formula.getProductoVendidoCollection()) {

                productoTransporteDatos = new ProductoTransporteDatos();

                productoTransporteDatos.setId(productoVendido.getId());
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

            formulaTransporteDatos.setProductos(listaProductoTransporteDatos);
            
            listaFormulasTransporteDatos.add(formulaTransporteDatos);

        }
        
        return listaFormulasTransporteDatos;
        
    }   
        
}
