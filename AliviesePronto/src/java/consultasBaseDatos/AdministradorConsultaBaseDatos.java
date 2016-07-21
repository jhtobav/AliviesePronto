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
import tablas.Administrador;

/**
 *
 * @author jhtob
 */
public class AdministradorConsultaBaseDatos {
    
    EntityManagerFactory emf = InicioSesionIntermedioPaginas.getEmf();
        
    public Administrador encontrarPorIdAdministrador(Long idAdministrador) {
        EntityManager em = emf.createEntityManager();
        Administrador administrador = null;
        try {
            administrador = em.find(Administrador.class
                    , idAdministrador);
        } catch (Exception e){
        } finally {
            em.close();
            return administrador;
        }
      
    }  
    
    public Administrador encontrarPorNombreUsuario(String nombreUsuario) {
      
        EntityManager em = emf.createEntityManager();
        Query q;
        
        Administrador administrador = null;
        
        try {
            q = em.createNamedQuery("Administrador.findByNombreUsuario", Administrador.class);
            q.setParameter("nombreUsuario", nombreUsuario);
            administrador = (Administrador) q.getSingleResult();
        } catch (Exception e){
        } finally {
            em.close();
            return administrador;
        }
    }
    
    public Administrador crearAdministrador(Administrador administrador) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(administrador);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return administrador;
        }

    }

}