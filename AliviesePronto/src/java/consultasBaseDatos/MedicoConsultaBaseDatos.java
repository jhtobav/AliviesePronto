package consultasBaseDatos;

import intermedioPaginas.InicioSesionIntermedioPaginas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import tablas.Medico;
import transporteDatos.MedicoTransporteDatos;

public class MedicoConsultaBaseDatos {
    
    EntityManagerFactory emf = InicioSesionIntermedioPaginas.getEmf();
        
    public Medico encontrarPorIdMedico(Long idMedico) {
        EntityManager em = emf.createEntityManager();
        Medico medico = null;
        try {
            medico = em.find(Medico.class
                    , idMedico);
        } catch (Exception e){
        } finally {
            em.close();
            return medico;
        }
      
    } 
    
    public Medico encontrarPorNombreUsuario(String nombreUsuario) {
      
        EntityManager em = emf.createEntityManager();
        Query q;
        
        Medico medico = null;
        
        try {
            q = em.createNamedQuery("Medico.findByNombreUsuario", Medico.class);
            q.setParameter("nombreUsuario", nombreUsuario);
            medico = (Medico) q.getSingleResult();
        } catch (Exception e){
        } finally {
            em.close();
            return medico;
        }
    }
    public Medico crearMedico(Medico medico) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(medico);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return medico;
        }

    }
    
    public Medico modificarMedico(MedicoTransporteDatos medicoTransporteDatos){
        
        EntityManager em = emf.createEntityManager();  
        
        em.getTransaction().begin();
        
        Medico nuevoMedico = new Medico();
        
        try {
            nuevoMedico = em.merge(em.find(Medico.class, medicoTransporteDatos.getId()));
            
            nuevoMedico.setNumDocumento(medicoTransporteDatos.getNumDocumento());
            nuevoMedico.setNombreUsuario(medicoTransporteDatos.getNombreUsuario());
            nuevoMedico.setPrimerNombre(medicoTransporteDatos.getPrimerNombre());
            nuevoMedico.setSegundoNombre(medicoTransporteDatos.getSegundoNombre());
            nuevoMedico.setPrimerApellido(medicoTransporteDatos.getPrimerApellido());
            nuevoMedico.setSegundoApellido(medicoTransporteDatos.getSegundoApellido());
            nuevoMedico.setFechaNacimiento(medicoTransporteDatos.getFechaNacimiento());
            nuevoMedico.setTelefono(medicoTransporteDatos.getTelefono());
            nuevoMedico.setDireccion(medicoTransporteDatos.getDireccion());
            nuevoMedico.setCorreo(medicoTransporteDatos.getCorreo());
            nuevoMedico.setContrasena(medicoTransporteDatos.getContrasena());
            nuevoMedico.setGenero(medicoTransporteDatos.getGenero());
            nuevoMedico.setEstadoCuenta(medicoTransporteDatos.isEstadoCuenta());
            nuevoMedico.setNumTarjetaProfesional(medicoTransporteDatos.getNumTarjetaProfesional());
            
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevoMedico;
        }
        
    }
    
    public List<Medico> obtenerMedicos(){
            
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query q;

        List<Medico> medicos = null;

        try {
            q = em.createNamedQuery("Medico.findAll", Medico.class);
            medicos = q.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
            return medicos;
        }
        
    }
    
}