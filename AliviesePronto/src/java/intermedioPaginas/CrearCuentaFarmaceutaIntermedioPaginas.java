package intermedioPaginas;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import metodosLogicaPaginas.CrearCuentasMetodosLogicaPaginas;
import metodosLogicaPaginas.ModificarCuentasMetodosLogicaPaginas;
import transporteDatos.FarmaceutaTransporteDatos;

@ManagedBean(name="crearCuentaFarmaceutaIntermedioPaginas")
@SessionScoped
public class CrearCuentaFarmaceutaIntermedioPaginas {
    
    List<FarmaceutaTransporteDatos> farmaceutas = null;
        
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

    public CrearCuentaFarmaceutaIntermedioPaginas() {
    }
    
    public String init(){
        
        farmaceutas = new ModificarCuentasMetodosLogicaPaginas().listarFarmaceutas();
        
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
        
        return "crearFarmaceutaLista.xhtml";
        
    }

    public Long getNumDocumento() {
        return numDocumento;
    }

    public List<FarmaceutaTransporteDatos> getFarmaceutas() {
        return farmaceutas;
    }

    public void setFarmaceutas(List<FarmaceutaTransporteDatos> farmaceutas) {
        this.farmaceutas = farmaceutas;
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

    public String crearFarmaceuta(){
        
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
            
            CrearCuentasMetodosLogicaPaginas crearCuentasMetodosLogicaPaginas = new CrearCuentasMetodosLogicaPaginas();
            
            if(crearCuentasMetodosLogicaPaginas.crearFarmaceuta(farmaceutaTransporteDatos)){
                
                return init();
                
            } else {
                
                return "pagina fracaso";
                
            }
            
        } else {
            
            return "Por favor ingrese los datos completos";
            
        }
        
    }
}
