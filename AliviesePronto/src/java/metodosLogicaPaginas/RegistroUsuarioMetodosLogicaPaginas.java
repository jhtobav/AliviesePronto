/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosLogicaPaginas;

import consultasBaseDatos.TarjetaConsultaBaseDatos;
import consultasBaseDatos.UsuarioConsultaBaseDatos;
import java.util.ArrayList;
import java.util.List;
import tablas.Formula;
import tablas.TarjetaCredito;
import tablas.Usuario;
import transporteDatos.TarjetaTransporteDatos;
import transporteDatos.UsuarioTransporteDatos;

/**
 *
 * @author jhtob
 */
public class RegistroUsuarioMetodosLogicaPaginas {

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
    
    
}
