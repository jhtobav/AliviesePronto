package intermedioPaginas;

import consultasBaseDatos.UsuarioConsultaBaseDatos;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.ModificarCuentasMetodosLogicaPaginas;
import tablas.Usuario;
import transporteDatos.UsuarioTransporteDatos;

@ManagedBean(name="modificarUsuarioIntermedioPaginas")
@SessionScoped
public class ModificarUsuarioIntermedioPaginas {
        
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

    public ModificarUsuarioIntermedioPaginas() {
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
        
        return "modificarUsuario.xhtml";
        
    }
    
    public String buscarUsuario(String nomUsuario){
     
        UsuarioConsultaBaseDatos consultaBaseDatos = new UsuarioConsultaBaseDatos();
        
        Usuario usuario = consultaBaseDatos.encontrarPorNombreUsuario(nomUsuario);
        
        if(usuario != null){
            
            numDocumento = usuario.getNumDocumento();
            nombreUsuario = usuario.getNombreUsuario();
            primerNombre = usuario.getPrimerNombre();
            segundoNombre = usuario.getSegundoNombre();
            primerApellido = usuario.getPrimerApellido();
            segundoApellido = usuario.getSegundoApellido();
            fechaNacimiento = usuario.getFechaNacimiento();
            telefono = usuario.getTelefono();
            direccion = usuario.getDireccion();
            correo = usuario.getCorreo();
            contrasena = usuario.getContrasena();
            genero = usuario.getGenero();
            estadoCuenta = usuario.getEstadoCuenta();
            
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

    public String modificarUsuario(){
        
        /*
        numDocumento = 123456789l;
        nombreUsuario = "PruebaUsuario";
        primerNombre = "PrimerNombreUsuario";
        segundoNombre = "SegundoNombreUsuario";
        primerApellido = "PrimerApellidoUsuario";
        segundoApellido = "SegudnoApellidoUsuario";
        fechaNacimiento = new Date();
        telefono = 12345l;
        direccion = "Cll 12345";
        correo = "usuario@gmail.com";
        contrasena = "passUsuario";
        genero = "femeninoUsuario";
        
        numTarjeta = 1000l;
        nombrePersona = "NombreUsuario";
        fechaVencimiento = "10/06/2016";
        csv = 2028;
        */
        
        if (numDocumento != null && nombreUsuario != null && primerNombre != null && 
        segundoNombre != null && primerApellido != null && segundoApellido != null && 
        fechaNacimiento != null && telefono != null && direccion != null && 
        correo != null && contrasena != null && genero != null){
            
            UsuarioTransporteDatos usuarioTransporteDatos = new UsuarioTransporteDatos();
            
            usuarioTransporteDatos.setNumDocumento(numDocumento);
            usuarioTransporteDatos.setNombreUsuario(nombreUsuario);
            usuarioTransporteDatos.setPrimerNombre(primerNombre);
            usuarioTransporteDatos.setSegundoNombre(segundoNombre);
            usuarioTransporteDatos.setPrimerApellido(primerApellido);
            usuarioTransporteDatos.setSegundoApellido(segundoApellido);
            usuarioTransporteDatos.setFechaNacimiento(fechaNacimiento);
            usuarioTransporteDatos.setTelefono(telefono);
            usuarioTransporteDatos.setDireccion(direccion);
            usuarioTransporteDatos.setCorreo(correo);
            usuarioTransporteDatos.setContrasena(contrasena);
            usuarioTransporteDatos.setGenero(genero);
            usuarioTransporteDatos.setEstadoCuenta(estadoCuenta);
            
            ModificarCuentasMetodosLogicaPaginas modificarCuentasMetodosLogicaPaginas = new ModificarCuentasMetodosLogicaPaginas();
            
            if(modificarCuentasMetodosLogicaPaginas.modificarUsuario(usuarioTransporteDatos)){
                
                return "pagina exito";
                
            } else {
                
                return "pagina fracaso";
                
            }
            
        } else {
            
            return "Por favor ingrese los datos completos";
            
        }
        
    }
}
