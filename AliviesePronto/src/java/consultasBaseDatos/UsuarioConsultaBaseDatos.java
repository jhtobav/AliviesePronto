package consultasBaseDatos;

import intermedioPaginas.ManejoEMFIntermedioPaginas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import tablas.Usuario;
import transporteDatos.UsuarioTransporteDatos;

public class UsuarioConsultaBaseDatos {
    
    EntityManagerFactory emf = ManejoEMFIntermedioPaginas.getEmf();
        
    public Usuario encontrarPorIdUsuario(Long idUsuario) {
        
        EntityManager em = emf.createEntityManager();
        
        Usuario usuario = null;
        
        try {
            usuario = em.find(Usuario.class
                    , idUsuario);
        } catch (Exception e){
        } finally {
            em.close();
            return usuario;
        }
      
    }  
    
    public Usuario encontrarPorNombreUsuario(String nombreUsuario) {
      
        EntityManager em = emf.createEntityManager();
        
        Query q;
        
        Usuario usuario = null;
        
        try {
            q = em.createNamedQuery("Usuario.findByNombreUsuario", Usuario.class);
            q.setParameter("nombreUsuario", nombreUsuario);
            usuario = (Usuario) q.getSingleResult();
        } catch (Exception e){
        } finally {
            em.close();
            return usuario;
        }
    }
    
    public Usuario crearUsuario(Usuario usuario) {
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        try{
            em.persist(usuario);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
            return usuario;
        }

    }
    
    public Usuario modificarUsuario(UsuarioTransporteDatos usuarioTransporteDatos){
        
        EntityManager em = emf.createEntityManager();  
        
        em.getTransaction().begin();
        
        Usuario nuevoUsuario = new Usuario();
        
        try {
            nuevoUsuario = em.merge(em.find(Usuario.class, usuarioTransporteDatos.getId()));
            
            nuevoUsuario.setNumDocumento(usuarioTransporteDatos.getNumDocumento());
            nuevoUsuario.setPrimerNombre(usuarioTransporteDatos.getPrimerNombre());
            nuevoUsuario.setSegundoNombre(usuarioTransporteDatos.getSegundoNombre());
            nuevoUsuario.setPrimerApellido(usuarioTransporteDatos.getPrimerApellido());
            nuevoUsuario.setSegundoApellido(usuarioTransporteDatos.getSegundoApellido());
            nuevoUsuario.setFechaNacimiento(usuarioTransporteDatos.getFechaNacimiento());
            nuevoUsuario.setTelefono(usuarioTransporteDatos.getTelefono());
            nuevoUsuario.setDireccion(usuarioTransporteDatos.getDireccion());
            nuevoUsuario.setCorreo(usuarioTransporteDatos.getCorreo());
            nuevoUsuario.setContrasena(usuarioTransporteDatos.getContrasena());
            nuevoUsuario.setGenero(usuarioTransporteDatos.getGenero());
            nuevoUsuario.setEstadoCuenta(usuarioTransporteDatos.isEstadoCuenta());
            
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevoUsuario;
        }
        
    }
    
    public List<Usuario> obtenerUsuarios(){
            
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query q;

        List<Usuario> usuarios = null;

        try {
            q = em.createNamedQuery("Usuario.findAll", Usuario.class);
            usuarios = q.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
            return usuarios;
        }
        
    }

}