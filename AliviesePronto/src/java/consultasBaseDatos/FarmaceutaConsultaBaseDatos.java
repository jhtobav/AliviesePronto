package consultasBaseDatos;

import intermedioPaginas.InicioSesionIntermedioPaginas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import tablas.Farmaceuta;
import transporteDatos.FarmaceutaTransporteDatos;

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
    
    public Farmaceuta modificarFarmaceuta(FarmaceutaTransporteDatos farmaceutaTransporteDatos){
        
        EntityManager em = emf.createEntityManager();  
        
        em.getTransaction().begin();
        
        Farmaceuta nuevoFarmaceuta = new Farmaceuta();
        
        try {
            nuevoFarmaceuta = em.merge(em.find(Farmaceuta.class, farmaceutaTransporteDatos.getId()));
            
            nuevoFarmaceuta.setNumDocumento(farmaceutaTransporteDatos.getNumDocumento());
            nuevoFarmaceuta.setPrimerNombre(farmaceutaTransporteDatos.getPrimerNombre());
            nuevoFarmaceuta.setSegundoNombre(farmaceutaTransporteDatos.getSegundoNombre());
            nuevoFarmaceuta.setPrimerApellido(farmaceutaTransporteDatos.getPrimerApellido());
            nuevoFarmaceuta.setSegundoApellido(farmaceutaTransporteDatos.getSegundoApellido());
            nuevoFarmaceuta.setFechaNacimiento(farmaceutaTransporteDatos.getFechaNacimiento());
            nuevoFarmaceuta.setTelefono(farmaceutaTransporteDatos.getTelefono());
            nuevoFarmaceuta.setDireccion(farmaceutaTransporteDatos.getDireccion());
            nuevoFarmaceuta.setCorreo(farmaceutaTransporteDatos.getCorreo());
            nuevoFarmaceuta.setContrasena(farmaceutaTransporteDatos.getContrasena());
            nuevoFarmaceuta.setGenero(farmaceutaTransporteDatos.getGenero());
            nuevoFarmaceuta.setEstadoCuenta(farmaceutaTransporteDatos.isEstadoCuenta());
            
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevoFarmaceuta;
        }
        
    }

}