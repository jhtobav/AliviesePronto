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
import consultasBaseDatos.UsuarioConsultaBaseDatos;
import java.util.List;
import java.util.ArrayList;
import tablas.Administrador;
import tablas.Farmaceuta;
import tablas.Gerente;
import tablas.Medico;
import tablas.Usuario;
import transporteDatos.AdministradorTransporteDatos;
import transporteDatos.FarmaceutaTransporteDatos;
import transporteDatos.GerenteTransporteDatos;
import transporteDatos.MedicoTransporteDatos;
import transporteDatos.UsuarioTransporteDatos;

/**
 *
 * @author jhtob
 */
public class ModificarCuentasMetodosLogicaPaginas {
    
    public List<MedicoTransporteDatos> listarMedicos(){
        
        List<Medico> listaMedicos = new MedicoConsultaBaseDatos().obtenerMedicos();
        
        List<MedicoTransporteDatos> listaMedicosTransporteDatos = new ArrayList<>();
        
        MedicoTransporteDatos medicoTransporteDatos;
        
        for(Medico medico : listaMedicos){
            
            medicoTransporteDatos = new MedicoTransporteDatos();
            
            medicoTransporteDatos.setId(medico.getId());
            medicoTransporteDatos.setNumDocumento(medico.getNumDocumento());
            medicoTransporteDatos.setNombreUsuario(medico.getNombreUsuario());
            medicoTransporteDatos.setPrimerNombre(medico.getPrimerNombre());
            medicoTransporteDatos.setSegundoNombre(medico.getSegundoNombre());
            medicoTransporteDatos.setPrimerApellido(medico.getPrimerApellido());
            medicoTransporteDatos.setSegundoApellido(medico.getSegundoApellido());
            medicoTransporteDatos.setFechaNacimiento(medico.getFechaNacimiento());
            medicoTransporteDatos.setTelefono(medico.getTelefono());
            medicoTransporteDatos.setDireccion(medico.getDireccion());
            medicoTransporteDatos.setCorreo(medico.getCorreo());
            medicoTransporteDatos.setContrasena(medico.getContrasena());
            medicoTransporteDatos.setGenero(medico.getGenero());
            medicoTransporteDatos.setNumTarjetaProfesional(medico.getNumTarjetaProfesional());
            medicoTransporteDatos.setEstadoCuenta(medico.getEstadoCuenta());
            
            listaMedicosTransporteDatos.add(medicoTransporteDatos);
            
        }
        
        return listaMedicosTransporteDatos;
        
    }
    
    public List<GerenteTransporteDatos> listarGerentes(){
        
        List<Gerente> listaGerentes = new GerenteConsultaBaseDatos().obtenerGerentes();
        
        List<GerenteTransporteDatos> listaGerentesTransporteDatos = new ArrayList<>();
        
        GerenteTransporteDatos gerenteTransporteDatos;
        
        for(Gerente gerente : listaGerentes){
            
            gerenteTransporteDatos = new GerenteTransporteDatos();
            
            gerenteTransporteDatos.setId(gerente.getId());
            gerenteTransporteDatos.setNumDocumento(gerente.getNumDocumento());
            gerenteTransporteDatos.setNombreUsuario(gerente.getNombreUsuario());
            gerenteTransporteDatos.setPrimerNombre(gerente.getPrimerNombre());
            gerenteTransporteDatos.setSegundoNombre(gerente.getSegundoNombre());
            gerenteTransporteDatos.setPrimerApellido(gerente.getPrimerApellido());
            gerenteTransporteDatos.setSegundoApellido(gerente.getSegundoApellido());
            gerenteTransporteDatos.setFechaNacimiento(gerente.getFechaNacimiento());
            gerenteTransporteDatos.setTelefono(gerente.getTelefono());
            gerenteTransporteDatos.setDireccion(gerente.getDireccion());
            gerenteTransporteDatos.setCorreo(gerente.getCorreo());
            gerenteTransporteDatos.setContrasena(gerente.getContrasena());
            gerenteTransporteDatos.setGenero(gerente.getGenero());
            gerenteTransporteDatos.setEstadoCuenta(gerente.getEstadoCuenta());
            
            listaGerentesTransporteDatos.add(gerenteTransporteDatos);
            
        }
        
        return listaGerentesTransporteDatos;
        
    }
    
