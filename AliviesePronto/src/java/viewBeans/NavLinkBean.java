/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewBeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author afleonc
 */
@ViewScoped
@ManagedBean
public class NavLinkBean implements Serializable {

    public String navegacion(String tipoUsuario) {
        System.out.println(tipoUsuario);
        if (tipoUsuario.equals("Paciente")) {
            return "crearPaciente.xhtml";
        }
        if (tipoUsuario.equals("Medico")) {
            return "crearMedico.xhtml";
        } 
        else{
            return "crearFarmaceuta.xhtml";
        }
    }

}