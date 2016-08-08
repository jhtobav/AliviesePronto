package intermedioPaginas;

import consultasBaseDatos.FarmaceutaConsultaBaseDatos;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.ModificarCuentasMetodosLogicaPaginas;
import tablas.Farmaceuta;
import transporteDatos.FarmaceutaTransporteDatos;

@ManagedBean(name="modificarCuentaFarmaceutaIntermedioPaginas")
@SessionScoped
public class ModificarCuentaFarmaceutaIntermedioPaginas {
        
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

    public ModificarCuentaFarmaceutaIntermedioPaginas() {
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
        
        return "modificarFarmaceuta.xhtml";
        
    }
    
    public String buscarFarmaceuta(String nomUsuario){
     
        FarmaceutaConsultaBaseDatos consultaBaseDatos = new FarmaceutaConsultaBaseDatos();
        
        Farmaceuta farmaceuta = consultaBaseDatos.encontrarPorNombreUsuario(nomUsuario);
        
        if(farmaceuta != null){
            
            numDocumento = farmaceuta.getNumDocumento();
            nombreUsuario = farmaceuta.getNombreUsuario();
            primerNombre = farmaceuta.getPrimerNombre();
            segundoNombre = farmaceuta.getSegundoNombre();
            primerApellido = farmaceuta.getPrimerApellido();
            segundoApellido = farmaceuta.getSegundoApellido();
            fechaNacimiento = farmaceuta.getFechaNacimiento();
            telefono = farmaceuta.getTelefono();
            direccion = farmaceuta.getDireccion();
            correo = farmaceuta.getCorreo();
            contrasena = farmaceuta.getContrasena();
            genero = farmaceuta.getGenero();
            estadoCuenta = farmaceuta.getEstadoCuenta();
            
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

    public String modificarFarmaceuta(){
        
        /*
        numDocumento = 192837465l;
        nombreUsuario = "PruebaFarmaceuta";
        primerNombre = "PrimerNombreFarmaceuta";
        segundoNombre = "SegundoNombreFarmaceuta";
        primerApellido = "PrimerApellidoFarmaceuta";
        segundoApellido = "SegudnoApellidoFarmaceuta";
        fechaNacimiento = new Date();
        telefono = 19283l;
        direccion = "Cll 19283";
        correo = "farmaceuta@gmail.com";
        contrasena = "passFarmaceuta";
        genero = "femeninoFarmaceuta";
        */
        
        if (numDocumento != null && nombreUsuario != null && primerNombre != null && 
        segundoNombre != null && primerApellido != null && segundoApellido != null && 
        fechaNacimiento != null && telefono != null && direccion != null && 
        correo != null && contrasena != null && genero != null){
            
            FarmaceutaTransporteDatos farmaceutaTransporteDatos = new FarmaceutaTransporteDatos();
            
            farmaceutaTransporteDatos.setNumDocumento(numDocumento);
            farmaceutaTransporteDatos.setNombreUsuario(nombreUsuario);
            farmaceutaTransporteDatos.setPrimerNombre(primerNombre);
            farmaceutaTransporteDatos.setSegundoNombre(segundoNombre);
            farmaceutaTransporteDatos.setPrimerApellido(primerApellido);
            farmaceutaTransporteDatos.setSegundoApellido(segundoApellido);
            farmaceutaTransporteDatos.setFechaNacimiento(fechaNacimiento);
            farmaceutaTransporteDatos.setTelefono(telefono);
            farmaceutaTransporteDatos.setDireccion(direccion);
            farmaceutaTransporteDatos.setCorreo(correo);
            farmaceutaTransporteDatos.setContrasena(contrasena);
            farmaceutaTransporteDatos.setGenero(genero);
            farmaceutaTransporteDatos.setEstadoCuenta(estadoCuenta);
            
            ModificarCuentasMetodosLogicaPaginas modificarCuentasMetodosLogicaPaginas = new ModificarCuentasMetodosLogicaPaginas();
            
            if(modificarCuentasMetodosLogicaPaginas.ModificarFarmaceuta(farmaceutaTransporteDatos)){
                
                return "pagina exito";
                
            } else {
                
                return "pagina fracaso";
                
            }
            
        } else {
            
            return "Por favor ingrese los datos completos";
            
        }
        
    }
}
