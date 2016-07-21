package intermedioPaginas;

import consultasBaseDatos.MedicoConsultaBaseDatos;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.ModificarCuentasMetodosLogicaPaginas;
import tablas.Medico;
import transporteDatos.MedicoTransporteDatos;

@ManagedBean(name="modificarCuentaMedicoIntermedioPaginas")
@SessionScoped
public class ModificarCuentaMedicoIntermedioPaginas {
        
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
    private Long numTarjetaProfesional;

    public ModificarCuentaMedicoIntermedioPaginas() {
    }
    
    @PostConstruct
    public void init(){
        
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
        numTarjetaProfesional = null;
        
    }
    public String buscarMedico(String nomUsuario){
     
        MedicoConsultaBaseDatos consultaBaseDatos = new MedicoConsultaBaseDatos();
        
        Medico medico = consultaBaseDatos.encontrarPorNombreUsuario(nomUsuario);
        
        if(medico != null){
            
            numDocumento = medico.getNumDocumento();
            nombreUsuario = medico.getNombreUsuario();
            primerNombre = medico.getPrimerNombre();
            segundoNombre = medico.getSegundoNombre();
            primerApellido = medico.getPrimerApellido();
            segundoApellido = medico.getSegundoApellido();
            fechaNacimiento = medico.getFechaNacimiento();
            telefono = medico.getTelefono();
            direccion = medico.getDireccion();
            correo = medico.getCorreo();
            contrasena = medico.getContrasena();
            genero = medico.getGenero();
            estadoCuenta = medico.getEstadoCuenta();
            
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

    public Long getNumTarjetaProfesional() {
        return numTarjetaProfesional;
    }

    public void setNumTarjetaProfesional(Long numTarjetaProfesional) {
        this.numTarjetaProfesional = numTarjetaProfesional;
    }

    public String modificarMedico(){
        
        /*
        numDocumento = 111111111l;
        nombreUsuario = "PruebaMedico";
        primerNombre = "PrimerNombreMedico";
        segundoNombre = "SegundoNombreMedico";
        primerApellido = "PrimerApellidoMedico";
        segundoApellido = "SegudnoApellidoMedico";
        fechaNacimiento = new Date();
        telefono = 11111l;
        direccion = "Cll 11111";
        correo = "medico@gmail.com";
        contrasena = "passMedico";
        genero = "femeninoMedico";
        numTarjetaProfesional = 11111111l;
        */
        
        if (numDocumento != null && nombreUsuario != null && primerNombre != null && 
        segundoNombre != null && primerApellido != null && segundoApellido != null && 
        fechaNacimiento != null && telefono != null && direccion != null && 
        correo != null && contrasena != null && genero != null &&
        numTarjetaProfesional != null){
            
            MedicoTransporteDatos medicoTransporteDatos = new MedicoTransporteDatos();
            
            medicoTransporteDatos.setNumDocumento(numDocumento);
            medicoTransporteDatos.setNombreUsuario(nombreUsuario);
            medicoTransporteDatos.setPrimerNombre(primerNombre);
            medicoTransporteDatos.setSegundoNombre(segundoNombre);
            medicoTransporteDatos.setPrimerApellido(primerApellido);
            medicoTransporteDatos.setSegundoApellido(segundoApellido);
            medicoTransporteDatos.setFechaNacimiento(fechaNacimiento);
            medicoTransporteDatos.setTelefono(telefono);
            medicoTransporteDatos.setDireccion(direccion);
            medicoTransporteDatos.setCorreo(correo);
            medicoTransporteDatos.setContrasena(contrasena);
            medicoTransporteDatos.setGenero(genero);
            medicoTransporteDatos.setEstadoCuenta(estadoCuenta);
            medicoTransporteDatos.setNumTarjetaProfesional(numTarjetaProfesional);
            
            ModificarCuentasMetodosLogicaPaginas modificarCuentasMetodosLogicaPaginas = new ModificarCuentasMetodosLogicaPaginas();
            
            if(modificarCuentasMetodosLogicaPaginas.ModificarMedico(medicoTransporteDatos)){
                
                return "pagina exito";
                
            } else {
                
                return "pagina fracaso";
                
            }
            
        } else {
            
            return "Por favor ingrese los datos completos";
            
        }
        
    }
}
