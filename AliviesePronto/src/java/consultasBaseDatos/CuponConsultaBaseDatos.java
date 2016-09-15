package consultasBaseDatos;

import intermedioPaginas.ManejoEMFIntermedioPaginas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import tablas.Cupon;

public class CuponConsultaBaseDatos {
    
    EntityManagerFactory emf = ManejoEMFIntermedioPaginas.getEmf();
        
    public Cupon encontrarPorIdCupon(Long idCupon) {
        EntityManager em = emf.createEntityManager();
        Cupon cupon = null;
        try {
            cupon = em.find(Cupon.class
                    , idCupon);
        } catch (Exception e){
        } finally {
            em.close();
            return cupon;
        }
      
    } 
    
    public Cupon crearCupon(Cupon cupon) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(cupon);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return cupon;
        }

    }
    
    public List<Cupon> obtenerCupones(){
            
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query q;

        List<Cupon> cupones = null;

        try {
            q = em.createNamedQuery("Cupon.findAll", Cupon.class);
            cupones = q.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
            return cupones;
        }
        
    }
    
}