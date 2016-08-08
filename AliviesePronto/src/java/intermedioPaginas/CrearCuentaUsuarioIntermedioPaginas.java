package intermedioPaginas;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.CrearCuentasMetodosLogicaPaginas;
import transporteDatos.TarjetaTransporteDatos;
import transporteDatos.UsuarioTransporteDatos;

@ManagedBean(name="crearCuentaUsuarioIntermedioPaginas")
@SessionScoped
public class CrearCuentaUsuarioIntermedioPaginas {
        
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
    
    private Long numTarjeta;
    private String nombrePersona;
    private Integer mesVencimiento;
    private Integer anoVencimiento;
    private String fechaVencimiento;
    private Integer csv;

    public CrearCuentaUsuarioIntermedioPaginas() {
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
        
        numTarjeta = null;
        nombrePersona = null;
        mesVencimiento = null;
        anoVencimiento = null;
        fechaVencimiento = null;
        csv = null;
        
        return "crearPaciente.xhtml";
        
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

    public Long getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(Long numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public Integer getMesVencimiento() {
        return mesVencimiento;
    }

    public void setMesVencimiento(Integer mesVencimiento) {
        this.mesVencimiento = mesVencimiento;
    }

    public Integer getAnoVencimiento() {
        return anoVencimiento;
    }

    public void setAnoVencimiento(Integer anoVencimiento) {
        this.anoVencimiento = anoVencimiento;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getCsv() {
        return csv;
    }

    public void setCsv(Integer csv) {
        this.csv = csv;
    }

    public String registroUsuario(){
        
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
        correo != null && contrasena != null && genero != null &&
        numTarjeta != null && nombrePersona != null && mesVencimiento != null &&  
        anoVencimiento != null && csv != null){
            
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
            
            TarjetaTransporteDatos tarjetaTransporteDatos = new TarjetaTransporteDatos();
            
            tarjetaTransporteDatos.setNumTarjeta(numTarjeta);
            tarjetaTransporteDatos.setNombrePersona(nombrePersona);
            tarjetaTransporteDatos.setFechaVencimiento(mesVencimiento.toString() + anoVencimiento.toString());
            tarjetaTransporteDatos.setCsv(csv.shortValue());
            
            CrearCuentasMetodosLogicaPaginas crearCuentasMetodosLogicaPaginas = new CrearCuentasMetodosLogicaPaginas();
            
            if(crearCuentasMetodosLogicaPaginas
                    .RegistrarUsuario(usuarioTransporteDatos, tarjetaTransporteDatos)){
                
                return "carrouselBienvenida.xhtml";
                
            } else {
                
                return "pagina fracaso";
                
            }
            
        } else {
            
            return "Por favor ingrese los datos completos";
            
        }
        
    }
}
