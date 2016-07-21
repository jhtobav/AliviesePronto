/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosLogicaPaginas;

import consultasBaseDatos.AdministradorConsultaBaseDatos;
import consultasBaseDatos.FarmaceutaConsultaBaseDatos;
import consultasBaseDatos.GerenteConsultaBaseDatos;
import consultasBaseDatos.MedicoConsultaBaseDatos;
import consultasBaseDatos.TarjetaConsultaBaseDatos;
import consultasBaseDatos.UsuarioConsultaBaseDatos;
import java.util.ArrayList;
import java.util.List;
import tablas.Administrador;
import tablas.Farmaceuta;
import tablas.Formula;
import tablas.Gerente;
import tablas.Medico;
import tablas.TarjetaCredito;
import tablas.Usuario;
import transporteDatos.AdministradorTransporteDatos;
import transporteDatos.FarmaceutaTransporteDatos;
import transporteDatos.GerenteTransporteDatos;
import transporteDatos.MedicoTransporteDatos;
import transporteDatos.TarjetaTransporteDatos;
import transporteDatos.UsuarioTransporteDatos;

/**
 *
 * @author jhtob
 */
public class CrearCuentasMetodosLogicaPaginas {

    public boolean RegistrarUsuario(UsuarioTransporteDatos usuarioTransporteDatos,
            TarjetaTransporteDatos tarjetaTransporteDatos ){
    
        TarjetaCredito tarjetaCredito = new TarjetaCredito();
        
        tarjetaCredito.setNumTarjeta(tarjetaTransporteDatos.getNumTarjeta());
        tarjetaCredito.setFechaVencimiento(tarjetaTransporteDatos.getFechaVencimiento());
        tarjetaCredito.setNombrePersona(tarjetaTransporteDatos.getNombrePersona());
        tarjetaCredito.setCsv(tarjetaTransporteDatos.getCsv());
        
        Usuario usuario = new Usuario();
        
        usuario.setNumDocumento(usuarioTransporteDatos.getNumDocumento());
        usuario.setNombreUsuario(usuarioTransporteDatos.getNombreUsuario());
        usuario.setPrimerNombre(usuarioTransporteDatos.getPrimerNombre());
        usuario.setSegundoNombre(usuarioTransporteDatos.getSegundoNombre());
        usuario.setPrimerApellido(usuarioTransporteDatos.getPrimerApellido());
        usuario.setSegundoApellido(usuarioTransporteDatos.getSegundoApellido());
        usuario.setFechaNacimiento(usuarioTransporteDatos.getFechaNacimiento());
        usuario.setTelefono(usuarioTransporteDatos.getTelefono());
        usuario.setDireccion(usuarioTransporteDatos.getDireccion());
        usuario.setCorreo(usuarioTransporteDatos.getCorreo());
        usuario.setContrasena(usuarioTransporteDatos.getContrasena());
        usuario.setGenero(usuarioTransporteDatos.getGenero());
        usuario.setEstadoCuenta(true);
        
        List<Formula> formulas = new ArrayList<>();
        usuario.setFormulaCollection(formulas);
        
        TarjetaConsultaBaseDatos tarjetaConsultaBaseDatos = new TarjetaConsultaBaseDatos();
        tarjetaConsultaBaseDatos.crearTarjetaCredito(tarjetaCredito);
        
        usuario.setTarjetaId(tarjetaCredito);
        
        UsuarioConsultaBaseDatos usuarioConsultaBaseDatos = new UsuarioConsultaBaseDatos();
        usuarioConsultaBaseDatos.crearUsuario(usuario);
        
        return true;
        
    }
    
    public boolean CrearAdministrador(AdministradorTransporteDatos administradorTransporteDatos){
        
        Administrador administrador = new Administrador();
        
        administrador.setNumDocumento(administradorTransporteDatos.getNumDocumento());
        administrador.setNombreUsuario(administradorTransporteDatos.getNombreUsuario());
        administrador.setPrimerNombre(administradorTransporteDatos.getPrimerNombre());
        administrador.setSegundoNombre(administradorTransporteDatos.getSegundoNombre());
        administrador.setPrimerApellido(administradorTransporteDatos.getPrimerApellido());
        administrador.setSegundoApellido(administradorTransporteDatos.getSegundoApellido());
        administrador.setFechaNacimiento(administradorTransporteDatos.getFechaNacimiento());
        administrador.setTelefono(administradorTransporteDatos.getTelefono());
        administrador.setDireccion(administradorTransporteDatos.getDireccion());
        administrador.setCorreo(administradorTransporteDatos.getCorreo());
        administrador.setContrasena(administradorTransporteDatos.getContrasena());
        administrador.setGenero(administradorTransporteDatos.getGenero());
        administrador.setEstadoCuenta(true);
        
        AdministradorConsultaBaseDatos administradorConsultaBaseDatos = new AdministradorConsultaBaseDatos();
        administradorConsultaBaseDatos.crearAdministrador(administrador);
        
        return true;
        
    }
    