    public List<AdministradorTransporteDatos> listarAdministradores(){
        
        List<Administrador> listaAdministradors = new AdministradorConsultaBaseDatos().obtenerAdministradores();
        
        List<AdministradorTransporteDatos> listaAdministradoresTransporteDatos = new ArrayList<>();
        
        AdministradorTransporteDatos administradorTransporteDatos;
        
        for(Administrador administrador : listaAdministradors){
            
            administradorTransporteDatos = new AdministradorTransporteDatos();
            
            administradorTransporteDatos.setId(administrador.getId());
            administradorTransporteDatos.setNumDocumento(administrador.getNumDocumento());
            administradorTransporteDatos.setNombreUsuario(administrador.getNombreUsuario());
            administradorTransporteDatos.setPrimerNombre(administrador.getPrimerNombre());
            administradorTransporteDatos.setSegundoNombre(administrador.getSegundoNombre());
            administradorTransporteDatos.setPrimerApellido(administrador.getPrimerApellido());
            administradorTransporteDatos.setSegundoApellido(administrador.getSegundoApellido());
            administradorTransporteDatos.setFechaNacimiento(administrador.getFechaNacimiento());
            administradorTransporteDatos.setTelefono(administrador.getTelefono());
            administradorTransporteDatos.setDireccion(administrador.getDireccion());
            administradorTransporteDatos.setCorreo(administrador.getCorreo());
            administradorTransporteDatos.setContrasena(administrador.getContrasena());
            administradorTransporteDatos.setGenero(administrador.getGenero());
            administradorTransporteDatos.setEstadoCuenta(administrador.getEstadoCuenta());
            
            listaAdministradoresTransporteDatos.add(administradorTransporteDatos);
            
        }
        
        return listaAdministradoresTransporteDatos;
        
    }
    
    public List<FarmaceutaTransporteDatos> listarFarmaceutas(){
        
        List<Farmaceuta> listaFarmaceutas = new FarmaceutaConsultaBaseDatos().obtenerFarmaceutas();
        
        List<FarmaceutaTransporteDatos> listaFarmaceutasTransporteDatos = new ArrayList<>();
        
        FarmaceutaTransporteDatos farmaceutaTransporteDatos;
        
        for(Farmaceuta farmaceuta : listaFarmaceutas){
            
            farmaceutaTransporteDatos = new FarmaceutaTransporteDatos();
            
            farmaceutaTransporteDatos.setId(farmaceuta.getId());
            farmaceutaTransporteDatos.setNumDocumento(farmaceuta.getNumDocumento());
            farmaceutaTransporteDatos.setNombreUsuario(farmaceuta.getNombreUsuario());
            farmaceutaTransporteDatos.setPrimerNombre(farmaceuta.getPrimerNombre());
            farmaceutaTransporteDatos.setSegundoNombre(farmaceuta.getSegundoNombre());
            farmaceutaTransporteDatos.setPrimerApellido(farmaceuta.getPrimerApellido());
            farmaceutaTransporteDatos.setSegundoApellido(farmaceuta.getSegundoApellido());
            farmaceutaTransporteDatos.setFechaNacimiento(farmaceuta.getFechaNacimiento());
            farmaceutaTransporteDatos.setTelefono(farmaceuta.getTelefono());
            farmaceutaTransporteDatos.setDireccion(farmaceuta.getDireccion());
            farmaceutaTransporteDatos.setCorreo(farmaceuta.getCorreo());
            farmaceutaTransporteDatos.setContrasena(farmaceuta.getContrasena());
            farmaceutaTransporteDatos.setGenero(farmaceuta.getGenero());
            farmaceutaTransporteDatos.setEstadoCuenta(farmaceuta.getEstadoCuenta());
            
            listaFarmaceutasTransporteDatos.add(farmaceutaTransporteDatos);
            
        }
        
        return listaFarmaceutasTransporteDatos;
        
    }
    
