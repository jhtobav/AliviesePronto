package intermedioPaginas;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.ModificarCuentasMetodosLogicaPaginas;
import transporteDatos.MedicoTransporteDatos;

@ManagedBean(name="modificarCuentaMedicoIntermedioPaginas")
@SessionScoped
public class ModificarCuentaMedicoIntermedioPaginas {
        
    List<MedicoTransporteDatos> medicos = null;
    
    private Long id;
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
    private String estadoCuenta;
    private Long numTarjetaProfesional;

    public ModificarCuentaMedicoIntermedioPaginas() {
    }
    
    public String init(){
        
        medicos = new ModificarCuentasMetodosLogicaPaginas().listarMedicos();
        
        id = null;
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
        
        return "listarMedicos.xhtml";
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public List<MedicoTransporteDatos> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<MedicoTransporteDatos> medicos) {
        this.medicos = medicos;
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

    public Long getNumTarjetaProfesional() {
        return numTarjetaProfesional;
    }

    public void setNumTarjetaProfesional(Long numTarjetaProfesional) {
        this.numTarjetaProfesional = numTarjetaProfesional;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }
    
    public String cargarMedico(Long idMedico){
        
        for(MedicoTransporteDatos medico : medicos){
            
            if(medico.getId() == idMedico){
                
                id = medico.getId();
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
                contrasena = null;
                genero = medico.getGenero();
                if (medico.isEstadoCuenta()){
                    estadoCuenta = "Activo";
                } else {
                    estadoCuenta = "Inactivo";
                }
                numTarjetaProfesional = medico.getNumTarjetaProfesional();
                
            }
            
        }
        
        return "modificarMedico.xhtml";
        
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
            
            medicoTransporteDatos.setId(id);
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
            if(estadoCuenta.equals("Activo")){
                medicoTransporteDatos.setEstadoCuenta(true);    
            } else {
                medicoTransporteDatos.setEstadoCuenta(false);    
            }
            medicoTransporteDatos.setNumTarjetaProfesional(numTarjetaProfesional);
            
            ModificarCuentasMetodosLogicaPaginas modificarCuentasMetodosLogicaPaginas = new ModificarCuentasMetodosLogicaPaginas();
            
            if(modificarCuentasMetodosLogicaPaginas.ModificarMedico(medicoTransporteDatos)){
                
                return init();
                
            } else {
                
                return "pagina fracaso";
                
            }
            
        } else {
            
            return "Por favor ingrese los datos completos";
            
        }
        
    }
}
