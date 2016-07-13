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
import tablas.Administrador;
import tablas.Farmaceuta;
import tablas.Gerente;
import tablas.Medico;
import tablas.Usuario;

/**
 *
 * @author jhtob
 */
public class InicioSesionMetodosLogicaPaginas {
    
    public Boolean inicioSesion(String nombreUsuario, String contrasena, String tipoUsuario){
        
        if("Usuario".equals(tipoUsuario)){
            
            UsuarioConsultaBaseDatos usuarioConsultaBaseDatos = new UsuarioConsultaBaseDatos();
           
            Usuario usuario = usuarioConsultaBaseDatos.encontrarPorNombreUsuario(nombreUsuario);
                
            if (usuario != null){
                
                return contrasena.equals(usuario.getContrasena());
                
            } else {
                
                return false;
                
            }
            
        }
        
        if( "Administrador".equals(tipoUsuario)){
            
            AdministradorConsultaBaseDatos administradorConsultaBaseDatos = new AdministradorConsultaBaseDatos();
           
            Administrador administrador = administradorConsultaBaseDatos.encontrarPorNombreUsuario(nombreUsuario);
                
            if (administrador != null){
                
                return contrasena.equals(administrador.getContrasena());
                
            } else {
                
                return false;
                
            }
            
        }
        
        if( "Farmaceuta".equals(tipoUsuario)){
            
            FarmaceutaConsultaBaseDatos farmaceutaConsultaBaseDatos = new FarmaceutaConsultaBaseDatos();
           
            Farmaceuta farmaceuta = farmaceutaConsultaBaseDatos.encontrarPorNombreUsuario(nombreUsuario);
                
            if (farmaceuta != null){
                
                return contrasena.equals(farmaceuta.getContrasena());
                
            } else {
                
                return false;
                
            }
            
        }
        
        if( "Gerente".equals(tipoUsuario)){
            
            GerenteConsultaBaseDatos gerenteConsultaBaseDatos = new GerenteConsultaBaseDatos();
           
            Gerente gerente = gerenteConsultaBaseDatos.encontrarPorNombreUsuario(nombreUsuario);
                
            if (gerente != null){
                
                return contrasena.equals(gerente.getContrasena());
                
            } else {
                
                return false;
                
            }
            
        }
        
        if( "Medico".equals(tipoUsuario)){
            
            MedicoConsultaBaseDatos medicoConsultaBaseDatos = new MedicoConsultaBaseDatos();
           
            Medico medico = medicoConsultaBaseDatos.encontrarPorNombreUsuario(nombreUsuario);
                
            if (medico != null){
                
                return contrasena.equals(medico.getContrasena());
                
            } else {
                
                return false;
                
            }
            
        }
        
        return false;
        
    }
    
}
