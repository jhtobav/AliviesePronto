package consultasBaseDatos;

import intermedioPaginas.InicioSesionIntermedioPaginas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
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
    
    public List<Producto> obtenerProductosPublicos(){
            
        EntityManager em = emf.createEntityManager();
        
        Query q;

        List<Producto> productos = null;

        try {
            q = em.createNamedQuery("Producto.findByTipo", Producto.class);
            q.setParameter("tipo", "Publico");
            productos = q.getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
            return productos;
        }
        
    }

}