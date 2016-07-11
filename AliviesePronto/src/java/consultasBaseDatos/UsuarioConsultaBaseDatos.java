/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultasBaseDatos;

import intermedioPaginas.InicioSesionIntermedioPaginas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import tablas.Usuario;

/**
 *
 * @author jhtob
 */
public class UsuarioConsultaBaseDatos {
    
    EntityManagerFactory emf = InicioSesionIntermedioPaginas.getEmf();
        
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

}