    public boolean CrearFarmaceuta(FarmaceutaTransporteDatos farmaceutaTransporteDatos){
            
        Farmaceuta farmaceuta = new Farmaceuta();
        
        farmaceuta.setNumDocumento(farmaceutaTransporteDatos.getNumDocumento());
        farmaceuta.setNombreUsuario(farmaceutaTransporteDatos.getNombreUsuario());
        farmaceuta.setPrimerNombre(farmaceutaTransporteDatos.getPrimerNombre());
        farmaceuta.setSegundoNombre(farmaceutaTransporteDatos.getSegundoNombre());
        farmaceuta.setPrimerApellido(farmaceutaTransporteDatos.getPrimerApellido());
        farmaceuta.setSegundoApellido(farmaceutaTransporteDatos.getSegundoApellido());
        farmaceuta.setFechaNacimiento(farmaceutaTransporteDatos.getFechaNacimiento());
        farmaceuta.setTelefono(farmaceutaTransporteDatos.getTelefono());
        farmaceuta.setDireccion(farmaceutaTransporteDatos.getDireccion());
        farmaceuta.setCorreo(farmaceutaTransporteDatos.getCorreo());
        farmaceuta.setContrasena(farmaceutaTransporteDatos.getContrasena());
        farmaceuta.setGenero(farmaceutaTransporteDatos.getGenero());
        farmaceuta.setEstadoCuenta(true);
        
        FarmaceutaConsultaBaseDatos farmaceutaConsultaBaseDatos = new FarmaceutaConsultaBaseDatos();
        farmaceutaConsultaBaseDatos.crearFarmaceuta(farmaceuta);
        
        return true;
        
    }
        
    public boolean CrearGerente(GerenteTransporteDatos gerenteTransporteDatos){
            
        Gerente gerente = new Gerente();
        
        gerente.setNumDocumento(gerenteTransporteDatos.getNumDocumento());
        gerente.setNombreUsuario(gerenteTransporteDatos.getNombreUsuario());
        gerente.setPrimerNombre(gerenteTransporteDatos.getPrimerNombre());
        gerente.setSegundoNombre(gerenteTransporteDatos.getSegundoNombre());
        gerente.setPrimerApellido(gerenteTransporteDatos.getPrimerApellido());
        gerente.setSegundoApellido(gerenteTransporteDatos.getSegundoApellido());
        gerente.setFechaNacimiento(gerenteTransporteDatos.getFechaNacimiento());
        gerente.setTelefono(gerenteTransporteDatos.getTelefono());
        gerente.setDireccion(gerenteTransporteDatos.getDireccion());
        gerente.setCorreo(gerenteTransporteDatos.getCorreo());
        gerente.setContrasena(gerenteTransporteDatos.getContrasena());
        gerente.setGenero(gerenteTransporteDatos.getGenero());
        gerente.setEstadoCuenta(true);
        
        GerenteConsultaBaseDatos gerenteConsultaBaseDatos = new GerenteConsultaBaseDatos();
        gerenteConsultaBaseDatos.crearGerente(gerente);
        
        return true;
        
    }
    
    public boolean CrearMedico(MedicoTransporteDatos medicoTransporteDatos){
            
        Medico medico = new Medico();
        
        medico.setNumDocumento(medicoTransporteDatos.getNumDocumento());
        medico.setNombreUsuario(medicoTransporteDatos.getNombreUsuario());
        medico.setPrimerNombre(medicoTransporteDatos.getPrimerNombre());
        medico.setSegundoNombre(medicoTransporteDatos.getSegundoNombre());
        medico.setPrimerApellido(medicoTransporteDatos.getPrimerApellido());
        medico.setSegundoApellido(medicoTransporteDatos.getSegundoApellido());
        medico.setFechaNacimiento(medicoTransporteDatos.getFechaNacimiento());
        medico.setTelefono(medicoTransporteDatos.getTelefono());
        medico.setDireccion(medicoTransporteDatos.getDireccion());
        medico.setCorreo(medicoTransporteDatos.getCorreo());
        medico.setContrasena(medicoTransporteDatos.getContrasena());
        medico.setGenero(medicoTransporteDatos.getGenero());
        medico.setEstadoCuenta(true);
        medico.setNumTarjetaProfesional(medicoTransporteDatos.getNumTarjetaProfesional());
        
        List<Formula> formulas = new ArrayList<>();
        medico.setFormulaCollection(formulas);
        
        MedicoConsultaBaseDatos medicoConsultaBaseDatos = new MedicoConsultaBaseDatos();
        medicoConsultaBaseDatos.crearMedico(medico);
        
        return true;
        
    }
    
}
