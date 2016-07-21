/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultasBaseDatos;

import intermedioPaginas.InicioSesionIntermedioPaginas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import tablas.Medico;

/**
 *
 * @author jhtob
 */
public class MedicoConsultaBaseDatos {
    
    EntityManagerFactory emf = InicioSesionIntermedioPaginas.getEmf();
        
    public Medico encontrarPorIdMedico(Long idMedico) {
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
    
    public Medico encontrarPorNombreUsuario(String nombreUsuario) {
      
        EntityManager em = emf.createEntityManager();
        Query q;
        
        Medico medico = null;
        
        try {
            q = em.createNamedQuery("Medico.findByNombreUsuario", Medico.class);
            q.setParameter("nombreUsuario", nombreUsuario);
            medico = (Medico) q.getSingleResult();
        } catch (Exception e){
        } finally {
            em.close();
            return medico;
        }
    }
    public Medico crearMedico(Medico medico) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(medico);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return medico;
        }

    }
}