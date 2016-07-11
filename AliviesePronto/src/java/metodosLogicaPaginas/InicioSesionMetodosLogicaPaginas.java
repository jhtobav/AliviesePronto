/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosLogicaPaginas;

import consultasBaseDatos.UsuarioConsultaBaseDatos;
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
