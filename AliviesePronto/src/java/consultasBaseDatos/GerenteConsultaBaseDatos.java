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
import tablas.Gerente;

/**
 *
 * @author jhtob
 */
public class GerenteConsultaBaseDatos {
    
    EntityManagerFactory emf = InicioSesionIntermedioPaginas.getEmf();
        
    public Gerente searchByIdGerente(Long idGerente) {
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
    
    public Gerente encontrarPorNombreUsuario(String nombreUsuario) {
      
        EntityManager em = emf.createEntityManager();
        Query q;
        
        Gerente gerente = null;
        
        try {
            q = em.createNamedQuery("Gerente.findByNombreUsuario", Gerente.class);
            q.setParameter("nombreUsuario", nombreUsuario);
            gerente = (Gerente) q.getSingleResult();
        } catch (Exception e){
        } finally {
            em.close();
            return gerente;
        }
    }
    
    public Gerente crearGerente(Gerente gerente) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(gerente);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return gerente;
        }

    }
    
}