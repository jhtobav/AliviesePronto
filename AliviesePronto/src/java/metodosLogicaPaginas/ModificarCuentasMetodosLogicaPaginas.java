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
import java.util.List;
import java.util.ArrayList;
import tablas.Medico;
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
    
    public List<MedicoTransporteDatos> listarMedicos(){
        
        List<Medico> listaMedicos = new MedicoConsultaBaseDatos().obtenerMedicos();
        
        List<MedicoTransporteDatos> listaMedicosTransporteDatos = new ArrayList<>();
        
        MedicoTransporteDatos medicoTransporteDatos;
        
        for(Medico medico : listaMedicos){
            
            medicoTransporteDatos = new MedicoTransporteDatos();
            
            medicoTransporteDatos.setId(medico.getId());
            medicoTransporteDatos.setNumDocumento(medico.getNumDocumento());
            medicoTransporteDatos.setNombreUsuario(medico.getNombreUsuario());
            medicoTransporteDatos.setPrimerNombre(medico.getPrimerNombre());
            medicoTransporteDatos.setSegundoNombre(medico.getSegundoNombre());
            medicoTransporteDatos.setPrimerApellido(medico.getPrimerApellido());
            medicoTransporteDatos.setSegundoApellido(medico.getSegundoApellido());
            medicoTransporteDatos.setFechaNacimiento(medico.getFechaNacimiento());
            medicoTransporteDatos.setTelefono(medico.getTelefono());
            medicoTransporteDatos.setDireccion(medico.getDireccion());
            medicoTransporteDatos.setCorreo(medico.getCorreo());
            medicoTransporteDatos.setContrasena(medico.getContrasena());
            medicoTransporteDatos.setGenero(medico.getGenero());
            medicoTransporteDatos.setNumTarjetaProfesional(medico.getNumTarjetaProfesional());
            medicoTransporteDatos.setEstadoCuenta(medico.getEstadoCuenta());
            
            listaMedicosTransporteDatos.add(medicoTransporteDatos);
            
        }
        
        return listaMedicosTransporteDatos;
        
    }

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
