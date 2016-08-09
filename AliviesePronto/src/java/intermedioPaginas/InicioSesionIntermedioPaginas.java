package intermedioPaginas;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.InicioSesionMetodosLogicaPaginas;

@ManagedBean(name="inicioSesionIntermedioPaginas")
@SessionScoped
public class InicioSesionIntermedioPaginas {
    
    private String nombreUsuario = null;
    private String contrasena = null;

    public InicioSesionIntermedioPaginas() {
    }
    
    public String init(String tipoUsuario){
        
        nombreUsuario = null;
        contrasena = null;

        switch (tipoUsuario) {
            case "Usuario":
                return "loginUsuario.xhtml";
            case "Medico":
                return "loginMedico.xhtml";
            case "Farmaceuta":
                return "loginFarmaceuta.xhtml";
            case "Administrador":
                return "loginAdministrador.xhtml";
            case "Gerente":
                return "loginGerente.xhtml";
            default:
                return "inicio.xhtml";
        }
        
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public String inicioSesion(String tipoUsuario){
        
        if(nombreUsuario != null && contrasena != null){
            
            InicioSesionMetodosLogicaPaginas inicioSesionMetodosLogicaPaginas 
                    = new InicioSesionMetodosLogicaPaginas();
            
            String respuesta = inicioSesionMetodosLogicaPaginas
                    .inicioSesion(nombreUsuario, contrasena, tipoUsuario);
            
            if ("Error Credenciales".equals(respuesta)){
                
                return "pag error credenciales";
                
            }
                
            if ("Cuenta Inactiva".equals(respuesta)){
                
                return "pagina cuenta inactiva";
                
            }
            
            return respuesta;
            
        } else {
            
            return "Por favor ingrese su Nombre de Usuario y Contraseña";
            
        }
        
    }
    
}
