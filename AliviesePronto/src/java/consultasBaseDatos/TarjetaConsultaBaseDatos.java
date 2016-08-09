package consultasBaseDatos;

import intermedioPaginas.ManejoEMFIntermedioPaginas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import tablas.TarjetaCredito;

public class TarjetaConsultaBaseDatos {
    
    EntityManagerFactory emf = ManejoEMFIntermedioPaginas.getEmf();
    
    public TarjetaCredito crearTarjetaCredito(TarjetaCredito tarjetaCredito) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(tarjetaCredito);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return tarjetaCredito;
        }

    }
    
}
