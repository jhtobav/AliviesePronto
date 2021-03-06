package consultasBaseDatos;

import intermedioPaginas.ManejoEMFIntermedioPaginas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import tablas.Producto;
import transporteDatos.ProductoTransporteDatos;

public class ProductoConsultaBaseDatos {
    
    EntityManagerFactory emf = ManejoEMFIntermedioPaginas.getEmf();
            
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
    
    public Producto encontrarPorIdProducto(Long idProducto) {
        EntityManager em = emf.createEntityManager();
        Producto producto = null;
        try {
            producto = em.find(Producto.class
                    , idProducto);
        } catch (Exception e){
        } finally {
            em.close();
            return producto;
        }
      
    } 

    public List<Producto> obtenerProductos(){
            
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query q;

        List<Producto> productos = null;    

        try {
            q = em.createNamedQuery("Producto.findAll", Producto.class);
            productos = q.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
            return productos;
        }
    }
    
    public List<Producto> obtenerProductosAlfabeticamente(){
            
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query q;

        List<Producto> productos = null;    

        try {
            q = em.createNamedQuery("Producto.findAllByName", Producto.class);
            productos = q.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
            return productos;
        }
    }
    
    public List<Producto> obtenerProductosPorFabricante(){
            
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query q;

        List<Producto> productos = null;    

        try {
            q = em.createNamedQuery("Producto.findAllByProductor", Producto.class);
            productos = q.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
            return productos;
        }
    }
    
    public List<Producto> obtenerProductosPublicos(){
            
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query q;

        List<Producto> productos = null;
        String tipo = "Publico";

        try {
            q = em.createNamedQuery("Producto.findByTipo", Producto.class);
            q.setParameter("tipo", tipo);
            productos = q.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
            return productos;
        }
        
    }
    
    public Producto actualizarCantidadInventario(ProductoTransporteDatos productoTransporteDatos){
        
        EntityManager em = emf.createEntityManager();  
        
        em.getTransaction().begin();
        
        Producto nuevoProducto = new Producto();
        
        try {
            nuevoProducto = em.merge(em.find(Producto.class, productoTransporteDatos.getId()));
            
            nuevoProducto.setCantidadInventario(productoTransporteDatos.getCantidadInventario());
            
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevoProducto;
        }
        
    }
    
    public List<Producto> buscarProductosPorNombre(String nombre){
            
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        nombre = "%" + nombre + "%";
        Query q;

        List<Producto> productos = null;    

        try {
            q = em.createNamedQuery("Producto.findByNombre", Producto.class);
            q.setParameter("nombre", nombre);
            productos = q.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
            return productos;
        }
    }
    
    public Producto registrarCompra(Long idProducto){
        
        EntityManager em = emf.createEntityManager();  
        
        em.getTransaction().begin();
        
        Producto nuevoProducto = new Producto();
        
        try {
            nuevoProducto = em.merge(em.find(Producto.class, idProducto));
            
            nuevoProducto.setCantidadInventario(nuevoProducto.getCantidadInventario() - 1);
            
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevoProducto;
        }
        
    }
    
    public Producto actualizarProducto(Producto producto){
        
        EntityManager em = emf.createEntityManager();  
        
        em.getTransaction().begin();
        
        
        try {
            producto = em.merge(producto);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
            return producto;
        }
        
    }
    
    public void eliminarProducto(Long id){
        
        EntityManager em = emf.createEntityManager();  
        
        em.getTransaction().begin();
        
        
        try {
            em.remove(em.find(Producto.class, id));
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
    }

}