/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultasBaseDatos;

import intermedioPaginas.InicioSesionIntermedioPaginas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import tablas.Medico;

/**
 *
 * @author jhtob
 */
public class MedicoConsultaBaseDatos {
    
    EntityManagerFactory emf = InicioSesionIntermedioPaginas.getEmf();
        
    public Medico searchByIdUsuario(Long idMedico) {
        EntityManager em = emf.createEntityManager();
        Medico medico = null;
        try {
            medico = em.find(Medico.class
                    , idMedico);
        } catch (Exception e){
        } finally {
            em.close();
            return medico;
        }
      
    }  

}