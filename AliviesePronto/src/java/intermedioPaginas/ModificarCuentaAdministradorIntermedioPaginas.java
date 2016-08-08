package intermedioPaginas;

import consultasBaseDatos.AdministradorConsultaBaseDatos;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.ModificarCuentasMetodosLogicaPaginas;
import tablas.Administrador;
import transporteDatos.AdministradorTransporteDatos;

@ManagedBean(name="modificarCuentaAdministradorIntermedioPaginas")
@SessionScoped
public class ModificarCuentaAdministradorIntermedioPaginas {
        
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
    private Boolean estadoCuenta;

    public ModificarCuentaAdministradorIntermedioPaginas() {
    }
    

    public String init(){
        
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
        estadoCuenta = null;
        
        return "modificarAdministrador.xhtml";
        
    }
    
    public String buscarAdministrador(String nomUsuario){
     
        AdministradorConsultaBaseDatos consultaBaseDatos = new AdministradorConsultaBaseDatos();
        
        Administrador administrador = consultaBaseDatos.encontrarPorNombreUsuario(nomUsuario);
        
        if(administrador != null){
            
            numDocumento = administrador.getNumDocumento();
            nombreUsuario = administrador.getNombreUsuario();
            primerNombre = administrador.getPrimerNombre();
            segundoNombre = administrador.getSegundoNombre();
            primerApellido = administrador.getPrimerApellido();
            segundoApellido = administrador.getSegundoApellido();
            fechaNacimiento = administrador.getFechaNacimiento();
            telefono = administrador.getTelefono();
            direccion = administrador.getDireccion();
            correo = administrador.getCorreo();
            contrasena = administrador.getContrasena();
            genero = administrador.getGenero();
            estadoCuenta = administrador.getEstadoCuenta();
            
            return "usuario encontrado";
            
        } else {
            
            return "usuario no encontrado";
            
        }
        
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

    public Boolean getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(Boolean estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public String modificarAdministrador(){
        
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
            administradorTransporteDatos.setEstadoCuenta(estadoCuenta);
            
            ModificarCuentasMetodosLogicaPaginas modificarCuentasMetodosLogicaPaginas = new ModificarCuentasMetodosLogicaPaginas();
            
            if(modificarCuentasMetodosLogicaPaginas.ModificarAdministrador(administradorTransporteDatos)){
                
                return "pagina exito";
                
            } else {
                
                return "pagina fracaso";
                
            }
            
        } else {
            
            return "Por favor ingrese los datos completos";
            
        }
        
    }
}
