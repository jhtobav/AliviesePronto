package intermedioPaginas;

import static intermedioPaginas.InicioSesionIntermedioPaginas.emf;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import metodosLogicaPaginas.InicioSesionMetodosLogicaPaginas;

@ManagedBean(name="inicioSesionIntermedioPaginas")
@SessionScoped
public class InicioSesionIntermedioPaginas {
    
    public static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("AlivieseProntoPU");
    
    private String nombreUsuario = null;
    private String contrasena = null;

    public InicioSesionIntermedioPaginas() {
    }
    
    @PostConstruct
    public void init(){
        
        nombreUsuario = null;
        contrasena = null;
        
    }
    
    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static void setEmf(EntityManagerFactory emf) {
        InicioSesionIntermedioPaginas.emf = emf;
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
            
            if ("Error Credenciales".equals(respuesta))

                return "pag error credenciales";
                
            if ("Cuenta Inactiva".equals(respuesta))
                
                return "pagina cuenta inactiva";
            
            return respuesta;
            
        } else {
            
            return "Por favor ingrese su Nombre de Usuario y Contraseña";
            
        }
        
    }
    
    @PreDestroy
    public void destruct()
    {
        emf.close();
    }
}
