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
import intermedioPaginas.InicioSesionIntermedioPaginas;
import tablas.Administrador;
import tablas.Farmaceuta;
import tablas.Gerente;
import tablas.Medico;
import tablas.Usuario;

/**
 *
 * @author jhtob
 */
public class InicioSesionMetodosLogicaPaginas {

    public String inicioSesion(String nombreUsuario, String contrasena, String tipoUsuario) {
        
        if ("Usuario".equals(tipoUsuario)) {

            UsuarioConsultaBaseDatos usuarioConsultaBaseDatos = new UsuarioConsultaBaseDatos();

            Usuario usuario = usuarioConsultaBaseDatos.encontrarPorNombreUsuario(nombreUsuario);

            if (usuario != null) {

                if (usuario.getEstadoCuenta()) {

                    if (contrasena.equals(usuario.getContrasena())) {

                        // Inicio Correcto
                        
                        InicioSesionIntermedioPaginas.idPersonaLogueada = usuario.getId();
                        InicioSesionIntermedioPaginas.nombrePersonaLogueada 
                                = usuario.getPrimerNombre() + " " + usuario.getPrimerApellido();
                        
                        return "inicioPaciente.xhtml";

                    } else {

                        return "Error Credenciales";

                    }

                } else {

                    return "Cuenta Inactiva";

                }

            } else {

                return "Error Credenciales";

            }

        }

        if ("Administrador".equals(tipoUsuario)) {
            
            AdministradorConsultaBaseDatos administradorConsultaBaseDatos = new AdministradorConsultaBaseDatos();

            Administrador administrador = administradorConsultaBaseDatos.encontrarPorNombreUsuario(nombreUsuario);
            
            if (administrador != null) {

                if (administrador.getEstadoCuenta()) {

                    if (contrasena.equals(administrador.getContrasena())) {

                        // Inicio Correcto
                        
                        InicioSesionIntermedioPaginas.idPersonaLogueada = administrador.getId();
                        InicioSesionIntermedioPaginas.nombrePersonaLogueada 
                                = administrador.getPrimerNombre() + " " + administrador.getPrimerApellido();
                        
                        return "inicioAdministrador.xhtml";

                    } else {

                        return "Error Credenciales";

                    }

                } else {

                    return "Cuenta Inactiva";

                }

            } else {

                return "Error Credenciales";

            }

        }

        if ("Farmaceuta".equals(tipoUsuario)) {

            FarmaceutaConsultaBaseDatos farmaceutaConsultaBaseDatos = new FarmaceutaConsultaBaseDatos();

            Farmaceuta farmaceuta = farmaceutaConsultaBaseDatos.encontrarPorNombreUsuario(nombreUsuario);

            if (farmaceuta != null) {

                if (farmaceuta.getEstadoCuenta()) {

                    if (contrasena.equals(farmaceuta.getContrasena())) {

                        // Inicio Correcto
                        
                        InicioSesionIntermedioPaginas.idPersonaLogueada = farmaceuta.getId();
                        InicioSesionIntermedioPaginas.nombrePersonaLogueada 
                                = farmaceuta.getPrimerNombre() + " " + farmaceuta.getPrimerApellido();
                        
                        return "inicioFarmaceuta.xhtml";

                    } else {

                        return "Error Credenciales";

                    }

                } else {

                    return "Cuenta Inactiva";

                }

            } else {

                return "Error Credenciales";

            }

        }

        if ("Gerente".equals(tipoUsuario)) {

            GerenteConsultaBaseDatos gerenteConsultaBaseDatos = new GerenteConsultaBaseDatos();

            Gerente gerente = gerenteConsultaBaseDatos.encontrarPorNombreUsuario(nombreUsuario);

            if (gerente != null) {

                if (gerente.getEstadoCuenta()) {

                    if (contrasena.equals(gerente.getContrasena())) {

                        // Inicio Correcto
                        
                        InicioSesionIntermedioPaginas.idPersonaLogueada = gerente.getId();
                        InicioSesionIntermedioPaginas.nombrePersonaLogueada 
                                = gerente.getPrimerNombre() + " " + gerente.getPrimerApellido();
                        
                        return "inicioGerente.xhtml";

                    } else {

                        return "Error Credenciales";

                    }

                } else {

                    return "Cuenta Inactiva";

                }

            } else {

                return "Error Credenciales";

            }

        }

        if ("Medico".equals(tipoUsuario)) {
            
            MedicoConsultaBaseDatos medicoConsultaBaseDatos = new MedicoConsultaBaseDatos();

            Medico medico = medicoConsultaBaseDatos.encontrarPorNombreUsuario(nombreUsuario);

            if (medico != null) {

                if (medico.getEstadoCuenta()) {

                    if (contrasena.equals(medico.getContrasena())) {

                        // Inicio Correcto
                        
                        InicioSesionIntermedioPaginas.idPersonaLogueada = medico.getId();
                        InicioSesionIntermedioPaginas.nombrePersonaLogueada 
                                = medico.getPrimerNombre() + " " + medico.getPrimerApellido();
                        
                        return "inicioMedico.xhtml";

                    } else {
                        
                        return "Error Credenciales";

                    }

                } else {

                    return "Cuenta Inactiva";

                }

            } else {

                System.out.println("error4");
                return "Error Credenciales";

            }

        }

        return "Error Credenciales";

    }
    
}