    public List<UsuarioTransporteDatos> listarUsuarios(){
        
        List<Usuario> listaUsuarios = new UsuarioConsultaBaseDatos().obtenerUsuarios();
        
        List<UsuarioTransporteDatos> listaUsuariosTransporteDatos = new ArrayList<>();
        
        UsuarioTransporteDatos usuarioTransporteDatos;
        
        for(Usuario usuario : listaUsuarios){
            
            usuarioTransporteDatos = new UsuarioTransporteDatos();
            
            usuarioTransporteDatos.setId(usuario.getId());
            usuarioTransporteDatos.setNumDocumento(usuario.getNumDocumento());
            usuarioTransporteDatos.setNombreUsuario(usuario.getNombreUsuario());
            usuarioTransporteDatos.setPrimerNombre(usuario.getPrimerNombre());
            usuarioTransporteDatos.setSegundoNombre(usuario.getSegundoNombre());
            usuarioTransporteDatos.setPrimerApellido(usuario.getPrimerApellido());
            usuarioTransporteDatos.setSegundoApellido(usuario.getSegundoApellido());
            usuarioTransporteDatos.setFechaNacimiento(usuario.getFechaNacimiento());
            usuarioTransporteDatos.setTelefono(usuario.getTelefono());
            usuarioTransporteDatos.setDireccion(usuario.getDireccion());
            usuarioTransporteDatos.setCorreo(usuario.getCorreo());
            usuarioTransporteDatos.setContrasena(usuario.getContrasena());
            usuarioTransporteDatos.setGenero(usuario.getGenero());
            usuarioTransporteDatos.setEstadoCuenta(usuario.getEstadoCuenta());
            
            listaUsuariosTransporteDatos.add(usuarioTransporteDatos);
            
        }
        
        return listaUsuariosTransporteDatos;
        
    }

    
    public boolean modificarUsuario(UsuarioTransporteDatos usuarioTransporteDatos){
        
        UsuarioConsultaBaseDatos usuarioConsultaBaseDatos = new UsuarioConsultaBaseDatos();
        usuarioConsultaBaseDatos.modificarUsuario(usuarioTransporteDatos);
        
        return true;
        
    }
    
    public boolean modificarAdministrador(AdministradorTransporteDatos administradorTransporteDatos){
                
        AdministradorConsultaBaseDatos administradorConsultaBaseDatos = new AdministradorConsultaBaseDatos();
        administradorConsultaBaseDatos.modificarAdministrador(administradorTransporteDatos);
        
        return true;
        
    }
    
    public boolean modificarFarmaceuta(FarmaceutaTransporteDatos farmaceutaTransporteDatos){
                   
        FarmaceutaConsultaBaseDatos farmaceutaConsultaBaseDatos = new FarmaceutaConsultaBaseDatos();
        farmaceutaConsultaBaseDatos.modificarFarmaceuta(farmaceutaTransporteDatos);
        
        return true;
        
    }
        
    public boolean modificarGerente(GerenteTransporteDatos gerenteTransporteDatos){
                    
        GerenteConsultaBaseDatos gerenteConsultaBaseDatos = new GerenteConsultaBaseDatos();
        gerenteConsultaBaseDatos.modificarGerente(gerenteTransporteDatos);
        
        return true;
        
    }
    
    public boolean modificarMedico(MedicoTransporteDatos medicoTransporteDatos){
        
        MedicoConsultaBaseDatos medicoConsultaBaseDatos = new MedicoConsultaBaseDatos();
        medicoConsultaBaseDatos.modificarMedico(medicoTransporteDatos);
        
        return true;
        
    }
    
}
