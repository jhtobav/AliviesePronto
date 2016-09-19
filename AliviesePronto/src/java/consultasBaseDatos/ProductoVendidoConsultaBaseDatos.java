package consultasBaseDatos;

import intermedioPaginas.ManejoEMFIntermedioPaginas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import tablas.ProductoVendido;
import tablas.Venta;

public class ProductoVendidoConsultaBaseDatos {
    
    EntityManagerFactory emf = ManejoEMFIntermedioPaginas.getEmf();
            
    public ProductoVendido crearProductoVendido(ProductoVendido productoVendido) {
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        try{
            em.persist(productoVendido);
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        }finally{
            em.close();
            return productoVendido;
        }

    }
    
    public ProductoVendido encontrarPorIdProductoVendido(Long idProductoVendido) {
        EntityManager em = emf.createEntityManager();
        ProductoVendido productoVendido = null;
        try {
            productoVendido = em.find(ProductoVendido.class
                    , idProductoVendido);
        } catch (Exception e){
        } finally {
            em.close();
            return productoVendido;
        }
      
    } 

    public List<ProductoVendido> obtenerProductosVendidos(){
            
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query q;

        List<ProductoVendido> productosVendidos = null;    

        try {
            q = em.createNamedQuery("Producto.findAll", ProductoVendido.class);
            productosVendidos = q.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
            return productosVendidos;
        }
        
    }
    
    public ProductoVendido registrarCompra(Long idProductoVendido, Venta venta){
        
        EntityManager em = emf.createEntityManager();  
        
        em.getTransaction().begin();
        
        ProductoVendido nuevoProductoVendido = new ProductoVendido();
        
        try {
            nuevoProductoVendido = em.merge(em.find(ProductoVendido.class, idProductoVendido));
            
            nuevoProductoVendido.setVentaProductoVendidoProductoVendidoId(venta);
            
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevoProductoVendido;
        }
        
    }

}