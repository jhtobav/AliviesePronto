/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultasBaseDatos;

import intermedioPaginas.ManejoEMFIntermedioPaginas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import tablas.Administrador;
import transporteDatos.AdministradorTransporteDatos;

/**
 *
 * @author jhtob
 */
public class AdministradorConsultaBaseDatos {
    
    EntityManagerFactory emf = ManejoEMFIntermedioPaginas.getEmf();
        
    public Administrador encontrarPorIdAdministrador(Long idAdministrador) {
        EntityManager em = emf.createEntityManager();
        Administrador administrador = null;
        try {
            administrador = em.find(Administrador.class
                    , idAdministrador);
        } catch (Exception e){
        } finally {
            em.close();
            return administrador;
        }
      
    }  
    
    public Administrador encontrarPorNombreUsuario(String nombreUsuario) {
      
        EntityManager em = emf.createEntityManager();
        Query q;
        
        Administrador administrador = null;
        
        try {
            q = em.createNamedQuery("Administrador.findByNombreUsuario", Administrador.class);
            q.setParameter("nombreUsuario", nombreUsuario);
            administrador = (Administrador) q.getSingleResult();
        } catch (Exception e){
        } finally {
            em.close();
            return administrador;
        }
    }
    
    public Administrador crearAdministrador(Administrador administrador) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        try{
            em.persist(administrador);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return administrador;
        }

    }
    
    public Administrador modificarAdministrador(AdministradorTransporteDatos administradorTransporteDatos){
        
        EntityManager em = emf.createEntityManager();  
        
        em.getTransaction().begin();
        
        Administrador nuevoAdministrador = new Administrador();
        
        try {
            nuevoAdministrador = em.merge(em.find(Administrador.class, administradorTransporteDatos.getId()));
            
            nuevoAdministrador.setNumDocumento(administradorTransporteDatos.getNumDocumento());
            nuevoAdministrador.setPrimerNombre(administradorTransporteDatos.getPrimerNombre());
            nuevoAdministrador.setSegundoNombre(administradorTransporteDatos.getSegundoNombre());
            nuevoAdministrador.setPrimerApellido(administradorTransporteDatos.getPrimerApellido());
            nuevoAdministrador.setSegundoApellido(administradorTransporteDatos.getSegundoApellido());
            nuevoAdministrador.setFechaNacimiento(administradorTransporteDatos.getFechaNacimiento());
            nuevoAdministrador.setTelefono(administradorTransporteDatos.getTelefono());
            nuevoAdministrador.setDireccion(administradorTransporteDatos.getDireccion());
            nuevoAdministrador.setCorreo(administradorTransporteDatos.getCorreo());
            nuevoAdministrador.setContrasena(administradorTransporteDatos.getContrasena());
            nuevoAdministrador.setGenero(administradorTransporteDatos.getGenero());
            nuevoAdministrador.setEstadoCuenta(administradorTransporteDatos.isEstadoCuenta());
            
            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevoAdministrador;
        }
        
    }
    
    public List<Administrador> obtenerAdministradores(){
            
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query q;

        List<Administrador> administradores = null;

        try {
            q = em.createNamedQuery("Administrador.findAll", Administrador.class);
            administradores = q.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
            return administradores;
        }
        
    }

}