package consultasBaseDatos;

import intermedioPaginas.ManejoEMFIntermedioPaginas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import tablas.Gerente;
import transporteDatos.GerenteTransporteDatos;

public class GerenteConsultaBaseDatos {
    
    EntityManagerFactory emf = ManejoEMFIntermedioPaginas.getEmf();
        
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
    
    public Gerente modificarGerente(GerenteTransporteDatos gerenteTransporteDatos){
        
        EntityManager em = emf.createEntityManager();  
        
        em.getTransaction().begin();
        
        Gerente nuevoGerente = new Gerente();
        
        try {
            nuevoGerente = em.merge(em.find(Gerente.class, gerenteTransporteDatos.getId()));
            
            nuevoGerente.setNumDocumento(gerenteTransporteDatos.getNumDocumento());
            nuevoGerente.setNombreUsuario(gerenteTransporteDatos.getNombreUsuario());
            nuevoGerente.setPrimerNombre(gerenteTransporteDatos.getPrimerNombre());
            nuevoGerente.setSegundoNombre(gerenteTransporteDatos.getSegundoNombre());
            nuevoGerente.setPrimerApellido(gerenteTransporteDatos.getPrimerApellido());
            nuevoGerente.setSegundoApellido(gerenteTransporteDatos.getSegundoApellido());
            nuevoGerente.setFechaNacimiento(gerenteTransporteDatos.getFechaNacimiento());
            nuevoGerente.setTelefono(gerenteTransporteDatos.getTelefono());
            nuevoGerente.setDireccion(gerenteTransporteDatos.getDireccion());
            nuevoGerente.setCorreo(gerenteTransporteDatos.getCorreo());
            nuevoGerente.setContrasena(gerenteTransporteDatos.getContrasena());
            nuevoGerente.setGenero(gerenteTransporteDatos.getGenero());
            nuevoGerente.setEstadoCuenta(gerenteTransporteDatos.isEstadoCuenta());
            
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevoGerente;
        }
        
    }
    
    public List<Gerente> obtenerGerentes(){
            
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query q;

        List<Gerente> gerentes = null;

        try {
            q = em.createNamedQuery("Gerente.findAll", Gerente.class);
            gerentes = q.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
            return gerentes;
        }
        
    }
    
}