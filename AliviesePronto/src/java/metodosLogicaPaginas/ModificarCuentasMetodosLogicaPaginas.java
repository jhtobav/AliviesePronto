/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosLogicaPaginas;

import consultasBaseDatos.AdministradorConsultaBaseDatos;
import consultasBaseDatos.FarmaceutaConsultaBaseDatos;
import consultasBaseDatos.GerenteConsultaBaseDatos;
import consultasBaseDatos.MedicoConsultaBaseDatos;
import consultasBaseDatos.UsuarioConsultaBaseDatos;
import transporteDatos.AdministradorTransporteDatos;
import transporteDatos.FarmaceutaTransporteDatos;
import transporteDatos.GerenteTransporteDatos;
import transporteDatos.MedicoTransporteDatos;
import transporteDatos.UsuarioTransporteDatos;

/**
 *
 * @author jhtob
 */
public class ModificarCuentasMetodosLogicaPaginas {

    public boolean ModificarUsuario(UsuarioTransporteDatos usuarioTransporteDatos){
        
        UsuarioConsultaBaseDatos usuarioConsultaBaseDatos = new UsuarioConsultaBaseDatos();
        usuarioConsultaBaseDatos.modificarUsuario(usuarioTransporteDatos);
        
        return true;
        
    }
    
    public boolean ModificarAdministrador(AdministradorTransporteDatos administradorTransporteDatos){
                
        AdministradorConsultaBaseDatos administradorConsultaBaseDatos = new AdministradorConsultaBaseDatos();
        administradorConsultaBaseDatos.modificarAdministrador(administradorTransporteDatos);
        
        return true;
        
    }
    
    public boolean ModificarFarmaceuta(FarmaceutaTransporteDatos farmaceutaTransporteDatos){
                   
        FarmaceutaConsultaBaseDatos farmaceutaConsultaBaseDatos = new FarmaceutaConsultaBaseDatos();
        farmaceutaConsultaBaseDatos.modificarFarmaceuta(farmaceutaTransporteDatos);
        
        return true;
        
    }
        
    public boolean ModificarGerente(GerenteTransporteDatos gerenteTransporteDatos){
                    
        GerenteConsultaBaseDatos gerenteConsultaBaseDatos = new GerenteConsultaBaseDatos();
        gerenteConsultaBaseDatos.modificarGerente(gerenteTransporteDatos);
        
        return true;
        
    }
    
    public boolean ModificarMedico(MedicoTransporteDatos medicoTransporteDatos){
        
        MedicoConsultaBaseDatos medicoConsultaBaseDatos = new MedicoConsultaBaseDatos();
        medicoConsultaBaseDatos.modificarMedico(medicoTransporteDatos);
        
        return true;
        
    }
    
}
