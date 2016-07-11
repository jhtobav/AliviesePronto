/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosLogicaPaginas;

import consultasBaseDatos.UsuarioConsultaBaseDatos;

/**
 *
 * @author jhtob
 */
public class InicioSesionMetodosLogicaPaginas {
    
    public Boolean inicioSesion(String nombreUsuario, String contrasena, String tipoUsuario){
        
        if( "Usuario".equals(tipoUsuario)){
            
            UsuarioConsultaBaseDatos usuarioConsultaBaseDatos = new UsuarioConsultaBaseDatos();
           
            
        }
        
        if( "Administrador".equals(tipoUsuario)){
            
        }
        
        if( "Farmaceuta".equals(tipoUsuario)){
            
        }
        
        if( "Gerente".equals(tipoUsuario)){
            
        }
        
        if( "Medico".equals(tipoUsuario)){
            
        }
        
        return true;
        
    }
    
}
