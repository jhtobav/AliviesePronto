/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosLogicaPaginas;

import consultasBaseDatos.CuponConsultaBaseDatos;
import java.util.List;
import java.util.ArrayList;
import tablas.Cupon;
import transporteDatos.CuponTransporteDatos;

/**
 *
 * @author jhtob
 */
public class GenerarCuponMetodosLogicaPaginas {
    
    public List<CuponTransporteDatos> listarCupones(){
        
        List<Cupon> listaCupones = new CuponConsultaBaseDatos().obtenerCupones();
        
        List<CuponTransporteDatos> listaCuponesTransporteDatos = new ArrayList<>();
        
        CuponTransporteDatos cuponTransporteDatos;
       
        for(Cupon cupon : listaCupones){
            
            cuponTransporteDatos = new CuponTransporteDatos();
            
            cuponTransporteDatos.setId(cupon.getId());
            cuponTransporteDatos.setFechaVencimiento(cupon.getFechaVencimiento());
            cuponTransporteDatos.setValor(cupon.getValor());
            if(cupon.getEstado()){
                cuponTransporteDatos.setEstado("Válido");
            } else {
                cuponTransporteDatos.setEstado("Ya Redimido");
            }
            
            listaCuponesTransporteDatos.add(cuponTransporteDatos);
            
        }
        
        return listaCuponesTransporteDatos;
        
    }
    
    public CuponTransporteDatos generarCupon(CuponTransporteDatos cuponTransporteDatos){
        
        Cupon cupon = new Cupon();
        
        cupon.setValor(cuponTransporteDatos.getValor());
        cupon.setEstado(true);
        cupon.setFechaVencimiento(cuponTransporteDatos.getFechaVencimiento());
        
        CuponConsultaBaseDatos cuponConsultaBaseDatos = new CuponConsultaBaseDatos();
        cupon = cuponConsultaBaseDatos.crearCupon(cupon);
        
        cuponTransporteDatos.setId(cupon.getId());
        cuponTransporteDatos.setEstado("Válido");
        
        return cuponTransporteDatos;
        
    }
    
}
