package intermedioPaginas;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.CrearCuentasMetodosLogicaPaginas;
import metodosLogicaPaginas.ModificarCuentasMetodosLogicaPaginas;
import transporteDatos.AdministradorTransporteDatos;

@ManagedBean(name="crearCuentaAdministradorIntermedioPaginas")
@SessionScoped
public class CrearCuentaAdministradorIntermedioPaginas {
    
    List<AdministradorTransporteDatos> administradores = null;
        
    private Long numDocumento;
    private String nombreUsuario;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private Long telefono;
    private String direccion;
    private String correo;
    private String contrasena;
    private String genero;

    public CrearCuentaAdministradorIntermedioPaginas() {
    }
    
    public String init(){
        
        administradores = new ModificarCuentasMetodosLogicaPaginas().listarAdministradores();
        
        numDocumento = null;
        nombreUsuario = null;
        primerNombre = null;
        segundoNombre = null;
        primerApellido = null;
        segundoApellido = null;
        fechaNacimiento = null;
        telefono = null;
        direccion = null;
        correo = null;
        contrasena = null;
        genero = null;
        
        return "crearAdministradorLista.xhtml";
        
    }

    public List<AdministradorTransporteDatos> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<AdministradorTransporteDatos> administradores) {
        this.administradores = administradores;
    }

    public Long getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(Long numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String crearAdministrador(){
        
        /*
        numDocumento = 987654321l;
        nombreUsuario = "PruebaAdministrador";
        primerNombre = "PrimerNombreAdministrador";
        segundoNombre = "SegundoNombreAdministrador";
        primerApellido = "PrimerApellidoAdministrador";
        segundoApellido = "SegudnoApellidoAdministrador";
        fechaNacimiento = new Date();
        telefono = 98765l;
        direccion = "Cll 98765";
        correo = "administrador@gmail.com";
        contrasena = "passAdministrador";
        genero = "femeninoAdministrador";
        */
        
        
        if (numDocumento != null && nombreUsuario != null && primerNombre != null && 
        segundoNombre != null && primerApellido != null && segundoApellido != null && 
        fechaNacimiento != null && telefono != null && direccion != null && 
        correo != null && contrasena != null && genero != null){
            
            AdministradorTransporteDatos administradorTransporteDatos = new AdministradorTransporteDatos();
            
            administradorTransporteDatos.setNumDocumento(numDocumento);
            administradorTransporteDatos.setNombreUsuario(nombreUsuario);
            administradorTransporteDatos.setPrimerNombre(primerNombre);
            administradorTransporteDatos.setSegundoNombre(segundoNombre);
            administradorTransporteDatos.setPrimerApellido(primerApellido);
            administradorTransporteDatos.setSegundoApellido(segundoApellido);
            administradorTransporteDatos.setFechaNacimiento(fechaNacimiento);
            administradorTransporteDatos.setTelefono(telefono);
            administradorTransporteDatos.setDireccion(direccion);
            administradorTransporteDatos.setCorreo(correo);
            administradorTransporteDatos.setContrasena(contrasena);
            administradorTransporteDatos.setGenero(genero);
            
            CrearCuentasMetodosLogicaPaginas crearCuentasMetodosLogicaPaginas = new CrearCuentasMetodosLogicaPaginas();
            
            if(crearCuentasMetodosLogicaPaginas.crearAdministrador(administradorTransporteDatos)){
                
                return init();
                
            } else {
                
                return "pagina fracaso";
                
            }
            
        } else {
            
            return "Por favor ingrese los datos completos";
            
        }
        
    }
}
