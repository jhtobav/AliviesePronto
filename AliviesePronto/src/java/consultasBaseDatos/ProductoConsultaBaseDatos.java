package consultasBaseDatos;

import intermedioPaginas.InicioSesionIntermedioPaginas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import tablas.Producto;

public class ProductoConsultaBaseDatos {
    
    EntityManagerFactory emf = InicioSesionIntermedioPaginas.getEmf();
            
    public Producto crearProducto(Producto producto) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        try{
            em.persist(producto);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return producto;
        }

    }

}