/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultasBaseDatos;

import intermedioPaginas.InicioSesionIntermedioPaginas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import tablas.Gerente;

/**
 *
 * @author jhtob
 */
public class GerenteConsultaBaseDatos {
    
    EntityManagerFactory emf = InicioSesionIntermedioPaginas.getEmf();
        
    public Gerente searchByIdUsuario(Long idGerente) {
        EntityManager em = emf.createEntityManager();
        Gerente gerente = null;
        try {
            gerente = em.find(Gerente.class
                    , idGerente);
        } catch (Exception e){
        } finally {
            em.close();
            return gerente;
        }
      
    }  

}