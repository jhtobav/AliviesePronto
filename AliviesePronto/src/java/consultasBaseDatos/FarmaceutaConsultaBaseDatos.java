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
import tablas.Farmaceuta;

/**
 *
 * @author jhtob
 */
public class FarmaceutaConsultaBaseDatos {
    
    EntityManagerFactory emf = InicioSesionIntermedioPaginas.getEmf();
        
    public Farmaceuta encontrarPorIdFarmaceuta(Long idFarmaceuta) {
        EntityManager em = emf.createEntityManager();
        Farmaceuta farmaceuta = null;
        try {
            farmaceuta = em.find(Farmaceuta.class
                    , idFarmaceuta);
        } catch (Exception e){
        } finally {
            em.close();
            return farmaceuta;
        }
      
    }  
    
    public Farmaceuta encontrarPorNombreUsuario(String nombreUsuario) {
      
        EntityManager em = emf.createEntityManager();
        Query q;
        
        Farmaceuta farmaceuta = null;
        
        try {
            q = em.createNamedQuery("Farmaceuta.findByNombreUsuario", Farmaceuta.class);
            q.setParameter("nombreUsuario", nombreUsuario);
            farmaceuta = (Farmaceuta) q.getSingleResult();
        } catch (Exception e){
        } finally {
            em.close();
            return farmaceuta;
        }
    }
    
    public Farmaceuta crearFarmaceuta(Farmaceuta farmaceuta) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(farmaceuta);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return farmaceuta;
        }

    }

}