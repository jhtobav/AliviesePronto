/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosLogicaPaginas;

import consultasBaseDatos.FormulaConsultaBaseDatos;
import transporteDatos.FormulaTransporteDatos;

/**
 *
 * @author jhtob
 */
public class DespacharFormulaMetodosLogicaPaginas {
    
    public String despacharFormula(FormulaTransporteDatos formulaTransporteDatos){
        
        FormulaConsultaBaseDatos formulaConsultaBaseDatos = new FormulaConsultaBaseDatos();
        
        formulaConsultaBaseDatos.despacharFormula(formulaTransporteDatos.getIdFormula());
        
        return "exito";
        
    }
    
}
