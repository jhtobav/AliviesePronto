package intermedioPaginas;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.ModificarCuentasMetodosLogicaPaginas;
import transporteDatos.GerenteTransporteDatos;

@ManagedBean(name="modificarCuentaGerenteIntermedioPaginas")
@SessionScoped
public class ModificarCuentaGerenteIntermedioPaginas {
        
    List<GerenteTransporteDatos> gerentes = null;
    
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

    public ModificarCuentaGerenteIntermedioPaginas() {
    }
    
    public String init(){
        
        gerentes = new ModificarCuentasMetodosLogicaPaginas().listarGerentes();
        
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
        
        return "modificarGerenteLista.xhtml";
        
    }

    public List<GerenteTransporteDatos> getGerentes() {
        return gerentes;
    }

    public void setGerentes(List<GerenteTransporteDatos> gerentes) {
        this.gerentes = gerentes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public String cargarGerente(Long idGerente){
        
        for(GerenteTransporteDatos gerente : gerentes){
            
            if(gerente.getId() == idGerente){
                
                id = gerente.getId();
                numDocumento = gerente.getNumDocumento();
                nombreUsuario = gerente.getNombreUsuario();
                primerNombre = gerente.getPrimerNombre();
                segundoNombre = gerente.getSegundoNombre();
                primerApellido = gerente.getPrimerApellido();
                segundoApellido = gerente.getSegundoApellido();
                fechaNacimiento = gerente.getFechaNacimiento();
                telefono = gerente.getTelefono();
                direccion = gerente.getDireccion();
                correo = gerente.getCorreo();
                contrasena = null;
                genero = gerente.getGenero();
                if (gerente.isEstadoCuenta()){
                    estadoCuenta = "Activo";
                } else {
                    estadoCuenta = "Inactivo";
                }
                
            }
            
        }
        
        return "modificarGerente.xhtml";
        
    }

    public String modificarGerente(){
        
        /*
        numDocumento = 6574839201l;
        nombreUsuario = "PruebaGerente";
        primerNombre = "PrimerNombreGerente";
        segundoNombre = "SegundoNombreGerente";
        primerApellido = "PrimerApellidoGerente";
        segundoApellido = "SegudnoApellidoGerente";
        fechaNacimiento = new Date();
        telefono = 65748l;
        direccion = "Cll 65748";
        correo = "gerente@gmail.com";
        contrasena = "passGerente";
        genero = "femeninoGerente";
        */
        
        
        if (numDocumento != null && nombreUsuario != null && primerNombre != null && 
        segundoNombre != null && primerApellido != null && segundoApellido != null && 
        fechaNacimiento != null && telefono != null && direccion != null && 
        correo != null && contrasena != null && genero != null){
            
            GerenteTransporteDatos gerenteTransporteDatos = new GerenteTransporteDatos();
            
            gerenteTransporteDatos.setId(id);
            gerenteTransporteDatos.setNumDocumento(numDocumento);
            gerenteTransporteDatos.setNombreUsuario(nombreUsuario);
            gerenteTransporteDatos.setPrimerNombre(primerNombre);
            gerenteTransporteDatos.setSegundoNombre(segundoNombre);
            gerenteTransporteDatos.setPrimerApellido(primerApellido);
            gerenteTransporteDatos.setSegundoApellido(segundoApellido);
            gerenteTransporteDatos.setFechaNacimiento(fechaNacimiento);
            gerenteTransporteDatos.setTelefono(telefono);
            gerenteTransporteDatos.setDireccion(direccion);
            gerenteTransporteDatos.setCorreo(correo);
            gerenteTransporteDatos.setContrasena(contrasena);
            gerenteTransporteDatos.setGenero(genero);
            if(estadoCuenta.equals("Activo")){
                gerenteTransporteDatos.setEstadoCuenta(true);
            } else {
                gerenteTransporteDatos.setEstadoCuenta(false);
            }
            
            ModificarCuentasMetodosLogicaPaginas modificarCuentasMetodosLogicaPaginas = new ModificarCuentasMetodosLogicaPaginas();
            
            if(modificarCuentasMetodosLogicaPaginas.modificarGerente(gerenteTransporteDatos)){
                
                return init();
                
            } else {
                
                return "pagina fracaso";
                
            }
            
        } else {
            
            return "Por favor ingrese los datos completos";
            
        }
        
    }
}
